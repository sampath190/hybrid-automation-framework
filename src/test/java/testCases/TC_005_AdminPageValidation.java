package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AdminPage;
import pageObjects.OrangeHrmMainPage;
import testBase.BaseClass;

public class TC_005_AdminPageValidation extends BaseClass {
	
	@Test(groups= {"smoke","sanity","regression","TC_005_AdminPageValidation"})
	public void checkAdminPageval() {
		
		logger.info("Admin Page Validation Test Started");
		loginToApplication();
		
		logger.info("Clicking Admin Menu");
		OrangeHrmMainPage op=new OrangeHrmMainPage(driver);
		
		op.clickAdminbtn();
		
		AdminPage ap=new AdminPage(driver);
		
		logger.info("Verifying Admin Page");
		
		
		Assert.assertTrue(ap.isAdminHeaderDisplayed(),"AdminPage Not displayed");
		
		logger.info("Adminpage validation passed");
		
		
	}

}
