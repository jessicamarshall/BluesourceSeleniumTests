package com.orasi.bluesource.core;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	
	private static XSSFSheet excelWorksheet;
    private static XSSFWorkbook excelWorkbook;
    private static XSSFCell cell;
    private static XSSFRow row;
    
    //Opens the excel file based on the path and sheet name passed in
	public void openExcelFile(String path, String sheetName) throws Exception {
		try{
			FileInputStream ExcelFile = new FileInputStream(path);
			excelWorkbook = new XSSFWorkbook(ExcelFile);
			excelWorksheet = excelWorkbook.getSheet(sheetName);
            } catch (Exception e){
                throw (e);
            }
		
		
		}
	
	public String GetCellData(int rowNum, int colNum) throws Exception {
		int dataType = 0;
		String cellData;
		try{
            cell = excelWorksheet.getRow(rowNum).getCell(colNum);
            dataType = cell.getCellType();
            if  (dataType == 3) {
                return "";
            }
            else{
                cellData = cell.getStringCellValue();
                return cellData;
            	}
			}
            catch (Exception e)
            {
            	System.out.println(e.getMessage());
            	throw (e);
            }
		}
	
	public int getNumOfRows() {
		return excelWorksheet.getLastRowNum();
	}
	
//	public int getNumOfCols() {
//		return excelWorksheet.g
//	}
}
