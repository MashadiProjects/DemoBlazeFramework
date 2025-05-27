package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;
    By cartLink = By.id("cartur");
    By productNameInCart = By.xpath("//td[2]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToCart() {
        driver.findElement(cartLink).click();
    }

    public String getCartProductName() {
        return driver.findElement(productNameInCart).getText();
    }
}
