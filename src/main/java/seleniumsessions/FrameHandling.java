package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandling {

	public static void main(String[] args) {
		
				WebDriverManager.chromedriver().setup();
				
				WebDriver driver=new ChromeDriver();
				driver.get("http://www.londonfreelance.org/courses/frames/index.html");
				//driver.switchTo().frame(2);//index
				//driver.switchTo().frame("main");//name or id
				driver.switchTo().frame(driver.findElement(By.name("main")));//WebElement frameElement
					//get the text of the element inside the frame		
				String header=driver.findElement(By.xpath("/html/body/h2")).getText();
				System.out.println(header);
				
				//come back to the main page 
				driver.switchTo().defaultContent();//Selects either the first frame on the page, or the main document when a page containsiframes.
				driver.switchTo().parentFrame();//Change focus to the parent context. If the current context is the top level browsing context,
													//the context remains unchanged

	}

}
