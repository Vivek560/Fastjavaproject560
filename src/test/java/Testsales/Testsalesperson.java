package Testsales;

import java.util.concurrent.TimeUnit;

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
import pageobjects.LoginPage;
import pageobjects.LogoutPage;
import pageobjects.SalespersonPage;

public class Testsalesperson {
	
	WebDriver driver;
	
	@Parameters("Browser")
	@BeforeClass
	public void Setup(String browser) {
		if(browser.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--start-maximized");
			driver = new ChromeDriver(option);
		}
			else if(browser.contains("Edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				driver.manage().window().maximize();
	}}
	
	@Parameters({"URL","USERNAME","PASSWORD"})
	@Test(priority=1)
	public void Login(String url, String username, String password) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.Username().sendKeys(username);
		loginpage.Password().sendKeys(password);
		loginpage.Login().click();
		
	}
	
	@Test(priority=2)
	public void AddSalesperson() {
		HomePage home=new HomePage(driver);
		home.Sales().click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		home.Salesperson().click();
		SalespersonPage salesperson=new SalespersonPage(driver);
		salesperson.Salesname().sendKeys("kumar");
		salesperson.Phone().sendKeys("990900");
		salesperson.Fax().sendKeys("809000");
		salesperson.Email().sendKeys("a@g.com");
	
		Actions action=new Actions(driver);
		action.doubleClick(salesperson.Provision()).build().perform();
		salesperson.Provision().sendKeys("3.000");
		action.doubleClick(salesperson.Turnoverbreak()).build().perform();
		salesperson.Turnoverbreak().sendKeys("3.000");
		action.doubleClick(salesperson.Provision2()).build().perform();
		salesperson.Provision2().sendKeys("3.000");
		salesperson.AddButton().click();
		salesperson.Back().click();

		LogoutPage logout=new LogoutPage(driver);
		logout.Logout().click();
	}
	
	@AfterClass
	public void Closebrowser() {
		driver.close();
	}
}
