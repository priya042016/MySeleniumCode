package mytests;

import org.testng.annotations.Test;

public class ExpectedExceptionsConcept {

		@Test(expectedExceptions=ArithmeticException.class)
		public void logintest() {
			System.out.println("Login test");
			int i=9/0;//ArithmeticException// the tc is passed with expectedExceptions. else, it will be failed.
			System.out.println(i);
		}
		@Test(expectedExceptions= {ArithmeticException.class, NullPointerException.class})//for multiple exceptions use {}
		public void searchTest() {
			System.out.println("Search test");
		}
		@Test
		public void logoutTest() {
			System.out.println("logout test");
		}
}

