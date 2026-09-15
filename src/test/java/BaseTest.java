import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import org.testng.ITestResult;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected InventoryPage inventoryPage;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;
    protected CheckoutOverviewPage checkoutOverviewPage;
    protected CheckoutCompletePage checkoutCompletePage;
    protected ConfigReader config;

    @BeforeMethod
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");

        config = new ConfigReader();
        driver = new ChromeDriver(options);
        driver.get(config.getProperty("baseUrl"));

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }

    protected void loginAsStandardUser() {
        loginPage.login(
                config.getProperty("username"),
                config.getProperty("password")
        );
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {

            System.out.println("Test failed: " + result.getName());

            File screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            File screenshotFolder = new File("screenshots");
            screenshotFolder.mkdirs();

            File destination = new File(
                    screenshotFolder,
                    result.getName() + ".png"
            );
            try {
                Files.copy(
                        screenshot.toPath(),
                        destination.toPath()
                );
            } catch (IOException e) {
                throw new RuntimeException("Screenshot could not be saved", e);
            }
        }

        if (driver != null) {
            driver.quit();
        }
    }
}