package apptests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoCartTest extends BaseTest{
	
		

	
	@Test
	public void logoTest() {
		Assert.assertTrue(driver.findElement(By.id("logo")).isDisplayed());
	}
	
	@Test
	public void pageTitleTest() {
		String title=driver.getTitle();
		Assert.assertEquals(title, "Account Login111");
	}
	
	@Test
	public void accountLinkTest() {
		Assert.assertTrue(driver.findElement(By.linkText("Account")).isDisplayed());
	}
	
	
	
/*
 * PASSED: accountLinkTest
PASSED: logoTest
PASSED: pageTitleTest

===============================================
    Default test
    Tests run: 3, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 3, Failures: 0, Skips: 0
===============================================
 * 
 */
	

}
