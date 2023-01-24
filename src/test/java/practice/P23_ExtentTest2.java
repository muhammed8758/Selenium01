package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class P23_ExtentTest2 extends TestBase {
    @Test
    public void name() {

        //https://www.techlistic.com/p/demo-selenium-practice.html adresine gidelim
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        extentTest.info("URL ye gidildi");

        //Demo Table altındaki tablodaki otel bilgilerini yazdırınız
        List<WebElement> otelInfos = driver.findElements(By.xpath("//*[@class='tsc_table_s13']//tbody//tr"));
        otelInfos.forEach(t -> System.out.println(t.getText()));
        extentTest.info("Otel Bilgileri");

        //Demo Table altındaki otel bilgileri olan tablodan Height değeri 601m olan otelin bilgilerini yazdırınız
        int row = 1;
        for (WebElement w : otelInfos) {
            if (w.getText().contains("601m")) {
                System.out.println("Tablodaki " + row + " satirdaki otel bilgileri : " + w.getText());
            }
            row++;
        }
        //Bütün Height bilgilerini yazdırınız
        List<WebElement> heightInfos = driver.findElements(By.xpath("//*[@class='tsc_table_s13']//tbody//tr//td[3]"));
        heightInfos.forEach(t -> System.out.println(t.getText()));
        //Otel uzunluklarının hepsini toplayınız
        List<String> list = new ArrayList<>();
        for (WebElement q : heightInfos) {
            list.add(q.getText());
        }
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i).replace("m", ""));
        }
        list.forEach(System.out::println);
        int sum = 0;
        for (String s : list) {
            sum += Integer.parseInt(s);
        }
        System.out.println(sum);


        //Bir method ile satır ve sutun bilgilerini çağıralım
        tabloSatirSutun(3,4);
    }
    private void tabloSatirSutun(int satir, int sutun){
        System.out.println(satir+"satir"+sutun+"sutun bilgisi :"+
                driver.findElement(By.xpath("//*[@class='tsc_table_s13']//tbody//tr["+satir+"]//td["+sutun+"]")).getText());

    }
}