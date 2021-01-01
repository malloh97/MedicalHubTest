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

public class AdminPanelCity {

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
	public void teardown() throws ATUTestRecorderException
	{
		recorder.stop();
		driver.quit();
	}
	
	@Test(priority=1, enabled=false) 
	public void SearchTextBox()
	{
		driver.findElement(By.xpath("//span[text()='City']")).click();
		WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
		search.sendKeys("7");
		boolean Actual = driver.findElement(By.xpath("//td[text()=' Aqaba ']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=2, enabled=false)
	public void ShowEntries()
	{
		driver.findElement(By.xpath("//span[text()='City']")).click();
		WebElement show = driver.findElement(By.xpath("//select[contains(@class,'custom-select')]"));
		Select select = new Select(show);
		select.selectByValue("25");
	}
	 

	@Test(priority=3, enabled=false) 
	public void ShowButton()
	{
		driver.findElement(By.xpath("//span[text()='City']")).click();
		driver.findElement(By.xpath("//a[@title='View']")).click();
		boolean Actual = driver.findElement(By.xpath("//input[@value='Amman']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	

	@Test(priority=4, enabled=false)
	public void EditButton()
	{
		driver.findElement(By.xpath("//span[text()='City']")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
        driver.findElement(By.id("title")).clear();
        driver.findElement(By.id("title")).sendKeys("amman");
        driver.findElement(By.xpath("//button[text()='Save']")).click();
	}
	

	@Test(priority=5, enabled=false)
	public void DownloadPDF()
	{
		driver.findElement(By.xpath("//span[text()='City']")).click();
		driver.findElement(By.xpath("//span[text()='Excel']")).click();
	}
	
	@Test(priority=6, enabled=false)
	public void DownloadCSV()
	{
		driver.findElement(By.xpath("//span[text()='City']")).click();
		driver.findElement(By.xpath("//span[text()='CSV']")).click();
	}
	

	@Test(priority=7, enabled=false)
	public void DownloadExcel()
	{
		driver.findElement(By.xpath("//span[text()='City']")).click();
		driver.findElement(By.xpath("//span[text()='Excel']")).click();
	}
	
	@Test(priority=8, enabled=false)
	public void AddNewCity()
	{
		driver.findElement(By.xpath("//span[text()='City']")).click();
		driver.findElement(By.xpath("//a[text()='Add New']")).click();
		driver.findElement(By.id("title")).sendKeys("Canda");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	}
	
    @Test(priority=9)
    public void DeleteButton()
    {
    	driver.findElement(By.xpath("//span[text()='City']")).click();
    	driver.findElement(By.xpath("(//a[@title='Delete'])[8]")).click();
    	Set<String> id = driver.getWindowHandles();
    	Iterator<String> it = id.iterator();
    	String MoveTo = it.next();
    	driver.switchTo().window(MoveTo);
    	driver.findElement(By.xpath("//button[text()='Delete']")).click();
    }
	
	
	
	
	

}
