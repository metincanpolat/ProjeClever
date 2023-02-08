package Utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelUtility {

    public static ArrayList<ArrayList<String>> getListData(String path, String sheetName, int columnCount)
    {
        ArrayList<ArrayList<String>> table = new ArrayList<>();

        Sheet sheet = null;

        try {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheet(sheetName);
            
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            ArrayList<String> rowData = new ArrayList<>();
            for (int j = 0; j < columnCount; j++) {
                rowData.add(sheet.getRow(i).getCell(j).toString());
            }
            table.add(rowData);
        }
        return table;
    }
    public static void writeToExcel(String path, Scenario scenario, String browserName, String time)
    {
        File f = new File(path);
        if (!f.exists())
        {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("ProjectCleverTest");

            Row newRow = sheet.createRow(0);

            Cell newCell = newRow.createCell(0);

            CellStyle cellStyle = newCell.getSheet().getWorkbook().createCellStyle();
            cellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
            cellStyle.setFillPattern(FillPatternType.DIAMONDS);

            newCell.setCellStyle(cellStyle);
            newCell.setCellValue("Test Scenario");


            newCell = newRow.createCell(1);
            newCell.setCellStyle(cellStyle);
            newCell.setCellValue("Status");


            newCell = newRow.createCell(2);
            newCell.setCellStyle(cellStyle);
            newCell.setCellValue("Browser");


            newCell = newRow.createCell(3);
            newCell.setCellStyle(cellStyle);
            newCell.setCellValue("Date");


            newRow = sheet.createRow(1);

            newCell = newRow.createCell(0);
            newCell.setCellValue(scenario.getName());

            newCell = newRow.createCell(1);
            newCell.setCellValue(scenario.getStatus().toString());

            newCell = newRow.createCell(2);
            newCell.setCellValue(browserName);

            newCell = newRow.createCell(3);
            newCell.setCellValue(time);


            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }
        else
        {
            FileInputStream inputStream;
            Workbook workbook = null;
            try {
                inputStream = new FileInputStream(path);
                workbook = WorkbookFactory.create(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Sheet sheet = workbook.getSheet("ProjectCleverTest");
            Row row = sheet.createRow(sheet.getPhysicalNumberOfRows());

            Cell cell = row.createCell(0);
            cell.setCellValue(scenario.getName());

            cell = row.createCell(1);
            cell.setCellValue(scenario.getStatus().toString());

            cell = row.createCell(2);
            cell.setCellValue(browserName);

            cell = row.createCell(3);
            cell.setCellValue(time);


            try {
                inputStream.close();
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

    public static void main(String[] args) {

        ArrayList<ArrayList<String>> tablo =
                getListData("src/test/java/ApachePOI/resource/ApacheExcel.xlsx","loginInfo",2);

        System.out.println("tablo = " + tablo);



    }


}
