package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class H07_SariKirmizi extends TestBase {
    @Test
    public void name() {
//        -https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");
//        -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
       WebElement iframe = driver.findElement(By.xpath("//*[@class='demo-frame']"));
       driver.switchTo().frame(iframe);
        WebElement ikinciTus = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
        WebElement ucuncuTus = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[3]"));

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(ikinciTus, -175 ,0);
        actions.dragAndDropBy(ucuncuTus, -80 ,0);
        actions.dragAndDropBy(ikinciTus, 301 ,0).release().build().perform();

//                -Sarı olduğunu test edelim
        WebElement sari = driver.findElement(By.xpath("//*[@style='background-color: rgb(255, 255, 0);']"));
        assert sari.isDisplayed();


    }
}
