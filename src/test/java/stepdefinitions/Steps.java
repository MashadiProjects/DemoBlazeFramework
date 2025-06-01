package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Steps extends Base {

    @Before
    public void setup(Scenario scenario) {
        this.scenario = scenario;
        driver = BrowserFactory.getDriver(); // Your existing browser factory [cite: 1]
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        orderPage = new OrderPage(driver);
    }


    @Given("I launch the Demoblaze application")
    public void i_launch_the_demoblaze_application() {
        // check how to use browser Base class
        driver.get("https://www.demoblaze.com/index.html");
    }
    @Given("I verify that I am in the product store")
    public void i_verify_that_i_am_in_the_product_store() {
        org.testng.Assert.assertTrue(homePage.isProductStoreTitleDisplayed(), "Product store title not displayed.");
        scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png", "Product Store Page");
    }
    @When("I click Laptops under categories")
    public void i_click_laptops_under_categories() {
        homePage.clickLaptopsCategory();
    }
    @When("I click on {string} laptop")
    public void i_click_on_laptop(String string) {
        productPage.selectFirstLaptop(laptopName);
        scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png", "Selected Laptop: " + laptopName);


}
    @When("I add the laptop to cart")
    public void i_add_the_laptop_to_cart() {
        public void iAddTheLaptopToCart() {
            productPage.addToCart(); [cite: 1]
    }


    @Then("I verify the popup message {string} and click OK")
    public void i_verify_the_popup_message_and_click_ok(String string) {
            String actualMessage = productPage.getPopupMessage(); [cite: 1]
            org.testng.Assert.assertEquals(actualMessage, expectedMessage, "Popup message mismatch.");
            productPage.acceptPopup(); [cite: 1]
            scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png", "Product Added Popup");
        }


    @When("I navigate to Cart")
    public void i_navigate_to_cart() {
            cartPage.goToCart(); [cite: 1]
    }


    @Then("I verify the added laptop {string} is available")
    public void i_verify_the_added_laptop_is_available(String laptopName) { {
           org.testng.Assert.assertTrue(cartPage.isProductAddedToCart(laptopName), laptopName + " not found in cart."); [cite: 1]
                scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png", "Cart with Laptop"); [
    }
    @When("I place an order")
    public void i_place_an_order() {
        cartPage.clickPlaceOrder();
    }

    @When("I complete the Place order screen with data from excel for row {int}")
    public void i_complete_the_place_order_screen_with_data_from_excel_for_row(Integer int1) {

    }
    @When("I click Purchase to confirm order")
    public void i_click_purchase_to_confirm_order() {
        orderPage.clickPurchase(); [cite: 1]
    }
    @Then("I verify that the order was successfully purchased")
    public void i_verify_that_the_order_was_successfully_purchased() {
                String confirmationMessage = orderPage.getPurchaseConfirmationMessage(); [cite: 1]
                org.testng.Assert.assertTrue(confirmationMessage.contains("Thank you for your purchase!"), "Order confirmation message not found.");
                scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png", "Purchase Confirmation"); [cite: 1]
                orderPage.clickOkOnConfirmation();
            }

    }



    @AfterStep
    public void addScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
    }

    @After
    public void quitBrowser() {
        driver.quit();
    }
}
}


