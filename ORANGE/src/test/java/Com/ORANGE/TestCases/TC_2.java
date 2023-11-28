package Com.ORANGE.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import Com.ORANGE.Kavish.PageObjects.PO_1;

public class TC_2 extends BaseClass_1 {

	@Test
	public void Login() throws Exception {
		System.out.println("Hi");

		Thread.sleep(2000);
		System.out.println(URL);

		PO_1 demo = new PO_1(driver);
		demo.element(username);

		ExtentTest.info("User Name : " + username);

		demo.lpass(UserPass);
		ExtentTest.info("User Password : " + UserPass);

		demo.lbutton();

		Thread.sleep(4000);

		String AR = driver.getCurrentUrl();
		String ER = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		Assert.assertEquals(ER, AR);

		Thread.sleep(2000);

		System.out.println("HE he he he");

	}
}
