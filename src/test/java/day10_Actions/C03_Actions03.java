package day10_Actions;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions03 extends TestBase {
    @Test
    public void scrollUpDown() {

        //https://techproeducation.com a git
        driver.get("https://techproeducation.com");

        //Sayfanin altına doğru gidelim
        Actions actions = new Actions(driver);

//        waitFor(2);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        waitFor(2);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        waitFor(2);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();

        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);

//      Page Down dan biraz daha az mesafe aldirir
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        waitFor(2);

        actions.sendKeys(Keys.PAGE_UP).perform();
        waitFor(2);
        actions.sendKeys(Keys.ARROW_UP).perform();
        waitFor(2);

        //Sonra sayfanın üstüne doğru gidelim

    }
}
