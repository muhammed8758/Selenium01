package day15_ExtentRapor;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ExtentRaports2 extends TestBase {
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;
    @BeforeClass
    public static void extentRaportsSetup() throws Exception {
        //      REPORT  PATH
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/reports/"+currentTime+"html_report.html";
//        creating HTML report in the path
        extentHtmlReporter = new ExtentHtmlReporter(path);
//        creating extent reports object for generating the Entire reports with configuration
        extentReports = new ExtentReports();

        //***************** RAPORU CUSTOMIZE EDEBILIRIZ************************
        extentReports.setSystemInfo("Test Environment", "Regression");
        extentReports.setSystemInfo("Application", "TechPro Eduvation");
        extentReports.setSystemInfo("Takim", "Eagle");
        extentReports.setSystemInfo("Epic", "Odeme Sayfasi");
        extentReports.setSystemInfo("Sprint Numarasi", "Sprint 145");
        extentReports.setSystemInfo("QA", "Muhammed D");

        //********************EXTRA RAPOR ISMI VE DOKUMAN ISMI EKLEYEBILIRZ**************
        extentHtmlReporter.config().setDocumentTitle("TechProEd Extent Raports");
        extentHtmlReporter.config().setReportName("Regression Test Sonucu");

        //********************RAPOR AYARI BITTI***************
        // RAporu Projeme Ekliyorum

        extentReports.attachReporter(extentHtmlReporter);

        extentTest = extentReports.createTest("Extent Report Login Test", "Smoke Test Raporu");

        // TUM AYARLAR BITTI. EXTENT TEST OBJESI ILE LOGLAMA (RAPORA YAZDIRMA) ISLEMINI YAPABILIRIM



    }

    @Test
    public void extentRaportsTest() {
        extentTest.pass("PASS");
        extentTest.info("BILGILENDIRME NOTU");
        extentTest.fail("FAILED");
        extentTest.warning("UYARRI MESAJI");
        extentTest.skip("ATLAMA MESAJI");
        extentTest.fatal("COKUS HATASI");

    }

    @AfterClass
    public static void extentRaportsTearDown() throws Exception {
        extentReports.flush();// raporu bitir anlaminda

    }
}
