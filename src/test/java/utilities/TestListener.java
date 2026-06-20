package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import testBase.BaseClass;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");
    }

    public void onTestFailure(ITestResult result) {

    	test.fail(result.getThrowable());

        try {
            if (BaseClass.driver != null) {

                String screenshotPath =
                        ScreenshotUtil.captureScreenshot(
                                BaseClass.driver,
                                result.getMethod().getMethodName());

                test.addScreenCaptureFromPath(screenshotPath);

            } else {
                test.fail("Screenshot not captured because WebDriver is null");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {

    	if (test == null) {
            test = extent.createTest(result.getMethod().getMethodName());
        }

        test.skip("Test Skipped");
    }

    public void onFinish(ITestContext context) {

        extent.flush();
    }
}