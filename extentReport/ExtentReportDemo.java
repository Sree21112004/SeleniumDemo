package extentReport;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.Reporter;

public class ExtentReportDemo {
	WebDriver driver;
	WebDriverWait wait;
	ExtentSparkReporter extSparkReporter;
	ExtentReports extReports;
	ExtentTest extTest;
	
	@BeforeMethod
	public void setUP() {
		extSparkReporter = new ExtentSparkReporter("reports\\ExtentReport.html");
		extReports = new ExtentReports();
		extReports.attachReporter(extSparkReporter);
		
		// to handle password popup
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_leak_detection", false);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}
	@Test
	public void testPlaceOrder() {
		
		extTest = extReports.createTest("Place Order");
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce1");
		driver.findElement(By.id("login-button")).click();
		By validateText = By.xpath("//span[text()='Products']");
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(validateText));
			Reporter.generateReport(driver, extTest, Status.PASS, "Login is success");
			System.out.println("Login Success");
		} catch (TimeoutException te) {
			System.out.println("Timeout Exception is thrown");
			Reporter.generateReport(driver, extTest, Status.FAIL, "Login is failed");
		}
	}
	@AfterMethod
	public void tearDown() {
		extReports.flush();
	}
}
