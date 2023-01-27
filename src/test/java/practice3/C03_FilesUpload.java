package practice3;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_FilesUpload extends TestBase {
    @Test
    public void name() {
// Exercise 3...

        // masaustunde bir deneme dosyası olusturun
        // 'https://the-internet.herokuapp.com/upload' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/upload");
        // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz
        WebElement dosyaSec = driver.findElement(By.xpath("//*[@id='file-upload']"));

        String farkliYol = System.getProperty("user.home");
        String ortakYol = "OneDrive\\Masaüstü\\logo.jpeg";
        String uploadKisim= farkliYol+ortakYol;

        dosyaSec.sendKeys(uploadKisim);
        // 'Upload' butonuna basın
        // 'File Uploaded!' yazısının goruntulendigini test edin

    }
}
