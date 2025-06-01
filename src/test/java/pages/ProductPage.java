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


    //Constructor to initialze the WebDriver
    public ProductPage(WebDriver driver) {

        this.driver = driver;
    }

    //Method to select the 1st laptop from the product list
    public void selectFirstLaptop() {
        driver.findElements((By) productName).get(0).click();
    }

    //method to get the name of the selected laptop
    public String getSelectedLaptopName() {
        return driver.findElement((By) productName).getText();
    }

    //Method to add the selected laptop to the cart
    public void addToCart() {
        driver.findElement((By) addToCartBtn).click();
    }

    //
    public void acceptPopup() {
    }

    public String getPopupMessage() {
        WebElement popup = driver.findElement(By.cssSelector(".sweet-alert h2"));
        return popup.getText();
    }
}
