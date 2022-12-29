package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_AlertAccept extends TestBase {
    /*
    Bir class olusturun: Alerts
https://testcenter.techproeducation.com/index.php?page=javascript-alerts  adresine gidin.
Bir metod olusturun: acceptAlert
1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
Bir metod olusturun: dismissAlert
2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “You clicked: Cancel” oldugunu test edin.
Bir metod olusturun: sendKeysAlert
3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
     */

    @Test
    public void acceptAlertTest() throws InterruptedException {

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //        1. butona tıklayın,
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();
        //        uyarıdaki OK butonuna tıklayın
        driver.switchTo().alert().accept();// degistir, alert e kabul et
        Thread.sleep(3000);
        //        ve result mesajının
       String actualResult=  driver.findElement(By.id("result")).getText();
       String expectedResult= "You successfully clicked an alert";
        Assert.assertEquals(expectedResult,actualResult);
        //       “You successfully clicked an alert” oldugunu test edin.
    }

    /*
    1) Alert leri nasil automate ederiz. How to hande alerts in selenium?
    C) Alertler JavaScript ile olusturlur. Inspect edilmezler. Oncelikle alerte switch etmemiz geremektedir.
     */
}
