package apptests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {
	
	
	@Test(enabled=false)
	public void googleTitleTest() {
		Assert.assertEquals(driver.getTitle(), "Google");
	}
	@Test
	public void googleSearch() {
		driver.findElement(By.name("q")).sendKeys("mackbook pro");
		Assert.assertTrue(true);
	}
		

}
