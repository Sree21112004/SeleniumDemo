package JUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FirstJUnitTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Before All");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("After All");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Before Each");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("After Each");
	}

	@Test@Order(3)
	void loginTest() {
		System.out.println("Login Test 1");
		Assertions.assertEquals("Selenium", "Selenium");
	}
	@Test@Order(1)
	void searchTest() {
		System.out.println("Search Test 2");
		Assertions.assertTrue(true);
	}
	@Test@Order(2)
	void addToCart() {
		System.out.println("Add to Cart Test 3");
		Assertions.assertFalse(false);
	}

}
