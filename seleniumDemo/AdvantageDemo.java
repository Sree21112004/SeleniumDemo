package seleniumDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AdvantageDemo {
  @Test
  public void f() throws InterruptedException{
  	  //public void f() throws InterruptedException 
	  //1 public void f() throws InterruptedException
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--disable-notifcations");
	  WebDriver driver = new ChromeDriver(options);
	  driver.manage().window().maximize();
	  driver.get("https://www.easemytrip.com/flights/");
	  
	  //1 Thread.sleep(5000);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(100));
	  driver.findElement(By.id("frmcity")).click();
	  driver.findElement(By.id("a_FromSector_show")).sendKeys("Bengaluru");
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	  driver.findElement(By.xpath("//div[@id='fromautoFill']/ul/li[1]")).click();
	  //driver.findElement(By.id("spnBengaluru")).click();
	  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("spnBengaluru")));
	  driver.findElement(By.id("a_Editbox13_show")).sendKeys("Chennai");
	  driver.findElement(By.xpath("//div[@id='toautoFill']/ul/li[1]"));
	  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("spnChennai")));
	  //driver.findElement(By.id("spnChennai")).click();
	  WebElement dateD = driver.findElement(By.id("fiv_3_31/12/2025"));
	  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fiv_3_31/12/2025")));
	  dateD.click();
	  driver.findElement(By.id("//span[@id='spnTraveller']")).click();
	  //button[@class='srchBtnSe']
	  driver.findElement(By.id("button[@class='srchBtnSe']")).click();
	  
  }
}
