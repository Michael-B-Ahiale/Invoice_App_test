package crud;

import base.BaseTests;
import base.Pages.Page_CreateInvoice;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateInvoiceTest extends BaseTests {

    @Test
    public void testCreateInvoice() {
        Page_CreateInvoice createInvoicePage = mainPage.clickAddInvoiceButton();

        createInvoicePage
                .fillBillFrom("123 Sender St", "Sender City", "12345", "Sender Country")
                .fillBillTo("John Doe", "john@example.com", "456 Client St", "Client City", "67890", "Client Country")
                .fillInvoiceDetails("9/13/2024", "Test Invoice")
                .addNewItem();

        mainPage = createInvoicePage.saveChanges();

        // Assert that the new invoice exists on the main page
        Assert.assertTrue(mainPage.isInvoiceItemsPresent(), "No invoice items are present on the page");


        Assert.assertTrue(mainPage.isInvoiceIdPresent("John Doe"), "The newly created invoice for John Doe is not present");
    }
}