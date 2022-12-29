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

public class T03_Dropdown {
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


        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        // Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        WebElement option = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select optionAll = new Select(option);
        optionAll.selectByIndex(1);
        System.out.println(optionAll.getFirstSelectedOption().getText());
        // Value kullanarak Option 2 seçin ve sectiginiz option'u yazdırın
        optionAll.selectByValue("2");
        String secilenValue = optionAll.getFirstSelectedOption().getText();
        System.out.println("secilenValue = " + secilenValue);


        // Visible Text kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        optionAll.selectByVisibleText("Option 1");
        // Tüm option'ları yazdırın
        List<WebElement> tumHepsi=optionAll.getAllSelectedOptions();
        int counter = 1;
        for(WebElement w : tumHepsi ){
            System.out.println(w.getText());
            counter++;

        }
        // dropdown'daki optionlarin toplam sayısının 3'e esit oldugunu test edin
        int expected =3;
        int actual =tumHepsi.size();
        Assert.assertEquals(expected,actual);

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}