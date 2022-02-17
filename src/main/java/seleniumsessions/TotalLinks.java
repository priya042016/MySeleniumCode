package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {

		static WebDriver driver;

		public static void main(String[] args) {
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
			driver.get("https://www.amazon.com/");
			
			//WAP:
			//1.to find total no. of links
			//2. print the text of each link(ignore empty or blank text)
			//3. print the href value of each link
			
			
			//1. total no. of links
			List<WebElement> linksList= driver.findElements(By.tagName("a"));//returns dynamic array list of web elements
			System.out.println(linksList.size());
			
			//2. Print text of each link ignoring blank text
			int c=0;//counter to print the index
			for(WebElement e:linksList) {
				String text=e.getText();
				
				if(!text.isEmpty()) {//ignoring blank text
				System.out.println(c+":"+e.getText());
							
				//3. print the href value of each link
				String hrefVal=e.getAttribute("href");
				System.out.println(hrefVal);
				
				c++;
			
			//using for loop:
			
//			for (int i=0; i<linksList.size();i++) {
//				String text=linksList.get(i).getText();
//				if(!text.isBlank()) {
//					System.out.println(i+":"+text);
//					String hrefVal=linksList.get(i).getAttribute("href");
//					System.out.println(hrefVal);

		}
			
				
				
			}
			
			
			
			
			
			
			

	}

}
