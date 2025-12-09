package seleniumDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FlipkartDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_leak_detection",false);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		WebElement search = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/header/div[1]/div[2]/form/div/div/input"));
		search.sendKeys("mobiles");
		
		WebElement enter = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/header/div[1]/div[2]/form/div/button"));
		enter.click();
		
		List<WebElement> details = new ArrayList<>();
		details.add(driver.findElement(By.xpath("/html/body/div/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[2]")));
		details.add(driver.findElement(By.xpath("/html/body/div/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[3]/span[2]/span")));
		details.add(driver.findElement(By.xpath("/html/body/div/div/div[3]/div[1]/div[2]/div[3]/div/div/div/a/div[2]/div[1]/div[2]")));
		details.add(driver.findElement(By.xpath("/html/body/div/div/div[3]/div[1]/div[2]/div[3]/div/div/div/a/div[2]/div[1]/div[3]/span[2]/span"))); 
		for(WebElement ele : details) {
		    System.out.println(ele.getText());
		}
		System.out.println();
		driver.findElement(By.partialLinkText("Google Pixel 10 Pro")).click();
		// //div[text()='Java'] -> custom xPath
		// //input[@value='radio2'] -> another custom xPath
		// //span[starts-with(@id,'u_0_d')]
		
	}

}
