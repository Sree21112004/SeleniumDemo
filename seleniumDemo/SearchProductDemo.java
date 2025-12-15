package seleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class SearchProductDemo {


    private static final Object[][] PRODUCTS_TO_SEARCH = {
        {"Laptop", 7},
        {"TV", 13},
        {"Smart Phone", 2}
    };

    public static void main(String[] args) {
        // 1. Setup WebDriver and Options
        // Note: Selenium 4.6+ automatically manages ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
        try {
             for (Object[] searchPair : PRODUCTS_TO_SEARCH) {
                String productName = (String) searchPair[0];
                int nthProduct = (int) searchPair[1];

                System.out.println("--- Searching for: " + productName + " and finding the " + nthProduct + " product ---");
                
                // Navigate to Flipkart
                driver.get("https://www.flipkart.com/");
                
                // Wait for the login pop-up to appear and close it
                try {
                    // Locator for the 'X' button of the login pop-up
                    WebElement closeButton = wait.until(
                        ExpectedConditions.elementToBeClickable(By.cssSelector("span[role='button']"))
                    );
                    closeButton.click();
                    System.out.println("Closed the login pop-up.");
                } catch (Exception e) {
                    // This block executes if the pop-up doesn't appear within the timeout
                    System.out.println("Login pop-up did not appear or was not closed.");
                }

                // 2. Locate the Search Box and Enter Text
                // Reusing the locator from the previous context: input[name="q"]
                WebElement searchBox = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.name("q"))
                );
                searchBox.sendKeys(productName);
                
                // 3. Click the Search Button
                // The search button is usually an adjacent sibling or part of the same form.
                // Inspecting the site shows a button within a form
                searchBox.submit(); // Submitting the search box is often the simplest way to initiate the search
                // OR: driver.findElement(By.cssSelector("button[type='submit']")).click();

                // 4. Wait for the Search Results to Load
                // Wait until the search results container is visible. 
                // Flipkart's search results are often contained in divs with specific classes.
                // We use a robust selector to target the product titles.
                String productTitleXPath = "//div[contains(@class, '_13oc-S') or contains(@class, '_4rR01T') or contains(@class, '_2B099V')]";
                
                // Wait for at least one search result element to be present
                wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(productTitleXPath))
                );

                // 5. Extract all Product Titles
                List<WebElement> productNames = driver.findElements(By.xpath(productTitleXPath));
                
                // 6. Check for results and display the Nth product
                if (productNames.isEmpty()) {
                    System.out.println("No products found for: " + productName);
                } else if (nthProduct > productNames.size()) {
                    System.out.println("Error: The requested product position (" + nthProduct + ") is greater than the total number of results (" + productNames.size() + ").");
                } else {
                    // Selenium lists are 0-indexed, so we subtract 1 from the Nth position
                    WebElement targetProduct = productNames.get(nthProduct - 1);
                    String targetProductName = targetProduct.getText().trim();
                    
                    System.out.println("✅ Result for " + productName + ":");
                    System.out.println("   Total products found on the page: " + productNames.size());
                    System.out.println("   The " + nthProduct + " product name is: **" + targetProductName + "**");
                }
                
                System.out.println("\n"); // Separator for the next product
            }

        } catch (Exception e) {
            System.err.println("An error occurred during the Selenium execution: " + e.getMessage());
        } 
    }
}