package crud;

import base.BaseTests;
import base.Pages.Page_CreateInvoice;
import base.Pages.Page_EditInvoice;
import base.Pages.Page_ViewInvoice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class EditInvoiceTest extends BaseTests {

    @Test
    public void testEditInvoice() {

        By backButton=By.cssSelector(".back-btn");
        By saveButton=By.cssSelector(".btn-action-save");
        String invoiceId = mainPage.getInvoiceId(1);

        Page_ViewInvoice viewInvoicePage = mainPage.clickInvoiceItem(0);
        Page_EditInvoice editInvoice = viewInvoicePage.editInvoice();
        editInvoice.fillBillFrom("123 Sender St", "Sender City", "12345", "Sender Country");

        driver.findElement(saveButton).click();
        driver.findElement(backButton).click();
        mainPage.clickInvoiceItem(0);


        List<WebElement> elementsWithText = driver.findElements(By.xpath("//p[contains(@class, 'text-secondary-200') and contains(text(), 'Sender City')]"));


        Assert.assertTrue(elementsWithText.size() > 0, "The text 'Sender City' was not found in any of the elements.");
    }
}
