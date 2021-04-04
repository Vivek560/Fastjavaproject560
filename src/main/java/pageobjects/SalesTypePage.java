package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesTypePage {

	WebDriver driver;
	
	public SalesTypePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@name='sales_type']")
	private WebElement salestypename;
	
	@FindBy(xpath="//input[@class='amount']")
	private WebElement calculationfactor;
	
	@FindBy(xpath="//*[@name='tax_included']")
	private WebElement taxincluded;
	
	@FindBy(xpath="//*[span='Add new']")
	private WebElement add;
	
	@FindBy(linkText="Back")
	private WebElement back;
	
	public WebElement SalesTypeName() {
		return salestypename;
	}
	
	public WebElement CalculationFactor() {
		return calculationfactor;
	}

	public WebElement TaxIncluded() {
		return taxincluded;
	}
	
	public WebElement AddButton() {
		return add;
	}
	
	public WebElement Back() {
		return back;
	}
}
