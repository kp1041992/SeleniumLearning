package com.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

public 	WebDriver driver;
	public static WebDriver startApp(WebDriver driver, String appUl, String browser) {

		String path = System.getProperty("user.dir");
		System.out.println(path);

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", path+"/drivers/Chrome/chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", path+"/drivers/Firefox/geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", path+"/drivers/IE/geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		else {
			System.out.println("we do not support this browser driver");
		}
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appUl);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void closeApp(WebDriver driver) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

}
