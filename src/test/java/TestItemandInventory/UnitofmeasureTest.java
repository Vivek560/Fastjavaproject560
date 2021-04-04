package TestItemandInventory;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UnitofmeasureTest {

	WebDriver driver;
	Logger log;
	
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		log = LogManager.getLogger(UnitofmeasureTest.class.getName());
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		log.debug("The browser is opened and maximized");
	}
	
	@Parameters({"URL"})
	@Test(priority=1)
	public void login(String url) {
		driver.get(url);
		if(driver.getTitle().equals("FrontAccounting 2.4.2 - Login")) {
			log.info("The title matches");
		}
		else {
			log.error("Title is not matching");
		}
		driver.findElement(By.xpath("//*[@name='user_name_entry_field']")).sendKeys("qaplanet1");
		log.debug("The username is entered Successfully");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("lab1");
		log.debug("The password is entered Successfully");
		driver.findElement(By.xpath("//*[@name='SubmitUser']")).click();
		log.debug("Login is Successfully");
	}

	@Test(priority=2)
	public void AddUnitofMeasure() {
		driver.findElement(By.linkText("Items and Inventory")).click();
		log.debug("Items and Inventory is clicked");
		driver.findElement(By.linkText("Units of Measure")).click();
		log.debug("Units of Measure is clicked");
		driver.findElement(By.xpath("//*[@name='abbr']")).sendKeys("MM");
		log.debug("Entered the measures");
		driver.findElement(By.xpath("//*[@name='description']")).sendKeys("Milli meter");
		WebElement Decimal=driver.findElement(By.xpath("//*[@name='decimals']"));
		Select Decimaldropdown=new Select(Decimal);
		Decimaldropdown.selectByValue("1");
		driver.findElement(By.xpath("//*[span='Add new']")).click();
		driver.findElement(By.linkText("Back")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
	
	@AfterClass
	public void teardown() {
		driver.close();
	}
	
}
