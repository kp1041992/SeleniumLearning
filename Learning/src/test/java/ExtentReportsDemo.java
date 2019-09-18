import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsDemo {
 private static	WebDriver driver;
	public static void main(String[] args) {
		
		ExtentHtmlReporter extenthtmlreport = new ExtentHtmlReporter("reporting1.html"); 
		ExtentReports extentreport = new ExtentReports();
		extentreport.attachReporter(extenthtmlreport);
		ExtentTest testgoogle = extentreport.createTest("This is test for google Search");
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/Chrome/chromedriver.exe");
		
		driver = new ChromeDriver();
		
		testgoogle.log(Status.INFO, "Starting a test case");
		driver.get("https://www.google.com");
		testgoogle.pass("Navigated to google home page");
		
		WebElement txtbox = driver.findElement(By.xpath("//input[@name='q']"));
		txtbox.sendKeys("Automation step by step");
		testgoogle.pass("Entered the text in search box");
		WebElement btnClick = driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@name='btnK']"));
		btnClick.sendKeys(Keys.RETURN);
		testgoogle.pass("clicked the search button");
		driver.close();
		testgoogle.pass("close the browser");
		testgoogle.info("completed");
		
		extentreport.flush();
		
	}
	
	
	

}
