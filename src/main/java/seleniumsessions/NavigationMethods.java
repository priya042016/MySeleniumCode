package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationMethods {

			public static void main(String[] args) {

				WebDriverManager.chromedriver().setup();
				WebDriver driver=new ChromeDriver();
				//driver.get("https://www.google.com");//using get() method
				driver.navigate().to("https://www.google.com");//using navigate().to() method
				System.out.println(driver.getTitle());
								
				//driver.navigate().to("https://www.amazon.com");//using navigate().to() method
				driver.get("https://www.amazon.com");
				System.out.println(driver.getTitle());
				
				driver.navigate().back();
				System.out.println(driver.getTitle());
				
				driver.navigate().forward();
				System.out.println(driver.getTitle());
				
				driver.navigate().back();
				System.out.println(driver.getTitle());
				
				driver.navigate().refresh();//refresh the page
				driver.close();

	}

}
