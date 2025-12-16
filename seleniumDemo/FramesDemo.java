package seleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FramesDemo {
  @Test
  public void f() {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://docs.oracle.com/javase/7/docs/api/\n");
	  System.out.println(driver.findElements(By.tagName("frame")).size());
	  System.out.println("Current Frame: "+driver.findElement(By.tagName("frame")).getDomAttribute("src"));
	  driver.switchTo().window("classFrame");
	  System.out.println(driver.findElement(By.xpath("//td[@class='colFirst']/a)[1]")).getText());
	  }
}
