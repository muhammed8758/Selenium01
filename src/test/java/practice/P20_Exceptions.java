package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class P20_Exceptions extends TestBase {
    @Test
    public void name() {
        // Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");
        //iphone aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone", Keys.ENTER);

        //cikan urunlerde sadece Appple iphone yazanlari tiklayalim
        List<WebElement> urunler = driver.findElements(By.partialLinkText("Apple iPhone"));
        // test icinde apple iphone yazisi gecenleri alacak

        for (int i=0 ; i< urunler.size(); i++) {
            urunler = driver.findElements(By.partialLinkText("Apple iPhone"));// handle ediliyor stale exception icin
            urunler.get(i).click();
            driver.navigate().back();

        }


    }
}
