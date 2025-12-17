package testNGxml;
import org.testng.annotations.Test;
public class AmazonGroup {
	@Test(groups = { "Smoke Test" })
	public void aLogin() {
		System.out.println("This is Amazon Login Page");
	}
	@Test(groups = { "Smoke Test", "Regression Test" })
	public void aSearchProduct() {
		System.out.println("This is Amazon Search Page");
	}
	@Test(groups = { "UAT Test" })
	public void aSelectProduct() {
		System.out.println("This is Amazon Display products page");
	}
}
