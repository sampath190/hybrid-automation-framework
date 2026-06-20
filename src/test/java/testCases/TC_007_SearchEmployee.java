package testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EmployeeListPage;
import pageObjects.OrangeHrmMainPage;
import testBase.BaseClass;
import utilities.TestDataStore;

public class TC_007_SearchEmployee extends BaseClass {

    @Test(
        groups = {"sanity", "regression", "TC_007_SearchEmployee"},
        dependsOnGroups = "TC_006_AddEmployee"
    )
    public void SearchEmployeeName() throws InterruptedException {

        logger.info("Employee Search Test Started");

        loginToApplication();

        OrangeHrmMainPage op = new OrangeHrmMainPage(driver);

        logger.info("Clicking on PIM button");
        op.clickPIMbtn();

        EmployeeListPage ep = new EmployeeListPage(driver);

        logger.info("Validating Employee List Page");
        Assert.assertTrue(
                ep.isEmployeeInfoHeaderDisplayed(),
                "Not navigated to Employee List page");

        String employeeID = TestDataStore.empId;

        logger.info("Searching Employee ID : " + employeeID);

        ep.EnterEmployeeID(employeeID);

        ep.clickSearchbtn();
        ep.checkEmplyIDDisplayed(employeeID);
        
        

    }
}