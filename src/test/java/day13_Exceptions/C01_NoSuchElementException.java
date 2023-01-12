package day13_Exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {
    @Test
    public void noSuchElementTest() {

        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//*[@class='elementor-item elementor-item-active ']")).click();
                /*
        TimeOutException:
Explicit wait kullanildiginda, ve element bulunamadiginda alinir.
Explicit wait & yanlis locator-> timeout
Explicit wait & doğru locator & sure yeterli degil -> timeout
Explicit wait & dogru locator & sure yeterli & iframe var ->  time out
Solution:
-Sureyi arttirmak
-Farkli explicit kullanmak: wait visibilityOfElementLocated YERINE presenceOfElementLocated. Yada javascript executor da ki waiter sayfa geçişlerini beklemek icin kullanabilirim
-Locatori tekrar kontrol etmek
-Frameworkunde hazir reusable method lar var Bu durumda timeoutexception aldigimda hızlıca o metotlar yardımıyla problemi cozebiliyoruz
        */



    }
}
