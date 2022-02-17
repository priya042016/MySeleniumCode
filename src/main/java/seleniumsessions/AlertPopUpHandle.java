package seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPopUpHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		Thread.sleep(3000);
		
		//switching to alert
		Alert alert=driver.switchTo().alert();//Switches to the currently active modal dialog for this particular driver instance. it returns Alert
		
		
		//four methods of alert
		String text=alert.getText();//to get the text on alert
		System.out.println(text);
		alert.accept();//to click on OK button
		//alert.dismiss();//to click on cancel button
		//alert.sendKeys("testing");// to pass values if any text box
		
		
	}

}
