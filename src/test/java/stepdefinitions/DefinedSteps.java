package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import pages.CartPage;
import pages.HomePage;
import pages.OrderPage;
import pages.ProductPage;
import utils.BrowserFactory;

public class DefinedSteps extends Base {

//    @Before
//    public void setup() {
//        browserFactory = new BrowserFactory();
//        browserFactory.startBrowser("chrome", "https://www.demoblaze.com/index.html");
//        homePage = new HomePage(browserFactory.getDriver());
//        productPage = new ProductPage(browserFactory.getDriver());
//        cartPage = new CartPage(browserFactory.getDriver());
//        orderPage = new OrderPage(browserFactory.getDriver());
//    }

// @Given("I launch the Demoblaze application")
// public void i_launch_the_demoblaze_application() {
//       browserFactory.getDriver().get("https://www.demoblaze.com/index.html");
//   }

    @Given("I verify that I am in the product store")
    public void i_verify_that_i_am_in_the_product_store() {
        Assert.assertTrue(homePage.isProductStoreTitleDisplayed(), "Product store title not displayed.");
        takeScreenshot("Product Store Page");
    }

    @When("I click Laptops under categories")
    public void i_click_laptops_under_categories() {
        homePage.clickLaptopsCategory();
    }

    @When("I click on {string} laptop")
    public void i_click_on_laptop(String laptopName) {
        productPage.selectFirstLaptop();
        takeScreenshot("Selected Laptop: " + laptopName);
    }

    @When("I add the laptop to cart")
    public void i_add_the_laptop_to_cart() {
        productPage.addToCart();
    }

    @Then("I verify the popup message {string} and click OK")
    public void i_verify_the_popup_message_and_click_ok(String expectedMessage) {
        String actualMessage = productPage.getPopupMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "Popup message mismatch.");
        productPage.acceptPopup();
        takeScreenshot("Product Added Popup");
    }

    @When("I navigate to Cart")
    public void i_navigate_to_cart() {
        cartPage.goToCart();
    }

    @Then("I verify the added laptop {string} is available")
    public void i_verify_the_added_laptop_is_available(String laptopName) {
        Assert.assertTrue(cartPage.isLaptopInCart(laptopName), laptopName + " not found in cart.");
        takeScreenshot("Cart with Laptop");
    }

    @When("I place an order")
    public void i_place_an_order() {
        cartPage.clickPlaceOrder();
    }

    @When("I click Purchase without filling information")
    public void i_click_purchase_without_filling_information() {
        orderPage.clickPurchase();
    }

    @Then("I verify the error message returned")
    public void i_verify_the_error_message_returned() {
        String errorMessage = orderPage.getErrorMessage();
        Assert.assertFalse(errorMessage.isEmpty(), "Error message was empty.");
        takeScreenshot("Error Message Popup");
    }

    @When("I complete the Place order screen with the following details:")
    public void i_complete_the_place_order_screen_with_the_following_details(io.cucumber.datatable.DataTable dataTable) {
        java.util.Map<String, String> data = dataTable.asMap(String.class, String.class);
        orderPage.fillOrderDetails(
                data.get("Name"),
                data.get("Country"),
                data.get("City"),
                data.get("CreditCard"),
                data.get("Month"),
                data.get("Year")
        );
    }

    @When("I click Purchase to confirm order")
    public void i_click_purchase_to_confirm_order() {
        orderPage.clickPurchase();
    }

    @Then("I verify that the order was successfully purchased")
    public void i_verify_that_the_order_was_successfully_purchased() {
        String confirmationMessage = orderPage.getPurchaseConfirmationMessage();
        Assert.assertTrue(confirmationMessage.contains("Thank you for your purchase!"), "Order confirmation message not found.");
        takeScreenshot("Purchase Confirmation");
    }

    @AfterStep
    public void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            // If scenario fails, take a screenshot
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed Screenshot");
        }
        if (driver != null) {
            driver.quit();
        }

    }
}