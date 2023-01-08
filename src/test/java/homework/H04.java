package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class H04 extends TestBase {
    @Test
    public void test01() {

        //    Bir Class olusturalim KeyboardActions2
        //     https://html.com/tags/iframe/ sayfasina gidelim
        driver.get(" https://html.com/tags/iframe/");

        //     video’yu gorecek kadar asagi inin
        scrollDownActions();
      //  scrollDownActions();

        //     videoyu izlemek icin Play tusuna basin
        driver.switchTo().frame(0);

      driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();


        waitFor(2);
        //     videoyu calistirdiginizi test edin



    }

    @Test
    public void test02() {

        // Test02 :  1- amazon gidin
        driver.get("https://www.amazon.com");

        //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement all = driver.findElement(By.id("searchDropdownBox"));
        Select dropdwnAll= new Select(all);
       List<WebElement> liste =  dropdwnAll.getOptions();
//       for(WebElement w : liste){
//           System.out.println(w.getText());
//       }
       liste.stream().forEach(t-> System.out.println(t.getText()));


        //dropdown menude 40 eleman olduğunu doğrulayın

    }





/*
Test03
dropdown menuden elektronik bölümü seçin
arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
sonuc sayisi bildiren yazinin iphone icerdigini test edin
ikinci ürüne relative locater kullanarak tıklayin
ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim


Test04
yeni bir sekme açarak amazon anasayfaya gidin
dropdown’dan bebek bölümüne secin
bebek puset aratıp bulundan sonuç sayısını yazdırın
sonuç yazsının puset içerdiğini test edin
5-üçüncü ürüne relative locater kullanarak tıklayin
6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin  Test 4
1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
     */
}
