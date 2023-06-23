package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pageObject.*;

import static stepDefinition.BaseTestClass.driver;

public class StepDefinitionFile {
    static Logger logger = Logger.getLogger(LoginPageObject.class);
    LoginPageObject loginPage = new LoginPageObject();
    HomePageObject homePage = new HomePageObject();
    ListAllProductsPageObject listAllProductsPage = new ListAllProductsPageObject();
    ProductPageObject productPage = new ProductPageObject();
    DeliverToIndiaPageObject deliverToIndia = new DeliverToIndiaPageObject();
    CartPageObject cartPage = new CartPageObject();
    WebElement searchBar;
    WebElement cartButton;
    static {
        PropertyConfigurator.configure("C:\\Users\\Padmapriya.I\\IdeaProjects\\BDD-POM\\src\\test\\java\\utilities\\log4j.properties");
    }

    @Given(": Open amazon.com")
    public void _open_amazoncom() {
        logger.info("Login to amazon");
        loginPage.loginToAmazon();
        logger.info("Get the current url");
        String amazonUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.amazon.com/", amazonUrl);
        logger.info("Maximize the window");
        driver.manage().window().maximize();
    }


    @When("^: Enter (.+) and click login$")
    public void _enter_and_click_login(String mobileNumber) {
        logger.info("click on sign in");
        homePage.clickOnSignIn();
        logger.info("Enter mobile number");
        loginPage.enterMobileNumber(mobileNumber);
        logger.info("click continue");
        loginPage.clickContinue();
    }

    @And("^: Incorrect phone number message should be visible$")
    public void _incorrect_phone_number_message_should_be_visible() {
        logger.info("Verify incorrect mobile number message");
        loginPage.incorrectMobileNumberMessage();
        logger.info("Click on Amazon logo");
        loginPage.clickOnAmazonLogo();
    }

    @When("^: Locate the searchbar$")
    public void locate_the_searchbar() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2500)", "");
        logger.info("Find the searchbar");
        searchBar = homePage.findSearchBar();
    }

    @And("^: Enter required mobile name in the searchbar$")
    public void enter_required_mobile_name_in_the_searchbar()
    {
        logger.info("Enter redmi in the search bar");
        this.searchBar.sendKeys("redmi");
    }

    @Then("^: Results page should be displayed$")
    public void results_page_should_be_displayed() {
        logger.info(("Result text should be visible"));
        Assert.assertEquals(listAllProductsPage.resultPageText(), "Results");
    }

    @And("^: click on search$")
    public void click_on_search() {
        logger.info("click on search");
        homePage.clickOnSearch();
    }

    @When("^: click on link$")
    public void _click_on_link() throws InterruptedException {
        logger.info("Click on link");
        listAllProductsPage.clickonProductLink();
    }

    @When("^: Find add to cart button$")
    public void _find_add_to_cart_button() {
        logger.info("Find add to cart button");
        cartButton = productPage.addToCartButton();
    }

    @Then("^: Verify item added to cart$")
    public void _verify_item_added_to_cart() throws InterruptedException {
        logger.info("Verify item added to cart");
        String cart_items = productPage.itemsInTheCart();
        Assert.assertEquals("1", cart_items);
    }

    @And("^: click$")
    public void _click()
    {
        logger.info("click");
        cartButton.click();
    }

    @And("^: click on deliver to India$")
    public void _click_on_deliver_to_india() throws InterruptedException {
        Thread.sleep(3000);
        logger.info("CLick deliver to India");
        productPage.deliverToIndia();
    }

    @And("^: Enter (.+) in the textBox$")
    public void _enter_in_the_textBox(String uszipcode) {
        logger.info("Enter pincode in the textbox");
        deliverToIndia.enterZipcode(uszipcode);
    }

    @And("^: Click Apply$")
    public void _click_Apply() {
        logger.info("Click Apply");
        deliverToIndia.clickApply();
    }

    @And("^: click continue$")
    public void _click_continue() {
        logger.info("Click continue");
        deliverToIndia.clickContinue();
    }

    @Given("^: click on the cart icon$")
    public void _click_on_the_cart_icon() {
        logger.info("Click on the cart icon");
        productPage.clickOnCartIcon();
    }

    @When("^: click delete under the product$")
    public void _click_delete_under_the_product()
    {
        logger.info("Click delete");
        cartPage.deleteProduct();
    }

    @Then("^: Verify item removed from cart$")
    public void _verify_item_removed_from_cart() throws InterruptedException {
        logger.info("Verify item removed from the cart");
        String cart_items = productPage.itemsInTheCart();
        Assert.assertEquals("0", cart_items);
    }

    @And("^: click on No thanks$")
    public void _click_on_no_thanks() {
        logger.info("Click No thanks");
        cartPage.clickNoThanks();

    }

}