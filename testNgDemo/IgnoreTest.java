package testNgDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class IgnoreTest {
	@Test
	public void flipkartLogin() {
		System.out.println("Login");
		Assert.assertEquals("hi", "hello");
	}

	@Test(dependsOnMethods = {"flipkartLogin"})
	public void flipkartSearch() {
		System.out.println("Search");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}

}
