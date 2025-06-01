package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;


    @FindBy(xpath = "//button[text()='Place Order']")
    private WebElement placeOrderButton;

    @FindBy(id = "cartur")
    WebElement  cartLink;
// XPath to locate the product name in the cart
    @FindBy(xpath = "//td[2]")
    WebElement productNameInCart;

    //Constructor to initialze the WebDriver
    public CartPage(WebDriver driver) {

        this.driver = driver;
    }

    public void goToCart() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(cartLink));

        driver.findElement((By) cartLink).click();
    }

    public String getCartProductName() {
        return driver.findElement((By) productNameInCart).getText();
    }

    public void clickPlaceOrder() {
    }

    public boolean isProductAddedToCart(String laptopName) {
    }
}
