package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EmployeeListPage extends Basepage {

	public EmployeeListPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h5[text()='Employee Information']")
	WebElement EmployeeInfoHeader;
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement Addbtn;
	@FindBy(xpath = "//h6[text()='Personal Details']")
	WebElement PersonalDetailsHeader;
	@FindBy(xpath = "//label[text()='Employee Id']/following::input[1]")
	WebElement txt_EmployeeID;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchbtn;
	
	@FindBy(xpath="//div[@class='oxd-table-card']//div[@class='oxd-checkbox-wrapper']")
	WebElement DisplayedEmployeeCheckbox;
	
	@FindBy(xpath="//div[@class='oxd-table-cell-actions']//button[@class='oxd-icon-button oxd-table-cell-action-space'][2]")
	WebElement DisplayedEmployDeletebtn;
	
	@FindBy(xpath="//button[text()=' Yes, Delete ']")
	WebElement ConfirmDeletBtn;
	
	@FindBy(xpath="//*[text()='No Records Found']")
	WebElement txt_NoRecordsFound;
	
	@FindBy(xpath="//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']")
	WebElement ClickEmpRecord;
	
	@FindBy(xpath="//div[@class='oxd-table-cell oxd-padding-cell'][3]/div")
	WebElement FirstFieldRecord;


	public boolean isEmployeeInfoHeaderDisplayed() {
		try {
			return EmployeeInfoHeader.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void clickAdd() {
		Addbtn.click();
	}

	public boolean isPersonalDetailsHeaderDisplayed() {
		try {
			return PersonalDetailsHeader.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void EnterEmployeeID(String EmployeeID) {
		txt_EmployeeID.click();
		txt_EmployeeID.sendKeys(Keys.CONTROL + "a");
		txt_EmployeeID.sendKeys(Keys.DELETE);
		txt_EmployeeID.sendKeys(EmployeeID);
	}

	public void clickSearchbtn() {
		searchbtn.click();
	}
	

	public void checkEmplyIDDisplayed(String EmployeeID) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    By employeeIDResult = By.xpath(
	            "//div[@class='oxd-table-card']//div[@class='oxd-table-cell oxd-padding-cell'][2]/div[text()='"
	                    + EmployeeID + "']"
	    );

	    wait.until(ExpectedConditions.refreshed(
	            ExpectedConditions.visibilityOfElementLocated(employeeIDResult)
	    ));

	    String displayedEmployID =
	            driver.findElement(employeeIDResult).getText().trim();

	    System.out.println("Expected Employee ID = " + EmployeeID);
	    System.out.println("Displayed Employee ID = " + displayedEmployID);

	    Assert.assertEquals(
	            displayedEmployID,
	            EmployeeID,
	            "Employee ID is not matching");
	}
	
	public void SelectCheckBox() {
		DisplayedEmployeeCheckbox.click();
	}
	
	
	public void DeleteEmploy() {
		DisplayedEmployDeletebtn.click();
	}
	
	public void clickconfirmDeletEmploy() {
		ConfirmDeletBtn.click();
	}
	
	public boolean NoRecordsFound() {
		try {
			return txt_NoRecordsFound.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	
	public void clickEmpRecord() {
		ClickEmpRecord.click();
	}
	
	public void checkEmployeeFirstNameDisplayed(String employeeId, String employeeFirstName) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    By tableBody = By.xpath("//div[@class='oxd-table-body']");

	    wait.until(ExpectedConditions.refreshed(
	            ExpectedConditions.visibilityOfElementLocated(tableBody)
	    ));

	    wait.until(ExpectedConditions.textToBePresentInElementLocated(tableBody, employeeId));

	    wait.until(ExpectedConditions.textToBePresentInElementLocated(tableBody, employeeFirstName));

	    String tableText = driver.findElement(tableBody).getText();

	    System.out.println("Expected Employee ID = " + employeeId);
	    System.out.println("Expected First Name = " + employeeFirstName);
	    System.out.println("Actual Table Text = " + tableText);

	    Assert.assertTrue(tableText.contains(employeeId), "Employee ID is not displayed");
	    Assert.assertTrue(tableText.contains(employeeFirstName), "Updated first name is not displayed");
	}
	
	
	
}
