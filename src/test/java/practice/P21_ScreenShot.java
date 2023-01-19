package practice;


import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WindowType;
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

        driver.navigate().back();
        Thread.sleep(3000);
        date = new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResmi/tumSayfa"+date+".jpeg"));

        //Arama sonucunun resmini alalım

    }
}