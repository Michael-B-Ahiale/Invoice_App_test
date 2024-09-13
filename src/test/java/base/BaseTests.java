package base;

import base.Pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTests {

    public  WebDriver driver;
    protected MainPage mainPage;

    @BeforeClass
    public  void setUpBeforeClass() throws Exception {
    System.setProperty("webdriver.chrome.driver",  "resources/chromedriver.exe");
    driver= new ChromeDriver();

    driver.get("https://ngrx-invoice-app.vercel.app/");


        mainPage = new MainPage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
