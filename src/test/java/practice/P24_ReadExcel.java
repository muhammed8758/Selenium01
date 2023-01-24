package practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class P24_ReadExcel extends TestBase {
    @Test
    public void name() throws IOException {
        //Bilgisayarınızdaki data isimli excel dosyasından kullanıcı bilgilerini alıp
        String dosyaYolu = "C:\\Users\\muham\\Downloads\\data.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        String email= workbook.getSheet("Sayfa1").getRow(1).getCell(1).toString();
        System.out.println(email);
        String password = workbook.getSheet("Sayfa1").getRow(2).getCell(1).toString();
        System.out.println(password);

        //https://www.bluerentalcars.com/ adresine gidip
        driver.get("https://www.bluerentalcars.com/");

        //Excel dosyasından aldığımız kullanıcı bilgileri ile login olalım
        driver.findElement(By.xpath("//*[@class='btn btn-primary btn-sm']")).click();
        WebElement emailAdress = driver.findElement(By.xpath("//*[@id='formBasicEmail']"));
        emailAdress.sendKeys(email,Keys.TAB,password,Keys.ENTER);

        //Login olduğumuzu doğrulayalım
        WebElement login = driver.findElement(By.xpath("//*[@id='dropdown-basic-button']"));
        assert login.getText().equals("Erol Evren");
    }
}
