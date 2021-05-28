 package TestItemandInventory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.HomePage;
import pageobjects.Itemspage;
import pageobjects.LoginPage;
import pageobjects.LogoutPage;

public class InventoryTest {


	WebDriver driver;
	
	@Parameters("Browser")
	@BeforeClass
	public void setup(String browser) {
		
		if(browser.contains("Chrome")){
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--start-maximized");
		driver = new ChromeDriver(option);
	}
		else if(browser.contains("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}	
		
	}

	@Parameters({"URL"})
	@Test(priority=1)
	public void TestLogin(String url) {
		driver.get(url);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.Username().sendKeys("qaplanet1");
		loginpage.Password().sendKeys("lab1");
		loginpage.Login().click();
		
	}

	@Test(priority=2)
	public void TestAddInventoryLocation() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
		HomePage homepage=new HomePage(driver);
		homepage.ItemsandInventory().click();
		homepage.Items().click();
		
		Itemspage items=new Itemspage(driver);
		Actions action=new Actions(driver);
		action.click(items.Itemscode()).build().perform();
		items.Itemscode().sendKeys("1298");
		
		items.Name().sendKeys("jai");
		
		items.Description().sendKeys("Items holding Description");
		
		
		Select categorydropdown=new Select(items.Category());
		categorydropdown.selectByValue("4");
		
		Select itemtaxtypedropdown=new Select(items.Taxtype());
		itemtaxtypedropdown.selectByValue("1");
		
		Select itemtypedropdown=new Select(items.Itemtype());
		itemtypedropdown.selectByValue("D");
		
		Select unitsofmeasuredropdown=new Select(items.Unitsmeasure());
		unitsofmeasuredropdown.selectByValue("ML");
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(driver, 25);
		
		WebElement description=wait.until(ExpectedConditions.elementToBeClickable(items.Editable()));
		description.click();
		WebElement sales=wait.until(ExpectedConditions.elementToBeClickable(items.Sales()));
		sales.click();
		
		
		WebElement dimension=wait.until(ExpectedConditions.elementToBeClickable(items.Dimension()));
		
		Select dimensiondropdown=new Select(dimension);
		dimensiondropdown.selectByValue("1");
		
		Select accountdropdown=new Select(items.SalesAccount());
		accountdropdown.selectByValue("1060");
		
		Select cogsaccountdropdown=new Select(items.Cogsaccount());
		cogsaccountdropdown.selectByValue("1520");
		
		items.InsertNewItem().click();
		items.Back().click();
		
	}
	
	@Test(priority=4)
	public void TestAddUnitofMeasure() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Items and Inventory")).click();
		driver.findElement(By.linkText("Units of Measure")).click();
		driver.findElement(By.xpath("//*[@name='abbr']")).sendKeys("MM");
		driver.findElement(By.xpath("//*[@name='description']")).sendKeys("Milli meter");
		WebElement Decimal=driver.findElement(By.xpath("//*[@name='decimals']"));
		Select Decimaldropdown=new Select(Decimal);
		Decimaldropdown.selectByValue("1");
		driver.findElement(By.xpath("//*[span='Add new']")).click();
		driver.findElement(By.linkText("Back")).click();
		LogoutPage logout=new LogoutPage(driver);
		logout.Logout().click();
	}
	
	@AfterClass
	public void teardown() {
		driver.close();
	}
}
