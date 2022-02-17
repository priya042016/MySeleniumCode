package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownAllOptions {

		static WebDriver driver;

		public static void main(String[] args) throws InterruptedException {
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
			driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
			By country=By.id("Form_submitForm_Country");
			By state=By.id("Form_submitForm_State");
			
			
//			WebElement countryEle=driver.findElement(country);
//			Select select=new Select(countryEle);
			
			//.getOptions() will return list of Web Elements (interview qn)
			//List<WebElement> optionsList=select.getOptions();
			System.out.println(getDropDownOptionsList(country));
			
			//System.out.println(getDropDownOptionsList(state));
			
			if(getDropDownOptionsList(country).contains("India")) {
				System.out.println("India is present");
			}
			
			selectDropDownValue(country, "India");
			Thread.sleep(3000);
			if(getDropDownOptionsList(state).contains("Karnataka")) {
				System.out.println("Karnataka is present");
			}
			
			
					

	}
		
		//generic methods
		public static WebElement getElement(By locator) {
			return driver.findElement(locator);
		}
		
		public static List<String> getDropDownOptionsList(By locator) {
			Select select=new Select(getElement(locator));
			List<WebElement> optionsList=select.getOptions();
			//create one string array list to store the text of all drop down options
			List<String> optionsTxtList=new ArrayList<String>();
			System.out.println(optionsList.size());
			
			for (WebElement e:optionsList) {
				String text=e.getText();
				optionsTxtList.add(text);
						}
			return optionsTxtList;
			
		}
		
		public static void selectDropDownValue(By locator, String value) {
			Select select=new Select(getElement(locator));
			List<WebElement> optionsList=select.getOptions();
			for(WebElement e:optionsList) {
				String text=e.getText();
				if(text.contains(value)) {
					e.click();
					break;
				}
			}
		}

}
