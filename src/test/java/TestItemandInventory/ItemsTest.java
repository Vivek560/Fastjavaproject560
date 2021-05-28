	package TestItemandInventory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class ItemsTest {

	WebDriver driver;
	
	@Parameters("Browser")
	@BeforeClass(groups= {"Regression"})
	public void Setup(String browser) {
		if(browser.contains("Chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}

		else if(browser.contains("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}	
		driver.manage().window().maximize();
	}
	
	@Parameters({"URL"})
	@Test(groups= {"Regression"},priority=1)
	public void login(String url) {
		driver.get(url);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.Username().sendKeys("qaplanet1");
		loginpage.Password().sendKeys("lab1");
		loginpage.Login().click();
		
	}
	
	@Test(groups= {"Regression"},priority=2)
	public void AddItem() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HomePage homepage=new HomePage(driver);
		homepage.ItemsandInventory().click();
		homepage.Items().click();
		
		Itemspage items=new Itemspage(driver);
		Actions action=new Actions(driver);
		action.click(items.Itemscode()).build().perform();
		items.Itemscode().sendKeys("1298");
		
		items.Name().sendKeys("kumar");
		
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
		
		Thread.sleep(2000);
		LogoutPage logout=new LogoutPage(driver);
		logout.Logout().click();
	}
	
	@AfterClass(groups= {"Regression"})
	public void teardown() {
		driver.close();
	}
}
