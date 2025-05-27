package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtil {
    public static String getCellData(String path, String sheet, int row, int col) {
        try (FileInputStream fis = new FileInputStream(path)) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet s = workbook.getSheet(sheet);
            return s.getRow(row).getCell(col).getStringCellValue();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
