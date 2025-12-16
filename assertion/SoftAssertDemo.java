package assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertDemo {


	@Test(priority = 2)
	public void testSoftAssert() {
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals("Selenium", "Selenium1");
		System.out.println("After First Soft Assert");

		
		softAssert.assertEquals("HCL", "HCL");
		System.out.println("After Second Soft Assert");
		
		softAssert.assertEquals("Saveetha", "Saveetha.ac.in");
		System.out.println("After Third Soft Assert");
		
		softAssert.assertAll();
		

	}
	
	@Test(priority = 1)
	public void testHardAssert() {
		Assert.assertEquals("Train1", "Train");
		System.out.println("this is Hard Assert");
	}

}