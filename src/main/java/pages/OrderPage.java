package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    WebDriver driver;
    By placeOrderBtn = By.xpath("//button[text()='Place Order']");
    By purchaseBtn = By.xpath("//button[text()='Purchase']");
    By nameInput = By.id("name");
    By countryInput = By.id("country");
    By cityInput = By.id("city");
    By cardInput = By.id("card");
    By monthInput = By.id("month");
    By yearInput = By.id("year");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPlaceOrder() {
        driver.findElement(placeOrderBtn).click();
    }

    public void clickPurchase() {
        driver.findElement(purchaseBtn).click();
    }

    public void fillForm(String name, String country, String city, String card, String month, String year) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(countryInput).sendKeys(country);
        driver.findElement(cityInput).sendKeys(city);
        driver.findElement(cardInput).sendKeys(card);
        driver.findElement(monthInput).sendKeys(month);
        driver.findElement(yearInput).sendKeys(year);
    }
}
