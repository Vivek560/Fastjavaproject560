package Testsales;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLogin {
	
	WebDriver driver;
	
	@Parameters({"Browser","URL"})
	@Test(groups= {"SmokeTest"},priority=1)
	public void Launchbrowser(String browser, String url) {
		if(browser.contains("Chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
		else if(browser.contains("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}	
		driver.manage().window().maximize();
		
		driver.get(url);
		Assert.assertEquals(driver.getTitle(), "FrontAccounting 2.4.2 - Login");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@Parameters({"USERNAME","PASSWORD"})
	@Test(groups= {"SmokeTest"},priority=2)
	public void Login(String username, String password) {
		Assert.assertTrue(driver.findElement(By.xpath("//*[@name='user_name_entry_field']")).isDisplayed(),"Username field is displayed");
		driver.findElement(By.xpath("//*[@name='user_name_entry_field']")).sendKeys(username);
		Assert.assertTrue(driver.findElement(By.xpath("//*[@name='password']")).isDisplayed(),"Password field is displayed");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@name='SubmitUser']")).click();
	}

	
	@Test(groups= {"SmokeTest"},priority=3)
	public void Logout() {
		driver.close();
	}
}
