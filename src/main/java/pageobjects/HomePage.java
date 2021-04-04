package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By bankingandLedgerlink = By.linkText("Banking and General Ledger");
	private By sales = By.linkText("Sales");
	private By itemsandinventory=By.linkText("Items and Inventory");
	private By bankaccount=new By.ByLinkText("Bank Accounts");
	private By salestype = By.linkText("Sales Types");
	private By logout = By.linkText("Logout");
	
	public WebElement Sales() {
		return driver.findElement(sales);
	}
	
	public WebElement ItemsandInventory() {
		return driver.findElement(itemsandinventory);
	}
	
	public WebElement BankandLedgerLink() {
		return driver.findElement(bankingandLedgerlink);
	}

	public WebElement BankAccounts() {
		return driver.findElement(bankaccount);
	}
	
	public WebElement SalesType() {
		return driver.findElement(salestype);
	}

	public WebElement Logout() {
		return driver.findElement(logout);
	}
}