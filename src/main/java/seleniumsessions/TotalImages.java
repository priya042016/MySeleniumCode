package seleniumsessions;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalImages {

		static WebDriver driver;

		public static void main(String[] args) {
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
			driver.get("https://www.amazon.com/");
			
			//WAP:
			//1.to find total no. of Images
			//2. print the alt values of images
			//3. print the src value of each image
			
			
			//1. total no. of images
			List<WebElement> imagesList=driver.findElements(By.tagName("img"));
			System.out.println("Total images:"+imagesList.size());
			
			//2. print the alt values of images
//			int c=0;
//			for(WebElement e:imagesList) {
//				String altValue=e.getAttribute("alt");
//				String srcValue=e.getAttribute("src");
//				if(!altValue.isBlank()) {
//				System.out.println(c+":"+altValue+": "+ srcValue);
//				}
//								
//				c++;
//				}
			
			By links=By.tagName("a");
			By images=By.tagName("img");
			System.out.println(getElementsCount(links));
			System.out.println(getElementsCount(images));
			
			//validation
			if(getElementsTextList(links).contains("Registry"));
			{
				System.out.println("Registry is present");
			}
			//get attribute list
			//System.out.println(getElementsAttributeList(images, "src"));
			//System.out.println(getElementsAttributeList(images, "alt"));
			System.out.println(getElementsAttributeList(links, "href"));
			
		}

			
		//generic methods
		public static List<WebElement> getElements(By locator) {
			return driver.findElements(locator);
		}
		
		public static int getElementsCount(By locator) {
			return getElements(locator).size();
			
		}
		
		public static void printElementsText(By locator) {
			List<WebElement> elementList=getElements(locator);
			for(WebElement e:elementList) {
				String text=e.getText();
				System.out.println(text);
			}
		}
			/**
			 * This method will return the list of element's text
			 * @param locator
			 * @return
			 */
			public static List<String> getElementsTextList(By locator) {
				List<WebElement> elementList=getElements(locator);
				//empty string arraylist to store the text values
				List<String> eleTextList=new ArrayList<String>();
				for(WebElement e:elementList) {
					String text=e.getText();
					if(!text.isEmpty()) {
					eleTextList.add(text);
					 }
					}
				return eleTextList;
					
				
			}
			/**
			 * This method will return the element's attribute values
			 * @param locator
			 * @return
			 */
			
			public static List<String> getElementsAttributeList(By locator, String attrName) {
				List<WebElement> eleList=getElements(locator);
				
				List<String> eleAttrList=new ArrayList<String>();
				for(WebElement e:eleList) {
					String attrVal=e.getAttribute(attrName);
					eleAttrList.add(attrVal);
					
				}
				return eleAttrList;
			}
		
		
		
		
}





