package com.learnauto.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	
	public static WebDriver startApplication(String appUrl, String browserName, WebDriver driver) {
		String path = System.getProperty("user.dir");
		if(browserName.equalsIgnoreCase("chrome")) {
			
			
			
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			
			System.setProperty("webdriver.gecko.driver", path+"/Drivers/Firefox/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("ie")){
			
		}
		else {
			System.out.println("we do not support this browser driver");
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
	}

	public static void quitBrowser(WebDriver driver) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
		
	}
}
