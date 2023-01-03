package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class H01 extends TestBase {
    @Test
    public void test01() {

        //    Bir class olusturun: IframeOdev


//    https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

//    sayfadaki toplam iframe sayısını bulunuz.

        driver.switchTo().frame(0);

//    Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
       String editor= driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(editor.contains("Editor"));


//    Paragrafdaki yaziyi silelim

//    Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım

//    Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim


    }
}