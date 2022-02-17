package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Priya\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");//launch chrome
		String title=driver.getTitle();//enter title
		System.out.println("title is"+title);//capture title
		System.out.println(driver.getCurrentUrl());//gives current url
		System.out.println(driver.getPageSource()); //gives page source);
		
		//verification of title
		if (title.equals("Google"))
		{
			System.out.println("correct title");
		}
		else {
			System.out.println("Incorect title");
		}
		driver.quit();//to close the browser
		
	

	}

}
