import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserTest {

	private static WebDriver driver;
	@BeforeTest
	public static void setup() {
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/Chrome/chromedriver.exe");
		
		}
	@Test
	public static void actualSteps() {
		 driver = new ChromeDriver();
		driver.get("https://www.google.com");
		WebElement txtbox = driver.findElement(By.xpath("//input[@name='q']"));
		txtbox.sendKeys("Automation step by step");
		
		WebElement btnClick = driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@name='btnK']"));
		btnClick.sendKeys(Keys.RETURN);
		}
	@AfterTest
	public static void tearDownTest() {
		driver.close();
		System.out.println("Success");
		}
}
