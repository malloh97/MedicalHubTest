package MedDashborad;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class AdminPanelCMSPages extends TestBase {
	
	@BeforeSuite
	public void StartedTesting()
	{
    	Started();
	}
    
	
	@AfterSuite
	public void FinishedTesting()
	{
		Finished();
	}

	@BeforeMethod
	public void setup(Method method) throws ATUTestRecorderException
	{
		test = extent.startTest(method.getName());
		recorder = new ATUTestRecorder("D:\\Users\\ahmad\\eclipse-workspace\\Qiotic_Projects\\TestReport",method.getName(),false);
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
	
	@AfterMethod
	public void teardown(ITestResult result, Method method) throws ATUTestRecorderException
	{
		recorder.stop();
		if (result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(LogStatus.PASS, "<a href='"+result.getName()+".mov" + "'><span class='lable info'>Download Video</span></a>");
		}
		else if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(LogStatus.FAIL,"<a href='"+result.getName()+".mov" + "'><span class='lable info'>Download Video</span></a>");
		}
		else 
			test.log(LogStatus.SKIP,"Test Skipped");
		
		driver.quit();
	}
	
	@Test(priority=1)
	public void ShowEntiersCMSPages()
	{
		driver.findElement(By.xpath("//span[text()='CMS Pages']")).click();
		WebElement show = driver.findElement(By.xpath("//select[contains(@class,'custom-select')]"));
		Select select = new Select(show);
		select.selectByValue("25");
	}
	

	@Test(priority=2) 
	public void SearchTextBoxCMSPages()
	{
		driver.findElement(By.xpath("//span[text()='CMS Pages']")).click();
		WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
		search.sendKeys("3");
	}
	
	@Test(priority=3) 
	public void ShowButtonCMSPages()
	{
		driver.findElement(By.xpath("//span[text()='CMS Pages']")).click();
		driver.findElement(By.xpath("//a[@title='View']")).click();
		boolean Actual = driver.findElement(By.xpath("//input[@value='CMS Page #1']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=4)
	public void EditButtonCMSPages()
	{
		driver.findElement(By.xpath("//span[text()='CMS Pages']")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		driver.findElement(By.id("title_en")).clear();
		driver.findElement(By.id("title_en")).sendKeys("CMS Page#1");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	}
	
	@Test(priority=5)
	public void DownloadPDFCMSPages()
	{
		driver.findElement(By.xpath("//span[text()='CMS Pages']")).click();
		driver.findElement(By.xpath("//span[text()='Excel']")).click();
	}
	
	@Test(priority=6)
	public void DownloadCSVCMSPages()
	{
		driver.findElement(By.xpath("//span[text()='CMS Pages']")).click();
		driver.findElement(By.xpath("//span[text()='CSV']")).click();
	}
	
    @Test(priority=7)
	public void DownloadExcelCMSPages()
	{
		driver.findElement(By.xpath("//span[text()='CMS Pages']")).click();
		driver.findElement(By.xpath("//span[text()='Excel']")).click();
	}

    @Test(priority=8)
	public void AddCMSPages()
	{
		driver.findElement(By.xpath("//span[text()='CMS Pages']")).click();
		driver.findElement(By.xpath("//a[text()='Add New']")).click();
		driver.findElement(By.id("title_en")).sendKeys("CMS Pages#2");
		driver.findElement(By.id("title_ar")).sendKeys("CMS Pages#2");
		driver.findElement(By.name("content_en")).sendKeys("TestContect");
		driver.findElement(By.name("content_ar")).sendKeys("TestContect");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	}


	@Test(priority=9) 
	public void DeleteButtonCMSPages()
	{
		driver.findElement(By.xpath("//span[text()='CMS Pages']")).click();
		driver.findElement(By.xpath("(//a[@title='Delete'])[2]")).click();
		Set<String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		String MoveTo = it.next();
		driver.switchTo().window(MoveTo);
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
	}
	
	
	
	



	


}
