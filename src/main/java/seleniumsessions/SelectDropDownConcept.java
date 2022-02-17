package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownConcept {

		static WebDriver driver;

		public static void main(String[] args) throws InterruptedException {
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
			driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
			By country=By.id("Form_submitForm_Country");
			By state=By.id("Form_submitForm_State");
//			WebElement country_ele=driver.findElement(country);
//			
//			Select select=new Select(country_ele);
//			select.selectByIndex(1);
//			select.selectByValue("Algeria");
//			select.selectByVisibleText("India");
			
			doSelectDropDownByVisibleText(country, "India");
			Thread.sleep(3000);
			
			doSelectDropDownByValue(state, "Karnataka");
			
				

	}
		
		
		//generic methods
		public static WebElement getElement(By locator) {
			return driver.findElement(locator);
		}
		public static void doSelectDropDownByIndex(By locator, int index) {
			Select select=new Select(getElement(locator));
			select.selectByIndex(index);
		}
		
		public static void doSelectDropDownByVisibleText(By locator, String visibletxt) {
			Select select=new Select(getElement(locator));
			select.selectByVisibleText(visibletxt);
		}
		
		public static void doSelectDropDownByValue(By locator, String value) {
			Select select=new Select(getElement(locator));
			select.selectByValue(value);
		}
		

}
