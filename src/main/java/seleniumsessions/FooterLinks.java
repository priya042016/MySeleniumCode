package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterLinks {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		List<WebElement> footers=driver.findElements(By.xpath("//div[contains(@class, 'navFooterCopyright')]//a"));
		for(WebElement e:footers) {
			String text=e.getText();
			System.out.println(text);
		}
	}

}
