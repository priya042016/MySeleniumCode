package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QuitVsClose {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();//session ID a102a36e78d0f53c5a6a04a32d348c7e
		driver.get("https://www.google.com");//a102a36e78d0f53c5a6a04a32d348c7e
		String title=driver.getTitle();//enter title
		System.out.println("title is"+title);//capture title
		
		if (title.equals("Google")) {
			System.out.println("Title is correct");
		}
		else {
			System.out.println("Incorrect title");
		}
		driver.close();
		//driver.quit();//a102a36e78d0f53c5a6a04a32d348c7e
		//driver.getTitle();//NoSuchSessionException: Session ID is null after driver.quit()// NoSuchSessionException: invalid Session ID for close()
													//sessino ID is not null for close(). its same but its expired after close(). so coming as invalid session ID
		
		driver= new ChromeDriver();//new session ID is created, b2add77358e34c9bdaa38aaa786e4ca0
		driver.getTitle();//b2add77358e34c9bdaa38aaa786e4ca0
		
	}

}
