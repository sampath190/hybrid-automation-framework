package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {

        String timeStamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss")
                        .format(new Date());

        String screenshotFolder =
                System.getProperty("user.dir")
                + "/Reports/screenshots/";

        String fileName =
                testName + "_"
                + timeStamp
                + ".png";

        String fullPath =
                screenshotFolder + fileName;

        try {

            File folder = new File(screenshotFolder);

            if (!folder.exists()) {
                folder.mkdirs();
            }

            File src =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(src, new File(fullPath));

            System.out.println("Screenshot saved at : " + fullPath);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return fullPath;
    }
}