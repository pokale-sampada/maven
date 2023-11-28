package Com.ORANGE.Kavish.Utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.google.common.io.Files;
import Com.ORANGE.TestCases.BaseClass_1;

public class Take_Screenshot extends BaseClass_1 {
	public static String Destination;
	public static String image;
	public static String dest;

	// taking Screenshot
	public static String TS(String Filename) throws IOException {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH.mm.ss");                                  // to format date and time to my requirement
		LocalDateTime now = LocalDateTime.now();                                                                     // to get date and time
		image = dtf.format(now);                                                                                     // to set dynamic name for image

		System.out.println(image);
//		System.out.println(System.getProperty("user.dir"));            // to get location of project
		
		String I1 = Filename;
		
		String A = "/Report//" + I1 + "//Report - " + image + ".png";
		dest = System.getProperty("user.dir") + A; 
		System.out.println("dest"+dest);

		// to take a screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);

		// to give desired location
		File destFile = new File(dest);

		// to copy and save pic at desired location
		FileUtils.copyFile(srcFile, destFile);
		return I1;

	}

}
