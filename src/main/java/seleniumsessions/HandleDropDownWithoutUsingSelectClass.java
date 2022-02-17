package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDownWithoutUsingSelectClass {

	
		static WebDriver driver;

		public static void main(String[] args) throws InterruptedException {
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
			driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
			//By country=By.id("Form_submitForm_Country");
			//By state=By.id("Form_submitForm_State");
			List<WebElement> ctryDropdownList=driver.findElements(By.xpath("//select[@id='Form_submitForm_Country']/option"));
			System.out.println(ctryDropdownList.size());
			
			for (WebElement e:ctryDropdownList) {
				String text=e.getText();
				if (text.contains("India")) {
					e.click();
					break;
				}
			}
			
			

	}

}
