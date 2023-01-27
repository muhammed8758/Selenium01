package day17_JavaScriptExecuter;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class JSExecuter_Practice extends TestBase {
    /*
                                -- JavascriptExecutor --
        -- ID'si ILE LOCATE
        WebElement element = (WebElement)
                js.executeScript("return document.getElementById('twotabsearchtextbox');");
          js.executeScript("return document.getElementById('twotabsearchtextbox');") kodu, JavaScriptExecutor
       aracılığıyla belirli bir ID değerine sahip bir web elementini locate etmek için kullanılan bir koddur.
       Bu kod, JavaScriptExecutor aracılığıyla tarayıcıda çalıştırılır ve getElementById()
       metodu kullanılarak 'twotabsearchtextbox' ID değerine sahip bir elementi locate eder.
       Bu kodun döndürdüğü sonuç, locate edilen elementi temsil eden bir WebElement nesnesidir.
       Bu WebElement nesnesi, daha sonra Selenium komutları ile bu element üzerinde işlem yapmak için kullanılabilir.
        -- XPATH ILE LOCATE
        WebElement element = (WebElement) js.executeScript
                ("return document.evaluate(\"//*[@id='twotabsearchtextbox']\", " +
                        "document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null ).singleNodeValue;");
        --CSS SELECTOR ILE LOCATE
        WebElement element = (WebElement)
                js.executeScript("return document.querySelector('input[id=twotabsearchtextbox]');");
        */

    @Test
    public void name() {
        JavascriptExecutor js =(JavascriptExecutor) driver;

//        -- Amazon sayfasına gidiniz
        driver.get("https://www.amazon.com");
//        -- Arama bölümünde selenium aratınız
        WebElement searchBox = (WebElement) js.executeScript("return document.querySelector('input[id=twotabsearchtextbox]');");
        js.executeScript("arguments[0].value='selenium'",searchBox);
        searchBox.submit();

//        -- Back to top bölümüne kadar scroll yapınız
        WebElement backToTop = (WebElement) js.executeScript("return document.getElementsByClassName('navFooterBackToTopText')[0];");
        js.executeScript("argument[0].scrollIntoView(true);",backToTop);
//        -- Back to top bölümüne tıklayınız


    }
}
