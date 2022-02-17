package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtility {
	
	private WebDriver driver;//default value is null
	/**
	 * This method is used to initialize the driver based on the browser passed
	 * @param browser
	 * @return Webdriver
	 */
		
	public WebDriver launchBrowser(String browser) {
		
		System.out.println("Browser is: "+browser);
		
//		if (browser.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Priya\\drivers\\chromedriver.exe");
//			driver=new ChromeDriver();
//			
//		}else if (browser.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Priya\\drivers\\geckodriver.exe");
//			driver= new FirefoxDriver();
//		}else {
//			System.out.println("Please pass correct browser");
//		}
//		return driver;
//		
		
		//using switch case
		
		switch (browser) {
		case "chrome":
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Priya\\drivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			//return driver;
			break;
		
		case "firefox":
			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Priya\\drivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			//return driver;
			break;
						
		default:
				System.out.println("please pass right browser");
				//return driver;
				break;
						
		}
		return driver;
		
	}
		/**
		 * This gives the URL
		 * @param url
		 */
		public void enterUrl(String url) {
			System.out.println("Url is: "+url);
			
			if (url.contains("http") || (url.contains("https"))) {
				driver.get(url);
			}
			else {
				System.out.println("Incorrect url");
				try {
					throw new Exception("Missing http or https");
				}
				catch (Exception e) {
					
				}
			}
						
		}
		
		public String getPageTitle() {
				return driver.getTitle();
		
					
		}
		
		public String getPageUrl() {
			return driver.getCurrentUrl();
		}
		
		public void quitBrowser() {
			driver.quit();
		}
		
		public void closeBrowser() {
			driver.close();
		}
		
			
		}
