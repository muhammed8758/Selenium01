package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import javax.swing.text.Utilities;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P10 extends TestBase {
    @Test
    public void test01() {

        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        // ikinci emojiye tıklayın
        WebElement iframe = driver.findElement(By.xpath("//*[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//*[@data-upgraded=',MaterialRipple'])[2]")).click();

        // tüm ikinci emoji öğelerini tıklayın
        List<WebElement> emojies = driver.findElements(By.xpath("//*[@id='nature']//img"));
        emojies.stream().forEach(t -> t.click());// lambda ile

//        for(WebElement w : emojies){
//            w.click();
//        }


        // parent iframe e geri donun
        //  driver.navigate().refresh();
        //  driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();

        // formu doldurun,(Formu istediğiniz metinlerle doldurun)
        List<WebElement> lst = driver.findElements(By.xpath("//*[@class='mdl-textfield__input']"));

        List<String> veriler = new ArrayList<>(Arrays.asList("Muhammed", "Dogan","Dogan", "Java", "SQL", "GIT", "Muhammed", "Dogan", "Java", "SQL", "GIT", "Mer"));

        for (int i = 0; i < lst.size(); i++) {
            lst.get(i).sendKeys(veriler.get(i));
        }


        //  apply button a basin
        driver.findElement(By.xpath("//*[@id='send']")).click();


    }
}
