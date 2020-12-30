package MedDashborad;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class AdminPanelproducts {
	
	WebDriver driver;
	ATUTestRecorder recorder;
	
	
	@BeforeMethod
	public void setuo(Method method) throws ATUTestRecorderException
	{
		recorder = new ATUTestRecorder("D:\\Users\\ahmad\\eclipse-workspace\\Qiotic_Projects\\VideosRecorder",method.getName(),false);
		recorder.start();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--incognito");
	    System.setProperty("webdriver.chrome.driver","C:\\Users\\ahmad\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		driver = new ChromeDriver(option);
		driver.get("https://medical.qiotic.info/en/admin/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//driver.manage().deleteAllCookies();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	}
	
	@AfterMethod
	public void teardown() throws ATUTestRecorderException
	{
		recorder.stop();
		driver.quit();
	}
	
	
	@Test(enabled=false)
	public void ShowButton()
	{
		driver.findElement(By.xpath("//span[text()='Products']")).click();
		driver.findElement(By.xpath("//span[text()='Categories']")).click();
		driver.findElement(By.xpath("//a[@title='View']")).click();
		boolean Actual = driver.findElement(By.id("title")).isDisplayed();
		Assert.assertTrue(Actual);
	
	}
	
	@Test
	public void EditButton()
	{
		driver.findElement(By.xpath("//span[text()='Products']")).click();
		driver.findElement(By.xpath("//span[text()='Categories']")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		driver.findElement(By.id("title_en")).clear();
		driver.findElement(By.id("title_en")).sendKeys("test");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	}
	

}
