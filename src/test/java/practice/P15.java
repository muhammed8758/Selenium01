package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class P15 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        // https://the-internet.herokuapp.com/iframe adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        // An iFrame conteining... başlığının altındaki Text Box’a “Techproeducation” yazin.
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();
        textBox.sendKeys("Techproeducation");
        Thread.sleep(3000);
        // TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu test edin
        driver.switchTo().defaultContent();
        WebElement elementSelenium = driver.findElement(By.xpath("//*[.='Elemental Selenium']"));
        Assert.assertTrue(elementSelenium.isDisplayed());

        // Elemental Selenium linkine tıklayın
        elementSelenium.click();
        List<String> windowsHandles = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("windowsHandles = " + windowsHandles);
        driver.switchTo().window(windowsHandles.get(1));

        /*
        Set<String> butunSekmeler = driver.getWindowHandles();
        for (String w : butunSekmeler) {
            if (!w.equals(ilkSayfa)) {
                driver.switchTo().window(w);
            }
        }
        System.out.println(driver.getTitle());
        String ikinciSayfa = driver.getWindowHandle();

        */

        // Açılan sayfada sayfa başlığını yazdırınız
        System.out.println(driver.getTitle());




        // Elemental Selenium başlığı altındaki "Source Labs" linkinin gorunur olduğunu test edin
      WebElement sourceLabsLinki =  driver.findElement(By.xpath("//*[@class='link']"));
      Assert.assertTrue(sourceLabsLinki.isDisplayed());
        // Source labs linkine tıklayın
        sourceLabsLinki.click();
        System.out.println("--------------------------------");
        List<String> windowHandles2 = new ArrayList<String>(driver.getWindowHandles());
        System.out.println(windowHandles2);
        driver.switchTo().window(windowHandles2.get(2));
        
        // Açılan sayfada sayfa başlığını yazdırınız
        System.out.println(driver.getTitle());




        // ilk sekmeye geri dönelim ve url'ini yazdıralım
        driver.switchTo().window(windowHandles2.get(0));
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        // ilk sekmeyi kapatalım
        driver.close();
     //   driver.switchTo().window(windowsHandles.get(2));


    }
}
