 package TestItemandInventory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InventoryTest {


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
	public void TestLogin(String url) {
		driver.get(url);
		driver.findElement(By.xpath("//*[@name='user_name_entry_field']")).sendKeys("qaplanet1");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("lab1");
		driver.findElement(By.xpath("//*[@name='SubmitUser']")).click();
	}

	@Test(priority=2)
	public void TestAddInventoryLocation() {
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
	}
	
	@Test(enabled=false)
	public void TestAddItem() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Items and Inventory")).click();
		driver.findElement(By.linkText("Items")).click();
		
		Actions action=new Actions(driver);
		action.click(driver.findElement(By.xpath("//*[@name='NewStockID']"))).build().perform();
		
		driver.findElement(By.xpath("//*[@name='NewStockID']")).sendKeys("1298");
		driver.findElement(By.xpath("//*[@name='description']")).sendKeys("kumar");
		driver.findElement(By.xpath("//*[@name='long_description']")).sendKeys("Items holding Description");
		
		Select categorydropdown=new Select(driver.findElement(By.xpath("//*[@name='category_id']")));
		categorydropdown.selectByValue("4");
		
		Select itemtaxtypedropdown=new Select(driver.findElement(By.xpath("//*[@name='tax_type_id']")));
		itemtaxtypedropdown.selectByValue("1");
		
		Select itemtypedropdown=new Select(driver.findElement(By.xpath("//*[@name='mb_flag']")));
		itemtypedropdown.selectByValue("D");
		
		Select unitsofmeasuredropdown=new Select(driver.findElement(By.xpath("//*[@name='units']")));
		unitsofmeasuredropdown.selectByValue("ML");
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(driver, 25);
		
		WebElement description=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='editable']")));
		description.click();
		WebElement sales=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='no_sale']")));
		sales.click();
		
		
		WebElement dimension=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='dimension_id']")));
		
		Select dimensiondropdown=new Select(dimension);
		dimensiondropdown.selectByValue("1");
		
		Select accountdropdown=new Select(driver.findElement(By.xpath("//*[@name='sales_account']")));
		accountdropdown.selectByValue("1060");
		
		Select cogsaccountdropdown=new Select(driver.findElement(By.xpath("//*[@name='cogs_account']")));
		cogsaccountdropdown.selectByValue("1520");
		
		driver.findElement(By.xpath("//*[span='Insert New Item']")).click();
		driver.findElement(By.linkText("Back"));
		
	}
	
	@Test(priority=4)
	public void TestAddUnitofMeasure() {
		driver.findElement(By.linkText("Items and Inventory")).click();
		driver.findElement(By.linkText("Units of Measure")).click();
		driver.findElement(By.xpath("//*[@name='abbr']")).sendKeys("MM");
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
