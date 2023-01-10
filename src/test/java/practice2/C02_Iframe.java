package practice2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Iframe extends TestBase {
    @Test
    public void IframeTest02() {


        // https://the-internet.herokuapp.com/iframe sayfasina gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        // 'An iFrame containing the TinyMCE WYSIWYG Editor' basliginin erisilebilir oldugunu test edin ve konsolda yazdırın.
       WebElement baslik = driver.findElement(By.xpath("//*[.='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(baslik.isEnabled());
        System.out.println(baslik.getText());


        // TextBox'a 'Merhaba Dunya' yazin.
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
       WebElement texBox = driver.findElement(By.xpath("//*[p='Your content goes here.']"));
       texBox.clear();
       texBox.sendKeys("Merhaba Dunya");

        // TextBox'in altinda bulunan 'Elemental Selenium' linkinin gorunur oldugunu test edin ve konsolda yazdirin
        driver.switchTo().parentFrame();
        WebElement elementalSelenium =driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalSelenium.isDisplayed());
        System.out.println("elementalSelenium = " + elementalSelenium);
    }
}
