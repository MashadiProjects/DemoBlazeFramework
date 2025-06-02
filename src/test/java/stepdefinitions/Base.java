package stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.CartPage;
import pages.HomePage;
import pages.OrderPage;
import pages.ProductPage;
import utils.BrowserFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Base {

//    protected HomePage homePage;
//    protected ProductPage productPage;
//    protected CartPage cartPage;
//    protected OrderPage orderPage;

    BrowserFactory browserFactory = new BrowserFactory();
    final WebDriver driver = browserFactory.startBrowser("chrome", "https://www.demoblaze.com/index.html");
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
    CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
    OrderPage orderPage = PageFactory.initElements(driver, OrderPage.class);




    // Method to take a screenshot and save it locally
//    public void takeScreenshot(String screenshotName) {
//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        try {
//            Files.copy(screenshot.toPath(), new File("screenshots/" + screenshotName + ".png").toPath());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
