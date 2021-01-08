package com.last.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.last.pages.BaseClass;
import com.last.pages.LoginPage;
import com.last.utilities.BrowserFactory;

public class testCase1 extends BaseClass{
	
	@Test
	public void abc() {
		
	test = extent.createTest("MyFirstTest");
	test.info("Start the test case");
	LoginPage logpage = PageFactory.initElements(driver, LoginPage.class);
	test.pass("successfully visit the website url");
	test.info("trying to enter the details for login");
	logpage.enterText("kp1041992@gmail.com", "kiranvpatel1041992");
	test.pass("successfully logged in");
	System.out.println(driver.getTitle());
	System.out.println("Test Completed");
	}
}
