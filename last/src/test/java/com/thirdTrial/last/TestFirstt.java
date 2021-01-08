package com.thirdTrial.last;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestFirstt {

	@Test
	public static void abc() throws InterruptedException {
	String path = System.getProperty("user.dir");
	System.setProperty("webdriver.gecko.driver", path+"/drivers/Firefox/geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	Thread.sleep(5000);
	driver.get("https://www.google.com/");
	Thread.sleep(5000);
	WebElement ele = driver.findElement(By.name("q"));
	Thread.sleep(5000);
	ele.sendKeys("Hello");
	ele.sendKeys(Keys.RETURN);
	Thread.sleep(5000);
	driver.quit();
	System.out.println("Test Completed");
	}
}
