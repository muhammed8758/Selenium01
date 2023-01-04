package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P12 extends TestBase {
    @Test
    public void test01() throws InterruptedException {

//        1. Launch browser

//        2. Navigate to url 'http://automationexercise.com'
         driver.navigate().to("http://automationexercise.com");
//        3. Verify that home page is visible successfully
        String homePage = driver.getTitle();
        Assert.assertEquals("Automation Exercise",homePage);
        System.out.println("homePage = " + homePage);


//        4. Click on 'Signup / Login' button
       WebElement login= driver.findElement(By.xpath("(//*[@class='nav navbar-nav']//li)[4]"));
       login.click();
       Thread.sleep(3000);


//        5. Verify 'Login to your account' is visible
        String logIn = driver.findElement(By.xpath("//div/h2[1]")).getText();

        Assert.assertEquals("Login to your account",logIn);



//        6. Enter correct email address and password
        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("muhammed@gmail.com", Keys.TAB,"Md4158");

//        7. Click 'login' button
        driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();
//        8. Verify that 'Logged in as username' is visible
       WebElement logout= driver.findElement(By.xpath("(//*[@class='nav navbar-nav']//li)[4]"));
       Assert.assertTrue(logout.isDisplayed());



//        9. Click 'Delete Account' button
        driver.findElement(By.xpath("(//*[@class='nav navbar-nav']//li)[5]")).click();

//        10. Verify that 'ACCOUNT DELETED!' is visible
       String delete= driver.findElement(By.xpath("//b")).getText();
        System.out.println("delete = " + delete);

    }
}
