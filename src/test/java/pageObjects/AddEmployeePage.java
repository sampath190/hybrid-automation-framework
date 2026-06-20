package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEmployeePage extends Basepage{

	public AddEmployeePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='firstName']") WebElement txt_firstName;
	@FindBy(xpath="//input[@name='middleName']") WebElement txt_middleName;
	@FindBy(xpath="//input[@name='lastName']") WebElement txt_lastName;
	@FindBy(xpath="//label[normalize-space()='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')]//input")WebElement txt_EmpID;
	@FindBy(xpath="//button[normalize-space()='Save']")WebElement Savebtn;
	
	public void EnterEmployeeDetails(String firstName,String middleName,String lastName,String EmpId)  {
		txt_firstName.sendKeys(firstName);
		txt_middleName.sendKeys(middleName);
		txt_lastName.sendKeys(lastName);
	
		txt_EmpID.click();
		txt_EmpID.sendKeys(Keys.CONTROL + "a");
		txt_EmpID.sendKeys(Keys.DELETE);
		txt_EmpID.sendKeys(EmpId);
	}
	
	public void clickSaveBtn() {
		Savebtn.click();
	}
	

}
