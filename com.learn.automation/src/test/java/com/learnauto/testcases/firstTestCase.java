package com.learnauto.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learnauto.pages.BaseClass;
import com.learnauto.pages.LoginPage;
import com.learnauto.utilities.BrowserFactory;
import com.learnauto.utilities.ExcelDataProvider;
import com.learnauto.utilities.Helper;

public class firstTestCase extends BaseClass {
	 
	@Test
	public void testone() {
	
		report.createTest("testing orange hrm");
		test.info("Start the test case");
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		test.pass("successfully visit the website url");
		test.info("trying to enter the details for login");
		login.loginToOrangeHRM(excel.getStringData("loginPage", 0, 0), excel.getStringData("loginPage", 0, 1));
		test.pass("successfully visit the website url");
		//		LoginPage page = new LoginPage(driver);
//		page.loginToOrangeHRM("Admin", "admin123");
		
	}
	


}
