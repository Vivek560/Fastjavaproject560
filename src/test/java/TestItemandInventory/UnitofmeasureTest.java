package TestItemandInventory;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.LogoutPage;
import pageobjects.UnitsMeasurePage;

public class UnitofmeasureTest {

	WebDriver driver;
	Logger log;
	
	@Parameters("Browser")
	@BeforeClass
	public void setup(String browser) {
		if(browser.contains("Chrome")) {
		WebDriverManager.chromedriver().setup();
		log = LogManager.getLogger(UnitofmeasureTest.class.getName());
		driver=new ChromeDriver();
		}
		else if(browser.contains("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}	
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
		
		LoginPage login=new LoginPage(driver);
		login.Username().sendKeys("qaplanet1");
		log.debug("The username is entered Successfully");
		login.Password().sendKeys("lab1");
		log.debug("The password is entered Successfully");
		login.Login().click();
		log.debug("Login is Successfully");
	}

	@Test(priority=2)
	public void AddUnitofMeasure() {
		
		HomePage homepage=new HomePage(driver);
		homepage.ItemsandInventory().click();
		log.debug("Items and Inventory is clicked");
		homepage.UnitsofMeasures().click();
		log.debug("Units of Measure is clicked");
		UnitsMeasurePage units=new UnitsMeasurePage(driver);
		units.Unitabbrevationfield().sendKeys("MM");
		log.debug("Entered the measures");
		units.Description().sendKeys("Milli meter");
		Select Decimaldropdown=new Select(units.Decimals());
		Decimaldropdown.selectByValue("1");
		units.AddNewButton().click();
		units.Back().click();
		
	}
	
	@Test(priority=3)
	public void Logout() {
		LogoutPage logout=new LogoutPage(driver);
		logout.Logout().click();
	}
	
	@AfterClass
	public void teardown() {
		driver.close();
	}
	
}
