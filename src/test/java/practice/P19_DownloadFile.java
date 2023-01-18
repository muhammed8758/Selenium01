package practice;

import org.apache.poi.sl.draw.geom.Path;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

public class P19_DownloadFile extends TestBase {
    @Test
    public void name() throws InterruptedException {
        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");
        String tab1= driver.getWindowHandle();

        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        Actions actions = new Actions(driver);
       WebElement browser = driver.findElement(By.xpath("(//*[@class='btn btn-dark btn-lg btn-block rounded-0 text-left'])[1]"));
      actions.moveToElement(browser).perform();

        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        browser.click();
        Thread.sleep(1);
        driver.findElement(By.xpath("(//*[.='documentation'])[5]")).click();


        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        driver.findElement(By.xpath("//*[.='ChromeDriver 109.0.5414.74']")).click();

        //Açılan pencerede chromedriver'i indirelim
        Set<String> allHandles = driver.getWindowHandles();
        String tab2="";
        for(String w : allHandles){
            if(!w.equals(tab1)){
                tab2 = w;
            }
        }
        driver.switchTo().window(tab2);

        driver.findElement(By.xpath("(//*[.='chromedriver_win32.zip'])[2]")).click();

        //Driver'in indiğini doğrulayalım
        String dosyaYolu = System.getProperty("user.home")+"\\Downloads\\chromedriver_win32.zip"; // Bilgisaydaki dosya mevcutmu

        assert Files.exists(Paths.get(dosyaYolu));


    }
}
