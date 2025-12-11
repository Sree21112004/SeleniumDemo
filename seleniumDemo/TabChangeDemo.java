package seleniumDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TabChangeDemo {

    @Test
    public void navigationTest() throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Website 1
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);

        // Website 2
        driver.navigate().to("https://www.youtube.com");
        Thread.sleep(2000);

        // Navigate back to Website 1
        driver.navigate().back();
        Thread.sleep(2000);

        // Navigate forward to Website 2
        driver.navigate().forward();
        Thread.sleep(2000);

        // Navigate again to Website 1
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);

        // Refresh Website 1
        driver.navigate().refresh();
        Thread.sleep(2000);

    }
}
