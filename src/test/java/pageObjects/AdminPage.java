package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AdminPage extends Basepage{

	public AdminPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath="//h6[text()='Admin']") WebElement AdminHeader;
	
	
	
	public boolean isAdminHeaderDisplayed() {
		
		try {
			return AdminHeader.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
}
