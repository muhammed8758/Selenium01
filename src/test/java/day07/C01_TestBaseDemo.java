package day07;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {
    /*UTILITIES
    -utilities tekrar tekrar kullanacagimiz classlari koydugumuz paketin adidir
    -TestBase-> Bugun
    -Driver->Sonra
    -ExellUtil->Sonra
    -Configuration -> Sonra
    -Utilitiies class larinda Test Case ler yazilmaz
    -Sadece Tekrar kullanilabilecek destek siniflar (support class) olusturur.
    -Bu support classlar test caselerin yazilmasini hizlandirir

     */
    @Test
    public void test01(){
        // techproeducation ana dayfasina git
        driver.get("https://www.techproeducation.com");

        //ve title Boootcamps kelimesi icerdigini test edelim
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Bootcamps"));


    }

}
