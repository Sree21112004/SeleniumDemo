package waitPrgms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

public class FluentWaitDemo {
  @Test
  public void performFluentWait() {
	  ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.easemytrip.com/");
		driver.findElement(By.id("frmcity")).click();
		driver.findElement(By.id("a_FromSector_show")).sendKeys("benga");
		By firstFrom = By.xpath("//div[@id='fromautoFill']/ul/li[1]");

		FluentWait<WebDriver> fluent = new FluentWait<>(driver)
		    .withTimeout(Duration.ofSeconds(20))
		    .pollingEvery(Duration.ofMillis(250))
		    .ignoring(StaleElementReferenceException.class);

		fluent.until(d -> {
              if (d.findElement(firstFrom).isDisplayed()) {
                  d.findElement(firstFrom).click();
                  return true;
              }
				return false;
		});
  }
}