package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

		private By username = By.xpath("//*[@name='user_name_entry_field']");
		private By password = By.xpath("//*[@name='password']");
		private By login = By.xpath("//*[@name='SubmitUser']");
		
		
		public WebElement Username() {
			return driver.findElement(username);
		}

		public WebElement Password() {
			return driver.findElement(password);
		}
		
		public WebElement Login() {
			return driver.findElement(login);
		}
		
}
