package seleniumsessions;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocatorWebTable {

		static WebDriver driver;
		public static void main(String[] args) {
			
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				
				driver.get("https://www.aqi.in/dashboard/india");
				WebElement eleStatus=driver.findElement(By.xpath("//table[@id='state-table']//td[@class='AQI_text-6']"));
				
				String state=driver.findElement(with(By.tagName("a")).toLeftOf(eleStatus)).getText();
				System.out.println(state);
				
				String AQIIN=driver.findElement(with(By.tagName("td")).toRightOf(eleStatus)).getText();
				System.out.println(AQIIN);
				
					
				String nearRec = driver.findElement(with(By.tagName("td")).near(eleStatus)).getText();
				System.out.println(nearRec);

	}

}
