package com.learnauto.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnauto.utilities.BrowserFactory;
import com.learnauto.utilities.ExcelDataProvider;
import com.learnauto.utilities.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public  ExtentReports report;
	public ExtentTest test;
	
	@BeforeSuite
	public void setUpSuite() {

		 excel = new ExcelDataProvider();
		 ExtentHtmlReporter html = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/OrangeHrm_"+Helper.getCurrentDateTime()+".html"));
		 report = new ExtentReports();
		 report.attachReporter(html);
		 
		
	
	}
	
	@BeforeClass
	public void setUp() {
		driver = BrowserFactory.startApplication("https://opensource-demo.orangehrmlive.com/index.php/auth/login", "firefox", driver);

	}
	

	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);

	}
	
	@AfterMethod
	public void teardownSetup(ITestResult result) throws IOException {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			
			
				test.fail("capture screen on fail", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShots(driver)).build());
			
			
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			
			
			test.skip("capture screen on fail", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShots(driver)).build());
		
		
	}
	
		
		report.flush();
	}

}
