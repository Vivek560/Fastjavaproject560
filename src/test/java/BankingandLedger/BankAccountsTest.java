package BankingandLedger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.BankAccountsPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class BankAccountsTest {

	WebDriver driver;
	
	@BeforeClass
	public void Setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void login() {
		driver.get("http://apps.qaplanet.in/erp/index.php");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.Username().sendKeys("qaplanet1");
		loginpage.Password().sendKeys("lab1");
		loginpage.Login().click();
	}

	
	@Test(priority=2)
	public void AddBankAccounts() {
		HomePage homepage=new HomePage(driver);
		homepage.BankandLedgerLink().click();
		homepage.BankAccounts().click();
		BankAccountsPage bankaccount = new BankAccountsPage(driver);
		bankaccount.BankAccountName().sendKeys("BABA");
		
		Select Accounttypedropdown = new Select(bankaccount.AccountType());
		Accounttypedropdown.selectByVisibleText("Credit Account");
		
		Select AccountCurrencydropdown = new Select(bankaccount.AccountCurrency());
		AccountCurrencydropdown.selectByIndex(2);
		
		Select CurrencyAccountdropdown = new Select(bankaccount.CurrencyAccount());
		CurrencyAccountdropdown.selectByVisibleText("Yes");
		
		Select AccountGLcodedropdown = new Select(bankaccount.AccountCode());
		AccountGLcodedropdown.selectByValue("1520");
		
		Select ChargesAccountdropdown = new Select(bankaccount.ChargesAccount());
		ChargesAccountdropdown.selectByValue("1840");
		
		bankaccount.BankName().sendKeys("kumar");
		bankaccount.AccountNumber().sendKeys("1232");
		bankaccount.BankAddress().sendKeys("Madhura Nagar Ameerper Khammam");
		bankaccount.AddButton().click();
		bankaccount.Back().click();
	}

	@AfterClass
	public void teardown() {
		driver.close();
	}
	
}
