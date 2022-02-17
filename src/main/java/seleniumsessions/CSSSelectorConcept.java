package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CSSSelectorConcept {


		static WebDriver driver;
		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			
			driver=new ChromeDriver();
			driver.get("https://demo.opencart.com/index.php?route=account/login");
			
			//1. by id. use # for id
			By.cssSelector("input#input-email");//can or cannot have html tag in the beginning. both will work
			
			//2. by class. use . for class
			By.cssSelector("input.form-control");
			
			//3. when id and name is not there
			By.cssSelector("input[type='submit'][value='Login']");
			//with multiple class name separated by comma
			By.cssSelector(".form-control.private-form__control.login-email");//replace the space with comma
			By.className(".form-control.private-form__control.login-email");//this will not work as the By.className can have only one class
			By.xpath("//input[@class='form-control private-form__control login-email']"); //this will work using xpath
			
			//4. contains
			By.cssSelector("input[id*=email]");//use * for contains
			
			//5. starts with
			By.cssSelector("input[id^=input]");// use ^ for starts with
			
			//6. ends with
			By.cssSelector("input[id$=email]");//use $ for ends with
			
			//7. parent to child:
			
			By.cssSelector("div#content >div']");//use > from parent to child. this will give the direct child
			By.cssSelector("div#content div");//this space will give both direct and indirect child
			
			//8. child to parent is not available in CSS. No backward traversing.
			
			//9. text() function is not available in css. so cannot handle Web tables
			
			//10. SVG element does not support CSS. it supports only xpath
			
			//11. sibling: only following-sibling is allowed:
			
			By.cssSelector("div.form-group>label+input");// use + to get all the following siblings. No preceding- sibling concept here
			
			//12. indexing:
			By.cssSelector("ul.footer-nav li:nth-of-type(2)");//use nth-of-type to go to particular index
			
			
			
			
			
			

	}

}
