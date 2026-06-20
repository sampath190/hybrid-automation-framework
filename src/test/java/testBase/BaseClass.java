package testBase;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pageObjects.orangehrmLoginpage;
import utilities.ConfigReader;

public class BaseClass {

    public static WebDriver driver;
    public static Logger logger;
    public ConfigReader config;

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setUp(String browser) {

        config = new ConfigReader();
        logger = LogManager.getLogger(this.getClass());

        logger.info("Browser received from testng.xml: " + browser);

        if (browser.equalsIgnoreCase("chrome")) {

            logger.info("Launching Chrome Browser");
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("edge")) {

            logger.info("Launching Edge Browser");
            driver = new EdgeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {

            logger.info("Launching Firefox Browser");
            driver = new FirefoxDriver();

        } else {

            logger.error("Invalid Browser Name: " + browser);
            throw new RuntimeException("Invalid Browser Name: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(config.getAppURL());

        logger.info("Application Opened Successfully");
    }

    public void loginToApplication() {

        orangehrmLoginpage loginPage = new orangehrmLoginpage(driver);

        logger.info("Entering Username");
        System.out.println("Username from config = " + config.getUsername());
        loginPage.enterUserName(config.getUsername());

        logger.info("Entering Password");
        System.out.println("Password from config = " + config.getPassword());
        loginPage.enterPassword(config.getPassword());

        logger.info("Clicking Login Button");
        loginPage.clickLogin();

        logger.info("Login Successful");
        
        loginPage.handleAlertIfPresent();
        
        
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {

        logger.info("Closing Browser");

        if (driver != null) {
            driver.quit();
        }
    }
}