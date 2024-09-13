package filter;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterByDraftTest extends BaseTests {

    @Test
    public void testFilterByDraft() {
        mainPage.hoverStatus();
        mainPage.selectStatus("Draft");

        Assert.assertTrue(mainPage.isInvoiceItemsPresent(), "No invoice items are present after filtering");

        int invoiceCount = mainPage.getInvoiceCount();
        for (int i = 0; i < invoiceCount; i++) {
            String status = mainPage.getInvoiceStatus(i);
            Assert.assertEquals(status.toLowerCase(), "draft",
                    "Invoice at index " + i + " is not in Draft status");
        }
    }
}



