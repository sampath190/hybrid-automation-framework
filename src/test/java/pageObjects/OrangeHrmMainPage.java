package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHrmMainPage extends Basepage{

	public OrangeHrmMainPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[@class='oxd-main-menu-item active']//span[text()='Admin']") WebElement Adminbtn;
	
	@FindBy(xpath="//span[text()='PIM']") WebElement PIMbtn;
	
	public void clickAdminbtn() {
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Admin']")));
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click();", ele);
	}
	
	public void clickPIMbtn() {
		PIMbtn.click();
	}

}
