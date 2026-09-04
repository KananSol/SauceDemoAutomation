import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        loginAsStandardUser();
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
}