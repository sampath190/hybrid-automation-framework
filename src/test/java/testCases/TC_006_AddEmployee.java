package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddEmployeePage;
import pageObjects.EmployeeListPage;
import pageObjects.OrangeHrmMainPage;
import testBase.BaseClass;
import utilities.TestDataStore;

public class TC_006_AddEmployee extends BaseClass {

    @Test(groups= {"sanity","regression","TC_006_AddEmployee"})
    public void AddEmployee() {

        logger.info("Adding of employee starts");

        loginToApplication();

        OrangeHrmMainPage op = new OrangeHrmMainPage(driver);

        logger.info("clicking on PIMbtn");
        op.clickPIMbtn();

        EmployeeListPage ep = new EmployeeListPage(driver);

        logger.info("validating navigating to Employeelist page");
        Assert.assertTrue(ep.isEmployeeInfoHeaderDisplayed(), "Not navigated on EmployeeList page");

        logger.info("clicking on add button");
        ep.clickAdd();

        logger.info("Enter Firstname, LastName and EmpID");

        String firstName = RandomStringUtils.secure().nextAlphabetic(5);
        String middleName = RandomStringUtils.secure().nextAlphabetic(5);
        String lastName = RandomStringUtils.secure().nextAlphabetic(5);
        String empId = RandomStringUtils.secure().nextNumeric(5);
        System.out.println(empId);

        TestDataStore.firstName = firstName;
        TestDataStore.middleName = middleName;
        TestDataStore.lastName = lastName;
        TestDataStore.empId = empId;

        AddEmployeePage ap = new AddEmployeePage(driver);

        ap.EnterEmployeeDetails(firstName, middleName, lastName, empId);
        ap.clickSaveBtn();

        Assert.assertTrue(ep.isPersonalDetailsHeaderDisplayed(), "PersonalDetails page is not displayed");

        logger.info("Employee added successfully: " + firstName + " " + lastName);
    }
}