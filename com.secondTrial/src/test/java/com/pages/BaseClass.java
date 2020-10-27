package com.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.utilities.BrowserFactory;

public class BaseClass {
	
	public static WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = BrowserFactory.startApp(driver, "https://classic.freecrm.com/", "firefox");

	}
	

	@AfterClass
	public void tearDown() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BrowserFactory.closeApp(driver);

	}
}
