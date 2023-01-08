package day12_fileUpload;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_Explicit extends TestBase {
    @Test
    public void test01() {
//        https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//        Start buttonuna tıkla
        driver.findElement(By.xpath("//*[@id='start']//button")).click();
//       WebElement helloWord =  driver.findElement(By.xpath("//*[@id='finish']//h4"));
//        Assert.assertEquals("Hello World!", helloWord.getText());

        //1 adim
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));// explicitWait kullanmamiz icin object olusturmamiz gerekir

        //2.adim wait objesi kullanarak bekleme problemlerini coz
       WebElement helloWorld = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='finish']//h4")));
       String helloWorldText=helloWorld.getText();



//        Hello World! Yazının sitede oldugunu test et
        Assert.assertEquals("Hello World!", helloWorld.getText());
    }
}
