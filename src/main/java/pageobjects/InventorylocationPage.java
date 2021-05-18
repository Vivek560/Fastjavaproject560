package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventorylocationPage {
	
	WebDriver driver;
	
	public InventorylocationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@name='loc_code']")
	private WebElement locationcode;
	
	@FindBy(xpath="//*[@name='location_name']")
	private WebElement locationname;
	
	@FindBy(xpath="//*[@name='contact']")
	private WebElement contactfordelivery;

	@FindBy(xpath="//*[@name='delivery_address']")
	private WebElement address;
	
	@FindBy(xpath="//*[@name='phone']")
	private WebElement phone;
	
	@FindBy(xpath="//*[@name='phone2']")
	private WebElement secondaryphone;
	
	@FindBy(xpath="//*[@name='fax']")
	private WebElement facsimile;
	
	@FindBy(xpath="//*[@name='email']")
	private WebElement email;
	
	@FindBy(xpath="//*[span='Add new']")
	private WebElement add;
	
	@FindBy(linkText="Back")
	private WebElement back;
	
	public WebElement Locationcode() {
		return locationcode;
	}
	
	public WebElement LocationName() {
		return locationname;
	}

	public WebElement Contactfordelivery() {
		return contactfordelivery;
	}	

	public WebElement Address() {
		return address;
	}

	public WebElement Telephone() {
		return phone;
	}

	public WebElement Secondaryphone() {
		return secondaryphone;
	}
	
	public WebElement Facsimile() {
		return facsimile;
	}
	
	public WebElement Email() {
		return email;
	}
	
	public WebElement AddButton() {
		return add;
	}
	
	public WebElement Back() {
		return back;
	}

}

