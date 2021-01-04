package MedDashborad;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import atu.testrecorder.ATUTestRecorder;

public class TestBase {
	
	 public static WebDriver driver;
	 public static ATUTestRecorder recorder;
	 public static ExtentReports extent;
	 public static ExtentTest test; 
	 
	 public void Started()
		{
			System.out.println("Start Testing");
			extent = new ExtentReports("D:\\Users\\ahmad\\eclipse-workspace\\Qiotic_Projects\\TestReport\\index.html", true);
			extent.addSystemInfo("OS", "Windows");
			extent.addSystemInfo("Tester", "Ahmad");
			extent.addSystemInfo("TestingFramwork", "TestNG");
		}
	 
	 public void Finished()
		{
			extent.flush();
			System.out.println("The Testing is Finished");
		}
	 
	 

}
