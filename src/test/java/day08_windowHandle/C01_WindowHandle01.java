package day08_windowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandle01 extends TestBase {

    //Tests package'inda yeni bir class olusturun: WindowHandle
    //https://the-internet.herokuapp.com/windows adresine gidin.

    @Test
    public void handleWindowTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");

        String window1Handle = driver.getWindowHandle(); //1. pencere title

        //Sayfadaki textin "Opening a new window" olduğunu doğrulayın.
        String window1Text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window", window1Text);
        //Sayfa başlığının(title) "The Internet" olduğunu doğrulayın.
        String window1Title = driver.getTitle();
        Assert.assertEquals("The Internet", window1Title);

        //Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(3000);


        //BU NOKTADA 2 PENCEREACIK VE IKINCISNE GECIS YAPMAK ICIN
        Set<String> allWindowHandless = driver.getWindowHandles();// window1handle ve window2hanle var
        System.out.println("allWindowHandless = " + allWindowHandless);
        for (String w : allWindowHandless) {
            //eger listedeki id window1 e esit degilse, otomatik olarak window 2 ye esittir
            if (!w.equals(window1Handle)) {
                driver.switchTo().window(w);// Burada w window2 handle esittir
                break;
            }
        }
        //  BU NOKTADA DRIVER 2. PENCEREDE
        //Acilan yeni pencerenin sayfa başlığının (title) "New Window" oldugunu dogrulayin.
        Assert.assertEquals("New Window", driver.getTitle());

        //Sayfadaki textin "New Window" olduğunu doğrulayın.
        String window2Title = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("New Window", window2Title);

        String window2Handle = driver.getWindowHandle();
        //Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu  doğrulayın.
        Thread.sleep(3000);
        driver.switchTo().window(window1Handle);
        Assert.assertEquals("The Internet", driver.getTitle());

        //2. window a gec

        driver.switchTo().window(window2Handle);
        Thread.sleep(3000);
        driver.switchTo().window(window1Handle);

    }
}