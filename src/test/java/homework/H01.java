package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class H01 extends TestBase {
    @Test
    public void test01() {

        //    Bir class olusturun: IframeOdev


//    https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

//    sayfadaki toplam iframe sayısını bulunuz.
        List<WebElement> iframe = driver.findElements(By.xpath("//iframe"));
        System.out.println("iframe.size() = " + iframe.size());
    

//    Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
       String editor= driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(editor.contains("Editor"));


//    Paragrafdaki yaziyi silelim
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//p")).clear();

//    Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
        driver.findElement(By.xpath("//p")).sendKeys("iframein icindeyim");

//    Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim
        driver.switchTo().defaultContent();
       String result = driver.findElement(By.xpath("(//*[@target='_blank'])[2]")).getText();
        Assert.assertTrue(result.contains("Elemental Selenium"));
    }
}