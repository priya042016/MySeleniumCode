package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterAccount {

	public static void main(String[] args) {
	BrowserUtility br=new BrowserUtility();
	
	WebDriver driver=br.launchBrowser("chrome");
	br.enterUrl("https://demo.opencart.com/index.php?route=account/login");
	driver.manage().window().maximize();
	System.out.println(br.getPageTitle());
	ElementUtil el=new ElementUtil(driver);
	
	//By locators
	By register=By.linkText("Register");
	By FName=By.id("input-firstname");
	By LName=By.id("input-lastname");
	By eMail=By.id("input-email");
	By phone=By.id("input-telephone");
	By pwd=By.id("input-password");
	By cpwd=By.id("input-confirm");
//	By rbtnY=By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input");
	By rbtnN=By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input");
	By chkbox=By.xpath("//*[@id=\"content\"]/form/div/div/input[1]");
	By continueBtn=By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
	//By createdMsg=By.linkText("Your Account Has Been Created!");
	By createdMsg=By.xpath("//*[@id=\"content\"]/h1");
	
	
	
	el.doClick(register);
	el.doSendKeys(FName, "pri");
	el.doSendKeys(LName, "s");
	el.doSendKeys(eMail, "spri3@gmail.com");
	el.doSendKeys(phone, "1234567892");
	el.doSendKeys(pwd, "test@123");
	el.doSendKeys(cpwd, "test@123");
	el.doClick(rbtnN);
	el.doClick(chkbox);
	if(el.doIsEnabled(createdMsg)) {
		el.doClick(continueBtn);
	}
	
	System.out.println(el.doGetText(createdMsg));
	if(el.doGetText(createdMsg).equalsIgnoreCase("Your Account Has Been Created!")) {
		System.out.println("Success---test case passed");
	}
	else {
		System.out.println("failed");
	}
	
	
	}

}
