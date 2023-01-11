package practice2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C04_WindowHandle extends TestBase {
    @Test
    public void windowHandleTest() {
        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        String tab1 = driver.getWindowHandle();

        // 2- url'in 'amazon' icerdigini test edelim
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("amazon"));

        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.bestbuy.com");
        String tab2 = driver.getWindowHandle();

        // 4- title'in 'Best Buy' icerdigini test edelim
        String bestByTitle =driver.getTitle();
        Assert.assertTrue(bestByTitle.contains("Best Buy"));

        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(tab1);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java", Keys.ENTER);

        // 6- arama sonuclarının 'Java' icerdigini test edelim
        String icerik = driver.findElement(By.xpath("//*[@class='a-color-state a-text-bold']")).getText();
        Assert.assertTrue(icerik.contains("java"));
        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(tab2);
        // 8- logonun gorundugunu test edelim
       WebElement logo =  driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
       Assert.assertTrue(logo.isDisplayed());

    }
}
