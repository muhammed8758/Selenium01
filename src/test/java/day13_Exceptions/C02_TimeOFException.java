package day13_Exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOFException extends TestBase {
//    TimeOutException:
//    If you use explicit wait and wait time is not enough/locator still incorrect then TimeOutException
//    Simply put, wait time is over but the commend is not completed
//    Solution:
//            -Increase the wait time
//-Try using different wait. For example try using javascript executor wait for the page to load. This is also a dynamic wait
//-I have different explicit waits in my Reusable util class. I have javascript executor wait as well. ReusableMethods.waitForPageToLoad(1);
//-Case by case, I prefer different explicit waits to maximize the performance of the automation script

    //Explicit wait kullandik locater elemani buladi timeoutexception alinir


    @Test
    public void test01() {
        driver.get("https://www.techproeducation.com");
       // Explit wait iicn olusturdugumuz methodlardan birimi kullanalim
        //PArametre 1 beklemek istedigim element, parametre 2 max sure
        //waitForVisibility( driver.findElement(By.xpath("//*[@class='elementor-item elementor-item-active ']")),15);

        WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Yanlis Id")));


    }
}
