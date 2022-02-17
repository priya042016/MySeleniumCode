package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElementConcept {

//interview question to capture SVG element
	//normal xpath concept will not work for SVG (Scalar Vector Graphs) element
		//use local-name() and name() in the xpath. these are only applicable for SVG elements
	
		static WebDriver driver;
		public static void main(String[] args) throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			
			driver=new ChromeDriver();
			driver.get("https://petdiseasealerts.org/forecast-map#/");
			
			//tc-1: to mouse over all states and click on particular state
			String svgxpath="//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='states']//*[name()='g']//*[name()='path']";
			List<WebElement> stateGraphList=driver.findElements(By.xpath(svgxpath));
			//create action class to mousehover on the states in the graph
			
			Actions act=new Actions(driver);
			
			for(WebElement e:stateGraphList) {
				act.moveToElement(e).perform();
				Thread.sleep(1000);
				String nameAttr=e.getAttribute("name");//since there is no text in the DOM
				System.out.println(nameAttr);
				if(nameAttr.equals("Arizona")) {
				//e.click();//org.openqa.selenium.ElementNotInteractableException:
					act.click(e).perform();//perform is mandatory for action class
					Thread.sleep(2000);
					break;
				}
			}
			
			//tc-2: to get the inter states of the above clicked state
//			String Arizonaxpath=
//					"//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='states']//*[name()='g' and @id='Arizona']//*[name()='path']";
//			WebElement Arizonastate=driver.findElement(By.xpath(floridaxpath));
//			
//			//floridastate.click();
//			act.click(floridastate);
//			Thread.sleep(3000);
//			
			List<WebElement> countiesList=
					driver.findElements(By.xpath
							("//*[local-name()='svg' and @id=\"map-svg\"]//*[name()='g' and @id='states']//*[name()='g' and @id='arizona']//*[name()='g' and @class='counties']//*[name()='path']"));
						
						
			for(WebElement e:countiesList) {
				act.moveToElement(e).perform();
				Thread.sleep(1000);
				String countyid=e.getAttribute("id");//since there is no text in the DOM
				System.out.println(countyid);
				if(countyid.equals("4017")) {
				//e.click();//org.openqa.selenium.ElementNotInteractableException:
				act.click(e).perform();
				break;
				}
			}

		}

}
