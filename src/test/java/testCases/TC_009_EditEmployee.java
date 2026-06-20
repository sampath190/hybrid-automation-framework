package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EmployeeListPage;
import pageObjects.OrangeHrmMainPage;
import pageObjects.PersonalDetailsPage;
import testBase.BaseClass;
import utilities.TestDataStore;

public class TC_009_EditEmployee extends BaseClass {

    @Test(
        groups = {"employee", "sanity", "regression", "TC_009_EditEmployee"},
        dependsOnGroups = "TC_006_AddEmployee"
    )
    public void EditEmployeeFirstName() {

        logger.info("Edit Employee Test Started");

        loginToApplication();

        OrangeHrmMainPage op = new OrangeHrmMainPage(driver);

        logger.info("Clicking PIM menu");
        op.clickPIMbtn();

        EmployeeListPage ep = new EmployeeListPage(driver);

        String employeeID = TestDataStore.empId;

        logger.info("Searching Employee ID: " + employeeID);
        ep.EnterEmployeeID(employeeID);
        ep.clickSearchbtn();

        logger.info("Opening employee record");
        ep.clickEmpRecord();

        PersonalDetailsPage pd = new PersonalDetailsPage(driver);

        String firstName = RandomStringUtils.secure().nextAlphabetic(5);
        TestDataStore.firstName = firstName;

        logger.info("Editing First Name to: " + firstName);
        pd.EditFirstName(firstName);

        logger.info("Clicking Save button");
        pd.clickSaveBtn();

        Assert.assertTrue(
                pd.isSuccessMessageDisplayed(),
                "Employee first name was not updated successfully");

        logger.info("Employee updated successfully");

        logger.info("Navigating back to PIM");
        op.clickPIMbtn();

        Assert.assertTrue(
                ep.isEmployeeInfoHeaderDisplayed(),
                "Employee List page is not displayed");

        logger.info("Searching updated employee by ID: " + employeeID);
        ep.EnterEmployeeID(employeeID);
        ep.clickSearchbtn();

        logger.info("Validating updated first name");
        ep.checkEmployeeFirstNameDisplayed(employeeID, firstName);

        logger.info("Edit Employee Test Passed");
    }
}