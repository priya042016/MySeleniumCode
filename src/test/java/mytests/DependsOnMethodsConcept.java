package mytests;

import org.testng.annotations.Test;

public class DependsOnMethodsConcept {
	@Test
	public void logintest() {
		System.out.println("Login test");
		int i=9/0;//ArithmeticException
	}
	@Test(dependsOnMethods="logintest")//if logintest() fails, then this method will be skipped.
	public void searchTest() {
		System.out.println("Search test");
	}
	@Test(dependsOnMethods="logintest")//if logintest() fails, then this method will be skipped.
	public void logoutTest() {
		System.out.println("logout test");
	}
	
	//Best Practice:
	//1. Tests should be independent. dont create dependancy. if the tc is failed, then the dependant tcs will be skipped.
	//2. try to avoid priority. all tcs are important.
	//3. always define the assertion. act vs exp.
	
	/*Test Result
	 * Default suite
Total tests run: 3, Failures: 1, Skips: 2
	 */
	

}
