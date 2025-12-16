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

	private static final Object[][] PRODUCTS_TO_SEARCH = { { "Laptop", 7 }, { "TV", 13 }, { "Smart Phone", 2 } };

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		try {
			for (Object[] searchPair : PRODUCTS_TO_SEARCH) {
				String productName = (String) searchPair[0];
				int nthProduct = (int) searchPair[1];

				System.out.println(
						"--- Searching for: " + productName + " and finding the " + nthProduct + " product ---");

				driver.get("https://www.flipkart.com/");

				try {
					WebElement closeButton = wait
							.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[role='button']")));
					closeButton.click();
					System.out.println("Closed the login pop-up.");
				} catch (Exception e) {
					// This block executes if the pop-up doesn't appear within the timeout
					System.out.println("Login pop-up did not appear or was not closed.");
				}

				WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
				searchBox.sendKeys(productName);

				searchBox.submit();
				String productTitleXPath = "//div[contains(@class, '_13oc-S') or contains(@class, '_4rR01T') or contains(@class, '_2B099V')]";

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(productTitleXPath)));

				List<WebElement> productNames = driver.findElements(By.xpath(productTitleXPath));

				if (productNames.isEmpty()) {
					System.out.println("No products found for: " + productName);
				} else if (nthProduct > productNames.size()) {
					System.out.println("Error: The requested product position (" + nthProduct
							+ ") is greater than the total number of results (" + productNames.size() + ").");
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