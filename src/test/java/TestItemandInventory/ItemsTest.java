package TestItemandInventory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ItemsTest {

	WebDriver driver;
	
	@BeforeClass(groups= {"Regression"})
	public void Setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Parameters({"URL"})
	@Test(groups= {"Regression"},priority=1)
	public void login(String url) {
		driver.get(url);
		driver.findElement(By.xpath("//*[@name='user_name_entry_field']")).sendKeys("qaplanet1");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("lab1");
		driver.findElement(By.xpath("//*[@name='SubmitUser']")).click();
		
	}
	
	@Test(groups= {"Regression"},priority=2)
	public void AddItem() throws InterruptedException {
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
		driver.findElement(By.linkText("Logout")).click();
	}
	
	@AfterClass(groups= {"Regression"})
	public void teardown() {
		driver.close();
	}
}
