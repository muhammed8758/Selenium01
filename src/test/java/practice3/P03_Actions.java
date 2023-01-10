package practice3;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P03_Actions extends TestBase {
    @Test
    public void actionsTest() {

//        http://uitestpractice.com/Students/Actions adresine gidelim
        driver.get("http://uitestpractice.com/Students/Actions");

//        Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini gorelim

        WebElement mavi = driver.findElement(By.id("div2"));
        Actions actions =new Actions(driver);
        actions.moveToElement(mavi).perform();


//        Double Click Me! butonuna tiklayalim ve cikan mesajin "Double Clicked !!" oldugunu dogrulayalim
        WebElement doubleClick = driver.findElement(By.name("dblClick"));
        actions.doubleClick(doubleClick).perform();
       String alert = driver.switchTo().alert().getText();
        Assert.assertEquals( "Double Clicked !!",alert);


//        Accept ile alert'ü kapatalım
        driver.switchTo().alert().accept();
//        Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin

        WebElement box1 = driver.findElement(By.id("draggable"));
        WebElement box2 =  driver.findElement(By.id("droppable"));
        actions.dragAndDrop(box1,box2).perform();

       String drop = driver.findElement(By.xpath("//*[p='Dropped!']//p")).getText();
       Assert.assertEquals("Dropped!",drop);


    }


}
