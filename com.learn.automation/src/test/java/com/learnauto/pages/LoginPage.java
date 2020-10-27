package com.learnauto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(id="txtUsername") WebElement username;
	@FindBy(id="txtPassword") WebElement password;
	@FindBy(id="btnLogin") WebElement loginButton;

	public void loginToOrangeHRM(String uname, String pass) {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginButton.click();
		
	}
	
}
