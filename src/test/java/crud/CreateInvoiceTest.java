//package crud;
//
//import base.Pages.MainPage;
//import base.Pages.Page_CreateInvoice;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//
//public class CreateInvoiceTest {
//
//    private WebDriver driver;
//    private MainPage mainPage;
//    private Page_CreateInvoice createInvoicePage;
//
//    @BeforeClass
//    public void setUpBeforeClass() throws Exception {
//        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://ngrx-invoice-app.vercel.app/");
//        mainPage = new MainPage(driver);
//        createInvoicePage = new Page_CreateInvoice(driver);
//    }
//
//    @Test
//    public void testCreateInvoice() {
//        // Click on "New Invoice" button
//        mainPage.clickNewInvoice();
//
//        // Generate a unique client name and invoice amount
//        String clientName = "Test Client " + System.currentTimeMillis();
//        String invoiceAmount = "1000.00";
//
//        // Get today's date in the required format
//        LocalDate today = LocalDate.now();
//        String invoiceDate = today.format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
//
//        // Fill in the invoice details
//        createInvoicePage.createInvoice(
//                "123 Sender St", "Sender City", "Sender Country", "12345",
//                clientName, "client@email.com", "456 Client St", "Client City", "54321", "Client Country",
//                invoiceDate, "Net 30 Days", "Test Project",
//                "Test Item", "1", invoiceAmount
//        );
//
////        // Click the back button
////        createInvoicePage.clickBackButton();
////
////        // Verify the invoice details on the main page
////        Assert.assertTrue(mainPage.isInvoicePresent(clientName), "Invoice with client name " + clientName + " not found on main page");
////        Assert.assertTrue(mainPage.isInvoiceDatePresent(invoiceDate), "Invoice with date " + invoiceDate + " not found on main page");
////        Assert.assertTrue(mainPage.isInvoiceAmountPresent("£" + invoiceAmount), "Invoice with amount £" + invoiceAmount + " not found on main page");
////    }
//
////    @AfterClass
////    public void tearDown() {
////        if (driver != null) {
////            driver.quit();
////        }
////    }
//}}