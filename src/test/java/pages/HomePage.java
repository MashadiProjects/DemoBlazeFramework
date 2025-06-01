package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;

    @FindBy(linkText = "Laptops")
    WebElement laptopsCategory;
    @FindBy(id = "nava")
    WebElement storeHeader;

    //Constructor to initialze the WebDriver
    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    public boolean isStoreDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(storeHeader));

        return driver.findElement((By) storeHeader).getText().contains("PRODUCT STORE");
    }

    public void clickLaptopsCategory() {

        driver.findElement((By) laptopsCategory).click();
    }

    public boolean isProductStoreTitleDisplayed() {
        return driver.findElement((By) storeHeader).getText().contains("PRODUCT STORE");
    }
}
