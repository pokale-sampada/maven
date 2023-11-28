package Com.ORANGE.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Com.ORANGE.Kavish.PageObjects.PO_1;

public class TC_1 extends BaseClass_1 {
//	
//	public TC_1() {
//		//  Default Constructor
//	}

	@Test
	public void TestDemo() throws Exception   { 
		System.out.println("Hi");

		Thread.sleep(2000);
		System.out.println(URL);

		PO_1 demo = new PO_1(driver);
		demo.element(username);
		
		ExtentTest.info("User Name : "  + username);
		
		demo.lpass(UserPass);
		ExtentTest.info("User Password : "  + UserPass);
		
		demo.lbutton();

		Thread.sleep(4000);

		String AR = driver.getCurrentUrl();
		String ER = "https://e-mails.go4hosting.in/owa/auth/logon.aspx?replaceCurrent=1&url=https%3a%2f%2fe-mails.go4hosting.in%2fowa%2f";
		Assert.assertEquals(ER, AR);

		Thread.sleep(2000);

		System.out.println("HE he he he");

	}

}
