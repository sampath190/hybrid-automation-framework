package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage extends Basepage {

    public DashBoardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//a//span[text()='Admin']")
    WebElement adminMenu;

    @FindBy(xpath="//h6[text()='Dashboard']")
    WebElement dashboardHeader;
    
    @FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
    WebElement Userdropdown;
    
    @FindBy(xpath="//a[text()='Logout']")
    WebElement btnLogOut;

    
    public boolean isDashboardDisplayed() {

        try {
            return dashboardHeader.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public void clickUserdropdown() {
    	Userdropdown.click();
    }
    public void clickLogOutBtn() {
    	btnLogOut.click();
    }
}