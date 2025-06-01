package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {
    WebDriver driver;

    @FindBy(css = ".hrefch")
    WebElement productName;

   @FindBy(linkText = "Add to cart")
   WebElement addToCartBtn;



    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFirstLaptop() {
        driver.findElements((By) productName).get(0).click();
    }

    public void addToCart() {
        driver.findElement((By) addToCartBtn).click();
    }

    public void acceptPopup() {
    }

    public String getPopupMessage() {
        WebElement popup = driver.findElement(By.cssSelector(".sweet-alert h2"));
        return popup.getText();
    }
}
