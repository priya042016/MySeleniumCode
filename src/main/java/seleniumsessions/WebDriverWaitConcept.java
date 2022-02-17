package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitConcept {

	static WebDriver driver;
	public static void main(String[] args) {
		
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get("https://demo.opencart.com/index.php?route=account/login");
			
			By email=By.id("input-email");
			By pwd=By.id("input-password");
			
//			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//			WebElement email_ele=wait.until(ExpectedConditions.presenceOfElementLocated(email));
//			email_ele.sendKeys("pri2@gmail.com");
//			driver.findElement(pwd).sendKeys("test@123");
			
			waitForElementPresence(email, 5).sendKeys("pri3@gmail.com");
			getElement(pwd).sendKeys("test@1234");
		
	}
	
	//generic method
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	/**
	 * An expectation for checking that an element is present on the DOM of a page. This does notnecessarily mean that the element is visible.
	 * @param locator
	 * @param timeout
	 * @return
	 */
	
	public static WebElement waitForElementPresence(By locator, int timeout) {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}
	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible.
	 * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
	 * @param locator
	 * @param timeout
	 * @return
	 */
	
public static WebElement waitForElementVisible(By locator, int timeout) {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	

}
