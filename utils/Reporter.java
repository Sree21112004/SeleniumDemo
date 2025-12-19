package utils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Reporter {
//	public static void generateReport(WebDriver driver, ExtentTest extTest, Status status, String stepMessage) {
//		
//		if(status.equals(Status.PASS)) {
//			System.out.println("The step: " + stepMessage + " is passed");
//			extTest.log(status, stepMessage);
//		}else if(status.equals(Status.FAIL)) {
//			System.out.println("The step: " + stepMessage + " is failed");
//			String screenShotName = getScreenshot(driver, "Login_Failure");
//			extTest.log(status, stepMessage, MediaEntityBuilder.createScreenCaptureFromPath(screenShotName).build());
//		}
//	}
	public static void generateReport(WebDriver driver, ExtentTest extTest, Status status, String stepMessage) {
	    
	    if(status.equals(Status.PASS)) {
	        System.out.println("The step: " + stepMessage + " is passed");
	        extTest.log(status, stepMessage);
	    } else if(status.equals(Status.FAIL)) {
	        System.out.println("The step: " + stepMessage + " is failed");
	        
	        // 1. Capture as Base64
	        String base64Code = getBase64Screenshot(driver);
	        
	        // 2. Attach to report (no file path needed for the report to display it)
	        extTest.log(status, stepMessage, 
	            MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code).build());
	        
	        // OPTIONAL: Keep your physical copy code if you still want a backup file on your drive
	        getScreenshot(driver, "Login_Failure"); 
	    }
	}
	
	public static String getScreenshot(WebDriver driver, String errorMsg) {
	    String timeStamp = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss").format(new Date());
	    
	    TakesScreenshot scrShot = (TakesScreenshot)driver;
	    File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
	    
	    // 1. Define the folder inside 'reports'
	    String reportDirectory = "reports/screenshots/";
	    String fileName = timeStamp + "_" + errorMsg + ".png";
	    
	    File desFile = new File(reportDirectory + fileName);
	    
	    try {
	        FileUtils.copyFile(srcFile, desFile);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    // 2. Return ONLY the relative path that the HTML file needs to find the image
	    // Since ExtentReport.html is already in 'reports', it just needs 'screenshots/name.png'
	    return "screenshots/" + fileName;
	}
	public static String getBase64Screenshot(WebDriver driver) {
	    // This captures the image and converts it into a Base64 string automatically
	    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}
	
}
