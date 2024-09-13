package filter;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterByPaidTest extends BaseTests {

    @Test
    public void testFilterByPaid() {
        mainPage.hoverStatus();
        mainPage.selectStatus("Paid");

        Assert.assertTrue(mainPage.isInvoiceItemsPresent(), "No invoice items are present after filtering");

        int invoiceCount = mainPage.getInvoiceCount();
        for (int i = 0; i < invoiceCount; i++) {
            String status = mainPage.getInvoiceStatus(i);
            Assert.assertEquals(status.toLowerCase(), ". paid",
                    "Invoice at index " + i + " is not in Paid status");
        }
    }
}
