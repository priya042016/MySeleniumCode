package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForAlert {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		ElementUtil ele=new ElementUtil(driver);
		ele.waitForURLToBe("https://mail.rediff.com/cgi-bin/login.cgi", 10);
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		
	


//		System.out.println(driver.getCurrentUrl());
//		By signIn=By.xpath("//input[@value='Sign in']");
//		ele.waitForElementVisible(signIn, 10).click();
		
		//driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		
		//driver.switchTo().alert();//NoAlertPresentException 
		
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
//		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
//		System.out.println(alert.getText());
		
		waitForAlert(10);
		System.out.println(getAlertText(5));
		acceptAlert(5);//TimeoutException
	
	}
	
	//generic methods
	
	public static Alert waitForAlert(int timeout) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.alertIsPresent());
		
	}
	
	public static String getAlertText(int timeout) {
		return waitForAlert(timeout).getText();
	}	
	
	public static void acceptAlert(int timeout) {
		waitForAlert(timeout).accept();
	}
	
	public static void dismissAlert(int timeout) {
		waitForAlert(timeout).dismiss();
	}
	

}
