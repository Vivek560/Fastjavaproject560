package Testsales;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testsalesgroup {
	
	WebDriver driver;

	@BeforeMethod(groups= {"SmokeTest"})
	public void LaunchBrowser() {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	@Parameters({"URL","USERNAME","PASSWORD"})
	@Test(groups= {"SmokeTest"},priority=1)
	public void Login(String url, String username, String password) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("user_name_entry_field")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("SubmitUser")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains (text(), 'Logout')]")).click();
		Thread.sleep(5000);
		
	}
	
	@Parameters({"URL","USERNAME","PASSWORD"})
	@Test(groups= {"SmokeTest"},priority=2)
	public void AddSalesgroup(String url, String username,String password) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("user_name_entry_field")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("SubmitUser")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sales Groups")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("description")).sendKeys("Extra Large");
		driver.findElement(By.xpath("//*[span='Add new']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains (text(), 'Logout')]")).click();
	}
	

	@AfterMethod(groups= {"SmokeTest"})
  public void Closebrowser() {
	  driver.close();
  }

}
