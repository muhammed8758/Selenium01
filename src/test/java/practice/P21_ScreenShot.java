package practice;


import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class P21_ScreenShot extends TestBase {
    @Test
    public void name() throws IOException, InterruptedException {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        String amazonSayfasi = driver.getWindowHandle();
        //Tüm sayfanın resmini alalım
        String date = new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResmi/tumSayfa"+date+".jpeg"));
        /*
        FILEUTILS CLASS'I, FİLE NESNELERİ İLE BİRLİKTE KULLANABİLECEĞİMİZ METHODLAR İÇERİR.
        BU METHODLARI KULLANARAK DOSYALARDA OKUMA, YAZMA VE KOPYALAMA İŞLEMLERİNİ ÇOK DAHA KOLAY YAPABİLİRİZ
         */
        //Yeni bir sekmede techproeducation sayfasına gidip sayfanın resmini alalım
        Thread.sleep(6000);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");
        date = new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResmi/tumSayfa"+date+".jpeg"));


        //Tekrar amazon sayfasına dönüp iphone aratalım
        driver.switchTo().window(amazonSayfasi);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        //Arama sonucunun resmini alalım
        WebElement sonuc = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        FileUtils.copyFile(sonuc.getScreenshotAs(OutputType.FILE),new File("target/WebElementScreenShot/WEScreenShot"+date+".jpeg"));
        //sonuc elementini locate edip webelmente assine edin
        //FileUtils.copyFile(WE.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResmi/tumSayfa"+tarih+".jpeg"));
    }
}