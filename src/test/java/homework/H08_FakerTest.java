package homework;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class H08_FakerTest extends TestBase {
    @Test
    public void fakerTest() {

//        Faker class'ı, adlar, telefon numaraları, adresler, SSN vb.
//        gibi gerçek görünümlü verileri dinamik olarak oluşturmanıza olanak tanır.
//                Web uygulamanızın bunları doğru bir şekilde kaydedeceğini bildiğiniz sürece,
//        çoğu zaman ad veya adres gibi bu değerlerin ne olduğu umurunuzda olmaz ve faker kullanmak
//        bu verileri modellemenize ve bu alanlar için şimdiye kadar test çalıştırması için yeni dinamik
//        değerler oluşturmanıza olanak tanır.
//        Faker class'ını kullanabilmemiz için mvn repository adresinden java faker kütüphanesini
//        projemize eklememiz gerekmektedir.
//
//        //"https://demoqa.com/automation-practice-form"  Adresine gidin
        driver.get("https://demoqa.com/automation-practice-form");
//        // Formu doldurunuz
        Faker faker = new Faker();
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys(faker.name().firstName(), Keys.TAB, faker.name().lastName(), Keys.TAB, faker.internet().emailAddress(),
                Keys.TAB, Keys.SPACE,Keys.TAB,faker.phoneNumber().cellPhone(),Keys.TAB,"04.05.1987", Keys.ENTER,Keys.TAB, faker.lorem().sentence(), Keys.TAB,
        Keys.SPACE, Keys.TAB,Keys.SPACE, Keys.TAB, Keys.SPACE, Keys.TAB );

        WebElement dosyaSec= driver.findElement(By.xpath("//*[@id='uploadPicture']"));
        String dosyaYolu = "C:\\Users\\muham\\OneDrive\\Masaüstü\\logo.jpeg";
        dosyaSec.sendKeys(dosyaYolu);// bu sekilde de kullanilabilir

        driver.findElement(By.xpath("//*[@id='currentAddress']")).sendKeys(faker.address().fullAddress(),
                Keys.TAB, "N",Keys.ENTER, Keys.TAB, "D", Keys.ENTER);









//        // Sayfayi kapatin

    }
}
