package com.last.pages;

import java.io.File;
import java.io.IOException;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.last.utilities.BrowserFactory;
import com.last.utilities.ConfigData;
import com.last.utilities.ExcelData;
import com.last.utilities.Helper;

public class BaseClass {

	public WebDriver driver;
	public  ExtentReports report;
	public ExtentTest test;
	public ExcelData data;
	public ConfigData config;
	@BeforeSuite
	public void setUpAhead() {

		data = new ExcelData();
		 ExtentHtmlReporter html = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/facebooklogin_"+Helper.getCurrentDateTime()+".html"));
		 report = new ExtentReports();
		 report.attachReporter(html);
		  config = new ConfigData();
	}

	@Parameters({"browserToRun","urltoTest"})
	@BeforeClass
	public void setUp(String browser1, String url) {
		//driver = BrowserFactory.startApp(config.getUrl(), config.getBrowser(), driver);
		driver = BrowserFactory.startApp(url, browser1, driver);
	}

	@AfterClass
	public void tearDown() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BrowserFactory.quitApp(driver);
	}
 
	@AfterMethod
	public void tearLater(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShots(driver)).build());
		}
		if(result.getStatus()==ITestResult.SUCCESS) {
			test.pass("Test success", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShots(driver)).build());
		}
		if(result.getStatus()==ITestResult.SKIP) {
			test.skip("Test Skipped", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShots(driver)).build());
		}

		report.flush();
	}
}
