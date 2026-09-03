package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {

    private WebDriver driver;
    private By overviewTitle = By.className("title");

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getOverviewTitle() {
        return driver.findElement(overviewTitle).getText();
    }
}