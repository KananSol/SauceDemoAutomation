package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {

    private By overviewTitle = By.className("title");
    private By finishButton = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public String getOverviewTitle() {
        return getText(overviewTitle);
    }

    public void clickFinish() {
        click(finishButton);
    }

}