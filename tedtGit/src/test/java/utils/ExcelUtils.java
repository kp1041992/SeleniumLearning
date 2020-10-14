package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelUtils {
	static String path;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	
//Constructor to access data from different class using path and sheet name
	public ExcelUtils(String filePath, String sheetName) {

		try {
			workbook = new XSSFWorkbook(filePath);
			sheet = workbook.getSheet(sheetName);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
//Main method start here
//	public static void main(String[] args) {
//
//		String path = System.getProperty("user.dir");
//
//		testData(path + "/excel/FacebookLoginData.xlsx", "Sheet1");
//	}
	
	@Test(dataProvider = "datagiver")
	public  void test1(String uName, String password) {
		System.out.println(uName + "|" + password);
	}
	
	@DataProvider(name = "datagiver")
	public  Object[][] testDataDetail() {
		String path = System.getProperty("user.dir");

		Object data[][] = testData(path + "/excel/FacebookLoginData.xlsx", "Sheet1");
		return data;
	}
	
//Method to iterate through the file and get data accordingly	
	public  Object[][] testData(String filePath, String sheetName) {

		String path = System.getProperty("user.dir");
		ExcelUtils util = new ExcelUtils(filePath, sheetName);
		int row = util.getRowCount();
		int column = util.getColumnCount();
		Object data[][] = new Object[row-1][column];
		
		for (int i = 1; i < row-1; i++) {
			for (int j = 0; j < column; j++) {
				String cellInfo = util.getCellDataString(i, j);
				//System.out.print(cellInfo+ "|");
				data[i-1][j] = cellInfo; 
			}
			//System.out.println();
		}
		return data;
	}

	// Method to get number of rows in the data file
	public static int getRowCount() {
		int rowCount = 0;
		try {

			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("No. of rows: " + rowCount);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.getStackTrace();
		}
		return rowCount;
	}
	
	// Method to get number of columns in the data file
	public static int getColumnCount() {
		int columnCount = 0;
		try {

			columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("No. of columns: " + columnCount);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.getStackTrace();

		}
		return columnCount;
	}

	// Method to get data of cells in string format in the data file
	public static String getCellDataString(int rowNum, int colNum) {
		String cellData = null;
		try {
			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.getStackTrace();
		}
		return cellData;
	}

	// Method to get data of cells in integer/double format in the data file
	public static double getCellDataNumeric(int rowNum, int colNum) {
		double cellData1 = 0;
		try {

			cellData1 = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.getStackTrace();
		}
		return cellData1;
	}

}
