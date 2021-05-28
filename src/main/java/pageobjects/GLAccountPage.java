package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GLAccountPage {

	WebDriver driver;
	
	public GLAccountPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//*[@name='account_code']")
	private WebElement accountcode;
	
	@FindBy(xpath="//*[@name='account_code2']")
	private WebElement accountcode2;
	
	@FindBy(xpath="//*[@name='account_name']")
	private WebElement accountname;

	@FindBy(xpath="//*[@name='account_type']")
	private WebElement accountgroup;
	
	@FindBy(xpath="//*[@name='inactive']")
	private WebElement accountstatus;
	
	@FindBy(xpath="//*[span='Add Account']")
	private WebElement addbutton;
	
	@FindBy(linkText="Back")
	private WebElement back;

	
	public WebElement Accountcode() {
		return accountcode;
	}
	
	public WebElement Accountcode2() {
		return accountcode2;
	}
	
	public WebElement Accountname() {
		return accountname;
	}

	public WebElement Accountgroup() {
	return accountgroup;
	}	
	
	public WebElement Accountstatus() {
		return accountstatus;
	}

	public WebElement Addbutton() {
		return addbutton;
	}	
	
	public WebElement Back() {
		return back;
	}


}
