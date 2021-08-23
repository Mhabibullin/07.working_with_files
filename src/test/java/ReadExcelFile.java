import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelFile {

    @Test
    void readXlsx() throws IOException {
        File fileToBeRead = new File("./src/test/resources/Invoice.xlsx");
        FileInputStream fis = new FileInputStream(fileToBeRead);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet firstSheet = workbook.getSheetAt(0);
        String getCellValue =
                firstSheet
                .getRow(2)
                .getCell(1)
                .getStringCellValue();

        System.out.println("Print cell:");
        System.out.println(getCellValue);
        Assertions.assertEquals("Элемент 1", getCellValue);
    }
}
