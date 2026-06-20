package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashBoardPage;
import pageObjects.orangehrmLoginpage;
import testBase.BaseClass;

public class TC_004_Logout extends BaseClass {

	@Test(groups ={"smoke", "regression","TC_004_Logout"})
	public void TestingLogOut() {
		
		logger.info("Admin Menu Test Started");

        loginToApplication();

        DashBoardPage d = new DashBoardPage(driver);

        logger.info("Verifying Dashboard Page");
        Assert.assertTrue(d.isDashboardDisplayed());
        
        
        logger.info("Clicking on the userdropdown");
        
        d.clickUserdropdown();
        
        logger.info("clicking on logout");
        
        d.clickLogOutBtn();
        
        orangehrmLoginpage op=new orangehrmLoginpage(driver);
        Assert.assertTrue(op.isLoginPageDisplayed(),"Logout failed - Login page is not displayed");
        
        
        
	}

}
