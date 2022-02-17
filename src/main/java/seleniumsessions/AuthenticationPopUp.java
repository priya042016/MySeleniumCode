package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticationPopUp {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		//driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");

		//or
		
		String Uname="admin";//Uname and pwd should not have @ to work on this logic
		String Pwd="admin";
		driver.get("http://"+Uname+":"+Pwd+"@the-internet.herokuapp.com/basic_auth");
		//limitation is it doesnt work sometimes in other browser
	}
	//or we can use CDP tool which is there in selenium 4 to pass any kind of Uname and pwd

}
