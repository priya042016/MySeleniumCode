package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableConcept {

	
		static WebDriver driver;
		public static void main(String[] args) throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			
			driver=new ChromeDriver();
			driver.get("https://www.w3schools.com/html/html_tables.asp");
			Thread.sleep(3000);  
//			System.out.println(getCompanyName("Roland Mendel"));
//			System.out.println(getCountryName("Roland Mendel"));
//			
//			System.out.println(getRowCount());
//			
//			System.out.println(getColumnCount());
//			System.out.println(getColumnNames());
		
			//interview qn to print the values of particular column
			//*[@id="customers"]/tbody/tr[2]/td[1]//first row of column
			//*[@id="customers"]/tbody/tr[3]/td[1]//second row of column
			//*[@id="customers"]/tbody/tr[7]/td[1]//last row of column
			
//			String befXpath="//*[@id=\"customers\"]/tbody/tr[";
//			String aftXpath="]/td[1]";
			
			//getting column's (row) values
//			
//			for(int i=2; i<=getRowCount();i++) {
//				String combinedXpath=befXpath+i+aftXpath;
//				String text=driver.findElement(By.xpath(combinedXpath)).getText();
//				System.out.println(text);
//			}
			
			//print the entire table
			
//			String befXpath="//*[@id=\"customers\"]/tbody/tr[";
//			String aftXpath="]/td[";//removed hard coded values and supplied with row variale below and appended with "["
//			
//			for(int col=1; col<=getColumnCount(); col++) {
//				
//				for(int row=2; row<=getRowCount();row++) {
//					String combinedXpath=befXpath+row+aftXpath+col+"]";
//					String text=driver.findElement(By.xpath(combinedXpath)).getText();
//					System.out.print(text+" ");
//				
//			}
//				System.out.println();
//			}
			
			// Method 2: print the entire table
			//changing col and row
			
			//*[@id="customers"]/tbody/tr[2]/td[1]
			//*[@id="customers"]/tbody/tr[2]/td[2]
			//*[@id="customers"]/tbody/tr[2]/td[3]
			
		//printing headers
//			
//			List<WebElement> headers=driver.findElements(By.xpath("//th[text()='Company']/parent::tr//following-sibling::th"));
//			for(WebElement e: headers) {
//				String text=e.getText();
//				System.out.print(text+" ");
//			}
//			System.out.println();
//			
//			//important interview qn to print the entire table
//			String befXpath="//*[@id=\"customers\"]/tbody/tr[";
//			String aftXpath="]/td[";//removed hard coded values and supplied with row variale below and appended with "["
			
//			for(int row=2; row<=getRowCount(); row++) {
//				
//				for(int col=1; col<=getColumnCount();col++) {
//					String combinedXpath=befXpath+row+aftXpath+col+"]";
//					String text=driver.findElement(By.xpath(combinedXpath)).getText();
//					System.out.print(text+" ");
//				
//			}
//				System.out.println();
//			}
//			
//			//Method 3: using xpath:
			
			List<WebElement> rowVal=driver.findElements(By.xpath("//table[@id='customers']//tr"));
			//List<String > contactrowVal=new ArrayList<String>();
			System.out.println();
//			for(WebElement e:rowVal) {
//				String text=e.getText();
//				contactrowVal.add(text);
//						}
//			System.out.println(contactrowVal+" ");
			
			for(int i=0; i<rowVal.size(); i++) {
				String text=rowVal.get(i).getText();
				System.out.print(text+" ");
				System.out.println();
			}
			
			//UC-4. getting contact column(col 2) values
			//*[@id="customers"]/tbody/tr[1]/th[2]--header
			
			//*[@id="customers"]/tbody/tr[2]/td[2]--row 1
			//*[@id="customers"]/tbody/tr[3]/td[2]--row 2
			
			String befxpath= "//table[@id=\"customers\"]/tbody/tr[";
			String aftxpath="]/td[2]";
			System.out.println("****************************************************");
			System.out.println("Getting contact column values");
			System.out.println("___________________________________");
			for(int i=2; i<=getRowCount();i++) {
				String combXpath=befxpath+i+aftxpath;
				String text= driver.findElement(By.xpath(combXpath)).getText();
				System.out.println(text);
				
			}
			
						
					
			
	}
				
		
		//generic function
		public static String getCompanyName(String contactName) {
			System.out.println("company name of "+contactName+ "is: ");
			return driver.findElement(By.xpath("//td[text()='"+contactName+"']/preceding-sibling::td")).getText();
		}
		
		public static String getCountryName(String contactName) {
			System.out.println("country name of "+contactName+ "is: ");
			return driver.findElement(By.xpath("//td[text()='"+ contactName +"']/following-sibling::td")).getText();
		}
		
		public static int getRowCount() {
		
			return driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		}
		
		public static int getColumnCount() {
			//System.out.println("column count is:");
			return driver.findElements(By.xpath("//table[@id='customers']//tr/th")).size();
		}
		
		public static List<String >getColumnNames() {
			System.out.println("column Names are:");
			 List<WebElement> cols=driver.findElements(By.xpath("//table[@id='customers']//tr/th"));
			 List<String> colNames=new ArrayList<String>();
			 
			 for(WebElement e:cols) {
				String text= e.getText();
				colNames.add(text);
							 }
			 return colNames;
		}
		
		
		
			
		
		
	}
		
	
			
			



 