package screenShots;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotDemo {

    @Test
    public void takeScreenshot() throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        Thread.sleep(2000);

        // Step 1: Convert WebDriver object to TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        // Step 2: Capture screenshot and store it as a file
        File src = ts.getScreenshotAs(OutputType.FILE);

        // Step 3: Create destination file
        File dest = new File("C:\\Users\\Sree\\Pictures\\google_page.png");

        // Step 4: Copy file from source to destination
        FileHandler.copy(src, dest);

        System.out.println("Screenshot taken successfully!");

    }
}
