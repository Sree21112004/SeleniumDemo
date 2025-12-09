package seleniumDemo;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CrossBrowserDemo {
  @Test
  public void task() {
	  WebDriver driver = null;
	  Scanner sc = new Scanner(System.in);
	  System.out.println("Enter browser name: ");
	  String browser = sc.nextLine();
	  
	  if(browser.equalsIgnoreCase("chrome")) {
		  driver = new ChromeDriver();
	  }else if(browser.equalsIgnoreCase("firefox")) {
		  driver = new FirefoxDriver();
	  }else if(browser.equalsIgnoreCase("edge")) {
		  driver = new EdgeDriver();
	  }
	  
	  driver.manage().window().maximize();
	  driver.get("https://in.tradingview.com/");
	  
	  driver.findElement(By.cssSelector("a[href='/markets/']")).click();
  }
}
