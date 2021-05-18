package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalespersonPage {

	WebDriver driver;
	
	public SalespersonPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@name='salesman_name']")
	private WebElement salesname;
	
	@FindBy(xpath="//*[@name='salesman_phone']")
	private WebElement phone;
	
	@FindBy(xpath="//*[@name='salesman_fax']")
	private WebElement fax;
	
	@FindBy(xpath="//*[@name='salesman_email']")
	private WebElement email;
	
	@FindBy(xpath="//*[@name='provision']")
	private WebElement provision;
	
	@FindBy(xpath="//*[@name='break_pt']")
	private WebElement turnoverbreak;
	
	@FindBy(xpath="//*[@name='provision2']")
	private WebElement provision2;
	
	
	@FindBy(xpath="//*[span='Add new']")
	private WebElement add;
	
	@FindBy(linkText="Back")
	private WebElement back;
	
	
	public WebElement Salesname() {
		return salesname;
	}

	public WebElement Phone() {
		return phone;
	}

	public WebElement Fax() {
		return fax;
	}
	
	public WebElement Email() {
		return email;
	}

	public WebElement Provision() {
		return provision;
	}
	
	public WebElement Turnoverbreak() {
		return turnoverbreak;
	}
	
	public WebElement Provision2() {
		return provision2;
	}

	public WebElement AddButton() {
		return add;
	}
	
	public WebElement Back() {
		return back;
	}
}