package pageObject;

import actions.WaitTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.UtilitiesClass;

import java.time.Duration;
import java.util.Properties;

import static stepDefinition.BaseTestClass.driver;

public class DeliverToIndiaPageObject {
    Properties locationPath = UtilitiesClass.readProperty("src\\test\\java\\utilities\\locators.properties");
    WaitTime waitHelper = new WaitTime();

    public void enterZipcode(String uszipcode) {
        WebElement zipcode = driver.findElement(By.xpath(locationPath.getProperty("pincode_textbox_xpath")));
        zipcode.sendKeys(uszipcode);
        waitHelper.waitForElementToBeClickable(zipcode, Duration.ofDays(30));

    }

    public void clickApply() {

        WebElement apply = driver.findElement(By.xpath(locationPath.getProperty("apply_button_xpath")));
        apply.click();
        waitHelper.waitForElementToBeClickable(apply, Duration.ofDays(30));
    }

    public void clickContinue() {
        WebElement clickContinue = driver.findElement(By.xpath(locationPath.getProperty("continuebutton_xpath")));
        clickContinue.click();
        waitHelper.waitForElementToBeClickable(clickContinue, Duration.ofDays(20));
    }
}
