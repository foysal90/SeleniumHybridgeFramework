package com.learnAutomation.dataProvider;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class excelReader {

    static XSSFWorkbook wb;

        public  static Object [][] getDataFromExcel(String sheetName) {
            File fs = new File(System.getProperty("user.dir")+"/excelData/userData.xlsx");

            try {
                wb = new XSSFWorkbook(fs);
            } catch (IOException e) {
                System.out.println("File not found..." + e.getMessage());
            } catch (InvalidFormatException e) {
                System.out.println("File is invalid..." + e.getMessage());
            }
            int row = wb.getSheet(sheetName).getPhysicalNumberOfRows();
            int column = wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
            Object [][] arr = new Object[row-1][column];



            for (int i =1; i<row;i++)
            {
                for (int j =0;j<column;j++)
                {
                    arr[i-1][j] =fetchDataFromExcel(sheetName,i,j);
                }
            }





            System.out.println("Test Data Generated");
            return arr;
        }

        public  static String fetchDataFromExcel(String sheetName, int row, int column)
        {
            XSSFCell cell = wb.getSheet(sheetName).getRow(row).getCell(column);
            String data = "";

            if (cell.getCellType()== CellType.STRING)
            {
                data = cell.getStringCellValue();
            }
            else if (cell.getCellType()==CellType.NUMERIC)
            {
                double nv =cell.getNumericCellValue();
                data = String.valueOf(nv);
            }
            else if (cell.getCellType()==CellType.BOOLEAN)
            {
                boolean bv = cell.getBooleanCellValue();
                data = String.valueOf(bv);
            }

            else if (cell.getCellType()==CellType.BLANK)
            {
                data = "";
            }
            return data;

        }}


