package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableCheckBox {


		static WebDriver driver;
		public static void main(String[] args) throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			
			driver=new ChromeDriver();
			driver.get("https://selectorshub.com/xpath-practice-page/");
			Thread.sleep(3000);
			driver.manage().window().maximize();
			selectEmployee("Kevin.Mathews");
			selectEmployee("Garry.White");

	}
		//generic method
		public static void selectEmployee(String name) {
			WebElement chkBox=driver.findElement(By.xpath("//a[text()='"+name+"']/parent::td/preceding-sibling::td/child::input"));
			chkBox.click();
		}

}
