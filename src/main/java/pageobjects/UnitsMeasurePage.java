package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UnitsMeasurePage {
	
	WebDriver driver;
	public UnitsMeasurePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//*[@name='abbr']")
	private WebElement unitabbrevation;

	@FindBy(xpath="//*[@name='description']")
	private WebElement description;
	
	@FindBy(xpath="//*[@name='decimals']")
	private WebElement decimals;
	
	@FindBy(xpath="//*[span='Add new']")
	private WebElement addnewbutton;
	
	@FindBy(linkText="Back")
	private WebElement back;
	
	public WebElement Unitabbrevationfield() {
		return unitabbrevation;
	}

	public WebElement Description() {
		return description;
	}

	public WebElement Decimals() {
		return decimals;
	}	

	public WebElement AddNewButton() {
		return addnewbutton;
	}

	public WebElement Back() {
		return back;
	}
	
}
