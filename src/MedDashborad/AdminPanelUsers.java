package MedDashborad;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class AdminPanelUsers {
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
	
	//UserHospital
	
	@Test(priority=2, enabled=false) 
	public void EditButton()
	{
		driver.findElement(By.xpath("//span[text()='Users']")).click();
		driver.findElement(By.xpath("//span[text()='Hospital Users']")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		WebElement city = driver.findElement(By.name("city_id"));
		Select select = new Select(city);
		select.selectByValue("6");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	}
	
	@Test(priority=1, enabled=false)
	public void ShowButton()
	{
		driver.findElement(By.xpath("//span[text()='Users']")).click();
		driver.findElement(By.xpath("//span[text()='Hospital Users']")).click();
		driver.findElement(By.xpath("//a[@title='View']")).click();
	    boolean Actual = driver.findElement(By.xpath("//input[@value='speciality']")).isDisplayed();
	    Assert.assertTrue(Actual);
	}
	
	@Test(enabled=false)
	public void DeleteButton()
	{
		driver.findElement(By.xpath("//span[text()='Users']")).click();
		driver.findElement(By.xpath("//span[text()='Hospital Users']")).click();
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
	    Set<String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		String go = it.next();
		driver.switchTo().window(go);
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
	}
	
	
	//UsersMerchant
	
	@Test(enabled=false)
	public void Showbutton()
	{
		driver.findElement(By.xpath("//span[text()='Users']")).click();
		driver.findElement(By.xpath("//span[text()='Merchant Users']")).click();
		driver.findElement(By.xpath("//a[@title='View']")).click();
	}
	
	@Test 
	public void editbutton()
	{
		driver.findElement(By.xpath("//span[text()='Users']")).click();
		driver.findElement(By.xpath("//span[text()='Merchant Users']")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		WebElement city = driver.findElement(By.name("city_id")); 
		Select select = new Select(city); 
		select.selectByValue("9");
		driver.findElement(By.id("email")).sendKeys("ahmad@gmail.com");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	}
	
	
	
	
	
	
	
	
	
	

}
