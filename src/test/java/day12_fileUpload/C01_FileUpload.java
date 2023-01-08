package day12_fileUpload;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_FileUpload extends TestBase {
    @Test
    public void fileUploadTest() {


        //    Tests packagenin altina bir class oluşturun : C05_UploadFile

//    https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload ");


//    chooseFile butonuna basalim
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));

//    Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu = System.getProperty("user.home") +"\\OneDrive\\Masaüstü\\logo.jpeg";
        chooseFileButton.sendKeys(dosyaYolu);
        waitFor(2);
//    Upload butonuna basalim.
       WebElement upload = driver.findElement(By.id("file-submit"));
       upload.click();

//    File Uploaded!” textinin goruntulendigini test edelim.
       String uploadedYazisi = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("File Uploaded!", uploadedYazisi);

    }
}