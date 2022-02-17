package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public static void main(String[] args) {
	
		BrowserUtility br=new BrowserUtility();
		WebDriver driver=br.launchBrowser("chrome");
		
		br.enterUrl("https://demo.opencart.com/index.php?route=account/login");
		System.out.println(br.getPageTitle());
		
		//By locators
		By emailId=By.id("input-email");
		By pwd=By.id("input-password");
		
		//ElementUtil methods
		ElementUtil el=new ElementUtil(driver);
		el.doSendKeys(emailId, "test@gmail.com");
		el.doSendKeys(pwd, "test@123");
		br.closeBrowser();

	}

}
