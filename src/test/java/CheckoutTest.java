import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest() {
        completeCheckoutFlow();
        String actualOverviewTitle = checkoutOverviewPage.getOverviewTitle();
        String expectedOverviewTitle = "Checkout: Overview";
        Assert.assertEquals(actualOverviewTitle, expectedOverviewTitle);
    }

    @Test
    public void checkoutCompletePageTest() {
        completeCheckoutFlow();
        checkoutOverviewPage.clickFinish();
        String actualCompleteHeaderTitle = checkoutCompletePage.getCompleteMessage();
        String expectedCompleteHeaderTitle = "Thank you for your order!";
        Assert.assertEquals(actualCompleteHeaderTitle, expectedCompleteHeaderTitle);
    }

    private void completeCheckoutFlow() {
        loginAsStandardUser();
        inventoryPage.addBackpackToCart();
        inventoryPage.openCart();
        cartPage.clickCheckout();
        checkoutPage.checkout("Kanan", "Soltanli", "AZ1000");
    }


}
