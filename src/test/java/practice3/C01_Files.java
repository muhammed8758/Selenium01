package practice3;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_Files {
    @Test
    public void name() {

        // Exercise 1...

        // masaustunde bir text dosyası olusturun
        // masaustundeki text dosyasının varlıgını test edin


    //   "C:\\Users\\muham  \OneDrive\Masaüstü\Text.txt".

    //    Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\muham\\OneDrive\\Masaüstü\\Text.txt")));// Bu islemi daha dynamik hale getirebiliriz

        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\OneDrive\\Masaüstü\\Text.txt";
        String dosyaYolu = farkliKisim + ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }

}
