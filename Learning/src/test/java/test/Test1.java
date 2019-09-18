package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import random.PageObjects;

public class Test1 {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		setup();
		display();
	}
	
	public static void setup() {

		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"/Drivers/Chrome/chromedriver.exe");
		driver = new ChromeDriver();
		
	}

	public static void display() {

	
		driver.get("https://www.google.ca");
		 
		PageObjects obj = new PageObjects(driver);
		obj.textbox_serch("Automation");
		obj.btn_click();
		driver.close();
		
		
		System.out.println("Success");
		driver.close();
	}
}
