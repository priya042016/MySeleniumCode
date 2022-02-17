package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonFootersXpath {

	
		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.amazon.com/");
			
			//to get the link text of Help footer link which is present in the last column as last content
			String helpFooter=driver.findElement(By.xpath("(//div[contains(@class, 'navFooterVerticalRow')]//ul)[last()]//li[last()]")).getText();
		System.out.println(helpFooter);
					
				

}
}
