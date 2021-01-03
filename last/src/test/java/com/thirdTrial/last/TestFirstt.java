package com.thirdTrial.last;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestFirstt {

	@Test
	public static void abc() {
		String path = System.getProperty("user.dir");
	System.setProperty("webdriver.gecko.driver", path+"/drivers/Firefox/geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("https://www.google.com/");
	WebElement ele = driver.findElement(By.name("q"));
	ele.sendKeys("Hello");
	
	System.out.println();
	}
}
