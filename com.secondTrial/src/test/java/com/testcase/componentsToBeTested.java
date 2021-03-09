package com.testcase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class componentsToBeTested {

	@Test
	public static void abc() throws InterruptedException {
	String path = System.getProperty("user.dir");
	System.setProperty("webdriver.gecko.driver", path+"/drivers/Firefox/geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	Thread.sleep(3000);
	
//	//-------------------Radio------Button-------------------------------------------------------
//	
//	driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
//	Thread.sleep(3000);
//	List<WebElement> ele = driver.findElements(By.xpath("//input[@name='lang' and @type='radio']"));
//	Thread.sleep(3000);
//	
//	for (int i=0;i<ele.size();i++) 
//	{
//	    WebElement language = ele.get(i);
//	    String name = language.getAttribute("value");
//	    System.out.println("lanugage ===="+name);
//	    if(name.equalsIgnoreCase("python")) {
//	    	language.click();
//	    	break;
//	    }
//	    
//	     
//	}
//	//-------------------checkbox------Button------------------------------------------------------- 
//	List<WebElement> ele2 = driver.findElements(By.xpath("//input[@name='lang' and @type='checkbox']"));
//	for (WebElement check: ele2) 
//	{
//	    
//	    String name = check.getAttribute("id");
//	    
//	    System.out.println("lanugage ===="+name);
//	    if(name.equalsIgnoreCase("sing")) {
//	    	check.click();
//	    	break;
//	    }
//	    
//	     
//	}
	
	
	
	
	//-------------------DropDown------Button------------------------------------------------------- 
//	driver.get("http://seleniumpractise.blogspot.com/2019/01/dropdown-demo-for-selenium.html");
//	Thread.sleep(3000);
//	WebElement dd_first = driver.findElement(By.id("tools1"));
//	Thread.sleep(3000);
//	Select ddf = new Select(dd_first);
//	List actualList = new ArrayList();
//	List<WebElement> all = ddf.getOptions();
//	
//	for(WebElement e: all) {
//		String data=e.getText();
//		actualList.add(data);
//		System.out.println("All options are :"+data);
//		
////		if(data.equalsIgnoreCase("Cucumber")) {
////			e.click();
////		}
//	}
//	List abc = new ArrayList();
//	abc.addAll(actualList);
//	
//	Collections.sort(abc);
//	
//	 Assert.assertEquals(actualList, abc);
	
	
	//-----------------------BootStrap dropdown
	driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
	Thread.sleep(3000);
	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	WebElement dd_first = driver.findElement(By.xpath("//button[@id='menu1']"));
	dd_first.click();
	Thread.sleep(3000);
	
	List<WebElement> menu = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li//a"));
	
	for(WebElement e: menu) {
		String data=e.getAttribute("innerHTML");
		
		if(data.contentEquals("JavaScript")) {
			e.click();
			break;
		}
		System.out.println("All options are :"+data);
		Thread.sleep(2000);

	}
	//----------------------------------------------------------------------------------------
	
	
	
	Thread.sleep(5000);
	driver.quit();
	System.out.println("Test Completed");
	}
}
