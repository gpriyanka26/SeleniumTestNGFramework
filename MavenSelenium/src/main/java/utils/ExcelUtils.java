package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {
		
	static XSSFWorkbook workbook;
	static String projectPath;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath, String sheetName) {
					
		try {
			
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);			
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String args[]) {
		
		/*
		getRowCount();
		getCellDataNumber(0, 0);
		getCellDataString(1, 1);
		*/
	}

	public static int getRowCount() {
		
		int rowCount=0;
			
		try {

			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("Total row Count: "+rowCount);
			
		} catch (Exception exp) {
			
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
			
		}
		return rowCount;
		
	}
	
	public static int getColCount() {
		
		int colCount = 0;
		
		try {

			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Total Column Count: "+colCount);
			
		} catch (Exception exp) {
			
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
			
		}
		return colCount;
		
	}
	
	public static String getCellDataString(int rowNum, int colNum) {
		
		String cellData = null;
			
		try {
			
			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			//System.out.println("Cell string data : "+cellData);
			
		} catch (Exception exp) {
			
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return cellData;	
	}
	
	public static Double getCellDataNumber(int rowNum, int colNum) {
		
		Double cellData = null;
		
		try {
			
			cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			//System.out.println("Cell numeric data : "+cellData);
			
		} catch (Exception exp) {
			
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
		}
		return cellData;
		
	}

}
