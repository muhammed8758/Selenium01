package practice2;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_WindowHandle extends TestBase {
    @Test
    public void windowHandleTest() {

        // 1- https://www.amazon.com sayfasına gidin
        driver.get("https://www.amazon.com");
       String tab1= driver.getWindowHandle();
        // 2- nutella icin arama yapın
     driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella", Keys.ENTER);

        // 3- yeni bir tab'da ilk urunun resmine tıklayınız
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella", Keys.ENTER);

        driver.findElement(By.xpath("//*[@src='https://m.media-amazon.com/images/I/71ZHuJfZxRL._AC_UL320_.jpg']")).click();
        // 4- yeni tab'da acilan urunun basligini yazdirin
       WebElement baslik=driver.findElement(By.xpath("//span[@id='productTitle']"));
        String baslikStr = baslik.getText();
        System.out.println("baslikStr = " + baslikStr);
        // 5- ilk sayfaya gecip url'i yazdırın
        driver.switchTo().window(tab1);
        System.out.println(driver.getCurrentUrl());


    }
}
