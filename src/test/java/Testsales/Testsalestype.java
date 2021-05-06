package Testsales;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.HomePage;
import pageobjects.SalesTypePage;

public class Testsalestype {

	
	WebDriver driver;

	@Parameters("Browser")
	@BeforeClass(groups= {"SmokeTest"})
	public void LaunchBrowser(String browser) {
		
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
	
	@Parameters({"URL","USERNAME","PASSWORD"})
	@Test(groups= {"SmokeTest"},priority=1)
	public void Login(String url,String username, String password) throws InterruptedException {
		
		driver.get(url);
		driver.findElement(By.name("user_name_entry_field")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("SubmitUser")).click();
		Thread.sleep(5000);
		
		
	}

	@Test(groups= {"SmokeTest"},priority=2)
	public void AddSalestype() throws InterruptedException {
		
		HomePage homepage=new HomePage(driver);
		homepage.Sales().click();
		homepage.SalesType().click();
		SalesTypePage salestype=new SalesTypePage(driver);
		salestype.SalesTypeName().sendKeys("Wheat");
		Actions AA=new Actions(driver);
		AA.doubleClick(salestype.CalculationFactor()).build().perform();
		salestype.CalculationFactor().sendKeys("2.000");
		//Thread.sleep(2000);
		salestype.TaxIncluded().click();
		salestype.AddButton().click();
		salestype.Back().click();
		HomePage page=new HomePage(driver);
		page.Logout();
	}
	

	@AfterClass(groups= {"SmokeTest"})
  public void Closebrowser() {
	  driver.close();
}
}

