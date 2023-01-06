package day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions01 extends TestBase {
    /*
    double clic()     : cift tikla
    ClickAndHold()    : tikla ve tut ve bekle
    dragAndDrop()     : bir noktadan dige noktaya surukler ve birakir
    contextClic()      : sag tiklama
    moveToElement()    : su elemete git
     */

    @Test
    public void rightClic() {
//        Class: Actions
//        Method: rightClick

        Actions actions =new Actions(driver); // Actions object olustur

//        https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

//        Kutuya sag tıklayın
       WebElement box =  driver.findElement(By.id("hot-spot"));
       actions.contextClick(box).perform();


//        Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
        Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());

//        Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();
    }
}
