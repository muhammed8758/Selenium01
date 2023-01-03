package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_DismissAlert extends TestBase {
    @Test
    public void dismissAlertTest() {

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        // 2. butona tıklayın,
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();
        // uyarıdaki Cancel butonuna tıklayın ve
        driver.switchTo().alert().dismiss();
        // result mesajının “You clicked: Cancel” oldugunu test edin.
        String actualResult = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedResult = "You clicked: Cancel";
        Assert.assertEquals(expectedResult, actualResult);

    }
}
