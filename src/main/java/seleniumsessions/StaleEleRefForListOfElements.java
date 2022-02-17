package seleniumsessions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleEleRefForListOfElements {

		public static void main(String[] args) throws InterruptedException {

			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.freshworks.com/");
			//driver.get("https://demo.opencart.com/index.php?route=account/login");
			
			//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
//			WebElement loc=driver.findElement(By.linkText("Freshdesk"));
//			wait.until(ExpectedConditions.elementToBeClickable(loc));
			Thread.sleep(5000);
			
			JavaScriptUtil js=new JavaScriptUtil(driver);
			//js.drawBorder(null);
			
			//driver.findElement(By.xpath("(//ul[@class='list-unstyled']) [8]//a[text()='About Us']")).click();
			//v1
			//List<WebElement> footerList = 
						//driver.findElements(By.xpath("(//ul[@class='list-unstyled'])[8]//a"));
			
			List<WebElement> footerList = 
					driver.findElements(By.xpath("(//ul[@class='footer-nav'])[1]//a"));
						
						
						
			//Actions act=new Actions(driver);
			for(int i=0; i<footerList.size(); i++) {
				//footerList.get(i).click();
				driver.manage().window().maximize();
				js.drawBorder(footerList.get(i));
				Thread.sleep(2);
				//act.click(footerList.get(i)).perform();
				js.clickElementByJS(footerList.get(i));
				Thread.sleep(2);
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(4));
				wait.until(ExpectedConditions.urlContains("footer"));
				System.out.println(driver.getTitle());
				Thread.sleep(2000);
				driver.navigate().back();
				Thread.sleep(2);
				//v2 v3 v4
				//v2 v3 v4
				footerList = 
						driver.findElements(By.xpath("(//ul[@class='footer-nav'])[1]//a"));
			}
		}

	

	}


