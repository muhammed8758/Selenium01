package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class H02 extends TestBase {
    @Test
    public void test01() {

//        https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");

//        Title'in "Windows" oldugunu test edin
       String baslik = driver.getTitle();
       String expected = "Windows";
       Assert.assertEquals(baslik,expected);


//        Click here a tiklayin
        driver.findElement(By.xpath("//*[.='Click Here']")).click();

//        Sonra acilan sayfadaki title in "New Window" oldugunu dogrulayin
        List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        String iki = driver.switchTo().window(windowHandles.get(1)).getTitle();
        String expected2 = "New Window";
        Assert.assertEquals(iki,expected2);

//
    }
}
