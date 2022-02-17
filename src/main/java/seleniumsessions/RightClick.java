package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClick {

		static WebDriver driver;

		public static void main(String[] args) throws InterruptedException {
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
			driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
			WebElement rightClickEle=driver.findElement(By.xpath("//span[text()='right click me']"));
			
			Actions act=new Actions(driver);
			act.contextClick(rightClickEle).perform();
			
			List<WebElement> options=
					driver.findElements(By.xpath("//ul[@class='context-menu-list context-menu-root']/li[contains(@class,'context-menu-icon')]"));
			
			for(WebElement e:options) {
				String text=e.getText();
				if(text.equalsIgnoreCase("Cut")) {
					e.click();
					break;
				}
			}
			
	}

}
