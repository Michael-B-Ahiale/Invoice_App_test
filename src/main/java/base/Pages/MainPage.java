package base.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By addInvoiceButton = By.cssSelector(".btn.icon-btn.btn-blue");
    private By invoiceItems = By.cssSelector(".invoice-card.card");
    private By statusFilter = By.id("paymentTerms");
    private By statusOptions = By.cssSelector(".input-select-options .options mat-checkbox");
    private By invoiceId = By.cssSelector(".invoice__id .id");
    private By invoiceStatus = By.cssSelector(".invoice__status .card-btn");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public Page_CreateInvoice clickAddInvoiceButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addInvoiceButton)).click();
        return new Page_CreateInvoice(driver);
    }

    public Page_ViewInvoice clickInvoiceItem(int index) {
        List<WebElement> items = driver.findElements(invoiceItems);
        if (index >= 0 && index < items.size()) {
            items.get(index).click();
            return new Page_ViewInvoice(driver);
        } else {
            throw new IndexOutOfBoundsException("Invalid invoice index");
        }
    }

    public void hoverStatus() {
        WebElement statusElement = driver.findElement(statusFilter);
        new Actions(driver).moveToElement(statusElement).perform();
    }

    public void selectStatus(String status) {
        hoverStatus();
        wait.until(ExpectedConditions.visibilityOfElementLocated(statusOptions));
        List<WebElement> options = driver.findElements(statusOptions);

        // Deselect all statuses first
        for (WebElement option : options) {
            if (option.isSelected()) {
                option.click();
            }
        }

        // Select the requested status
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(status)) {
                option.click();
                break;
            }
        }
    }

    public boolean isInvoiceIdPresent(String id) {
        List<WebElement> ids = driver.findElements(invoiceId);
        return ids.stream().anyMatch(element -> element.getText().equals(id));
    }

    public void viewInvoice(int index) {
        List<WebElement> items = driver.findElements(invoiceItems);
        if (index >= 0 && index < items.size()) {
            items.get(index).findElement(By.cssSelector(".invoice__right-arrow")).click();
        } else {
            throw new IndexOutOfBoundsException("Invalid invoice index");
        }
    }

    public boolean isInvoiceItemsPresent() {
        return !driver.findElements(invoiceItems).isEmpty();
    }
    public int getInvoiceCount() {
        return driver.findElements(invoiceItems).size();
    }
    public String getInvoiceStatus(int index) {
        List<WebElement> statuses = driver.findElements(invoiceStatus);
        if (index >= 0 && index < statuses.size()) {
            return statuses.get(index).getText().trim();
        } else {
            throw new IndexOutOfBoundsException("Invalid invoice index");
        }
    }
}