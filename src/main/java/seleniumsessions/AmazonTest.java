package seleniumsessions;

public class AmazonTest {

	public static void main(String[] args) {
	BrowserUtility br=new BrowserUtility();
	//br.launchBrowser("chrome");
	br.launchBrowser("firefox");
	br.enterUrl("https://www.amazon.com");
	String title=br.getPageTitle();
	System.out.println("title is:"+title);
	if(title.contains("Amazon")) {
		System.out.println("title is correct");
	}
	else {
		System.out.println("Incorrect title");
	}
	
	String url=br.getPageUrl();
	if(url.contains("amazon")) {
		System.out.println("url is correct");
	}
	else {
		System.out.println("Incorrect title");
	}
	
	br.quitBrowser();
	
	
	
	
	}

}
