package Com.ORANGE.Kavish.Utilities;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListnerClass extends Take_Screenshot implements ITestListener {

	public void onTestFailure(ITestResult result) {
//		System.out.println(result.getTestContext().getName()+"_"+result.getMethod().getMethodName());
		try {
			TS(result.getTestContext().getName() + "//" + result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
	}

}
 