package seleniumDemo;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FlipkartSearch {
  @Test
  public void f() {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.flipkart.com/");
	  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	  WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
	  
	  WebElement search = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/header/div[1]/div[2]/form/div/div/input"));
	  search.sendKeys("mobiles");
	  
	  WebElement enter = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/header/div[1]/div[2]/form/div/button"));
	  enter.click();
	  
	  driver.findElement(By.xpath("(//div[@class='nZIRY7'])[2]")).click();	  
	  String parentWindow = driver.getWindowHandle();
	  Set<String> allWindows = driver.getWindowHandles();
	  System.out.println("Unique string of parent id: "+parentWindow);
	  for(String each:allWindows) {
		  if(!each.equals(parentWindow)) {
			  driver.switchTo().window(each);
		  }
	  }
	  
  }
}
