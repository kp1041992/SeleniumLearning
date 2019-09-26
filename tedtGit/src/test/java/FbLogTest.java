import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Elements.AllElements;

public class FbLogTest {
	private static WebDriver driver = null;

	@BeforeTest
	public void setup() {
		String project = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", project + "/Drivers/Firefox/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
	}

	@Test
	public static void fbLoginTest() {

		AllElements elements = new AllElements(driver);
		elements.element_EmailTextbox("kp1041992@gmail.com");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		elements.element_PasswordTextbox("abcd");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		elements.element_LoginBtn();

	}

	@AfterTest
	public void tearDown() {
		driver.close();

		System.out.println("test completed");
	}

	
	
}
