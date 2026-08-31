import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import pages.LoginPage;
import pages.InventoryPage;
import pages.CartPage;


public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;


    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
    }


    @Test
    public void validLoginTest() {

        loginPage.login("standard_user", "secret_sauce");
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void invalidLoginTest() {
        loginPage.login("wrong_user", "wrong_password");
        String actualErrorMessage = loginPage.getErrorText();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @Test
    public void inventoryPageTest() {

        loginPage.login("standard_user", "secret_sauce");
        String actualProductsTitle = inventoryPage.getProductsTitle();
        String expectedProductsTitle = "Products";

        Assert.assertEquals(actualProductsTitle, expectedProductsTitle);
    }

    @Test
    public void addBackpackToCartTest() {

        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addBackpackToCart();
        String actualCartCount = inventoryPage.getCartItemCount();
        String expectedCartCount = "1";
        Assert.assertEquals(actualCartCount, expectedCartCount);
    }

    @Test
    public void verifyBackpackInCartTest() {

        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addBackpackToCart();
        inventoryPage.openCart();
        String actualProductName = cartPage.getProductName();
        String expectedProductName = "Sauce Labs Backpack";
        Assert.assertEquals(actualProductName, expectedProductName);
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}