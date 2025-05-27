package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    By laptopsCategory = By.linkText("Laptops");
    By storeHeader = By.id("nava");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isStoreDisplayed() {
        return driver.findElement(storeHeader).getText().contains("PRODUCT STORE");
    }

    public void clickLaptopsCategory() {
        driver.findElement(laptopsCategory).click();
    }
}
