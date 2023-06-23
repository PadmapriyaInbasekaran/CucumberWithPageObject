package pageObject;

import actions.WaitTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.UtilitiesClass;

import java.time.Duration;
import java.util.Properties;

import static stepDefinition.BaseTestClass.driver;

public class CartPageObject {
    Properties locationPath = UtilitiesClass.readProperty("src\\test\\java\\utilities\\locators.properties");
    WaitTime waitHelper = new WaitTime();

    public void deleteProduct() {
        driver.findElement(By.xpath(locationPath.getProperty("delete_item_xpath"))).click();
    }

    public void clickNoThanks() {
        WebElement clickNoThanks = driver.findElement(By.xpath(locationPath.getProperty("no_thanks_xpath")));
        clickNoThanks.click();
        waitHelper.waitForElementToBeClickable(clickNoThanks, Duration.ofDays(20));
    }

}
