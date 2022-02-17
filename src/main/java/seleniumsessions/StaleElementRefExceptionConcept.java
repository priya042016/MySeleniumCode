package seleniumsessions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementRefExceptionConcept {

		static WebDriver driver;
		
		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			//DOM-----version 1
			driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
			WebElement fn=driver.findElement(By.id("Form_submitForm_Name"));
			By FirstName=By.id("Form_submitForm_Name");
			fn.sendKeys("Priya");
			driver.navigate().refresh();
			
			//DOM-----------Version 2 created after page refresh
			
			//Method 1: to solve the below exception, create the webelement again.
			//fn=driver.findElement(By.id("Form_submitForm_Name"));
			//fn.sendKeys("Akashini");//org.openqa.selenium.StaleElementReferenceException
			
			
			//Method 2: use FluentWait to enter value for that element
//			FluentWait<WebDriver> wait=new WebDriverWait(driver, Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1))
//					.ignoring(StaleElementReferenceException.class);
//			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Form_submitForm_Name"))).sendKeys("Akashini");			
			
			//Method 3: using getElement, sendKeys util
			
			ElementUtil ele=new ElementUtil(driver);
			ele.doSendKeys(FirstName, "Akashini");
			
			

	}

}
