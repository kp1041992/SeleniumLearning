

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerTest {
public static void main(String[] args) {
	WebDriverManager.chromedriver().version("77.0").setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.google.ca");
	WebElement txtbox1 = driver.findElement(By.xpath("//input[@name='q']"));
	txtbox1.sendKeys("Automation step by step");
	driver.close();
}
}
