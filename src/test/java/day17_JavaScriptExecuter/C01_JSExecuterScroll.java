package day17_JavaScriptExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import utilities.TestBase;

public class C01_JSExecuterScroll extends TestBase {
    @Test
    public void scrollIntoViewTest() {
//        scrollIntoViewTest metotu olustur
        //

//        Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com");
        waitFor(3);

//        We Offer elementi gorunur olacak sekilde uzerine scroll et ve ekran gorunturunu al
        //1.adim
        WebElement weOffer = driver.findElement(By.xpath("//*[.='we offer']"));
        waitFor(3);
        //2.adim
        JavascriptExecutor js = (JavascriptExecutor)driver;// casting yapildi

        //3.adim yapmak istedigim islemi js.executeScript methodu ile yap
        //scrollIntoView(true): methodu ile belirli bir elemana scroll yapmak icin kulanilir
        //arguments[0] ilk parametrede ki eleman
        js.executeScript("arguments[0].scrollIntoView(true);", weOffer);
        waitFor(3);

        //sayfa goruntusu al
        takeScreenShotOfPage();

//        Ayni sayfada Enroll Free Course elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al

       WebElement enrollFree = driver.findElement(By.xpath("//*[.='Enroll Free Course']"));
        scrollIntoViewJS(enrollFree);
        waitFor(3);
        takeScreenShotOfPage();

//        Ayni sayfada WHY US? elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        scrollIntoViewJS(driver.findElement(By.xpath("//*[.='WHY US?']")));
        waitFor(1);
        takeScreenShotOfPage();

//        Ayni sayfada tekrar Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        scrollIntoViewJS(driver.findElement(By.xpath("//*[.='Enroll Free Course']")));

        waitFor(3);
        takeScreenShotOfPage();

        scrollEndJS();
        waitFor(3);
        scrollTopJS();
    }
}
