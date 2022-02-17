package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.List;

public class RelativeLocatorsConcept {

	static WebDriver driver;
	public static void main(String[] args) {
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			driver.get("https://www.aqi.in/dashboard/india");
			WebElement ele=driver.findElement(By.linkText("New-Delhi, India"));
			
			String rank=driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText();
			System.out.println(rank);
			
			String AQIIN=driver.findElement(with(By.tagName("p")).toRightOf(ele)).getText();
			System.out.println(AQIIN);
			
			String belowCity=driver.findElement(with(By.tagName("p")).below(ele)).getText();
			System.out.println(belowCity);
			
			String abvCity=driver.findElement(with(By.tagName("p")).above(ele)).getText();
			System.out.println(abvCity);
			
			String name = driver.findElement(with(By.tagName("p")).near(ele)).getText();
			System.out.println(name);
			
			
			List<WebElement> aboveList = driver.findElements(with(By.tagName("p")).above(ele));
			for(WebElement e : aboveList) {
				System.out.println(e.getText());
			}

	}

}
