package day13_Exceptions;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utilities.TestBase;

public class C03_NullPointerException {

    WebDriver driver;
    Faker faker;

    @Test
    public void name() {
    }

    @Test
    public void test01() {
//        NullPointerException
//        When a variable is created, but not instantiated, when pointer does not show any value then we get NullPointerException.
//        It is common to initialize the Driver, they we get the extaction. Driver driver; but never use driver=new ChromeDriver()
//        For example, in my page object model, I create page objects in test classes but when I forgot to use new keyword to instantiate, then I get the exception
//        Solution:
//        Instantiate the variable

//        NullPointerException
//        Degiskenleri oluşturup instantiate etmediğimizde alırız(new kelimesini kullanmadigimizda)
//        Ornegin WebDriver driver; deyip = new ChromeDriver() demezisek null pointer exception aliriz
//        Solution:
//        Degiskeni instantiate et

        driver.get("https://www.google.com");



    }

    @Test
    public void test2() {
      //  faker=new Faker();
        System.out.println(faker.name().firstName());// new faker demeyeyerek nullpointer exception aldik

    }
}
