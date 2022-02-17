package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadPopUp {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		
		//type="file" should be there in html DOM to upload the file. else, we need to raise bug and ask the 
		//dev to add this as this will block the testing.
		driver.findElement(By.name("upfile")).sendKeys("C:\\Users\\Priya\\Desktop\\error.PNG");

	}

}
