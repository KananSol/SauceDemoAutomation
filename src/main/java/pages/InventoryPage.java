package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {

    private By productsText = By.className("title");
    private By addBackpackButton = By.id("add-to-cart-sauce-labs-backpack");
    private By cartBadge = By.className("shopping_cart_badge");
    private By cartLink = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String getProductsTitle() {
        return getText(productsText);
    }

    public void addBackpackToCart() {
        click(addBackpackButton);
    }

    public String getCartItemCount() {
        waitForText(cartBadge, "1");

        return getText(cartBadge);
    }

    public void openCart() {
        click(cartLink);
    }


}