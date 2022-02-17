package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElementConcept {

		static WebDriver driver;

		public static void main(String[] args) throws InterruptedException {
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
			driver.get("http://mrbool.com/");
			WebElement content=driver.findElement(By.className("menulink"));
			Actions action=new Actions(driver);
			action.moveToElement(content).perform();
			Thread.sleep(3000);
			driver.findElement(By.linkText("COURSES")).click();
			
	}

}
