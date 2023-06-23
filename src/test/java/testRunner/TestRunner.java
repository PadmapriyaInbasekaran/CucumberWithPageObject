package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:reports/report.html"},
        monochrome = true,
        features = {"src\\test\\java\\features\\RemoveProductFromCart.feature", "src\\test\\java\\features\\SearchForProducts.feature", "src\\test\\java\\features\\AddToCart.feature", "src\\test\\java\\features\\Login.feature"},
        glue = "stepDefinition",
        dryRun = false
        //  tags = "@Login or @SearchProduct or @AddToCart or @RemoveProduct"

)

public class TestRunner {
}
