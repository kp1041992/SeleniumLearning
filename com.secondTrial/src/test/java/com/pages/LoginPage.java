package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		 this.driver = driver;
	}
	
	@FindBy(xpath="//input[@name='username']") WebElement uname;
	@FindBy(xpath="//input[@name='password']") WebElement pass;
	@FindBy(xpath="//input[@value='Login']") WebElement loginbtn;
	
	
	public void loginTofreeCrm(String user, String pwd) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		uname.sendKeys(user);
		pass.sendKeys(pwd);
		loginbtn.click();
		
	}
}
