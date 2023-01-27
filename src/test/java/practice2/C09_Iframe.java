package practice2;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C09_Iframe extends TestBase {
    @Test
    public void name() throws InterruptedException {
        // https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ sayfasına gidiniz
        driver.get("https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/");
        // Videoyu görecek kadar asagiya ininiz
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();


        // Videoyu izlemek icin Play tusuna basiniz
       WebElement iframe = driver.findElement(By.xpath("//iframe"));

        driver.switchTo().frame(iframe);

        WebElement play = driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        play.click();
        // videoyu durdurunuz
        Thread.sleep(3000);
        WebElement pause = driver.findElement(By.xpath("//*[@class='ytp-play-button ytp-button']"));
        pause.click();
        Thread.sleep(3000);

        // videoyu tam ekran yapınız
       WebElement fullSize = driver.findElement(By.xpath("//*[@class='ytp-fullscreen-button ytp-button']"));
       fullSize.click();
        Thread.sleep(3000);
        // videoyu calıstırınız
        pause.click();
        // videoyu kucultunuz
        fullSize.click();
        // videoyu durdurunuz
        pause.click();

        // Videoyu calistirdiginizi test ediniz
        assert driver.findElement(By.xpath("//*[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']")).isDisplayed();
        // 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz

        driver.switchTo().parentFrame();
        assert driver.findElement(By.xpath("//h1[.='jQuery Flexy Plugin Demos']")).isDisplayed();
    }
}
