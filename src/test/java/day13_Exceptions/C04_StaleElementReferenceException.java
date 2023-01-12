package day13_Exceptions;

import com.beust.ah.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferenceException extends TestBase {
    @Test
    public void staleElementReferenceExceptionTest01() {
        driver.get("https://www.techproeducation.com");
        //LMS login linkine tikla ve o sayfanin URL nin lms icerdigini test et
        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
        lmsLogin.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("lms"));
        waitFor(5);

        //Tekrar anasayfaya gel ve Lms Login sayfasina tekrar git
        driver.navigate().back();
        waitFor(5);
        lmsLogin.click();


    }

    @Test
    public void staleElementReferenceExceptionTest2() {
        driver.get("https://www.techproeducation.com");
        waitFor(5);
        WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));
        waitFor(5);
        driver.navigate().refresh();
        waitFor(5);
        lmsLoginLink.click();

      //  Cozum eski stale  elementi locate et
    //    driver.findElement(By.linkText("LMS LOGIN")).click();

    }
}