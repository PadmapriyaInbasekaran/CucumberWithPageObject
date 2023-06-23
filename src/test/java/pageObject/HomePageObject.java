package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.UtilitiesClass;

import java.util.Properties;

import static stepDefinition.BaseTestClass.driver;

public class HomePageObject {
    Properties locationPath = UtilitiesClass.readProperty("src\\test\\java\\utilities\\locators.properties");

    public void clickOnSignIn() {
        driver.findElement(By.xpath(locationPath.getProperty("signin_xpath"))).click();
    }

    public WebElement findSearchBar() {
        return driver.findElement(By.xpath(locationPath.getProperty("searchbar_xpath")));
    }

    public void clickOnSearch() {
        driver.findElement(By.xpath(locationPath.getProperty("searchicon_xpath"))).click();
    }
}
