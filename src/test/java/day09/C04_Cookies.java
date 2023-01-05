package day09;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C04_Cookies extends TestBase {
    @Test
    public void handleCookiesTest() {
//        Class: Cookies
//        Method: handleCookies
//        Amazona git
        driver.get("https://www.amazon.com");

//        1.toplam cookie sayisini bul
        Set<Cookie> allCookies = driver.manage().getCookies();
        waitFor(2);
        int cookiesSayisi = allCookies.size();
        System.out.println("cookiesSayisi = " + cookiesSayisi);
//       2. Tum Cookie leri yazdir
       // allCookies.stream().forEach(t -> System.out.println(t.getName()));
        for(Cookie w : allCookies){
            System.out.println("Cookie Isimler =" + w.getName());
            System.out.println(w);
        }

//        3. Bir Cookie yi ismiyle bul
        System.out.println("ismiye cagirma" + driver.manage().getCookieNamed("i18n-prefs"));


//        4. Yeni bir cookie ekle
        Cookie favoriCookies = new Cookie("Cikolatam","antep-fistikli-cikolata");
        driver.manage().addCookie(favoriCookies);
        System.out.println(driver.manage().getCookies().size());
        waitFor(3);
        System.out.println("yeni Cookies= "+ driver.manage().getCookies().size());

//        5. Bir Cookie yi ismiyle sil
        driver.manage().deleteCookieNamed("i18n-prefs");
//        6. Tum cookie leri sil
        driver.manage().deleteAllCookies();
    }
}
