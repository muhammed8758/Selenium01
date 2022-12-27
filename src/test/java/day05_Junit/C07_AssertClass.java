package day05_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_AssertClass {


    WebDriver driver;

    @Before
    public void sutup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //   https://www.amazon.com adresine gidin
        driver.get("https://www.amazon.com");

    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {

        //    Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin

        //=> Sayfa başlığının “Amazon” oldugunu test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

        @Test
        public void test02(){
            //=> Amazon resminin görüntülendiğini (isDisplayed()) test edin
            WebElement sayfaRemi = driver.findElement(By.xpath("//*[@id='nav-logo-sprites']"));
            Assert.assertTrue(sayfaRemi.isDisplayed());
        }

        @Test
        public void test03(){
            //    Search Box 'in erisilebilir oldugunu test edin (isEnabled())
            WebElement searchBox = driver.findElement(By.xpath("//*[@for='twotabsearchtextbox']"));
            Assert.assertTrue(searchBox.isEnabled());
        }


        @Test
        public void test04() {
            //    wrongTitleTest  => Sayfa basliginin “amazon” olmadigini dogrulayin
            String actualTitle = driver.getTitle();
            String expectedTitle = "amazon";
            Assert.assertFalse(actualTitle.contains(expectedTitle));


        }

}
