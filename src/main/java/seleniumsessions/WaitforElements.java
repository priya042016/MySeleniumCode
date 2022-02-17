package seleniumsessions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitforElements {

		static WebDriver driver;

		public static void main(String[] args) {
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
			driver.get("https://www.freshworks.com/");
					
			By footers=By.cssSelector(".footer-nav>li");
//			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
//			List<WebElement> footerList=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footers));
//			for(WebElement e:footerList) {
//				System.out.println(e.getText());
			
			List<WebElement> footerList= waitForElementsVisible(footers, 10);
			for(WebElement e:footerList) {
				System.out.println(e.getText());
			
			}
		}
			
			//generic methods
		/**
		 * An expectation for checking that all elements present on the web page that match the locatorare visible. 
		 * Visibility means that the elements are not only displayed but also have a heightand width that is greater than 0.
		 * @param locator
		 * @param timeout
		 * @return
		 */
			public static List<WebElement> waitForElementsVisible(By locator, int timeout) {
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
				return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
				
			}
			
			public static List<WebElement> waitForElementsPresence(By locator, int timeout) {
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
				return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
				
			}
			
			
			
			

	}


