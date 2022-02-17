package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WDMConcept {

	public static void main(String[] args) {
		//WebDriverManager.chromedriver().setup();
		
		//WebDriverManager.chromedriver().browserVersion("87.0").setup();//for backward compatability
		//WebDriver driver=new ChromeDriver();
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		
		driver.get("http://www.google.com");
		driver.quit();

	}

}
