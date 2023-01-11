package practice2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Set;

public class C06_ActionsMoveToElement extends TestBase {
    @Test
    public void actionsTest() {
        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        String tab1 = driver.getWindowHandle();

        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        Actions actions = new Actions(driver);

        WebElement language = driver.findElement(By.xpath("//*[@class='icp-nav-link-inner']"));
        actions.moveToElement(language).perform();

        // Change country/region butonuna basiniz
        WebElement countryRegion = driver.findElement(By.xpath("(//*[@class='icp-mkt-change-lnk'])[1]"));
        actions.click(countryRegion).perform();

        // United States dropdown'undan 'Turkey (Türkiye)' seciniz

        WebElement ulke = driver.findElement(By.id("icp-dropdown"));
        Select ulkeDropdown = new Select(ulke);
        ulkeDropdown.selectByVisibleText("Turkey (Türkiye)");

        driver.findElement(By.xpath("//*[@class='a-column a-span12 a-ws-span5']")).click();

        // Go to website butonuna tiklayiniz
        driver.findElement(By.xpath("//*[@class='a-button-input']")).click();
        Set<String> allHandles = driver.getWindowHandles();
        String tab2="";
        for (String w : allHandles) {
            if(!w.equals(tab1)){
                tab2=w;
            }
        }
        driver.switchTo().window(tab2);
        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
        String son = driver.getTitle();
        System.out.println("son = " + son);
        Assert.assertTrue(son.contains("Elektronik"));
    }
}
