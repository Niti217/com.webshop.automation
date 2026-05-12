package com.webshop.utils;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelUtil {
    XSSFWorkbook workbook;

    /**
     * Constructor to initialize the workbook object
     * @param excelFilePath
     */
    public ExcelUtil(String excelFilePath) {
        try
        {
            File file = new File(excelFilePath);
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
        }
        catch(Exception e)
        {
            System.out.println("Exception while reading excel file : "+e.getMessage());
        }
    }

    /**
     * Method to get the active row count in the sheet
     * @param sheetNumber
     * @return count of active rows in the sheet
     */
    public int getRowCount(int sheetNumber) {
        int count = workbook.getSheetAt(sheetNumber).getLastRowNum()+1;
        return count;
    }

    public int getRowCount(String sheetName) {
        int count = workbook.getSheet(sheetName).getLastRowNum()+1;
        return count;
    }

    /** Method to get the cell data based on sheet number, row number and column number
     * @param sheetNumber , @param rowNum, @param colNum
     * @return cell data in string format
     */
    public String getCellData(int sheetNumber, int rowNum, int colNum) {
        String data = workbook.getSheetAt(sheetNumber).getRow(rowNum).getCell(colNum).toString();
        return data;
    }

    public String getCellData(String sheetName, int rowNum, int colNum) {
        String data = workbook.getSheet(sheetName).getRow(rowNum).getCell(colNum).toString();
        return data;
    }
}
