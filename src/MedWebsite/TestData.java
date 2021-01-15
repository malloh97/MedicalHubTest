package MedWebsite;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;


public class TestData {
	
	public static ATUTestRecorder recorder;
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public void started()
	{
		System.out.println("Testing is Started");
		extent = new ExtentReports("D:\\Users\\ahmad\\eclipse-workspace\\Qiotic_Projects\\MedTestReport\\index.html",true);
		extent.addSystemInfo("Project", "MedicalHub");
		extent.addSystemInfo("OS", "Windows");
		extent.addSystemInfo("Tester", "Ahmad Malloh");
		extent.addSystemInfo("Testing Framwork", "TestNG");
	}

	public void finished()
	{
		System.out.println("Congrats, Testing is Finished");
		extent.flush();
	}
	public void beforetest(String name) throws ATUTestRecorderException
	{
		recorder = new ATUTestRecorder("D:\\Users\\ahmad\\eclipse-workspace\\Qiotic_Projects\\MedTestReport", name, false);
		recorder.start();
		test = extent.startTest(name);
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--incognito");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ahmad\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		driver = new ChromeDriver(option);
		driver.get("https://medical.qiotic.info/en");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public Double CopounDiscount(Double SupTotal)
	{
		Scanner input = new Scanner (System.in);
		Double Total;
		Double Copune = input.nextDouble();
		Total = Copune * SupTotal;
		return Total; 
	}
	
	
}
