package com.last.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	@FindBy(xpath = "//input[@id='email']") WebElement user;
	@FindBy(xpath = "//input[@id='pass']") WebElement passw;
	@FindBy(xpath = "//button[@id='u_0_b']") WebElement btn;
	
	public void enterText(String uname, String pass) {

		user.sendKeys(uname);
		passw.sendKeys(pass);
		btn.click();
	}
}
