package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.security.Key;

public class P18_Upload extends TestBase {
    @Test
    public void uploadTest() throws InterruptedException {
        //https://demo.guru99.com/test/upload/ adresine gidiniz
        driver.get("https://demo.guru99.com/test/upload/");
        //Bilgisayarınızdan herhangi bir dosyayı upload ediniz

        String anaYol = System.getProperty("user.home");
        String ortakYol ="\\OneDrive\\Masaüstü\\logo.jpeg";
        String dosyaYolu = anaYol+ortakYol;

     //  String dosyaYolu = "C:\\Users\\muham\\OneDrive\\Masaüstü\\logo.jpeg";

        WebElement upload = driver.findElement(By.id("uploadfile_0"));
        upload.sendKeys(dosyaYolu);

        // I accept terms of service bölümünü tikleyin
        WebElement checkBox = driver.findElement(By.xpath("//*[@id='terms']"));
        checkBox.click();
        checkBox.sendKeys(Keys.TAB,Keys.TAB, Keys.ENTER);


        // Submit File buttonuna basınız
        // "1 file has been successfully uploaded" görünür olduğunu test edin
        Thread.sleep(2000);
        assert driver.findElement(By.xpath("//*[@id='res']")).isDisplayed();
    }
}
