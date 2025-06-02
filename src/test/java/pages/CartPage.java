package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;

    @FindBy(xpath = "//button[text()='Place Order']")
     WebElement placeOrderButton;

    @FindBy(id = "cartur")
    WebElement cartLink;

    @FindBy(xpath = "//td[2]")
    WebElement productNameInCart;

    // Constructor to initialize the WebDriver
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToCart() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(cartLink));
        cartLink.click();
    }

    public String getCartProductName() {
        return productNameInCart.getText();
    }

    public void clickPlaceOrder() {
        placeOrderButton.click();
    }

    public boolean isLaptopInCart(String laptopName) {
        String cartProductName = getCartProductName();
        return cartProductName.equalsIgnoreCase(laptopName);
    }
}