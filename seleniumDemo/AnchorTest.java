package seleniumDemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AnchorTest {

    @Test
    public void f() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open website
        driver.get("https://www.wikipedia.org/");

        // Find all anchor tags by tagName
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        // Print all href values
        System.out.println("Printing all href values\n");
        for (WebElement element : allLinks) {
            String href = element.getAttribute("href");
            System.out.println(href);
        }

        // Print total number of anchor tags
        System.out.println("\nTotal Anchor Tags: " + allLinks.size());

    }
}

