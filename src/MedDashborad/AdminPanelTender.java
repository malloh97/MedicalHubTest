package MedDashborad;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class AdminPanelTender {
	
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
	

	@Test(priority=1) 
	public void SearchTextBox()
	{
		driver.findElement(By.xpath("//span[text()='Tender']")).click();
		WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
		search.sendKeys("4");
		boolean Actual = driver.findElement(By.xpath("//td[text()=' Tender #1 ']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=2)
	public void ShowEntries()
	{
		driver.findElement(By.xpath("//span[text()='Tender']")).click();
		WebElement show = driver.findElement(By.xpath("//select[contains(@class,'custom-select')]"));
		Select select = new Select(show);
		select.selectByValue("25");
	}
	 

	@Test(priority=3) 
	public void ShowButton()
	{
		driver.findElement(By.xpath("//span[text()='Tender']")).click();
		driver.findElement(By.xpath("//a[@title='View']")).click();
		boolean Actual = driver.findElement(By.xpath("//input[@value='Tender #1']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	

	@Test(priority=4)
	public void EditButton()
	{
		driver.findElement(By.xpath("//span[text()='Tender']")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
        WebElement city = driver.findElement(By.name("city_id"));
        Select select = new Select(city);
        select.selectByValue("7");

       WebElement date = driver.findElement(By.id("title"));
       JavascriptExecutor js = ((JavascriptExecutor ) driver);
       js.executeScript("arguments[0].setAttribute('value','"+"2021/12/17"+"');", date);
     
       driver.findElement(By.xpath("//button[text()='Save']")).click();
	
	}
	 

    @Test(priority=5)
	public void DownloadPDF()
	{
		driver.findElement(By.xpath("//span[text()='Tender']")).click();
		driver.findElement(By.xpath("//span[text()='Excel']")).click();
	}
	
	@Test(priority=6)
	public void DownloadCSV()
	{
		driver.findElement(By.xpath("//span[text()='Tender']")).click();
		driver.findElement(By.xpath("//span[text()='CSV']")).click();
	}
	

	@Test(priority=7)
	public void DownloadExcel()
	{
		driver.findElement(By.xpath("//span[text()='Tender']")).click();
		driver.findElement(By.xpath("//span[text()='Excel']")).click();
	}
	
	@Test(priority=8)
	public void AddNewTender()
	{
        driver.findElement(By.xpath("//span[text()='Tender']")).click();
		driver.findElement(By.xpath("//a[text()='Add New']")).click();
		driver.findElement(By.id("number")).sendKeys("005");
		driver.findElement(By.id("title")).sendKeys("Tender");
		WebElement city = driver.findElement(By.name("city_id"));
		Select select = new Select(city);
		select.selectByValue("9");
		
		WebElement From = driver.findElement(By.name("publish_date"));
		WebElement To = driver.findElement(By.name("end_date"));
		
		JavascriptExecutor js = ((JavascriptExecutor ) driver);
	    js.executeScript("arguments[0].setAttribute('value','"+"2021-12-01"+"');", From);
	    js.executeScript("arguments[0].setAttribute('value','"+"2021-12-31"+"');", To);
	    
	    driver.findElement(By.xpath("//button[text()='Save']")).click();
	}
	
	@Test(priority=9)
	public void DeleteButton()
	{
		driver.findElement(By.xpath("//span[text()='Tender']")).click();
		driver.findElement(By.xpath("(//a[@title='Delete'])[2]")).click();
		Set<String> id = driver.getWindowHandles();
    	Iterator<String> it = id.iterator();
    	String MoveTo = it.next();
    	driver.switchTo().window(MoveTo);
    	driver.findElement(By.xpath("//button[text()='Delete']")).click();
	}


	


}
