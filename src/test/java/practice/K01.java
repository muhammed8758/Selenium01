package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class K01 {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void Test01() {

        //1-https://rahulshettyacademy.com/AutomationPractice/ adresine gidin
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //2-Dropdown Example menüsünün görünür olduğunu doğrulayın.
        WebElement gorunur = driver.findElement(By.xpath("//*[text()='Dropdown Example']"));
        Assert.assertTrue(gorunur.isDisplayed());
        //3-Option3 ü seçin.
        WebElement option = driver.findElement(By.id("dropdown-class-example"));
        Select optionDropdown = new Select(option);
        optionDropdown.selectByVisibleText("Option3");
        //4-Option3 ün seçili olduğunu doğrulayın.
        WebElement DogruMu = optionDropdown.getFirstSelectedOption();
        WebElement option3= driver.findElement(By.xpath("(//*[@value='option3'])[1]"));
        Assert.assertEquals(DogruMu,option3);




    }
}
