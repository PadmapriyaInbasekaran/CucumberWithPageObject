package pageObject;

import actions.WaitTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.UtilitiesClass;

import java.time.Duration;
import java.util.Properties;

import static stepDefinition.BaseTestClass.driver;

public class ProductPageObject {
    Properties locationPath = UtilitiesClass.readProperty("src\\test\\java\\utilities\\locators.properties");
    WaitTime waitHelper = new WaitTime();

    public WebElement addToCartButton() {
        WebElement addToCart = driver.findElement(By.xpath(locationPath.getProperty("add_to_cart_xpath")));
        waitHelper.waitForElementToBeClickable(addToCart, Duration.ofDays(20));
        return addToCart;
    }

    public String itemsInTheCart() throws InterruptedException {
        Thread.sleep(4000);
        WebElement cartItems = driver.findElement(By.xpath(locationPath.getProperty("cart_item_xpath")));
        return cartItems.getText();
    }

    public void deliverToIndia() {
        driver.findElement(By.xpath(locationPath.getProperty("location_xpath"))).click();
    }

    public void clickOnCartIcon() {
        driver.findElement(By.xpath(locationPath.getProperty("cart_item_xpath"))).click();
    }
}
