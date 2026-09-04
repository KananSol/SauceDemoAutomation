import org.testng.Assert;
import org.testng.annotations.Test;


public class InventoryTest extends BaseTest {

    @Test
    public void inventoryPageTest() {

        loginAsStandardUser();

        String actualProductsTitle = inventoryPage.getProductsTitle();
        String expectedProductsTitle = "Products";

        Assert.assertEquals(actualProductsTitle, expectedProductsTitle);
    }
}
