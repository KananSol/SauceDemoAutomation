import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest() {
        loginAsStandardUser();
        inventoryPage.addBackpackToCart();
        inventoryPage.openCart();
        cartPage.clickCheckout();
        checkoutPage.checkout("Kanan", "Soltanli", "AZ1000");
        String actualOverviewTitle = checkoutOverviewPage.getOverviewTitle();
        String expectedOverviewTitle = "Checkout: Overview";
        Assert.assertEquals(actualOverviewTitle, expectedOverviewTitle);
    }

    @Test
    public void checkoutCompletePageTest() {
        loginAsStandardUser();
        inventoryPage.addBackpackToCart();
        inventoryPage.openCart();
        cartPage.clickCheckout();
        checkoutPage.checkout("Kanan", "Soltanli", "AZ1000");
        checkoutOverviewPage.clickFinish();
        String actualCompleteHeaderTitle = checkoutCompletePage.getCompleteMessage();
        String expectedCompleteHeaderTitle = "Thank you for your order!";
        Assert.assertEquals(actualCompleteHeaderTitle, expectedCompleteHeaderTitle);
    }
}
