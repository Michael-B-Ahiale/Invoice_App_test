package crud;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReadInvoiceTest extends BaseTests {

    @Test
    public void testInvoiceExists() {
        Assert.assertTrue(mainPage.isInvoiceItemsPresent(), "No invoice items are present on the page");
    }

    @Test
    public void testSpecificInvoiceExists() {
        String expectedInvoiceId = "RT3080"; // You can change this to any invoice ID you expect to exist
        Assert.assertTrue(mainPage.isInvoiceIdPresent(expectedInvoiceId),
                "Invoice with ID " + expectedInvoiceId + " is not present on the page");
    }

    @Test
    public void testViewInvoice() {
        int invoiceIndex = 0; // View the first invoice
        mainPage.viewInvoice(invoiceIndex);

    }
}