package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C05_IFrame extends TestBase {

    /*
    How do you find the number of iframe on a page? Bir sayfadaki toplam iframe sayisini basil buluruz?
***Iframe ler iframe tagi kullanılarak oluşturulur. Bu durumda find elements by frame locatorini kullanarak tum iframeleri bulurum
***driver.findElements(By.tagName(“iframe”));
***driver.findElements(By.xpath(“//iframe”));
————————————
Explain how you can switch back from a main page? Tekrar ana sayfaya nasil donersin?
***2 farkli yol vardır.
***defaultContent yada parentFrame metotlarını kullarak gecis yapabiliriz.
———————————-
What is the difference between defaultContent and parentFrame? defaultContent ve parentFrame arasindaki farklar nelerdi?
*** Oncelikle her ikiside framein disina cikmamizi saglar. Ama defaultContent direk ana sayfaya atlatır, parentFrame ise bir üst seviyeye atlatir
—————————————
What might be the reason for your test case to fail? Bir test case in fail etme sebepleri neler olabilir?
Yanlis locator. Cozum : Tekrar elementi locate etmek. Değişken element var ise ona gore dynamic bir xpath yazarız.
Wait / Syncronization /Bekleme problemi: Cozum : implicit wait de yeterli sure oldugundan emin oluruz. O sureyi arttırabiliriz. 30 saniye verilebilir. Explicit wait kullanilabilir(sonra gore).
Iframe. Cozum : switch to iframe
Alert. Cozum : switch to alert
New window(Yeni pencere) : switch to window
     */

    @Test
    public void iFrameTest() {

        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //Ana sayfadaki An iframe with a thin black border: metnin black border yazisinin oldugunu test edelim
        String anaMetin = driver.findElement(By.xpath("//*[.='An iframe with a thin black border:']")).getText();
        String expectedText = "black border";
        Assert.assertTrue(anaMetin.contains(expectedText));


        //Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0);// index 0 dan baslar ilk iframe giris yapar
        String icMetin = driver.findElement(By.xpath("//*[@class='display-5 fw-bold']")).getText();
        String expectedText1 = "Applications lists";
        Assert.assertEquals(expectedText1, icMetin);

        //        Alternatif olarak altdaki secenekler de kullanilabilir
        //        Assert.assertTrue(expectedText1.contains(icMetin));
        //        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Applications lists']")).isDisplayed());

        driver.switchTo().defaultContent().findElement(By.xpath("(//*[text()='Povered By'])[1]"));
        //  Son olarak footer daki 'Powered By' yazisini varligini test edilip





    }
}
