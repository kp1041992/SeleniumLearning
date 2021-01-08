package com.last.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.last.utilities.BrowserFactory;
import com.last.utilities.Helper;

public class BaseClass {

	public WebDriver driver;
//	public ExtentReports extent;
//	public ExtentTest test;

	@BeforeSuite
//	public void setUpAhead() {
//		extent = new ExtentReports();
//		ExtentSparkReporter spark = new ExtentSparkReporter(
//				new File(System.getProperty("user.dir") + "/Reports/fblogin_" + Helper.getCurrentDateTime() + ".html"));
//		extent.attachReporter(spark);
//
//	}

	@BeforeClass
	public void setUp() {
		driver = BrowserFactory.startApp("https://www.facebook.com/", "firefox", driver);
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

//	@AfterSuite
//	public void tearLater(ITestResult result) {
//
//		if (result.getStatus() == ITestResult.FAILURE) {
//			test.fail("capture screen on fail", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShots(driver)).build());
//		}
//		if (result.getStatus() == ITestResult.SKIP) {
//			test.skip("capture screen on fail", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShots(driver)).build());
//		}
//		//extent.flush();
//	}
}
