package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForUrl {

	static WebDriver driver;
	public static void main(String[] args) {
		
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get("https://demo.opencart.com/index.php?route=account/login");
			ElementUtil ele=new ElementUtil(driver);
			
			By registerLink= By.linkText("Register");
	
			ele.waitForElementVisible(registerLink, 5).click();
			
//			
//			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
//			if(wait.until(ExpectedConditions.urlContains("account/register"))) {
//						System.out.println(driver.getCurrentUrl());
//			}
			
			String URL=waitForURLToBe("https://demo.opencart.com/index.php?route=account/register", 5);
			System.out.println(URL);
			
			

	}
	
	//generic method
	
	public static String waitForURLContains(String partialURL, int timeout) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		if(wait.until(ExpectedConditions.urlContains(partialURL))) {
				return driver.getCurrentUrl();
		}
		else return null;
	}
	
	public static String waitForURLToBe(String ActualURl, int timeout) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		if(wait.until(ExpectedConditions.urlToBe(ActualURl))) {
				return driver.getCurrentUrl();
		}
		else return null;
	}
	
	
	

}
