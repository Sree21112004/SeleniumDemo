

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedBus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		String result="Bus Booking Online and Train Tickets at Lowest Price - redBus";
		String expResult=driver.getTitle();
		if(expResult.equals(result)) {
			System.out.println("Passed");
		}else {
			System.out.println("Failed");
		}
	}

}
