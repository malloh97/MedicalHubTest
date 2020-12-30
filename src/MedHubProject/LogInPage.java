package MedHubProject;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestData.TestBase;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;


    
public class LogInPage extends TestBase {
	
	
	
	public LogInPage() throws IOException 
	{
		super();
	}

	
	@BeforeMethod
	public void setup(Method method) throws ATUTestRecorderException, IOException
	{
		recorder = new ATUTestRecorder("D:\\Users\\ahmad\\eclipse-workspace\\Qiotic_Projects\\VideosRecorder",method.getName(),false);
		recorder.start();
		ChromeOptions option = new ChromeOptions();
		recorder.start();
		option.addArguments("--incognito");
	    System.setProperty("webdriver.chrome.driver","C:\\Users\\ahmad\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		driver = new ChromeDriver(option);
		driver.get("https://gb.qiotic.info/");
        driver.manage().window().maximize();
        driver.findElement(By.id("cky-btn-accept")).click();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        
	}
	
	@AfterMethod
	public void teardown(Method method) throws ATUTestRecorderException, IOException
	{
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE );
		FileUtils.copyFile(srcfile, new File("D:\\Users\\ahmad\\eclipse-workspace\\Qiotic_Projects\\Snapshots\\"+method.getName()+".png"));
       	
        recorder.stop();
        driver.quit();
		
	}
	
	@Test(priority=1, groups= {"SignUp"})
	public void SignUpCheck(Method method) throws IOException
	{
		WebElement list = driver.findElement(By.xpath("//ul[@class='header-dropdown']"));
		list.findElements(By.tagName("a")).get(0).click();
		driver.findElement(By.id("First name")).sendKeys(prop.getProperty("Firstname"));
		driver.findElement(By.id("last_name")).sendKeys(prop.getProperty("Lastname"));
		driver.findElement(By.id("phone_number")).sendKeys(prop.getProperty("Phone"));
		driver.findElement(By.id("company_name")).sendKeys(prop.getProperty("Company"));
		WebElement employees = driver.findElement(By.id("number_of_employees"));
		Select select = new Select(employees);
		select.selectByIndex(1);
		
		driver.findElement(By.id("email")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("rpassword")).sendKeys(prop.getProperty("rpassword"));
		
		WebElement areas = driver.findElement(By.id("section"));
		Select Area = new Select(areas);
		Area.selectByIndex(3);
		
		WebElement jobs = driver.findElement(By.id("job_title"));
		Select Job = new Select(jobs);
		Job.selectByValue("10");
		
		WebElement Countries = driver.findElement(By.id("country"));
		Select contry = new Select(Countries);
		contry.selectByValue("1");
		driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
		
		boolean ActualResault = driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed();
		Assert.assertTrue(ActualResault);
		
		
	}
	
	@Test(priority=2, groups= {"SignUp"})
	public void FailedLogInCheck() throws ATUTestRecorderException
	{
		WebElement list = driver.findElement(By.xpath("//ul[@class='header-dropdown']"));
		list.findElements(By.tagName("a")).get(1).click();
		driver.findElement(By.id("email")).sendKeys("ahmadmalloh97@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456789");
		driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
		boolean Actual = driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed();
		boolean Expected = true; 
		Assert.assertEquals(Actual, Expected);
	}
	
	@Test(priority=3, groups= {"SignUp"}, dataProvider="MyData", enabled=false) 
	public void LogInCheck(String username, String password) 
	{
		WebElement list = driver.findElement(By.xpath("//ul[@class='header-dropdown']"));
		list.findElements(By.tagName("a")).get(1).click();
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
	}
	
	@DataProvider
	public Object[][] MyData()
	{
		Object[][] data = new Object[4][2];
		data[0][0]=prop.getProperty("data[0][0]");
		data[0][1]=prop.getProperty("data[0][1]");
		data[1][0]=prop.getProperty("data[1][0]");
		data[1][1]=prop.getProperty("data[0][1]");
		data[2][0]=prop.getProperty("data[0][0]");
		data[2][1]=prop.getProperty("data[2][1]");
		data[3][0]=prop.getProperty("data[1][0]");
		data[3][1]=prop.getProperty("data[3][1]");
		
		return data;
	}
	
	
	
}
