package BankingandLedger;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.GLAccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class GLAccountTest {

	WebDriver driver;
	
	@Parameters("Browser")
	@BeforeClass
	public void setup(String browser) {

		if(browser.contains("Chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
		else if(browser.contains("Edge")) {
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();	
		}
		
		driver.manage().window().maximize();
	}
	
	
	@Test(priority=1)
	public void Login() {
		driver.get("http://apps.qaplanet.in/erp/index.php");
		LoginPage login=new LoginPage(driver);
		login.Username().sendKeys("qaplanet1");
		login.Password().sendKeys("lab1");
		login.Login().click();
	}
	
	

	@Test(priority=2,dataProvider="GLdata")
	public void AddGLAccount(String accountcode, String accountcode2, String accountname, String accountgroup, String status) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		HomePage home=new HomePage(driver);
		home.BankandLedgerLink().click();
		home.GLAccount().click();
		
		GLAccountPage glaccount=new GLAccountPage(driver);		
		
		Actions action=new Actions(driver);
		action.click(glaccount.Accountcode()).perform();
		glaccount.Accountcode().sendKeys(accountcode);
		glaccount.Accountcode2().sendKeys(accountcode2);
		glaccount.Accountname().sendKeys(accountname);
		
		Select group=new Select(glaccount.Accountgroup());
		group.selectByVisibleText(accountgroup);
		
		Select Status=new Select(glaccount.Accountstatus());
		Status.selectByVisibleText(status);
		
		glaccount.Addbutton().click();
		glaccount.Back().click();
	}

	
	@DataProvider
	public Object[][] GLdata() {
	
	Object[][] GLinformation= {{"111","1101","Savings account","5    Long Term Liabilities","Active"},{"222","1102","Current account","8    Sales Revenue","Active"},{"333","1103","Demat account","4    Current Liabilities","Active"}};	
	
	return GLinformation;
	
	}
	
	
	@AfterClass
	public void teardown() {
		driver.close();
	}
}
