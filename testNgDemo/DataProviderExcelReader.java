package testNgDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.ExcelReader;

public class DataProviderExcelReader {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bookswagon.com/");
    }

    @Test(dataProvider = "excelData")
    public void searchAndFetchNthProduct(String searchText, String nthProduct) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inputbar"))).clear();
        driver.findElement(By.className("inputbar")).sendKeys(searchText);
        driver.findElement(By.name("btnTopSearch")).sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("preferences-show")));

        String product = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//div[@class='title'])[" + nthProduct + "]/a"))).getText();

        System.out.println("Search: " + searchText + " | Nth Product: " + product);
    }

    @DataProvider(name = "excelData")
    public Object[][] getExcelData()  {
        return ExcelReader.readData();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}