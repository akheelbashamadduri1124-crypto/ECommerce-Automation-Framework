package com.ecommerce.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    private static final String FILE_PATH =
            "src/test/resources/testdata/TestData.xlsx";

    private ExcelUtils() {
        // Utility class
    }

    public static Object[][] getLoginData() {

        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet("LoginData");

            int rowCount = sheet.getPhysicalNumberOfRows();
            Object[][] data = new Object[rowCount - 1][2];

            for (int i = 1; i < rowCount; i++) {

                Row row = sheet.getRow(i);

                data[i - 1][0] = row.getCell(0).getStringCellValue();
                data[i - 1][1] = row.getCell(1).getStringCellValue();
            }

            return data;

        } catch (IOException e) {
            throw new RuntimeException(
                    "Unable to read Excel test data: " + FILE_PATH, e);
        }
    }
}