package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.CartPage;
import pages.HomePage;
import pages.OrderPage;
import pages.ProductPage;
import utils.BrowserFactory;

public class Base {

    //add page objects here

    BrowserFactory browserFactory = new BrowserFactory();
    final WebDriver driver = browserFactory.startBrowser("chrome", "https://www.demoblaze.com/index.html");
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
    CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
    OrderPage orderPage = PageFactory.initElements(driver, OrderPage.class);


}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // You can make this configurable
    }

    // Common methods like taking screenshots, explicit waits can go here
    public void takeScreenshot(String screenshotName) {
        // Implement screenshot logic here (e.g., using TakesScreenshot interface) [cite: 1]
    }
}


