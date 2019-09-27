import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Elements.AllElements;

public class FbLogTest {
	private static WebDriver driver = null;
	ExtentHtmlReporter htmlReporter;
	ExtentReports report;
	ExtentTest test;
	
	
	@BeforeTest
	public void setup() {
		 htmlReporter = new ExtentHtmlReporter("extentReport.html");
		 report = new ExtentReports();
		report.attachReporter(htmlReporter);
		 test = report.createTest("Testing","This is for creating a test");
		String project = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", project + "/Drivers/Firefox/geckodriver.exe");
		driver = new FirefoxDriver();
		test.log(Status.INFO, "Starting a test case");
		driver.get("https://www.facebook.com/");
		test.pass("Navigated to the facebook page");
	}

	@Test
	public void fbLoginTest() {

		AllElements elements = new AllElements(driver);
		elements.element_EmailTextbox("kp1041992@gmail.com");
		test.pass("Email component found and insert value successfully");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		elements.element_PasswordTextbox("abcd");
		test.pass("password component found and insert value successfully");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		elements.element_LoginBtn();
		test.pass("Login button clicked");

	}

	@AfterTest
	public void tearDown() {
		driver.close();
		test.pass("Closed the browser");
		test.info("test completed");
		report.flush();
	}

	
	
}
