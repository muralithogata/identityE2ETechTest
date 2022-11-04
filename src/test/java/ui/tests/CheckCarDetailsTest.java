package ui.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.pages.CarTaxCheckPage;

import java.io.IOException;


public class CheckCarDetailsTest {

    WebDriver driver;
    CarTaxCheckPage carTaxCheckPage = new CarTaxCheckPage(driver);

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://cartaxcheck.co.uk");
    }

    @Test
    public void checkCarInfo() throws InterruptedException, IOException {
             carTaxCheckPage.verifyCarDetails(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
