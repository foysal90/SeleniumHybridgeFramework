package com.learnAutomation.dataProvider;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class dataProvider {

    static  XSSFWorkbook workbook;
    @DataProvider (name = "loginTestApp")
    public  static Object [][] fetchData(){
           Object[][] arr =  excelReader.getDataFromExcel("Sheet1");
        return arr;
    }



}


//
//    File file = new File(System.getProperty("user.dir")+ "/excelData/userData.xlsx");
//        try {
//                workbook = new XSSFWorkbook(file);
//                } catch (IOException e) {
//                System.out.println("unable tom load ...." + e.getMessage());
//                } catch (InvalidFormatException e) {
//                System.out.println("File format is not valid....." + e.getMessage());
//                }
//                int row = workbook.getSheet("Sheet1").getPhysicalNumberOfRows();
//                int col = workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells();
//
//                Object [][] arr = new Object[row][col];
//
//                for (int i =0; i<row;i++)
//        {
//        for (int j=0;j<col;j++)
//        {
//        arr[i][j] = workbook.getSheet("Sheet1").getRow(i).getCell(j).getStringCellValue();
//        }
//        }
//        return arr;
