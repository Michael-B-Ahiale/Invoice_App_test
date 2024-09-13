package base.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page_CreateInvoice {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By streetAddressFrom = By.cssSelector("input[formcontrolname='senderStreet']");
    private By cityFrom = By.cssSelector("input[formcontrolname='senderCity']");
    private By countryFrom = By.cssSelector("input[formcontrolname='senderCountry']");
    private By postCodeFrom = By.cssSelector("input[formcontrolname='senderPostCode']");
    private By clientName = By.cssSelector("input[formcontrolname='clientName']");
    private By clientEmail = By.cssSelector("input[formcontrolname='clientEmail']");
    private By streetAddressTo = By.cssSelector("input[formcontrolname='clientStreet']");
    private By cityTo = By.cssSelector("input[formcontrolname='clientCity']");
    private By postCodeTo = By.cssSelector("input[formcontrolname='clientPostCode']");
    private By countryTo = By.cssSelector("input[formcontrolname='clientCountry']");
    private By invoiceDate = By.cssSelector("input.mat-datepicker-input");
    private By paymentTerms = By.id("paymentTerms");
    private By projectDescription = By.cssSelector("input[formcontrolname='description']");
    private By addNewInvoiceButton = By.cssSelector("button.btn-add-new-invoice");
    private By itemName = By.id("itemname0");
    private By itemQuantity = By.cssSelector("input[type='number']");
    private By itemPrice = By.cssSelector("input[type='Number']");
    private By saveChangesButton = By.cssSelector("button.btn-action-save");

    public Page_CreateInvoice(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public void fillBillFromSection(String street, String city, String country, String postCode) {
        driver.findElement(streetAddressFrom).sendKeys(street);
        driver.findElement(cityFrom).sendKeys(city);
        driver.findElement(countryFrom).sendKeys(country);
        driver.findElement(postCodeFrom).sendKeys(postCode);
    }

    public void fillBillToSection(String name, String email, String street, String city, String postCode, String country) {
        driver.findElement(clientName).sendKeys(name);
        driver.findElement(clientEmail).sendKeys(email);
        driver.findElement(streetAddressTo).sendKeys(street);
        driver.findElement(cityTo).sendKeys(city);
        driver.findElement(postCodeTo).sendKeys(postCode);
        driver.findElement(countryTo).sendKeys(country);
    }

    public void setInvoiceDate(String date) {
        driver.findElement(invoiceDate).sendKeys(date);
    }

    public void selectPaymentTerms(String terms) {
        driver.findElement(paymentTerms).click();
        driver.findElement(By.xpath("//li[text()='" + terms + "']")).click();
    }

    public void setProjectDescription(String description) {
        driver.findElement(projectDescription).sendKeys(description);
    }

    public void clickAddNewInvoice() {
        driver.findElement(addNewInvoiceButton).click();
    }

    public void fillItemDetails(String name, String quantity, String price) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemName));
        driver.findElement(itemName).sendKeys(name);
        driver.findElement(itemQuantity).sendKeys(quantity);
        driver.findElement(itemPrice).sendKeys(price);
    }

    public void saveChanges() {
        driver.findElement(saveChangesButton).click();
    }

    public void createInvoice(String streetFrom, String cityFrom, String countryFrom, String postCodeFrom,
                              String clientName, String clientEmail, String streetTo, String cityTo, String postCodeTo, String countryTo,
                              String invoiceDate, String paymentTerms, String projectDescription,
                              String itemName, String itemQuantity, String itemPrice) {
        fillBillFromSection(streetFrom, cityFrom, countryFrom, postCodeFrom);
        fillBillToSection(clientName, clientEmail, streetTo, cityTo, postCodeTo, countryTo);
        setInvoiceDate(invoiceDate);
        selectPaymentTerms(paymentTerms);
        setProjectDescription(projectDescription);
        clickAddNewInvoice();
        fillItemDetails(itemName, itemQuantity, itemPrice);
        saveChanges();
    }
}