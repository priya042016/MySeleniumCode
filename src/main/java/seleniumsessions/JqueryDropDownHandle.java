package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDownHandle {

		static WebDriver driver;

		public static void main(String[] args) throws InterruptedException {
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
			driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
			driver.findElement(By.id("justAnInputBox")).click();
			Thread.sleep(3000);
			By choices=By.xpath("//span[@class='comboTreeItemTitle']");
			
			//tc_1: single selection
			//selectChoice(choices, "choice 8");
			
			//tc_2: multi selection
			selectChoice(choices, "choice 1", "choice 2", "choice 9");
			
			//tc_3: all selection
			//selectChoice(choices, "All");
			
			
		
	}
		
		//generic method
		public static List<WebElement> getElements(By locator) {
			return driver.findElements(locator);
		}
		
		public static void selectChoice(By locator, String... value) {
			List<WebElement> choiceList=getElements(locator);
			
			System.out.println(choiceList.size());
			boolean flag=false;
			if(!value[0].equalsIgnoreCase("all")) {
				
			for(WebElement e:choiceList) {
				String text=e.getText();
				//System.out.println(text);
				
				for(int i=0;i<value.length;i++) {
					if(text.equals(value[i])) {
						e.click();
						flag=true;
						break;
						}
					else {
							System.out.println(value[i]+"is not found");
							//flag=false;
							}
					}
				
								
			}
			}
			//for all selection
			else {
				try {
					for(WebElement e:choiceList) {
						e.click();
						flag=true;
							}
					}
					catch(ElementNotInteractableException e) {
						System.out.println("choices are over..");
					}
				}
			if(flag==false) {
				System.out.println("choice is not available: "+value[0]);
				}
					
				}
			}
		


