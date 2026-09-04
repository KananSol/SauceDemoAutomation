import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void addBackpackToCartTest() {

        loginAsStandardUser();

        inventoryPage.addBackpackToCart();

        String actualCartCount = inventoryPage.getCartItemCount();
        String expectedCartCount = "1";

        Assert.assertEquals(actualCartCount, expectedCartCount);
    }

    @Test
    public void verifyBackpackInCartTest() {

        loginAsStandardUser();
        inventoryPage.addBackpackToCart();
        inventoryPage.openCart();
        String actualProductName = cartPage.getProductName();
        String expectedProductName = "Sauce Labs Backpack";
        Assert.assertEquals(actualProductName, expectedProductName);
    }
}
