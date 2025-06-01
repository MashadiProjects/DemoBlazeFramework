package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    WebDriver driver;

    @FindBy(linkText = "Laptops")
    WebElement laptopsCategory;
    @FindBy(id = "nava")
    WebElement storeHeader;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isStoreDisplayed() {
        return driver.findElement((By) storeHeader).getText().contains("PRODUCT STORE");
    }

    public void clickLaptopsCategory() {
        driver.findElement((By) laptopsCategory).click();
    }

    public boolean isProductStoreTitleDisplayed() {
        return driver.findElement((By) storeHeader).getText().contains("PRODUCT STORE");
    }
}
