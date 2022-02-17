package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XPathAxes {


		static WebDriver driver;
		public static void main(String[] args) throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			
			driver=new ChromeDriver();
			driver.get("https://www.espncricinfo.com/series/india-in-south-africa-2021-22-1277060/south-africa-vs-india-1st-odi-1277082/full-scorecard");
			
			Thread.sleep(3000);
			
			//String wicketerName=driver.findElement(By.xpath("//a[text()='Temba Bavuma']/parent::td/following-sibling::td/span")).getText();
			//System.out.println(wicketerName);
			
			System.out.println(getWicketTakername("Janneman Malan"));
			//getting batting scorecard
			
			System.out.println(getBattingScoreCard("Temba Bavuma"));
			
			//getting bowling scroecard list
			System.out.println(getBowlingScoreCard("Jasprit Bumrah"));
			
			System.out.println(getBowlingScoreCardWithHeader());
				
			

	}
		
		//generic method:
		
		public static String getWicketTakername(String playerName) {
			WebElement batsMan =driver.findElement(By.xpath("//a[text()='" + playerName +"']/parent::td/following-sibling::td/span"));
			return batsMan.getText();
		}
		/**
		 * this method will return the score card from first Batting table.
		 * @param playerName
		 * @return
		 */
		public static List<String> getBattingScoreCard(String playerName) {
			
			//List<WebElement> scoreCardList=driver.findElements(By.xpath("//a[text()='" + playerName + "']//parent::td/following-sibling::td"));
				//this will give scroe card from Batting and Bowling scroeboard as per xpath
			//(//th[contains(text(),'BATTING')])[1]//ancestor::table//child::td/a[text()='Quinton de Kock']/parent::td/following-sibling::td 
					//(xpath from Batting SCroeboard)
			
			List<WebElement> scoreCardList=
					driver.findElements
						(By.xpath("(//th[contains(text(),'BATTING')])[1]//ancestor::table//child::td/a[text()='" + playerName +"']/parent::td/following-sibling::td"));
			
			
			System.out.println(scoreCardList.size());
			
			List<String> scoreList=new ArrayList<String> ();
			System.out.println("getting the batting score card of: "+playerName);
			
			for(int i=1; i<scoreCardList.size(); i++) {
				String text=scoreCardList.get(i).getText();
				//System.out.println(text);
				scoreList.add(text);
								
			}
			return scoreList;
		}
		
		/**
		 * this method will return the scorecard from first Bowling score table
		 * @param playerName
		 * @return
	 */
		public static List<String> getBowlingScoreCard(String playerName) {
						
			List<WebElement> scoreCardList=
					driver.findElements
						(By.xpath("(//th[contains(text(),'BOWLING')])[1]/ancestor::table[@class='table bowler']//child::td/a[text()='Jasprit Bumrah']/parent::td/following-sibling::td"));
						
			System.out.println(scoreCardList.size());
			
			List<String> scoreList=new ArrayList<String> ();
			System.out.println("getting the bowling score card of: "+playerName);
			
			for(int i=0; i<scoreCardList.size(); i++) {
				String text=scoreCardList.get(i).getText();
				//System.out.println(text);
				scoreList.add(text);
								
			}
			return scoreList;
		}
		
		
		// print the bowlong scorecard details with header
		
		public static List<String> getBowlingScoreCardWithHeader() {
			
			List<WebElement> scoreCardList=
					driver.findElements
						(By.xpath("(//th[contains(text(),'BOWLING')])[1]/ancestor::table[@class='table bowler']//child::tr"));
			
			List<String> scoreList=new ArrayList<String> ();
						
			System.out.println(scoreCardList.size());
			for(WebElement e:scoreCardList) {
				String text=e.getText();
				//System.out.println(text);
				scoreList.add(text);
			}
			
			return scoreList;
			
		}
		

}
