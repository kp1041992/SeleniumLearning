package com.last.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {


	public static WebDriver startApp(String appUrl, String browser, WebDriver driver) {
		String path = System.getProperty("user.dir");
		
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", path+"/drivers/Firefox/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", path+"/drivers/Chrome/chromedriver.exe");
			driver = new ChromeDriver();
		}
		if(browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", path+"/drivers/ie/iedriver.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		return driver;
	}
	
    
	public static void quitApp(WebDriver driver) {
		
		driver.quit();
	}
}
