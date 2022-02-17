package mytests;

import org.testng.annotations.Test;

public class invocationCount {
	
	@Test(invocationCount=10)//this test will be executed 10 tims
	public void getUserTest() {
		System.out.println("get User");
	}
	

}
