package org.example;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;

public class DataProvidedExcel {

    String username;
    String password;

    @DataProvider
    public Object[][] readExcel() throws Exception{
        File file = new File("C:\\Users\\vrtosh\\Desktop\\aow\\hi.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Object[][] data = new Object[sheet.getLastRowNum()][2]; // 2 columns: username + password
        for (int i = sheet.getFirstRowNum()+1; i <= sheet.getLastRowNum(); i++) {

            data[i - 1][0] = sheet.getRow(i).getCell(0).toString();
            data[i - 1][1] = sheet.getRow(i).getCell(1).toString();

        }
        return data;
    }

}
