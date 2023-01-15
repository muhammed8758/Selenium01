package day16_excelread;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead {
    @Test
    public void readExcelTest() throws IOException {

        //    FORMUL
        // WORKBOOK (EXCEL DOSYASI) > WORKSHEET/SHEET(SAYFA) > ROW (SATIR) > CELL(VERI HUCRESI)

        String path = ".\\src\\test\\java\\resources\\Capitals.xlsx";

        //DOSYAYI AC
        FileInputStream fileInputStream = new FileInputStream(path);

        //EXCEL DOSYASINI AC /WORKBOOK
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //SAYFAYI AC/ SHEET1
        //Sheet sheet1 = workbook.getSheetAt(0);
        Sheet sheet1 = workbook.getSheet("Sheet1");

        //ILK SATIRA GI /ROW
        Row row1 = sheet1.getRow(0);

        // ILK SATIRDAKI VERI AL
        Cell cell1 = row1.getCell(0);


        // O VERIYI YAZDIR
        System.out.println("cell1 = " + cell1);

        //1.Satir 2. Sutun

        Cell cell2 = sheet1.getRow(0).getCell(1);
        System.out.println("cell2 = " + cell2);

        //3. satir 1. sutun

        Cell cell3 = sheet1.getRow(2).getCell(0);
        System.out.println("cell3 = " + cell3);

        String cell31 = sheet1.getRow(2).getCell(0).toString();
        Assert.assertEquals("France", cell31);

        // Excel deki Toplam satir Sayisini Bul

        int toplamSatirSayisi = sheet1.getLastRowNum()+1;// son satir numarasi, indexden dolayida +1 ekleniyor 
        System.out.println("toplamSatirSayisi = " + toplamSatirSayisi);
        
        // Kullanilan Toplam Satir Sayisi
        
        int kullanilanSatirSayisi = sheet1.getPhysicalNumberOfRows();
        System.out.println("kullanilanSatirSayisi  = " + kullanilanSatirSayisi );// 1 den basliyor

        //COUNTRY VE CAPITALS key ve valualari map a alip print et
     //   {{USA,D.C},{FRANCE,PARIS},...}

        // Variableleri olusturalim. Bu variable exceldeki country,capital verileri tutatcak

        Map<String, String> ulkeBasketleri = new HashMap<>();

        for(int satirSayisi=1; satirSayisi<kullanilanSatirSayisi; satirSayisi++) {
            String country = sheet1.getRow(satirSayisi).getCell(0).toString();
            String capital= sheet1.getRow(satirSayisi).getCell(1).toString();
            ulkeBasketleri.put(country, capital);

        }
        System.out.println(ulkeBasketleri);


    }
}
