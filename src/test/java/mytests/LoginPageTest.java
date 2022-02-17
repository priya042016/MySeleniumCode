package mytests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest {
	
//	@DataProvider
//	public Object[][] loginTestData() {
//		return new Object[][] {
//			{"user1@gmail.com", "user@123"},
//			{"user2@gmail.com", "test@123"},
//			{"admin@gmail.com", "admin@123"},
//			{null, null}
//			};
//			
//	}
//	
//	@Test(dataProvider="loginTestData")
//	public void loginTest(String userName, String password) {
//		
//		//Assert.assertTrue(doLogin("user1@gmail.com", "user1@123"));//this is for single user. use data provider for multi users
//		Assert.assertTrue(doLogin(userName, password));
//	}
//	
//	public boolean doLogin(String userName, String password) {
//		System.out.println("userName is "+ userName);
//		System.out.println("password is "+ password);
//		System.out.println("Login Successful");
//		return true;
//	}


		@DataProvider
		public Object[][] loginTestData() {
			return new Object[][] {
					{ "admin@gmail.com", "admin123" }, 
					{ "cust@gmail.com", "cust123" }, 
					{ "vendor@gmail.com", "vendor123" },
					{ "vendor@gmail.com", "@#@#@" },
					{ "@#@#@#", "vendor123" },
					{ " ", " " },
					{ null, null }
			};
		}

		@Test(dataProvider = "loginTestData")
		public void loginTest(String userName, String password) {
			Assert.assertTrue(doLogin(userName, password));
		}

		public boolean doLogin(String userName, String password) {
			System.out.println("user name: " + userName);
			System.out.println("password: " + password);
			System.out.println("login successful");
			return true;
		}
		
		/*
		 * login successful
user name:  
password:  
login successful
user name: null
password: null
login successful
PASSED: loginTest("admin@gmail.com", "admin123")
PASSED: loginTest("cust@gmail.com", "cust123")
PASSED: loginTest("vendor@gmail.com", "vendor123")
PASSED: loginTest("vendor@gmail.com", "@#@#@")
PASSED: loginTest("@#@#@#", "vendor123")
PASSED: loginTest(" ", " ")
PASSED: loginTest(null, null)

===============================================
    Default test
    Tests run: 7, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 7, Failures: 0, Skips: 0
===============================================

		 * 
		 */

	}
