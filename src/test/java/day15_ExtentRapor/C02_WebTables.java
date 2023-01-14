package day15_ExtentRapor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {


//        Create a class: WebTables

    //        Task 2 : 3. Row’ datalarını print edin
//        Task 3 : Son row daki dataları print edin
//        Task 4 : 5. Column datalarini print edin

//    odev
//        Task 5 : Iki parametreli bir Java metot oluşturalım: printData
//        Parameter 1 = row numarasi
//        Parameter 2 = column numarasi
//        printData(2,3);  => 2nd row, 3rd column daki datayı print etsin
    @Test
    public void table1Print() {


            driver.get("https://the-internet.herokuapp.com/tables");
            String table1 = driver.findElement(By.xpath("//table[@id='table1']")).getText();
            System.out.println("TABLE 1 VERILERI");
            System.out.println(table1);
            List<WebElement> tumVeriler = driver.findElements(By.xpath("//table[@id='table1']//td"));
            for (WebElement veri : tumVeriler){
                System.out.println(veri.getText());
            }
        }

    @Test
    public void row3Print() {
        driver.get("https://the-internet.herokuapp.com/tables");
        List <WebElement> row3Elements = driver.findElements(By.xpath("//*[@id='table1']//tbody//tr[3]//td"));
        for (WebElement w : row3Elements) {
            System.out.println("w = " + w.getText());
        }
      //  row3Elements.stream().forEach(t-> System.out.println(t.getText()));
        
        
    }

    @Test
    public void lastRowVerileriTest() {
        driver.get("https://the-internet.herokuapp.com/tables");
        List <WebElement> lastRowVerileri = driver.findElements(By.xpath("//*[@id='table1']//tbody//tr[last()]//td"));
        for (WebElement w : lastRowVerileri) {
            System.out.println("w = " + w.getText());
        }
        //  lastRowVerileri.stream().forEach(t-> System.out.println(t.getText()));
    }

    @Test
    public void sutun5Test() {
        driver.get("https://the-internet.herokuapp.com/tables");
        List <WebElement> sutun5Test = driver.findElements(By.xpath("//*[@id='table1']//tbody//tr//td[5]"));
        for (WebElement w : sutun5Test) {
            System.out.println("w = " + w.getText());
        }
        //  sutun5Test.stream().forEach(t-> System.out.println(t.getText()));

    }
}
