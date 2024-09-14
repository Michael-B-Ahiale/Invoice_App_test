package base.Pages;

import base.utilities.InvoiceFormLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page_CreateInvoice {
    private WebDriver driver;
    private WebDriverWait wait;

    public Page_CreateInvoice(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public Page_CreateInvoice fillBillFrom(String street, String city, String postCode, String country) {
        driver.findElement(InvoiceFormLocators.SENDER_STREET).sendKeys(street);
        driver.findElement(InvoiceFormLocators.SENDER_CITY).sendKeys(city);
        driver.findElement(InvoiceFormLocators.SENDER_POST_CODE).sendKeys(postCode);
        driver.findElement(InvoiceFormLocators.SENDER_COUNTRY).sendKeys(country);
        return this;
    }

    public Page_CreateInvoice fillBillTo(String name, String email, String street, String city, String postCode, String country) {
        driver.findElement(InvoiceFormLocators.CLIENT_NAME).sendKeys(name);
        driver.findElement(InvoiceFormLocators.CLIENT_EMAIL).sendKeys(email);
        driver.findElement(InvoiceFormLocators.CLIENT_STREET).sendKeys(street);
        driver.findElement(InvoiceFormLocators.CLIENT_CITY).sendKeys(city);
        driver.findElement(InvoiceFormLocators.CLIENT_POST_CODE).sendKeys(postCode);
        driver.findElement(InvoiceFormLocators.CLIENT_COUNTRY).sendKeys(country);
        return this;
    }

    public Page_CreateInvoice fillInvoiceDetails(String date, String description) {
        driver.findElement(InvoiceFormLocators.INVOICE_DATE).sendKeys(date);
//        driver.findElement(InvoiceFormLocators.PAYMENT_TERMS).sendKeys(paymentTerms);
        driver.findElement(InvoiceFormLocators.DESCRIPTION).sendKeys(description);
        return this;
    }

    public Page_CreateInvoice addNewItem() {
        driver.findElement(InvoiceFormLocators.ADD_NEW_ITEM).click();
        return this;
    }

    public MainPage saveChanges() {
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(InvoiceFormLocators.SAVE_CHANGES));
        saveButton.click();
        return new MainPage(driver);
    }

    public MainPage cancel() {
        driver.findElement(InvoiceFormLocators.CANCEL).click();
        return new MainPage(driver);
    }
}