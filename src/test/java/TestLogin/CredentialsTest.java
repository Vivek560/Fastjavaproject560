package TestLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CredentialsTest {
	
	WebDriver driver; 
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="credentials")
	public void TestvalidateLogin(String username, String password) {
		driver.get("http://apps.qaplanet.in/erp/index.php");
		driver.findElement(By.xpath("//*[@name='user_name_entry_field']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@name='SubmitUser']")).click();
		
		if(driver.getTitle()=="Main Menu") {
			System.out.println("Login is successful");
			driver.findElement(By.linkText("Logout")).click();
		}
		else {
			System.out.println("Invalid credentials");
		}
	}
	
	@DataProvider
	public Object[][] credentials() {
		Object[][] data=new Object[3][2];
		
		data[0][0]="qaplanet1";
		data[0][1]="lab1";
		
		data[1][0]="qaplanet";
		data[1][1]="lab1";
		
		data[2][0]="qaplanet1";
		data[2][1]="lab";
		
		return data;
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
}
