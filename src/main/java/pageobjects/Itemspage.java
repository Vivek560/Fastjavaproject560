package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Itemspage {

	WebDriver driver;
	
	public Itemspage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//*[@name='NewStockID']")
	private WebElement itemscode;
	
	@FindBy(xpath="//*[@name='description']")
	private WebElement name;
	
	@FindBy(xpath="//*[@name='long_description']")
	private WebElement description;
	
	@FindBy(xpath="//*[@name='category_id']")
	private WebElement category;
	
	@FindBy(xpath="//*[@name='tax_type_id']")
	private WebElement taxtype;
	
	@FindBy(xpath="//*[@name='mb_flag']")
	private WebElement itemtype;
	
	@FindBy(xpath="//*[@name='units']")
	private WebElement unitsmeasure;
	
	
	@FindBy(xpath="//*[@name='editable']")
	private WebElement editable;
	
	@FindBy(xpath="//*[@name='no_sale']")
	private WebElement sales;
	
	@FindBy(xpath="//*[@name='dimension_id']")
	private WebElement dimension;
	
	@FindBy(xpath="//*[@name='sales_account']")
	private WebElement salesaccount;
	
	@FindBy(xpath="//*[@name='cogs_account']")
	private WebElement cogsaccount;
	
	@FindBy(xpath="//*[span='Insert New Item']")
	private WebElement additem;
	
	@FindBy(linkText="Back")
	private WebElement back;
	
	public WebElement Itemscode() {
		return itemscode;
	}
	
	public WebElement Name() {
		return name;
	}
	
	public WebElement Description() {
		return description;
	}
	
	public WebElement Category() {
		return category;
	}

	public WebElement Taxtype() {
		return taxtype;
	}

	public WebElement Itemtype() {
		return itemtype;
	}
	
	public WebElement Unitsmeasure() {
		return unitsmeasure;
	}

	public WebElement Editable() {
		return editable;
	}

	public WebElement Sales() {
		return sales;
	}

	public WebElement Dimension() {
		return dimension;
	}

	public WebElement SalesAccount() {
		return salesaccount;
	}

	public WebElement Cogsaccount() {
		return cogsaccount;
	}
	
	public WebElement InsertNewItem() {
		return additem;
	}

	public WebElement Back(){
		return back;
	}
}
