package stepDefinition;

import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BaseTestClass {
    public static WebDriver driver;

    @Before
    public static void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take screenshot and embed it in the report
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "FailedTestScreenshot");

            // Save the screenshot to a file
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            String filePath = System.getProperty("user.dir") + "\\screenshots\\" + screenshotName + ".png";
            try {
                Files.write(Paths.get(filePath), screenshot);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Before
    public void cleanUpScreenshots() {
        String screenshotDirectory = System.getProperty("user.dir") + "\\screenshots";
        File directory = new File(screenshotDirectory);
        if (directory.exists() && directory.isDirectory()) {
            File[] screenshots = directory.listFiles();
            if (screenshots != null) {
                for (File screenshot : screenshots) {
                    screenshot.delete();
                }
            }
        }
    }

    @After(order = 1)
    public void teardown() {
        driver.close();
    }
}