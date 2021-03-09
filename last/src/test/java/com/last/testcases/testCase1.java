package com.last.testcases;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.last.pages.BaseClass;
import com.last.pages.LoginPage;

public class testCase1 extends BaseClass{
	
	@Test(priority=1)
	public void abc() {
	test = report.createTest("MyFirstTest");
	test.info("Start the test case");
	LoginPage logpage = PageFactory.initElements(driver, LoginPage.class);
	test.pass("successfully visit the website url");
	test.info("trying to enter the details for login");
	logpage.enterText(data.getStringData(0, 0, 0), data.getStringData(0, 0, 1));
	test.pass("successfully logged in");
	
	System.out.println(driver.getTitle());
	System.out.println("Test Completed");
	
	
	
	
	}
	
//	@Test (priority=2)
//	public void sec() {
//	test = report.createTest("second");
//	test.info("Start the test case");
//	
//	test.fail("successfully failed");
//	
//	
//	}
}
