package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BankAccountsPage {
	
	WebDriver driver;
	
	public BankAccountsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By bankaccountname = By.xpath("//*[@name='bank_account_name']");
	private By accounttype= By.xpath("//*[@name='account_type']");
	private By accountcurrency = By.xpath("//*[@name='BankAccountCurrency']");
	private By currencyaccount = By.xpath("//*[@name='dflt_curr_act']");
	private By accountcode = By.xpath("//*[@name='account_code']");
	private By chargesaccount = By.xpath("//*[@name='bank_charge_act']");
	private By bankname = By.xpath("//*[@name='bank_name']");
	private By accountnumber = By.xpath("//*[@name='bank_account_number']");
	private By bankaddress = By.xpath("//*[@name='bank_address']");
	private By add = By.xpath("//*[span='Add new']");
	private By back = By.linkText("Back");
	
	public WebElement BankAccountName() {
		return driver.findElement(bankaccountname);
	}
	
	public WebElement AccountType() {
		return driver.findElement(accounttype);
	}
	
	public WebElement AccountCurrency() {
		return driver.findElement(accountcurrency);
	}
	
	public WebElement CurrencyAccount() {
		return driver.findElement(currencyaccount);
	}
	
	public WebElement AccountCode() {
		return driver.findElement(accountcode);
	}
	
	public WebElement ChargesAccount() {
		return driver.findElement(chargesaccount);
	}

	public WebElement BankName() {
		return driver.findElement(bankname);
	}

	public WebElement BankAddress() {
		return driver.findElement(bankaddress);
	}
	
	public WebElement AccountNumber() {
		return driver.findElement(accountnumber);
	}
	
	public WebElement AddButton() {
		return driver.findElement(add);
	}
	
	public WebElement Back() {
		return driver.findElement(back);
	}
}


