package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle3 extends TestBase {
    @Test
    public void newWindowHandleTest() { //selenium 4 de var bu

        //1.TechPro education sayfasinin titlenin "Techpro Education" metni icerdigini test edin
        driver.get("https://www.techproeducation.com");
        String tecProHandle = driver.getWindowHandle();
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));
        waitFor(3);

        //2. Yeni bir sayfada Amazon sayfasi acip titlenin "Amazon" metni icerdigini test edin
        driver.switchTo().newWindow(WindowType.WINDOW);// yeni pencere olusturur ve oraya gecis yapar
        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

        waitFor(3);

        //3. Yeni bir sayfada Linkedin sayfasi acip titlenin "LinkedIn" metni icerdigini test edin
        driver.switchTo().newWindow(WindowType.WINDOW);// yeni pencere olusturur ve oraya gecis yapar
        driver.get("https://www.linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));

        //ilk pencereye git
        driver.switchTo().window(tecProHandle);
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));
    }

}
