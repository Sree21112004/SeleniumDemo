package toolTip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class ToolTipDemo {
  @Test
  public void f() {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.bing.com/?FORM=Z9FD1");
	
	  WebElement pic = driver.findElement(By.xpath("//h1[@class='logo_cont']"));
	  Actions action = new Actions(driver);
	  action.moveToElement(pic);
	  System.out.println(pic.getAttribute("title"));
  }
}
