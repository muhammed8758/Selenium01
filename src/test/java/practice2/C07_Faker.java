package practice2;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.Key;

public class C07_Faker extends TestBase {

    @Test
    public void test01() {

        // 'https://www.facebook.com' sayfasina gidiniz
        driver.get("https://www.facebook.com");

        // yeni hesap olustur butonuna basin
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        // isim kutusunu locate ediniz
        WebElement nameBox = driver.findElement(By.xpath("//*[@name='firstname']"));
        // geriye kalan alanlari TAB ile dolasarak faker bilgilerle formu doldurun}
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        Actions actions = new Actions(driver);
        actions.click(nameBox).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).
                sendKeys(email).sendKeys(Keys.TAB).sendKeys(email).sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password()).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("15").sendKeys(Keys.TAB).sendKeys("Ocak").sendKeys(Keys.TAB)
                .sendKeys("1987"). sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_RIGHT).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();







    }
}
