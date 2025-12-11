package seleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MobiScrollDemo {

    @Test
    public void f() throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.mobiscroll.com/select/multiple-select");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//input[@id='single-select-input']")).click();
        // Scroll down so the textbox becomes clickable
//        WebElement multiSelectInput = driver.findElement(By.xpath("//input[@placeholder='Please select...']"));
//        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", multiSelectInput);
        Thread.sleep(1000);

        //multiSelectInput.click();
        

        // Select multiple values (Mobiscroll uses li elements)
        driver.findElement(By.xpath("//div[@role='listbox']/div/div/div/div[41]")).click();
        Thread.sleep(800);

        driver.findElement(By.xpath("//div[@role='listbox']/div/div/div/div[42]")).click();
        Thread.sleep(800);

        //driver.findElement(By.xpath("//li[contains(@class,'mbsc-list-item')][.='Boston']")).click();
        //Thread.sleep(800);
        driver.findElement(By.xpath("//div[@role='listbox']/div/div/div/div[43]")).click();
        Thread.sleep(800);
        
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();

        Thread.sleep(2000);
    }
}
