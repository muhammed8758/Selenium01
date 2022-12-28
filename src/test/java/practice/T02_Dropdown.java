package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class T02_Dropdown {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {

        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");
        // dropdown'dan "Baby" secenegini secin
       WebElement all = driver.findElement(By.xpath("//*[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        Select allDropdown = new Select(all);
        allDropdown.selectByVisibleText("Baby");

       // sectiginiz option'i yazdirin
        String secilenOption = allDropdown.getFirstSelectedOption().getText();
        System.out.println(secilenOption);
        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
        List<WebElement> toplam = allDropdown.getOptions();
        int actual = toplam.size();
        int expected =28;
        Assert.assertEquals(expected,actual);


    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
