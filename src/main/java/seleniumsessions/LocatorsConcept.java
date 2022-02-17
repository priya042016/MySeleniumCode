package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		//WebElement=By Locator. there are different approaches to create web eleements.
		
		//1. Approach (creating webelements each time and hitting server by driver.
		
//		driver.findElement(By.id("input-email")).sendKeys("pri@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("test@123");
		
		//2. create and store the webelements in a variable
	
//		WebElement emailId=driver.findElement(By.id("input-email"));
//		WebElement password=driver.findElement(By.id("input-password"));
//		
//		emailId.sendKeys("pri@gmail.com");
//		password.sendKeys("test@123");
		
		//3. By Locator: create locators using BY and create webelement whenever is required using it.
		
//		By emailId=By.id("input-email");
//		By pwd=By.id("input-password");
//		
//		WebElement mailId=driver.findElement(emailId);
//		WebElement password=driver.findElement(pwd);
//		
//		mailId.sendKeys("pri@gmail.com");
//		password.sendKeys("test@123");

		//4. By Locator with generic method
//		By emailId=By.id("input-email");
//		By pwd=By.id("input-password");
//		
//		getElement(emailId).sendKeys("pri@gmail.com");
//		getElement(pwd).sendKeys("test@123");
		
		//5. By Locator with getElement and with generic actions:
		
//		By emailId=By.id("input-email");
//		By pwd=By.id("input-password");
//		
//		doSendKeys(emailId, "pri@gmail.com");
//		doSendKeys(pwd, "test@123");
		
		
	//6. By locator with generic actions and getElement in util class
//		
//		By emailId=By.id("input-email");
//		By pwd=By.id("input-password");
//		
//		//create object of ElementUtil class to call its methods.
//		ElementUtil eleUtil=new ElementUtil(driver);
//		eleUtil.doSendKeys(emailId, "pri@gmail.com");
//		eleUtil.doSendKeys(pwd, "test@123");
//		
//		//7. String locator with By, getElement and actions generic method in Util class
//		String eId="input-email";
//		String pwd="input-password";
//		
//		doSendKeys("id", eId, "pri@gmail.com");
//		doSendKeys("id", pwd, "test@123");
		
		//8. using ElementUtil:
//		
//		String eId="input-email";
//		String pwd="input-password";
//		
//		ElementUtil eleUtil=new ElementUtil(driver);
//		eleUtil.doSendKeys("id", eId, "pri@gmail.com");
//		eleUtil.doSendKeys("id", pwd, "test@123");
//		
		
		//By xpath
//		By emailId=By.xpath("//*[@id=\"input-email\"]");
//		By pwd=By.xpath("//*[@id=\"input-password\"]");
//		By loginBtn=By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
//		
//		ElementUtil eleUtil=new ElementUtil(driver);
//		eleUtil.doSendKeys(emailId, "pri@gmail.com");
//		eleUtil.doSendKeys(pwd, "test@123");
//		eleUtil.doClick(loginBtn);
		
		//By linkText
		
//		By register=By.linkText("Register");
//		By header=By.tagName("h2");
//		
//		System.out.println(doGetText(register));
//		System.out.println(doGetText(header));
//		
		//getting entered input value
		By emailId=By.id("input-email");
		doSendKeys(emailId, "pri@gmail.com");
		System.out.println(doGetAttribute(emailId, "value"));
		
		//By loginBtn=By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
//		String att=driver.findElement(emailId).getAttribute("value");
//		System.out.println(att);
		
//		String loginbtntext=driver.findElement(loginBtn).getAttribute("value");
//		System.out.println(loginbtntext);
		
		
		//capturing the paragraph text
		String para=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/p[2]")).getText();
		System.out.println(para);
		
		
		
			

	}
	
	//generic methods
	
	public static boolean doIsEnabled(By locator) {
		return getElement(locator).isEnabled();
	}
	
	public static boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	public static String doGetAttribute(By locator, String attName) {
		return getElement(locator).getAttribute(attName);
				}
	
	public static String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	public static void doClick(By locator) {
	getElement(locator).click();
	}
	
	
	//move these methods to ElementUtil class
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	//overload doSendKeys with string locator 
	
	public static void doSendKeys(String locatortype, String locatorvalue, String value) {//By locator, "inuput-email", "pri@gmail.com"
		getElement(getBy(locatortype, locatorvalue)).sendKeys(value);
		
	}
	
	public static By getBy(String locatortype, String locatorvalue) {
		By locator=null;
		switch (locatortype.toLowerCase()) {
		case "id":
			locator=By.id(locatorvalue);
			break;

		default:
			break;
		}
		return locator;
	}
}


