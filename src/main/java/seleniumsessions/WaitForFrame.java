package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForFrame {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		
		//driver.switchTo().frame(2);//index
		//driver.switchTo().frame("main");//name or id
	//	driver.switchTo().frame(driver.findElement(By.name("main")));//WebElement frameElement
			//get the text of the element inside the frame	
		
		//using wait
		
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
//		WebDriver driver=wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(2));//by index
	//	By frameLocator=By.name("main");
		WebElement frame=driver.findElement(By.name("main"));
		//waitForFrameByIndex(5, 2);
		//waitForFrameByLocator(5, frameLocator);
		waitForFrameByElement(5, frame);
		String header=driver.findElement(By.xpath("/html/body/h2")).getText();
		System.out.println(header);

	}
	//generic methods
	
	public static WebDriver waitForFrameByIndex(int timeout, int index) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));//by index
	}
	
	public static WebDriver waitForFrameByLocator(int timeout, By frameLocator) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
	
	public static WebDriver waitForFrameByElement(int timeout, WebElement frameElement) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}

	
}
