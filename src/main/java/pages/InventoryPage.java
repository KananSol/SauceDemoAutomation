package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private WebDriver driver;
    private By productsText = By.className("title");
    private By addBackpackButton = By.id("add-to-cart-sauce-labs-backpack");
    private By cartBadge = By.className("shopping_cart_badge");
    private By cartLink = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductsTitle() {
        return driver.findElement(productsText).getText();
    }

    public void addBackpackToCart() {
        driver.findElement(addBackpackButton).click();
    }

    public String getCartItemCount() {
        return driver.findElement(cartBadge).getText();
    }

    public void openCart() {
        driver.findElement(cartLink).click();
    }

}