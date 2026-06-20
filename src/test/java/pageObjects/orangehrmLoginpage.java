package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orangehrmLoginpage {

	WebDriver driver;

	public orangehrmLoginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By Username = By.xpath("//input[@name='username']");
	
	@FindBy(xpath="//input[@name='username']") WebElement txtUsername;
	@FindBy(xpath="//input[@name='password']") WebElement txtPassword;
	@FindBy(xpath="//button[@type='submit']") WebElement btnLogin;
	@FindBy(xpath="//h5[text()='Login']") WebElement txtLoginHeading;
	
	public void enterUserName(String uname) {
        txtUsername.sendKeys(uname);
    }

    public void enterPassword(String pwd) {
        txtPassword.sendKeys(pwd);
    }

    public void clickLogin() {
        btnLogin.click();
    }
    public boolean isLoginPageDisplayed() {

        try {
            return txtLoginHeading.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void handleAlertIfPresent() {
        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
            // No alert, do nothing
        }
    }

}
