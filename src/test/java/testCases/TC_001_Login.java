package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashBoardPage;
import testBase.BaseClass;

public class TC_001_Login extends BaseClass {

    @Test(groups ={"smoke", "regression","TC_001_Login"})
    public void login() {

        logger.info("Login Test Started");

        loginToApplication();

        logger.info("Verifying Login Success");

        DashBoardPage dp = new DashBoardPage(driver);

        Assert.assertTrue(dp.isDashboardDisplayed(),"Login failed - Dashboard is not displayed");

        logger.info("Login Test Completed Successfully");
    }

    @Test(groups = "regression")
    public void samplefromLogin() {

        logger.info("Sample Login Test Started");

        Assert.assertTrue(true);

        System.out.println("Inside sample from Login");

        logger.info("Sample Login Test Completed");
    }
}
