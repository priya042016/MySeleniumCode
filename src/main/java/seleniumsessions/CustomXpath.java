package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomXpath {

		static WebDriver driver;
		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			
			driver=new ChromeDriver();
			driver.get("https://demo.opencart.com/index.php?route=account/register");
			driver.findElement(By.xpath("(//input[@class='form-control'])[3]"));//index based//3rd element out of 6
			driver.findElement((By.xpath("(//input[@class='form-control'])[position()=3]")));//position based//3rd element out of 6
			
			driver.findElement(By.xpath("(//input[@class='form-control'])[last()]"));//to select the last element//there is no first()
			
			//text()
			driver.findElement(By.xpath("//h1[text()='Register Account']")); 
			
			driver.findElement(By.xpath("(//a[@class='nav_a' and text()='Careers']//ancestor::div)[last()]"));// this is the xpath to give the 
			//immediate div parent when there are multiple parents....the same can be written like
			
			// ..... (//a[@class='nav_a' and text()='Careers']//ancestor::div)[5]// 5th level div parent
			
			driver.findElement(By.xpath("//a[@class='nav_a' and text()='Careers']/parent::li"));// this is the immediate parent
			//or
			driver.findElement(By.xpath("//a[@class='nav_a' and text()='Careers']/.."));// this also gives immediate parent
			
			driver.findElement(By.xpath("//a[@class='nav_a' and text()='Careers']/../.."));//2nd level parent
			
			driver.findElement(By.xpath("(//div[@id='navFooter']//child::ul)[1]/li"));//use double slash to get the indirect child. 
					//this also includes direct child
			
			driver.findElement(By.xpath("//select[@id='Form_submitForm_Country']/option[@value='India']"));//single / gives direct child..the
			//samething can be written as //select[@id='Form_submitForm_Country']/child::option[@value='India']
			
			
	}

}
