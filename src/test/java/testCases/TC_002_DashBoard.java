package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashBoardPage;
import testBase.BaseClass;

public class TC_002_DashBoard extends BaseClass {

    @Test(groups = {"smoke","sanity","regression","TC_002_DashBoard"})
    public void clickonAdmin() {

        logger.info("Admin Menu Test Started");

        loginToApplication();

        DashBoardPage d = new DashBoardPage(driver);

        logger.info("Verifying Dashboard Page");
        Assert.assertTrue(d.isDashboardDisplayed(),"dashboardpage not displayed");


    }

    @Test(priority = 2, groups = "sanity")
    public void samplefromDashboard() {

        logger.info("Sample Dashboard Test Started");

        loginToApplication();

        System.out.println("Inside sample from dashboard");

    }
}