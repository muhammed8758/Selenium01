package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class H03 extends TestBase {
    @Test
    public void test01() {


        //    Keyboard Base Actions
//            Homework
//    Yeni Class olusturun ActionsClassHomeWork
//1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

// 2- Hover over Me First" kutusunun ustune gelin
        WebElement link1 = driver.findElement(By.xpath("//*[.='Hover Over Me First!']"));
        hoverOverOnElementActions(link1);
        waitFor(1);


//    Link 1" e tiklayin
        driver.findElement(By.linkText("Link 1")).click();
//    Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

//    Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
//            “Click and hold" kutusuna basili tutun
        Actions actions = new Actions(driver);
        WebElement box = driver.findElement(By.id("click-box"));
        actions.clickAndHold(box).perform();
        waitFor(2);

//            7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(driver.findElement(By.id("click-box")).getText());
        actions.click(box).perform();



//            8- “Double click me" butonunu cift tiklayin
       WebElement box2= driver.findElement(By.xpath("//h2"));
        doubleClick(box2);


    }
}