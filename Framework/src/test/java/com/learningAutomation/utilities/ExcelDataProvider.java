package com.learningAutomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	public ExcelDataProvider() {
		
		
		File src = new File(System.getProperty("user.dir")+"/TestData/testData.xlsx");
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			
			System.out.println("XXXXX..... Unable to read Excel File" +e.getMessage());
			
		}	
	}
		
	
	// ******* We can get the sheet either using the sheetname or the sheetIndex
	//**** using SheetIndex
	public String getStringData(int sheetIndex, int row, int column) {
		
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	
	}
	
	
	// ****** using sheetName
		public String getStringData(String sheetName, int row, int column) {
			
			return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		
		}
		
		public double getNumericData(String sheetName, int row, int column) {
			
			return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
			
		}	

}
