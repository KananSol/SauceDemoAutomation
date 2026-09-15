package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
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

    @Test(dataProvider = "checkoutInvalidData")
    public void negativeCheckoutTest(
            String firstName,
            String lastName,
            String postalCode,
            String expectedErrorMessage) {

        loginAsStandardUser();
        inventoryPage.addBackpackToCart();
        inventoryPage.openCart();
        cartPage.clickCheckout();

        checkoutPage.checkout(firstName, lastName, postalCode);

        String actualErrorMessage = checkoutPage.getErrorMessage();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }


    private void completeCheckoutFlow() {
        loginAsStandardUser();
        inventoryPage.addBackpackToCart();
        inventoryPage.openCart();
        cartPage.clickCheckout();
        checkoutPage.checkout("Kanan", "Soltanli", "AZ1000");

    }

    @DataProvider(name = "checkoutInvalidData")
    public Object[][] checkoutInvalidData() {
        return new Object[][] {
                {"", "Soltanli", "AZ1000", "Error: First Name is required"},
                {"Kanan", "", "AZ1000", "Error: Last Name is required"},
                {"Kanan", "Soltanli", "", "Error: Postal Code is required"}
        };
    }

}
