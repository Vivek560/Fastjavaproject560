package Testsales;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testsalesperson {
	
	WebDriver driver;
	
	@BeforeClass
	public void Setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Parameters({"URL","USERNAME","PASSWORD"})
	@Test(priority=1)
	public void Login(String url, String username, String password) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@name='user_name_entry_field']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@name='SubmitUser']")).click();
		
	}
	
	@Test(priority=2)
	public void AddSalesperson() {
		driver.findElement(By.linkText("Sales")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Sales Persons")).click();
		driver.findElement(By.xpath("//*[@name='salesman_name']")).sendKeys("kumar");
		driver.findElement(By.xpath("//*[@name='salesman_phone']")).sendKeys("990900");
		driver.findElement(By.xpath("//*[@name='salesman_fax']")).sendKeys("809000");
		driver.findElement(By.xpath("//*[@name='salesman_email']")).sendKeys("a@g.com");
		Actions action=new Actions(driver);
		action.doubleClick(driver.findElement(By.xpath("//*[@name='provision']"))).build().perform();
		driver.findElement(By.xpath("//*[@name='provision']")).sendKeys("3.000");
		action.doubleClick(driver.findElement(By.xpath("//*[@name='break_pt']"))).build().perform();
		driver.findElement(By.xpath("//*[@name='break_pt']")).sendKeys("3.000");
		action.doubleClick(driver.findElement(By.xpath("//*[@name='provision2']"))).build().perform();
		driver.findElement(By.xpath("//*[@name='provision2']")).sendKeys("3.000");
		driver.findElement(By.xpath("//*[span='Add new']")).click();
		driver.findElement(By.linkText("Back")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
	
	@AfterClass
	public void Closebrowser() {
		driver.close();
	}
}
