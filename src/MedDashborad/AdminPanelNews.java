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
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class AdminPanelNews {
	
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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	}
	
	@AfterMethod
	public void teardown(ITestResult result) throws ATUTestRecorderException
	{
		
		recorder.stop();
		driver.quit();
	}
	
	@Test(priority=1, enabled=false)
	public void ShowEntiersBlogs()
	{
		driver.findElement(By.xpath("//span[text()='News & Blogs']")).click();
		driver.findElement(By.xpath("//span[text()='Blogs']")).click();
		WebElement show = driver.findElement(By.xpath("//select[contains(@class,'custom-select')]"));
		Select select = new Select(show);
		select.selectByValue("25");
	}
	

	@Test(priority=2, enabled=false) 
	public void SearchTextBoxBlogs()
	{
		driver.findElement(By.xpath("//span[text()='News & Blogs']")).click();
		driver.findElement(By.xpath("//span[text()='Blogs']")).click();
		WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
		search.sendKeys("4");
		boolean Actual = driver.findElement(By.xpath("//td[text()=' Blog #1 ']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	

	@Test(priority=3, enabled=false) 
	public void ShowButtonBlogs()
	{
		driver.findElement(By.xpath("//span[text()='News & Blogs']")).click();
		driver.findElement(By.xpath("//span[text()='Blogs']")).click();
		driver.findElement(By.xpath("//a[@title='View']")).click();
		boolean Actual = driver.findElement(By.xpath("//input[@value='fasd']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=4, enabled=false)
	public void EditButtonBlogs()
	{
		driver.findElement(By.xpath("//span[text()='News & Blogs']")).click();
		driver.findElement(By.xpath("//span[text()='Blogs']")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		driver.findElement(By.id("title_en")).clear();
		driver.findElement(By.id("title_en")).sendKeys("Blog#1");
		driver.findElement(By.name("image")).sendKeys("C:\\Users\\ahmad\\Downloads\\Translated 05.jpeg");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
	}
	

	@Test(priority=5, enabled=false)
	public void DownloadPDFBlogs()
	{
		driver.findElement(By.xpath("//span[text()='News & Blogs']")).click();
		driver.findElement(By.xpath("//span[text()='Blogs']")).click();
		driver.findElement(By.xpath("//span[text()='Excel']")).click();
	}
	
	@Test(priority=6, enabled=false)
	public void DownloadCSVBlogs()
	{
		driver.findElement(By.xpath("//span[text()='News & Blogs']")).click();
		driver.findElement(By.xpath("//span[text()='Blogs']")).click();
		driver.findElement(By.xpath("//span[text()='CSV']")).click();
	}
	

	@Test(priority=7, enabled=false)
	public void DownloadExcelBlogs()
	{
		driver.findElement(By.xpath("//span[text()='News & Blogs']")).click();
		driver.findElement(By.xpath("//span[text()='Blogs']")).click();
		driver.findElement(By.xpath("//span[text()='Excel']")).click();
	}
	

	@Test(priority=8, enabled=false)
	public void AddBlog()
	{
		driver.findElement(By.xpath("//span[text()='News & Blogs']")).click();
		driver.findElement(By.xpath("//span[text()='Blogs']")).click();
		driver.findElement(By.xpath("//a[text()='Add New']")).click();
		driver.findElement(By.id("title_en")).sendKeys("Blog#1");
		driver.findElement(By.id("title_ar")).sendKeys("Blog#1");
		driver.findElement(By.id("short_content_en")).sendKeys("Testdescription");
		driver.findElement(By.id("short_content_ar")).sendKeys("Testdescription");
		driver.findElement(By.name("content_en")).sendKeys("TestContect");
		driver.findElement(By.name("content_ar")).sendKeys("TestContect");
		driver.findElement(By.id("file")).sendKeys("C:\\Users\\ahmad\\Downloads\\274516447.jpg");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	}


	@Test(priority=9) 
	public void DeleteButton()
	{
		driver.findElement(By.xpath("//span[text()='News & Blogs']")).click();
		driver.findElement(By.xpath("//span[text()='Blogs']")).click();
		driver.findElement(By.xpath("(//a[@title='Delete'])[4]")).click();
		Set<String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		String MoveTo = it.next();
		driver.switchTo().window(MoveTo);
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
