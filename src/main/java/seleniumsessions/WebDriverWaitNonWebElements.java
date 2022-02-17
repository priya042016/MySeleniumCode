package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitNonWebElements {

	static WebDriver driver;
	public static void main(String[] args) {
		
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get("https://www.amazon.com");
			
//			String title=doGetPageTile("Amazon", 5);
			String title=doGetPageTitleIs("Amazon.com. Spend less. Smile more.", 5);
			System.out.println(title);
			
	}
	
	//generic method
	
	public static boolean waitForPageTitle(String title, int timeout) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.titleContains(title));
	}
	
	public static String doGetPageTile(String title, int timeout) {
		if(waitForPageTitle(title, timeout)) {
			return driver.getTitle();
		}
		return null;
	}
	
	public static boolean waitForPageActualTitle(String actTitle, int timeout) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.titleIs(actTitle));
	}
	
	public  static String doGetPageTitleIs(String titleVal, int timeout) {
		if(waitForPageActualTitle(titleVal, timeout)) {
			return driver.getTitle();
		}
		return null;
	}
	

}
