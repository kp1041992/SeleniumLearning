package com.last.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	XSSFWorkbook wb;

	public ExcelData() {
		File src = new File(System.getProperty("user.dir") + "/testdata/LoginPageData.xlsx");
		try {
			FileInputStream fin = new FileInputStream(src);
			 wb = new XSSFWorkbook(fin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("unable to read excel file" + e.getMessage());
		}

	}

	public String getStringData(int sheet, int row, int col) {
		
		
		return wb.getSheetAt(sheet).getRow(row).getCell(col).getStringCellValue();

	}

	public Double getDoubleData(int sheet, int row, int col) {
		
		return wb.getSheetAt(sheet).getRow(row).getCell(col).getNumericCellValue();	
		
		

	}

}
