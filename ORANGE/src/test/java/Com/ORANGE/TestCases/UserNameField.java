package Com.ORANGE.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Com.ORANGE.Kavish.PageObjects.PO_1;

public class UserNameField extends BaseClass_1{
	
	@Test
	public void TestDemo() throws Exception   { 
		System.out.println("Testing UserName Field :-");

		Thread.sleep(2000);
		System.out.println(URL);

		PO_1 demo = new PO_1(driver);
		demo.element(username);
		demo.lpass(UserPass);
		demo.lbutton();

		

	}

}
