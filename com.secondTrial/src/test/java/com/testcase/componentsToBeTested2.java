package com.testcase;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class componentsToBeTested2 {

	@Test
	public static void abc() throws InterruptedException {
	String path = System.getProperty("user.dir");
	System.setProperty("webdriver.chrome.driver", path+"/drivers/ch/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	Thread.sleep(3000);
	driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
//------------Alert Windows-------------------------------------------------------------------------	
//	driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
//	driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
//	Thread.sleep(3000);
//	WebElement ele = driver.findElement(By.xpath("//button[contains(text(), 'Try it')]"));
//	ele.click();
//	Thread.sleep(3000);
//	driver.switchTo().alert().accept();
	

//-------------------------------------------------------------------------------------	
	
//------------multiple Windows-- handles-----------------------------------------------------------------------	

	driver.get("https://www.naukri.com/");
	String parent = driver.getWindowHandle();
	System.out.println("parent window: "+parent);
	Set<String> allwin = driver.getWindowHandles();
	System.out.println("windoes count "+allwin.size());
	
	for(String ele: allwin) {
		if(!parent.equalsIgnoreCase(ele)) {
			driver.switchTo().window(ele);
		
			driver.close();
		}
	}
	WebDriverWait wait = new WebDriverWait(driver, 5);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Later']")));
//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Later']")));
	driver.findElement(By.xpath("//span[text()='Later']")).click();
	
	//driver.findElement(By.xpath("//span[text()='Later']")).click();
	

//-------------------------------------------------------------------------------------	
	Thread.sleep(3000);
	//driver.quit();
	System.out.println("Test Completed");
	}
}
