package pageObject;

import actions.WaitTime;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.UtilitiesClass;
import java.util.Properties;
import static stepDefinition.BaseTestClass.driver;

public class LoginPageObject {

    Properties locationPath = UtilitiesClass.readProperty("src\\test\\java\\utilities\\locators.properties");
    WaitTime waitHelper = new WaitTime();

    public void loginToAmazon() {
        waitHelper.implicitWaits();
        driver.get(locationPath.getProperty("amazon_url"));

    }

    public void enterMobileNumber(String mobileNumber) {
        driver.findElement(By.xpath(locationPath.getProperty("enter_mobile_number_xpath"))).sendKeys(mobileNumber);
    }

    public void clickContinue() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath(locationPath.getProperty("continue_button_xpath")));
        jsExecutor.executeScript("arguments[0].click();", element);
        //driver.findElement(By.xpath(locationPath.getProperty("continue_button_xpath"))).click();
    }

    public void incorrectMobileNumberMessage() {
        driver.findElement(By.xpath(locationPath.getProperty("incorrect_phone_number_xpath"))).getText();
    }

    public void clickOnAmazonLogo() {
        driver.findElement(By.xpath(locationPath.getProperty("amazon_logo_xpath"))).click();
    }
}
