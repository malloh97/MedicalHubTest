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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class AdminPanelCategorie extends TestBase {
	
	
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
	

	@Test(priority=1)
	public void ShowEntries()
	{
		driver.findElement(By.xpath("//span[text()='Products']")).click();
		driver.findElement(By.xpath("//span[text()='Categories']")).click();
		WebElement show = driver.findElement(By.xpath("//select[contains(@class,'custom-select')]"));
		Select select = new Select(show);
		select.selectByValue("25");
	}
	
	@Test(priority=2) 
	public void SearchTextBox()
	{
		driver.findElement(By.xpath("//span[text()='Products']")).click();
		driver.findElement(By.xpath("//span[text()='Categories']")).click();
		WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
		search.sendKeys("7");
		boolean Actual = driver.findElement(By.xpath("//td[text()=' Medical ']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	
	@Test(priority=3 ,enabled=false)
	public void ShowButton()
	{
		driver.findElement(By.xpath("//span[text()='Products']")).click();
		driver.findElement(By.xpath("//span[text()='Categories']")).click();
		driver.findElement(By.xpath("//a[@title='View']")).click();
		boolean Actual = driver.findElement(By.id("title")).isDisplayed();
		Assert.assertTrue(Actual);
	
	}
	
	@Test(priority=4 ,enabled=false)
	public void EditButton()
	{
		driver.findElement(By.xpath("//span[text()='Products']")).click();
		driver.findElement(By.xpath("//span[text()='Categories']")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		driver.findElement(By.id("title_en")).clear();
		driver.findElement(By.id("title_en")).sendKeys("test");
		driver.findElement(By.id("file")).sendKeys("C:\\Users\\ahmad\\OneDrive\\Desktop\\SmartCart Logo.png");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	}
	
	
	@Test(priority=5 ,enabled=false)
	public void AddCategory()
	{
		driver.findElement(By.xpath("//span[text()='Products']")).click();
		driver.findElement(By.xpath("//span[text()='Categories']")).click();
		driver.findElement(By.xpath("//a[text()='Add New']")).click();
		driver.findElement(By.id("title_en")).sendKeys("Category#1");
		driver.findElement(By.id("title_ar")).sendKeys("Category#1");
		driver.findElement(By.id("file")).sendKeys("C:\\Users\\ahmad\\Downloads\\Translated 05.jpeg");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	}
	
	@Test(priority=6 ,enabled=false)
	public void deletebutton()
	{
		driver.findElement(By.xpath("//span[text()='Products']")).click();
		driver.findElement(By.xpath("//span[text()='Categories']")).click();
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		Set <String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		String MoveTo = it.next();
		driver.switchTo().window(MoveTo);
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
	}


	@Test(priority=7, enabled=false)
	public void DownloadPDF()
	{
		driver.findElement(By.xpath("//span[text()='Products']")).click();
		driver.findElement(By.xpath("//span[text()='Categories']")).click();
		driver.findElement(By.xpath("//span[text()='Excel']")).click();
	}
	
	@Test(priority=8, enabled=false)
	public void DownloadCSV()
	{
		driver.findElement(By.xpath("//span[text()='Products']")).click();
		driver.findElement(By.xpath("//span[text()='Categories']")).click();
		driver.findElement(By.xpath("//span[text()='CSV']")).click();
	}
	

	@Test(priority=9, enabled=false)
	public void DownloadExcel()
	{
		driver.findElement(By.xpath("//span[text()='Products']")).click();
		driver.findElement(By.xpath("//span[text()='Categories']")).click();
		driver.findElement(By.xpath("//span[text()='Excel']")).click();
	}
	
	
	
	
	
	
	
	
}
