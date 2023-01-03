package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class P07_Dropdown extends TestBase {

    @Test
    public void test01() {
        //Amazon sayfasina gidelim.
        driver.get("https://www.amazon.com");
        //Dropdown menuden baby secelim
         List<WebElement> dropdown = driver.findElements(By.xpath("//*[@id='searchDropdownBox']"));
        //Select select = new Select(dropdown);

        dropdown.forEach(t-> System.out.println(t.getText()));
        driver.findElement(By.xpath("//*[@id='searchDropdownBox']")).sendKeys("Baby", Keys.TAB,"Milk",Keys.ENTER);

        //arama bolumunden milk aratalim


    }
}
