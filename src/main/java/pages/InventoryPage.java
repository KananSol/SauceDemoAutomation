package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private WebDriver driver;
    private By productsText = By.className("title");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductsTitle() {
        return driver.findElement(productsText).getText();
    }
}