package seleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDownTest {
  @Test
  public void f() throws InterruptedException {
  WebDriver driver = new ChromeDriver();
  driver.manage().window().maximize();
  driver.get("https://www.facebook.com/r.php?entry_point=login");
  driver.findElement(By.xpath("//select[@id=\"day\"]"));
  
  driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Sree Dharma");
  Thread.sleep(2000);

  driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("A V");
  
  Select s1 = new Select(driver.findElement(By.id("day")));
  s1.selectByContainsVisibleText("21");
  Thread.sleep(2000);
  Select s2 = new Select(driver.findElement(By.id("month")));
  s2.selectByContainsVisibleText("Nov");
  Thread.sleep(2000);
  Select s3 = new Select(driver.findElement(By.id("year")));
  s3.selectByContainsVisibleText("2004");
  Thread.sleep(2000);

  
  
  }
}
