package base.Pages;

import base.utilities.InvoiceFormLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page_EditInvoice {

    private WebDriver driver;
    private WebDriverWait wait;

    public Page_EditInvoice(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public Page_EditInvoice fillBillFrom(String street, String city, String postCode, String country) {
        driver.findElement(InvoiceFormLocators.SENDER_STREET).sendKeys(street);
        driver.findElement(InvoiceFormLocators.SENDER_CITY).sendKeys(city);
        driver.findElement(InvoiceFormLocators.SENDER_POST_CODE).sendKeys(postCode);
        driver.findElement(InvoiceFormLocators.SENDER_COUNTRY).sendKeys(country);
        return this;
    }
}
