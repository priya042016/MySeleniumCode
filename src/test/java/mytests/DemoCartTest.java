package mytests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoCartTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demo.opencart.com/index.php?route=account/login");
	}
	
	@Test
	public void logoTest() {
		Assert.assertTrue(driver.findElement(By.id("logo")).isDisplayed());
	}
	
	@Test
	public void pageTitleTest() {
		String title=driver.getTitle();
		Assert.assertEquals(title, "Account Login");
	}
	
	@Test
	public void accountLinkTest() {
		Assert.assertTrue(driver.findElement(By.linkText("Account")).isDisplayed());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
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
