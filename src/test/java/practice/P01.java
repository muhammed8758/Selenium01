package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//    -"amazon.com" adresine gidelim
        driver.get("https://www.amazon.com");

//    -bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
        String actualTitle = driver.getTitle();
        String actualUrl = driver.getCurrentUrl();
        System.out.println("actualUrl = " + actualUrl);
        System.out.println("actualTitle = " + actualTitle);


//    -title ve url'nin "spend" kelimesinin icerip icermedigini kontrol edelim
        Assert.assertFalse(actualTitle.contains("spend") && actualUrl.contains("spend")); // dogrulama yapmak icin kullanilir if else yerine

//    -Ardindan "trendyol.com" adresine gidelim
        driver.get("https://www.trendyol.com");

//    -bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
        String actualTitle2 = driver.getTitle();
        System.out.println("actualTitle2 = " + actualTitle2);
        Assert.assertTrue(actualTitle2.contains("Sitesi"));
//    -Bi onceki web sayfamiza geri donelim
        driver.navigate().back();
//    -sayfayi yenileyelim
        driver.navigate().refresh();
//    -Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim
        driver.navigate().forward();
        driver.quit();


    }
}