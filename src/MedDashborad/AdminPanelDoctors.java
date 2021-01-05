package MedDashborad;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class AdminPanelDoctors extends TestBase {
	
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
	

	@Test(priority=1, enabled=false)
	public void ShowEntiersDoctors()
	{
		WebElement Slider = driver.findElement(By.xpath("//span[text()='Slider']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", Slider);
		driver.findElement(By.xpath("//span[text()='Doctors']")).click();
		driver.findElement(By.xpath("//span[text()='Specialization']")).click();
		WebElement show = driver.findElement(By.xpath("//select[contains(@class,'custom-select')]"));
		Select select = new Select(show);
		select.selectByValue("25");
	}
	

	@Test(priority=2, enabled=false) 
	public void SearchTextBoxDoctors()
	{
		WebElement Slider = driver.findElement(By.xpath("//span[text()='Slider']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", Slider);
		driver.findElement(By.xpath("//span[text()='Doctors']")).click();
		driver.findElement(By.xpath("//span[text()='Specialization']")).click();
		WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
		search.sendKeys("4");
	}
	
	@Test(priority=3, enabled=false) 
	public void ShowButtonDoctors()
	{
		WebElement Slider = driver.findElement(By.xpath("//span[text()='Slider']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", Slider);
    	driver.findElement(By.xpath("//span[text()='Doctors']")).click();
		driver.findElement(By.xpath("//span[text()='Specialization']")).click();
		driver.findElement(By.xpath("(//i[contains(@class,'ik')])[24]")).click();
	}
	
	@Test(priority=4, enabled=false) 
	public void EditButtonDoctors()
	{
        WebElement Slider = driver.findElement(By.xpath("//span[text()='Slider']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", Slider);
    	driver.findElement(By.xpath("//span[text()='Doctors']")).click();
		driver.findElement(By.xpath("//span[text()='Specialization']")).click();
		driver.findElement(By.xpath("(//i[contains(@class,'ik')])[23]")).click();
		driver.findElement(By.id("title_en")).clear();
		driver.findElement(By.id("title_en")).sendKeys("Heart Disease");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	}
	
	@Test(priority=5, enabled=false)
	public void DownloadPDFDoctors()
	{
		WebElement Slider = driver.findElement(By.xpath("//span[text()='Slider']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", Slider);
    	driver.findElement(By.xpath("//span[text()='Doctors']")).click();
		driver.findElement(By.xpath("//span[text()='Specialization']")).click();
		driver.findElement(By.xpath("//span[text()='Excel']")).click();
	}
	
	@Test(priority=6, enabled=false)
	public void DownloadCSVDoctors()
	{
		WebElement Slider = driver.findElement(By.xpath("//span[text()='Slider']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", Slider);
    	driver.findElement(By.xpath("//span[text()='Doctors']")).click();
		driver.findElement(By.xpath("//span[text()='Specialization']")).click();
		driver.findElement(By.xpath("//span[text()='CSV']")).click();
	}
	
    @Test(priority=7, enabled=false)
	public void DownloadExcelDoctors()
	{
    	WebElement Slider = driver.findElement(By.xpath("//span[text()='Slider']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", Slider);
    	driver.findElement(By.xpath("//span[text()='Doctors']")).click();
		driver.findElement(By.xpath("//span[text()='Specialization']")).click();
		driver.findElement(By.xpath("//span[text()='Excel']")).click();
	}
	

    @Test(priority=7)
	public void AddDoctors()
	{
    	WebElement Slider = driver.findElement(By.xpath("//span[text()='Slider']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", Slider);
    	driver.findElement(By.xpath("//span[text()='Doctors']")).click();
		driver.findElement(By.xpath("//span[text()='Specialization']")).click();
		driver.findElement(By.xpath("//a[text()='Add New']")).click();
		driver.findElement(By.name("title_en")).sendKeys("Doctors #1");
		driver.findElement(By.name("title_ar")).sendKeys("Doctors #1");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	}


	@Test(priority=8) 
	public void DeleteButtonDoctors()
	{
		WebElement Slider = driver.findElement(By.xpath("//span[text()='Slider']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", Slider);
    	driver.findElement(By.xpath("//span[text()='Doctors']")).click();
		driver.findElement(By.xpath("//span[text()='Specialization']")).click();
		driver.findElement(By.xpath("(//i[contains(@class,'ik')])[25]")).click();
		Set<String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		String MoveTo = it.next();
		driver.switchTo().window(MoveTo);
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
	}
	
	


}
