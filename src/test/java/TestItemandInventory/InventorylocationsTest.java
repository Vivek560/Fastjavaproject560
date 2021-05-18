package TestItemandInventory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.HomePage;
import pageobjects.InventorylocationPage;
import pageobjects.LoginPage;
import pageobjects.LogoutPage;

public class InventorylocationsTest {
	
	WebDriver driver;
	
	@Parameters("Browser")
	@BeforeClass
	public void setup(String browser) {
		if(browser.contains("Chrome")) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--start-maximized");
		driver = new ChromeDriver(option);
		}
		else if(browser.contains("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}	
	}
	
	@Parameters({"URL"})
	@Test(priority=1)
	public void Login(String url) {
		driver.get(url);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.Username().sendKeys("qaplanet1");
		loginpage.Password().sendKeys("lab1");
		loginpage.Login().click();
		
	}

	@Test(priority=2)
	public void AddInventoryLocation() {
		HomePage home=new HomePage(driver);
		home.ItemsandInventory().click();
		home.AddInventoryLocations().click();
		
		InventorylocationPage inventorylocation=new InventorylocationPage(driver);
		inventorylocation.Locationcode().sendKeys("0012");
		inventorylocation.LocationName().sendKeys("moren");
		inventorylocation.Contactfordelivery().sendKeys("john");
		inventorylocation.Address().sendKeys("2nd street mallepally");
		inventorylocation.Telephone().sendKeys("90770007");
		inventorylocation.Secondaryphone().sendKeys("88000900");
		inventorylocation.Facsimile().sendKeys("70000");
		inventorylocation.Email().sendKeys("a@g.com");
		inventorylocation.AddButton().click();
		inventorylocation.Back().click();
		
		
		LogoutPage logout=new LogoutPage(driver);
		logout.Logout().click();
	}
	
	@AfterClass
	public void teardown() {
		driver.close();
	}
}
