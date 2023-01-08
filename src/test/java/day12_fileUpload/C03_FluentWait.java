package day12_fileUpload;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

import java.time.Duration;

public class C03_FluentWait extends TestBase {
    @Test
    public void fluentWaitTest() {

//        https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//        Start buttonuna tıkla
        driver.findElement(By.xpath("//*[@id='start']//button")).click();
        //1. FluentWait icin obje olustur

        Wait<WebDriver> wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))// Max bekleme
                .pollingEvery(Duration.ofSeconds(3))// Deneme Araligi
                .withMessage("Ignore Exception")// Opsiyonel olarak mesaj yazdirilabilir
                .ignoring(NoSuchMethodException.class);// Exception u Handle ediliyor

        //2. Wait objesi kullanarak bekleme problemeini coz
        WebElement helloWorld = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='finish']//h4")));
        String helloWorldText=helloWorld.getText();
//        Hello World! Yazının sitede oldugunu test et
        Assert.assertEquals("Hello World!", helloWorld.getText());

    }
}
