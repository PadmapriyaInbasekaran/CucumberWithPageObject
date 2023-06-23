package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.UtilitiesClass;

import java.util.Properties;

import static stepDefinition.BaseTestClass.driver;


public class ListAllProductsPageObject {
    Properties locationPath = UtilitiesClass.readProperty("src\\test\\java\\utilities\\locators.properties");

    public String resultPageText() {
        return driver.findElement(By.xpath(locationPath.getProperty("result_text_xpath"))).getText();
    }

    public void clickonProductLink() throws InterruptedException {
        Thread.sleep(3000);
        WebElement productLink = driver.findElement(By.xpath(locationPath.getProperty("mobile_link_xpath")));
        productLink.click();

    }
}
