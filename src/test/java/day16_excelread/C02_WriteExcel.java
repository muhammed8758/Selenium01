package day16_excelread;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {
    @Test
    public void writeExcelTest() throws IOException {
        //WORKBOOK > SHEET > ROW > CELL > YAZ > KAYDET
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

        //ILK SATIR 3. SUTUTNU CREATE ET
        Cell cell3 = row1.createCell(2);

        //NUSFUS YAZ
        cell3.setCellValue("Nufus");

        //KAYDET ISLEMI FILEOUTPUTSTREAM ile YAPILIR
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        //        2. SATIR 3. SUTUN'A 450000
        sheet1.getRow(1).createCell(2).setCellValue("450000");

//        3. SATIR 3. SUTUN'A 350000
        sheet1.getRow(2).createCell(2).setCellValue("350000");

    }
}
