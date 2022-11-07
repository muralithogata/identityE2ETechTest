package ui.pages;

import org.junit.Assert;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.util.CarDetails;

import java.io.IOException;
import java.time.Duration;

public class CarTaxCheckPage {

    CarDetails carDetails = new CarDetails();
    WebDriver driver;

    public CarTaxCheckPage(WebDriver driver) {
        this.driver = driver;
    }

    By input = By.id("vrm-input");

    By button = By.cssSelector("form > button");

    By reg = By.xpath("//*[@id=\"m\"]/div[2]/div[3]/div[1]/div/span/div[2]/dl[1]/dd");

    By make = By.xpath("//*[@id=\"m\"]/div[2]/div[3]/div[1]/div/span/div[2]/dl[2]/dd");

    By model = By.xpath("//*[@id=\"m\"]/div[2]/div[3]/div[1]/div/span/div[2]/dl[3]/dd[1]");

    By colour = By.xpath("//*[@id=\"m\"]/div[2]/div[3]/div[1]/div/span/div[2]/dl[6]/dd");

    By year = By.xpath("//*[@id=\"m\"]/div[2]/div[3]/div[1]/div/span/div[2]/dl[4]/dd[1]");



    public void verifyCarDetails(WebDriver driver) throws IOException {
        for (int i = 0; i < carDetails.getRegnumberFromInputTxtFile().size(); i++) {

            if (i == 0) {
                driver.findElement(input).sendKeys(carDetails.getRegnumberFromInputTxtFile().get(i));
                driver.findElement(button).click();
            } else {
                driver.navigate().back();
                driver.findElement(By.id("vrm-input")).sendKeys(carDetails.getRegnumberFromInputTxtFile().get(i));
                driver.findElement(By.cssSelector("form > button")).click();
            }

            WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"selectProduct\"]/div[1]/div/div/h1")));

            String carReg = carDetails.getRegnumberFromInputTxtFile().get(i);
            switch (carReg) {
                case "DN09HRM":
                    Assert.assertEquals("Car reg number not found or not equal", carDetails.getExpectedFromOutputFile().get(2).getReg(), driver.findElement(reg).getText());
                    Assert.assertEquals("Car make not found or not equal", carDetails.getExpectedFromOutputFile().get(2).getMake(), driver.findElement(make).getText());
                    Assert.assertEquals("Car model not found or not equal", carDetails.getExpectedFromOutputFile().get(2).getModel(), driver.findElement(model).getText());
                    Assert.assertEquals("Car colour not found or not equal", carDetails.getExpectedFromOutputFile().get(2).getColour(), driver.findElement(colour).getText());
                    Assert.assertEquals("Car year not found or not equal", carDetails.getExpectedFromOutputFile().get(2).getYear(), driver.findElement(year).getText());
                    break;
                case "BW57 BOW":
                    System.out.println("Vehicle not found");
                    break;
                case "KT17DLX":
                    Assert.assertEquals("Car reg number not found or not equal", carDetails.getExpectedFromOutputFile().get(4).getReg(), driver.findElement(reg).getText());
                    Assert.assertEquals("Car make not found or not equal", carDetails.getExpectedFromOutputFile().get(4).getMake(), driver.findElement(make).getText());
                    Assert.assertEquals("Car model not found or not equal", carDetails.getExpectedFromOutputFile().get(4).getModel(), driver.findElement(model).getText());
                    Assert.assertEquals("Car colour not found or not equal", carDetails.getExpectedFromOutputFile().get(4).getColour(), driver.findElement(colour).getText());
                    Assert.assertEquals("Car year not found or not equal", carDetails.getExpectedFromOutputFile().get(4).getYear(), driver.findElement(year).getText());
                    break;
                case "SG18 HTN":
                    Assert.assertEquals("Car reg number not found or not equal", carDetails.getExpectedFromOutputFile().get(1).getReg(), driver.findElement(reg).getText());
                    Assert.assertEquals("Car make not found or not equal", carDetails.getExpectedFromOutputFile().get(1).getMake(), driver.findElement(make).getText());
                    Assert.assertEquals("Car model not found or not equal", carDetails.getExpectedFromOutputFile().get(1).getModel(), driver.findElement(model).getText());
                    Assert.assertEquals("Car colour not found or not equal", carDetails.getExpectedFromOutputFile().get(1).getColour(), driver.findElement(colour).getText());
                    Assert.assertEquals("Car year not found or not equal", carDetails.getExpectedFromOutputFile().get(1).getYear(), driver.findElement(year).getText());
                    break;
                default:
                    System.out.println("Reg number " + carReg + "not found");
            }
        }
    }

}
