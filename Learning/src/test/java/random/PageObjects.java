package random;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PageObjects {
	WebDriver driver = null;
	By txtBox = By.xpath("//input[@name='q']");
	By btn1 = By.xpath("//div[@class='FPdoLc VlcLAe']//input[@name='btnK']");

	public PageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void textbox_serch(String text) {
		driver.findElement(txtBox).sendKeys(text);
	}

	public void btn_click() {
		driver.findElement(btn1).sendKeys(Keys.RETURN);
	}
}
