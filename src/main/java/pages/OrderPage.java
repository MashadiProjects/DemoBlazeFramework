package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage {
    WebDriver driver;
    //Locators for elements in the Order Page
    @FindBy(xpath = "//button[text()='Place Order']")
    WebElement placeOrderBtn;
    @FindBy(xpath = "//button[text()='Purchase']")
    WebElement purchaseBtn;
    @FindBy(id = "name")
    WebElement  nameInput;

    @FindBy(id = "country")
    WebElement  countryInput;
    @FindBy(id = "city")
    WebElement  cityInput;
    @FindBy(id = "card")
    WebElement  cardInput;
    @FindBy(id = "month")
    WebElement  monthInput;
    @FindBy(id = "year")
    WebElement  yearInput;

    @FindBy(xpath = "//div[@class='sweet-alert showSweetAlert visible']//p")
    WebElement purchaseConfirmationMessage;


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPlaceOrder() {
        driver.findElement((By) placeOrderBtn).click();
    }

    public void clickPurchase() {
        driver.findElement((By) purchaseBtn).click();
    }

    public void fillForm(String name, String country, String city, String card, String month, String year) {
        driver.findElement((By) nameInput).sendKeys(name);
        driver.findElement((By) countryInput).sendKeys(country);
        driver.findElement((By) cityInput).sendKeys(city);
        driver.findElement((By) cardInput).sendKeys(card);
        driver.findElement((By) monthInput).sendKeys(month);
        driver.findElement((By) yearInput).sendKeys(year);
    }

    public String getPurchaseConfirmationMessage() {

        return driver.findElement((By) purchaseConfirmationMessage).getText();
    }

    public void clickOkOnConfirmation() {
    }
}
