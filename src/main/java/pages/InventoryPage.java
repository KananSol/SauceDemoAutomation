package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InventoryPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By productsText = By.className("title");
    private By addBackpackButton = By.id("add-to-cart-sauce-labs-backpack");
    private By cartBadge = By.className("shopping_cart_badge");
    private By cartLink = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getProductsTitle() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(productsText)
        ).getText();
    }

    public void addBackpackToCart() {
        wait.until(
                ExpectedConditions.elementToBeClickable(addBackpackButton)
        ).click();
    }

    public String getCartItemCount() {
        wait.until(
                ExpectedConditions.textToBe(cartBadge, "1")
        );

        return driver.findElement(cartBadge).getText();
    }

    public void openCart() {
        wait.until(
                ExpectedConditions.elementToBeClickable(cartLink)
        ).click();
    }


}