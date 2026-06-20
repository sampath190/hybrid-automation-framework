package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            String timeStamp =
                    new SimpleDateFormat("yyyyMMdd_HHmmss")
                            .format(new Date());

            String reportFolder =
                    System.getProperty("user.dir") + "/Reports/";

            File folder = new File(reportFolder);

            if (!folder.exists()) {
                folder.mkdirs();
            }

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(
                            reportFolder + "OrangeHRM_" + timeStamp + ".html");

            spark.config().setReportName("OrangeHRM Automation Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Application", "OrangeHRM");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Tester", "Sampath");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        }

        return extent;
    }
}