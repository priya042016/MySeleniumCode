package seleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDOMElementConcept {


		static WebDriver driver;
		public static void main(String[] args) throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			
			driver=new ChromeDriver();
			driver.get("https://selectorshub.com/xpath-practice-page/");
			
			driver.switchTo().frame("pact");
			JavascriptExecutor js=(JavascriptExecutor)driver;
			WebElement tea=(WebElement) js.executeScript("return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")");
			tea.sendKeys("masala tea");
			
			

	}

}
