package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EmployeeListPage;
import pageObjects.OrangeHrmMainPage;
import testBase.BaseClass;
import utilities.TestDataStore;

public class TC_008_DeleteEmployee extends BaseClass {
	
	@Test(groups="TC_008_DeleteEmployee")
	public void verifyDeleteEmployee() throws InterruptedException {

	    logger.info("Delete Employee Test Started");

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

	    logger.info("Searching Employee ID: " + employeeID);

	    ep.EnterEmployeeID(employeeID);

	    logger.info("Clicking Search button");
	    ep.clickSearchbtn();

	    logger.info("Validating searched employee is displayed");
	    ep.checkEmplyIDDisplayed(employeeID);

	    logger.info("Selecting employee checkbox");
	    ep.SelectCheckBox();

	    logger.info("Clicking Delete button");
	    ep.DeleteEmploy();

	    logger.info("Confirming employee deletion");
	    ep.clickconfirmDeletEmploy();

	    logger.info("Searching deleted employee again");
	    ep.EnterEmployeeID(employeeID);

	    logger.info("Verifying No Records Found message");
	    Assert.assertTrue(
	            ep.NoRecordsFound(),
	            "Record is not deleted");

	    logger.info("Employee deleted successfully");

	}
	}
