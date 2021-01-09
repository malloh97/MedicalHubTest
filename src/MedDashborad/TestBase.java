package MedDashborad;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;


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
	 
	 public void before(String name) throws ATUTestRecorderException 
	 {

			test = extent.startTest(name);
			recorder = new ATUTestRecorder("D:\\Users\\ahmad\\eclipse-workspace\\Qiotic_Projects\\TestReport",name,false);
			recorder.start();
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--incognito");
		    System.setProperty("webdriver.chrome.driver","C:\\Users\\ahmad\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
			driver = new ChromeDriver(option);
			driver.get("https://medical.qiotic.info/en/admin/login");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.findElement(By.id("username")).sendKeys("admin");
	        driver.findElement(By.id("password")).sendKeys("123456");
	        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	 }
	 
	 

}
