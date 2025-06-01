package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.CartPage;
import pages.HomePage;
import pages.OrderPage;
import pages.ProductPage;
import utils.BrowserFactory;

public class Base {
//To link the browser and page object,add page objects here

    BrowserFactory browserFactory = new BrowserFactory();
    final WebDriver driver = browserFactory.startBrowser("chrome", "https://www.demoblaze.com/index.html");
    /*
    The above parameters are only passed if running  locally.
    When running in a pipeline, the browser and URL will be passed from the pipeline configuration. as parameters */

    //Now create a link between  pages and the browser setup
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
    CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
    OrderPage orderPage = PageFactory.initElements(driver, OrderPage.class);


}




