package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LanguageLinks {

	
		static WebDriver driver;

		public static void main(String[] args) {
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
			driver.get("https://www.google.co.in/");
			
			//click on language
			By lang=By.xpath("//div[@id=\"SIvCob\"]/a");
			clickOnLink(lang, "English");
			
			//click on footer1
			By footer1=By.xpath("//div[@class=\"KxwPGc SSwjIe\"]//a");
			clickOnLink(footer1, "Terms");
			
						
					

	}
		//generic method
		
		public static void clickOnLink(By locator, String linkText) {
			List<WebElement> langList=driver.findElements(locator);
			System.out.println(langList.size());
			for(WebElement e:langList) {
				String text=e.getText();
				if(text.contains(linkText)) {
					e.click();
					break;
				}
			}
			
		}

}
