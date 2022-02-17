package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PollingTimeConcept {

	static WebDriver driver;

		public static void main(String[] args) throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get("https://demo.opencart.com/index.php?route=account/login");
			By email=By.id("input-email2");
			//By pwd=By.id("input-password");
			
			//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			//wait.pollingEvery(Duration.ofSeconds(2));//it will chk for the element every 2 sec
			//tried for 10 second(s) with 2000 milliseconds interval
			//default polling time is 500 ms if no polling .....//tried for 10 second(s) with 500 milliseconds interval
			
			//another method of writing polling
			
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(2));//sleep means, interval time , here it is 2 sec
			wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys("pri@gmail.com");
			
		
			
			


	}

}
