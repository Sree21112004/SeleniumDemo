package Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MouseActions {
  @Test
  public void f() {
	  WebDriver driver = new EdgeDriver();
	  driver.get("https://www.ebay.com/");
	  driver.manage().window().maximize();
	  
	  WebElement electronicsMenu = driver.findElement(By.xpath("(//a[text()='Electronics'])[1]"));
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Electronics'])[1]")));
	  Actions actions = new Actions(driver);
	  actions.moveToElement(electronicsMenu).perform();
	  
	  
	  
  }
}
