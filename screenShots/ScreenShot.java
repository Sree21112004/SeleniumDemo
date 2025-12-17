package screenShots;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScreenShot{

	@Test
	public void takeScreenshot() throws Exception {
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_leak_detection",false);
		
		ChromeOptions option = new ChromeOptions();
		option.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(option);
		
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		WebElement username = driver.findElement(By.id("user-name"));
		username.click();
		username.sendKeys("standard_user");
		WebElement pass = driver.findElement(By.id("password"));
		pass.click();
		pass.sendKeys("secret_sauc");
		driver.findElement(By.id("login-button")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
		}catch(TimeoutException te) {
			System.out.println("Taking Screenshot of failure page");
			
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
			String timeStamp = sdf.format(date);
			
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File ("screenshots/"+timeStamp+"_LoginFailure.png");
			try {
			FileUtils.copyFile(src, dest);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		String act_result = driver.findElement(By.className("title")).getText();
		System.out.println(act_result);
		String exp_result = "Products";
		Assert.assertEquals(act_result, exp_result);
	}
}