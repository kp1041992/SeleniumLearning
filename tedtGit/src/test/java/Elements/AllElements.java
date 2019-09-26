package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AllElements {
	
	 WebDriver driver = null;
	By text_Email = By.xpath("//input[@id='email']");
	By text_Pass = By.xpath("//input[@id='pass']");
	By btn_Login = By.xpath("//input[@id='u_0_b']");
	
	public AllElements(WebDriver driver) {
		this.driver = driver;
	}
	
	public void element_EmailTextbox(String email_Value) {
		driver.findElement(text_Email).sendKeys(email_Value);
	}
	
	public void element_PasswordTextbox(String pass_Value) {
		driver.findElement(text_Pass).sendKeys(pass_Value);
	}
	public void element_LoginBtn() {
		driver.findElement(btn_Login).sendKeys(Keys.RETURN);
	}
	

}
