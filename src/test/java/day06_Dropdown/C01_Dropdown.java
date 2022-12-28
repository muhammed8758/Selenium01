package day06_Dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_Dropdown {
        WebDriver driver;

        @Before  // eger test classi nda birden fazla method olusturulmus ise @before kullanilir
        public void sutup() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

    }

    @Test

    public void selectByIndexTesxt() {
        //Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        // Dogum yil, ay ve gunu seceer 2020/June/10

        //1. Locate dropdown element
        WebElement year = driver.findElement(By.xpath("//*[@id='year']"));
        //2. Select object olustur
        Select yearDropdown = new Select(year);
        //3. Select olbject kullanilarak 3 farkli sekilde secim yapabiliriz
        //yil
        yearDropdown.selectByIndex(22);// index secenek sirasi 0 dan baslar
        //ay
        WebElement month = driver.findElement(By.xpath("//*[@id='month']"));
        Select monthDropdown = new Select(month);
        monthDropdown.selectByValue("0");// option in value degeri ile secim yapilabilri.
        //gun
        WebElement day = driver.findElement(By.xpath("//*[@id='day']"));
        Select dayDropdown = new Select(day);
        dayDropdown.selectByVisibleText("10");

    }

    @Test
    public void printAllTest() {


        //Tum eyaletleri print ediniz
        WebElement state = driver.findElement(By.xpath("//*[@id='state']"));
        Select stateDropdown = new Select(state);
        List<WebElement> tumStateList = stateDropdown.getOptions();
        for (WebElement w : tumStateList) {
            System.out.println(w.getText());
        }
        tumStateList.stream().forEach(t-> System.out.println(t.getText()));


    }


    @Test
    public void getFirstSelectedOptionTest() {

        // State dropdown daki varsayilan secili secenegi "Select a State " oldugunu veryf edelim
        WebElement state = driver.findElement(By.xpath("//*[@id='state']"));
        Select stateDrpdown = new Select(state);
        String defaultText = stateDrpdown.getFirstSelectedOption().getText();// chain yapildi
        Assert.assertEquals("Select a State", defaultText);


    }

    @Test       // kendimin yaptigi
    public void test2 (){
        WebElement option = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select optionDropdown = new Select(option);
       optionDropdown.selectByVisibleText("Option 2");

       WebElement stateselection = driver.findElement(By.xpath("//*[@id='state']"));
       Select stateSelectDropdown = new Select(stateselection);
       List<WebElement> eyaletler= stateSelectDropdown.getOptions();
       for(WebElement w : eyaletler){
           System.out.println(w.getText());
       }
       eyaletler.stream().forEach(t-> System.out.println(t.getText()));




    }








    @After
    public void tearDown() {
        driver.close();
    }


/*
    1.What is Dropdown?
    dropdown liste olusturma icin kullanilir
    2. How to handle dropdown elemnent? // selec classi duymak ister
    -dropdown i locate ederiz
    -select object olustururum
    -select object ile istedigim secenegi secerim
    Note: select objesi olusturma nedenim, dropdownlarin Select class ile olusturulmasi
    3.Tum dropdown seceneklerini nasil cosolda print ederiz
    -tum dropdown elementlerini getOptions() method ile listeye koyariz
    -sonra secenekleri loop ile yazdiririz
    4. Bir secenegin secili oldugunu otomate etmek icin ne yapilir
    Ornek gun olarak 10 u sectik ama ya secilmediyse
    getFirstSelectedOption() secili olan secenegi

     */


}