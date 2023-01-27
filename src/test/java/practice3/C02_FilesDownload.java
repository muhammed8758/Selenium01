package practice3;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FilesDownload extends TestBase {
    // Exercise 2...


    //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
    //2. LambdaTest.txt dosyasini indirelim
    //3. dosyanin bilgisayarınızda downloads'a basariyla indirilip indirilmedigini test ediniz


    @Test
    public void name() {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.linkText("LambdaTest.txt")).click();
//Bundan sonrasini Java yapacak

       // "C:\Users\muham\Downloads"
        Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\muham\\Downloads\\LambdaTest.txt")));

        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\LambdaTest.txt";
        String dosyaYolu = farkliKisim+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
