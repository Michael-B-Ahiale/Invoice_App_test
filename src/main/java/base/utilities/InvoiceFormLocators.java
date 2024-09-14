package base.utilities;



import org.openqa.selenium.By;

public class InvoiceFormLocators {
    // Bill From
    public static final By SENDER_STREET = By.cssSelector("input[formcontrolname='senderStreet']");
    public static final By SENDER_CITY = By.cssSelector("input[formcontrolname='senderCity']");
    public static final By SENDER_POST_CODE = By.cssSelector("input[formcontrolname='senderPostCode']");
    public static final By SENDER_COUNTRY = By.cssSelector("input[formcontrolname='senderCountry']");

    // Bill To
    public static final By CLIENT_NAME = By.cssSelector("input[formcontrolname='clientName']");
    public static final By CLIENT_EMAIL = By.cssSelector("input[formcontrolname='clientEmail']");
    public static final By CLIENT_STREET = By.cssSelector("input[formcontrolname='clientStreet']");
    public static final By CLIENT_CITY = By.cssSelector("input[formcontrolname='clientCity']");
    public static final By CLIENT_POST_CODE = By.cssSelector("input[formcontrolname='clientPostCode']");
    public static final By CLIENT_COUNTRY = By.cssSelector("input[formcontrolname='clientCountry']");

    // Invoice Details
    public static final By INVOICE_DATE = By.cssSelector("input.mat-datepicker-input");
    public static final By PAYMENT_TERMS = By.id("paymentTerms");
    public static final By DESCRIPTION = By.cssSelector("input[formcontrolname='description']");

    // Buttons
    public static final By ADD_NEW_ITEM = By.cssSelector("button.btn-add-new-invoice");
    public static final By SAVE_CHANGES = By.cssSelector("button.btn-action-save");
    public static final By CANCEL = By.cssSelector("button.btn-action-cancel");
}
