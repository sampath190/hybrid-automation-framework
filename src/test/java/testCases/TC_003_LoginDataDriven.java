package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashBoardPage;
import pageObjects.orangehrmLoginpage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDriven extends BaseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups={"regression","TC_003_LoginDataDriven"})
    public void loginDataDriven(String username, String password, String expected) {

        logger.info("Data Driven Login Test Started");

        orangehrmLoginpage lp = new orangehrmLoginpage(driver);

        logger.info("Entering Username: " + username);
        lp.enterUserName(username);

        logger.info("Entering Password");
        lp.enterPassword(password);

        logger.info("Clicking Login Button");
        lp.clickLogin();

        DashBoardPage dp = new DashBoardPage(driver);

        boolean loginStatus = dp.isDashboardDisplayed();

        if (expected.equalsIgnoreCase("valid")) {

            Assert.assertTrue(loginStatus, "Valid login failed");

        } else if (expected.equalsIgnoreCase("invalid")) {

            Assert.assertFalse(loginStatus, "Invalid login passed unexpectedly");

        } else {

            Assert.fail("Invalid expected value in Excel: " + expected);
        }

        logger.info("Data Driven Login Test Completed");
    }
}