package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_DropdownResuable {


    WebDriver driver;

    @Before  // eger test classi nda birden fazla method olusturulmus ise @before kullanilir
    public void sutup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

    }

    //REUSABLE METHOD: Dropdown icin tekrar tekrar kullanabilecegimiz method olusturalim
    public void selectFromDropdown(WebElement dropdown, String secenek) {
        // selectFromDropdown(driver.findElement(By.xpath("//*[@id='year']")), "2005");
        // selectFromDropdown(driver.findElement(By.xpath("//*[@id='month']")), "January");
        // selectFromDropdown(driver.findElement(By.xpath("//*[@id='day']")), "12");

        //  Gonderilen dropdown elementlernin tum optionslarini alinir
        List<WebElement> options = dropdown.findElements(By.tagName("option")); // Tum option tagli elementleri aliyor
        for (WebElement w : options) {
            if (w.getText().equals(secenek)) {
                w.click();
                break;
            }
        }


    }

    @Test
    public void selectFromDropdown() {

        selectFromDropdown(driver.findElement(By.xpath("//select[@id='year']")), "2005");//2005 i secti
    }


}
