package com.learnauto.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;

	public ExcelDataProvider() {

		File src = new File("./TestData/LoginPageData.xlsx");
		try {
			FileInputStream inputFile = new FileInputStream(src);
			wb = new XSSFWorkbook(inputFile);

		} catch (Exception e) {
			System.out.println("file error occured" + e.getMessage());
		}
	}

	public String getStringData(String sheet, int row, int column) {
	
		return wb.getSheet(sheet).getRow(row).getCell(column).getStringCellValue();
				
	}

	public double getNumericData(String sheet1, int row1, int column1) {
		
		return wb.getSheet(sheet1).getRow(row1).getCell(column1).getNumericCellValue();

	}

}
