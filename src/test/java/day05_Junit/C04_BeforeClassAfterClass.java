package day05_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeClassAfterClass {

    /*
        @BeforeClass ve @AfterClass notasyonlari sadece static methodlar icin calisir
    @BeforeClass ve @AfterClass kullanirsak olusturdugumuz Test Methodlarinin hepsni ayni anda calsitirip
    en son @AfterClass i calistiririz.
        Ama Sadece @Before ve @After kullanirsak her test icin @before ve @After i kullanilir
     */


    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterClass
    public static void tearDown() {
        System.out.println("Butun Testlerden Sonra Calsiti");
    }
    @Before
    public void setup01(){
        System.out.println("Her Ters den once calsir");
    }
    @After
    public void tearDown01(){
        System.out.println("Her Ters den sonra calsir");
    }

    @Test
    public void test01(){
        System.out.println("Ilk test");
    }
    @Test
    public void test02(){
        System.out.println("ikinci test");
    }
    @Test
    @Ignore         // Calistirmak istemedigimiz test icin @ignore kullanlir
    public void test03(){
        System.out.println("Ucuncu test");
    }

}
