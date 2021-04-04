package TestItemandInventory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InventorylocationsTest {
	
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--start-maximized");
		driver = new ChromeDriver(option);
		
	}
	
	@Parameters({"URL"})
	@Test(priority=1)
	public void Login(String url) {
		driver.get(url);
		driver.findElement(By.xpath("//*[@name='user_name_entry_field']")).sendKeys("qaplanet1");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("lab1");
		driver.findElement(By.xpath("//*[@name='SubmitUser']")).click();
	}

	@Test(priority=2)
	public void AddInventoryLocation() {
		driver.findElement(By.linkText("Items and Inventory")).click();
		driver.findElement(By.linkText("Inventory Locations")).click();
		driver.findElement(By.xpath("//*[@name='loc_code']")).sendKeys("0012");
		driver.findElement(By.xpath("//*[@name='location_name']")).sendKeys("moren");
		driver.findElement(By.xpath("//*[@name='contact']")).sendKeys("john");
		driver.findElement(By.xpath("//*[@name='delivery_address']")).sendKeys("2nd street mallepally");
		driver.findElement(By.xpath("//*[@name='phone']")).sendKeys("90770007");
		driver.findElement(By.xpath("//*[@name='phone2']")).sendKeys("88000900");
		driver.findElement(By.xpath("//*[@name='fax']")).sendKeys("70000");
		driver.findElement(By.xpath("//*[@name='email']")).sendKeys("a@g.com");
		driver.findElement(By.xpath("//*[span='Add new']")).click();
		driver.findElement(By.linkText("Back")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
	
	@AfterClass
	public void teardown() {
		driver.close();
	}
}
