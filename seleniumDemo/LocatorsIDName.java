package seleniumDemo;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIDName{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_leak_detection",false);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		//to enter user-name
		//driver.findElement(By.id("user-name")).sendKeys("standard_user");
		
		//short-cut to enter user-name
		WebElement usrName = driver.findElement(By.id("user-name"));
		usrName.sendKeys("standard_user");
		
		//to enter password
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		
		//to login
		driver.findElement(By.id("login-button")).click();
				
		String result="Products";
		String expResult=driver.findElement(By.className("title")).getText();
		
		if(result.equals(expResult)) {
			System.out.println("Passed");
		}else {
			System.out.println("Failed");
		}
		
		driver.findElement(By.id("react-burger-menu-btn")).click();
	}

}
