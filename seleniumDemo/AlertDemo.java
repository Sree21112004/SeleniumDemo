package seleniumDemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertDemo {
  @Test
  public void f() throws InterruptedException {
	  WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://the-internet.herokuapp.com/javascript_alerts");
      
      driver.findElement(By.xpath("//ul/li[3]/button")).click();
      Alert alert = driver.switchTo().alert();
      alert.sendKeys("Demo");
      Thread.sleep(10000);
      alert.accept();
  }
}
