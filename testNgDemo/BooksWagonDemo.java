package testNgDemo;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BooksWagonDemo {
	Scanner sc = new Scanner(System.in);
	WebDriver driver = new ChromeDriver();

	@Test(priority = 1)
	public void launch() {
		driver.manage().window().maximize();
		driver.get("https://www.bookswagon.com/");
	}

	@Test(priority = 2)
	public void search() {
		WebElement searchBook = driver.findElement(By.cssSelector(".inputbar"));
		searchBook.click();
		searchBook.sendKeys("harry potter");
	}

	@Test(priority = 3)
	public void searchClick() {
		WebElement searchEnter = driver.findElement(By.cssSelector("input[name='btnTopSearch']"));
		searchEnter.click();
	}

	@Test(priority = 4)
	public void prefShow() {
		WebElement bookCount = driver.findElement(By.cssSelector(".preferences-show"));
		System.out.println(bookCount.getText());
	}

	@Test(priority = 5)
	public void sort() {
		System.out.println("Enter the nth book: ");
		int n = sc.nextInt();
		// Capture title BEFORE sorting
		String beforeSort = driver.findElement(By.xpath("(//div[@class='title'])[1]/a")).getText();

		// Apply sorting
		Select s1 = new Select(driver.findElement(By.id("ddlSort")));
		s1.selectByVisibleText("Title - A to Z");

		// Explicit wait for title change
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions
				.not(ExpectedConditions.textToBe(By.xpath("(//div[@class='title'])[1]/a"), beforeSort)));

		// Capture title AFTER sorting
		String afterSort = driver.findElement(By.xpath("(//div[@class='title'])[2]/a")).getText();

		System.out.println("Before sorting : " + beforeSort);
		System.out.println("After sorting  : " + afterSort);
	}

//	@Test(priority = 6)
//	public void chooseBook() throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='title'])[2]")));
//		WebElement chosenBook = driver.findElement(By.xpath("(//div[@class='title'])[2]"));
//		System.out.println(chosenBook.getText());
//	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

}
