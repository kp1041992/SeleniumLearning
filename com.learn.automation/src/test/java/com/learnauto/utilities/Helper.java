package com.learnauto.utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	//frame, alert, screenShot, multiple windows, Sync issue, javaScript Executor
	
	
	public static String captureScreenShots(WebDriver driver) {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenPath=System.getProperty("user.dir")+"/ScreenShots/loginPage_"+ getCurrentDateTime()+".png";
		try {
			FileHandler.copy(src, new File(screenPath));
			System.out.println("screenshot taken");
		} catch (Exception e) {
			System.out.println("Shreenshot not taken"+e.getMessage());
		}
		return screenPath;
	}
	
	
	public static String getCurrentDateTime() {
		
		DateFormat date = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		
		
		return date.format(currentDate);
		
	}

}
