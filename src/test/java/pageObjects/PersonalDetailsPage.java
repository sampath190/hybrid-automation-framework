package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalDetailsPage extends Basepage {

    public PersonalDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//input[@name='firstName']")
    WebElement txt_firstName;

    @FindBy(xpath="(//div[@id='app']//button[normalize-space()='Save'])[1]")
    WebElement SaveBtn;

    @FindBy(xpath="//div[contains(@class,'oxd-form-loader')]")
    WebElement formLoader;

    @FindBy(xpath="//p[contains(@class,'oxd-text--toast-message')]")
    WebElement successMessage;

    public void EditFirstName(String firstName) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.invisibilityOf(formLoader));
        wait.until(ExpectedConditions.elementToBeClickable(txt_firstName));

        txt_firstName.click();
        txt_firstName.sendKeys(Keys.CONTROL + "a");
        txt_firstName.sendKeys(Keys.DELETE);
        txt_firstName.sendKeys(firstName);
    }

    public void clickSaveBtn() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.elementToBeClickable(SaveBtn));
        SaveBtn.click();
    }

    public boolean isSuccessMessageDisplayed() {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOf(successMessage)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}