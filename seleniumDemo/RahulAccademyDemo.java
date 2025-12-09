package seleniumDemo;

import java.util.HashMap;
import java.util.Map;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RahulAccademyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_leak_detection",false);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		WebElement button = driver.findElement(By.xpath("//input[@value='radio1']"));
		button.click();
		WebElement checkBox = driver.findElement(By.xpath("//input[@id='checkBoxOption1']"));
		checkBox.click();
		WebElement checkBox1 = driver.findElement(By.xpath("//input[@id='checkBoxOption2']"));
		checkBox1.click();
		}

		
	}


