package seleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorConcept {

	static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		String pagetitle=js.executeScript("return document.title").toString();
		System.out.println(pagetitle);
		
		String alertmsg=getAlertMessage("Selenium Alert");
		System.out.println(alertmsg);
		
		
		JavaScriptUtil jsUtil=new JavaScriptUtil(driver);
		String pageTitle=jsUtil.getTitleByJS();
		System.out.println(pageTitle);
		
	//use different JavaScriptUtil methods
		

	}
//generic method
	
	public static String getAlertMessage(String msg) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		return js.executeScript("alert('"+msg+"')").toString();
		
	}
}
