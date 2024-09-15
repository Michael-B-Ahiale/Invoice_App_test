package base.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page_ViewInvoice {
    private WebDriver driver;
    private WebDriverWait wait;
    private By deleteInvoiceButton = By.cssSelector("button.btn-danger");
    private By editInvoiceButton = By.cssSelector("button.btn-edit");


    public Page_ViewInvoice(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void deleteInvoice() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteInvoiceButton)).click();
    }

    public Page_EditInvoice editInvoice(){
        wait.until(ExpectedConditions.elementToBeClickable(editInvoiceButton)).click();
        return new Page_EditInvoice(driver);
    }

    public void markAsPending(){

    }


}
