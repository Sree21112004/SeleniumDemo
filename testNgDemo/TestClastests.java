package testNgDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class TestClastests {
  @Test(priority=1)
  public void app() {
	  System.out.println("apple");
	  Assert.assertEquals("java", "apple");
  }
  @Test(priority=2)
  public void cat() {
	  System.out.println("cat");
	  Assert.assertTrue(true);
  }
  @Test()
  public void bag() {
	  System.out.println("bag");
	  Assert.assertTrue(false);
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("before test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("after test");
  }
  
}
