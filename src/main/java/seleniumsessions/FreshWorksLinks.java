package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FreshWorksLinks {

		static WebDriver driver;

		public static void main(String[] args) {
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
			driver.get("https://www.freshworks.com/");
			ElementUtil ele=new ElementUtil(driver);
			
			By footer=By.xpath("//ul[@class=\"footer-nav\"]//a");
			ele.clickOnLink(footer, "Careers");
			
			By copyright=By.xpath("//div[@class=\"footer-copyrights\"]//a");
			ele.clickOnLink(copyright, "Security");

	}

}
