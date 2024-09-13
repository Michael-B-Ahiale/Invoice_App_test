package filter;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterByPendingTest extends BaseTests {

    @Test
    public void testFilterByPending() {
        mainPage.hoverStatus();
        mainPage.selectStatus("Pending");

        Assert.assertTrue(mainPage.isInvoiceItemsPresent(), "No invoice items are present after filtering");

        int invoiceCount = mainPage.getInvoiceCount();
        for (int i = 0; i < invoiceCount; i++) {
            String status = mainPage.getInvoiceStatus(i);
            Assert.assertEquals(status.toLowerCase(), "pending",
                    "Invoice at index " + i + " is not in Pending status");
        }
    }
}
