package Com.ORANGE.TestCases;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.ITestContext;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Com.ORANGE.Kavish.Utilities.Read_Excel;
import Com.ORANGE.Kavish.Utilities.Read_File;
import Com.ORANGE.Kavish.Utilities.Take_Screenshot;

public class BaseClass_1 {

	public static WebDriver driver;  
	
	public Take_Screenshot ts;
	
	public Read_Excel Excel = new Read_Excel();                                        // Read Properties File
	String username = Excel.getData("Sheet1", 0, 1);
	String UserPass = Excel.getData("Sheet1", 1, 1);
	
	Read_File RC = new Read_File();                                                   // Read Properties File
	public String URL = RC.readfile();

	

	public static ExtentReports  ExtentReports;                                       // TO create report
	public static String Report_Sub_Folder;
	public static com.aventstack.extentreports.ExtentTest  ExtentTest;
	
	@Parameters("browser")
	@BeforeTest
	public void Setup(ITestContext context, String br) throws Exception { 

		System.out.print("1");
		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\ORANGE\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			Thread.sleep(5000);

		}
		driver.get(URL);
		Thread.sleep(3000);

		driver.manage().window().maximize();
	
		ExtentTest =ExtentReports.createTest(context.getName());
		Capabilities  capabilities =((RemoteWebDriver)driver).getCapabilities();

		String Device= capabilities.getBrowserName()+" "+capabilities.getBrowserVersion();
		ExtentTest.assignDevice(Device);
		String Author=context.getCurrentXmlTest().getParameter("Author");
		ExtentTest.assignAuthor(Author);

		
	}

	@AfterTest
	public void TearDown() {
		driver.close();
	}

	@AfterMethod
	public void After_TC_Failure(Method M, ITestResult result) throws IOException {
		ts  = new Take_Screenshot();
		
		if (result.getStatus() == ITestResult.FAILURE) {
			String ScreenshotPath = ts.TS(result.getTestContext().getName() + "//" + result.getMethod().getMethodName());
			String path = Take_Screenshot.dest;
			System.out.println("ScreenShotPath - " + path);
			
			ExtentTest.addScreenCaptureFromPath(path)	;
			Throwable Error_msg_of_Console = result.getThrowable();

			System.out.println("Error_msg_of_Console : "+Error_msg_of_Console);
			ExtentTest.fail(Error_msg_of_Console);
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			ExtentTest.pass(M.getName() + " method is Passed");
			
		}
		
//		ExtentTest.assignCategory(M.getAnnotation(Test.class).groups());
	
	}
	
	
	@BeforeSuite
	public void Initialize_ExtentReprts() {
		
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd.MM.yyyy_HH.mm.ss");                         // String formattedDate=myDateObj.format(myFormatObj);
		Report_Sub_Folder = myDateObj.format(myFormatObj);
		
		ExtentReports = new ExtentReports();
		ExtentSparkReporter SparkReporter_Alltest = new ExtentSparkReporter("Report\\Report-"+Report_Sub_Folder+"\\ORANGE_TestCases.html");
		ExtentReports.attachReporter(SparkReporter_Alltest);
		SparkReporter_Alltest.config().setTheme(Theme.DARK);
		//to print the specific information in Report
		ExtentReports.setSystemInfo("Java_Version", System.getProperty("java.version"));
		ExtentReports.setSystemInfo("OS", System.getProperty("os.name"));
		
	}
	
	@AfterSuite
	public void Generate_ExtentReprts() {
		
		ExtentReports.flush();
	}
	
}