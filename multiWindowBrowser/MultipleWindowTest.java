package multiWindowBrowser;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MultipleWindowTest {
  @Test
  public void f() {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[id='openwindow']'"))).sendKeys(Keys.ENTER);
	  
	  String parentWindow = driver.getWindowHandle();
	  Set<String> allWindows = driver.getWindowHandles();
	  for(String each:allWindows) {
		  if(!each.equals(parentWindow)) {
			  driver.switchTo().window(each);
		  }
	  }
	  System.out.println("Switched to new window");
	  driver.switchTo().window(parentWindow);
	  System.out.println("Switched to parent window");
	  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#opentab"))).sendKeys(Keys.ENTER);
  }
}
