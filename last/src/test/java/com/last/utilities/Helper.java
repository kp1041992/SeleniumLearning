package com.last.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.stream.FileCacheImageOutputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	public static String getCurrentDateTime() {
		DateFormat dformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date todate = new Date();
		return dformat.format(todate); 
	}
	
	public static String captureScreenShots(WebDriver driver) {
	
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String pathTostore = System.getProperty("user.dir") + "/screenshots/Login_"+ getCurrentDateTime() +".png";
		try {
			FileHandler.copy(srcfile, new File(pathTostore));
			System.out.println("screenshot taken");
		} catch (Exception e) {
			System.out.println("Shreenshot not taken"+e.getMessage());
		}
		
		return pathTostore;
	}	

}