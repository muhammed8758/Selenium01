package day10_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_DragAndDown extends TestBase {
    @Test
    public void DragAnDown() {
//        Class: Action4
//        Method: dragAndDropTest
//        Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
//        And user moves the target element(Drag me to my target) in to  destination(Drop here)

        driver.switchTo().frame(0);
        WebElement kaynak = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement hedef = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(kaynak, hedef).perform();
    }

    @Test
    public void clikAndHold() {
        driver.get("https://jqueryui.com/droppable/");
//        And user moves the target element(Drag me to my target) in to  destination(Drop here)

        driver.switchTo().frame(0);
        WebElement kaynak = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement hedef = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(kaynak).
                moveToElement(hedef).
                release().// kaynagi birak
                build().// onceki methodlari insaa eder  ve kullanilabilir de kullanilmaya da bilir
                perform();



    }

    @Test
    public void moveByOffSet() {
        driver.get("https://jqueryui.com/droppable/");
//        And user moves the target element(Drag me to my target) in to  destination(Drop here)

        driver.switchTo().frame(0);
        WebElement kaynak = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement hedef = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(kaynak).moveByOffset(401,22).
                release().build().perform();

    }
}
