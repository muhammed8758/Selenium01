package practice;

import com.sun.jna.StringArray;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class p14 extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        //- https://html.com/tags/iframe/ adresine gidiniz
        driver.get("https://html.com/tags/iframe/ ");
        String ilkSekme=driver.getWindowHandle();

        //    - youtube videosunu çalıştırınız
        WebElement iframe =driver.findElement(By.cssSelector("iframe[frameborder='0']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@aria-label = 'Oynat']")).click();

        //    - üç saniye çalıştıktan sonra sayfayı yenileyiniz
        Thread.sleep(3000);
        driver.navigate().refresh();
        //    - yeni sekmede amazon adresine gidiniz
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");


        //    - iphone aratınız
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        //    - arama sonucu olarak sadece sonuc sayısını yazdırınız
      String[] result =  driver.findElement(By.xpath("//*[.='1-16 of 144 results for']")).getText().split(" ");
        System.out.println("Sonuc Sayisi: " + result[2]);

        //    - ilk sekmeye geri dönüp url'ini konsola yazdıralım
        driver.switchTo().window(ilkSekme);
        System.out.println("ilkSekme Url = " + driver.getCurrentUrl());

        //    - ilk sekmeyi kapatalım

        driver.close();
        //    - Sonra diğer sekmeyide kapatalım

    }
}
