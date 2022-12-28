package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class T01_Dropdown {
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


        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/ ");
        // dropdown'dan "Books" secenegini secin
        WebElement all = driver.findElement(By.xpath("//*[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        Select allDown = new Select(all);
        allDown.selectByVisibleText("Books");
        // arama cubuguna "Java" aratın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);
        // arama sonuclarinin Java icerdigini test edin
        WebElement aramaSonuc = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(aramaSonuc.getText());
        if (aramaSonuc.getText().contains("Java")){
            System.out.println("Passed");
        }else System.out.println("Failed");
        Assert.assertTrue(aramaSonuc.getText().contains("Java"));


    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}