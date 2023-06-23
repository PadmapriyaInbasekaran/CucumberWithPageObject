package actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static stepDefinition.BaseTestClass.driver;

public class WaitTime {
    public void implicitWaits() {
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(20));
    }

    public void waitForElementToBeClickable(WebElement element, Duration timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
