package com.secondTrial;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.pages.BaseClass;
import com.pages.LoginPage;
import com.utilities.BrowserFactory;

public class start extends BaseClass{
	@Test
	public static void firstcase() {
		
		
		LoginPage page = PageFactory.initElements(driver, LoginPage.class);
		
		page.loginTofreeCrm("Selenium_50", "Abcd@123456");
		System.out.println("login");
		
	
	
		
	}

}
