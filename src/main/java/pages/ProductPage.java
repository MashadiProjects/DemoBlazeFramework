package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;
    By productName = By.cssSelector(".hrefch");
    By addToCartBtn = By.linkText("Add to cart");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFirstLaptop() {
        driver.findElements(productName).get(0).click();
    }

    public void addToCart() {
        driver.findElement(addToCartBtn).click();
    }
}
