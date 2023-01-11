package practice2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C05_WindowHandles extends TestBase {
    @Test
    public void windowHandlesTest() {

        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
       String tab1= driver.getWindowHandle();

        // arama motoruna 'oppo' yazıp aratın
       WebElement aramaMotoru=  driver.findElement(By.id("searchData"));
        aramaMotoru.sendKeys("oppo", Keys.ENTER);

        // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//img[@class='lazy cardImage'])[1]")).click();
        Set<String> allHandles = driver.getWindowHandles();
        String tab2="";
        for(String w : allHandles){
            if(!w.equals(tab1)){
                 tab2 = w;
            }
        }
        driver.switchTo().window(tab2);


        // Basligin 'Oppo' icerdigini test edin.

      String baslik =  driver.findElement(By.xpath("//h1[@class='proName']")).getText();
        Assert.assertTrue(baslik.contains("Oppo"));

        // ilk sayfaya donun ve Title'ını yazdırın
        System.out.println(driver.switchTo().window(tab1).getTitle());

    }
}
