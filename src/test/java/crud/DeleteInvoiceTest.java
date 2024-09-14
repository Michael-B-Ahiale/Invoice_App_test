package crud;

import base.BaseTests;
import base.Pages.Page_ViewInvoice;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteInvoiceTest extends BaseTests {

    @Test
    public void deleteInvoice() {
        String invoiceId = mainPage.getInvoiceId(1);
        int initialCount = mainPage.getInvoiceCount();

        Page_ViewInvoice viewInvoicePage = mainPage.clickInvoiceItem(0);
        viewInvoicePage.deleteInvoice();
        Assert.assertEquals(mainPage.getInvoiceCount(), initialCount - 1, "Invoice count did not decrease");
        Assert.assertFalse(mainPage.isInvoiceIdPresent(invoiceId), "Invoice was not deleted");

    }
}
