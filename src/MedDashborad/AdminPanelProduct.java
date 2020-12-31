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

public class AdminPanelProduct {
	
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
		driver.findElement(By.xpath("//span[text()='Products']")).click();
		driver.findElement(By.xpath("//span[text()='Product']")).click();
		WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
		search.sendKeys("15");
		boolean Actual = driver.findElement(By.xpath("//td[text()=' Blood chemistry analyzer 2 ']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=2, enabled=false)
	public void ShowEntries()
	{
		driver.findElement(By.xpath("//span[text()='Products']")).click();
		driver.findElement(By.xpath("//span[text()='Product']")).click();
		WebElement show = driver.findElement(By.xpath("//select[contains(@class,'custom-select')]"));
		Select select = new Select(show);
		select.selectByValue("25");
	}
	
	@Test(priority=3, enabled=false) 
	public void ShowButton()
	{
		driver.findElement(By.xpath("//span[text()='Products']")).click();
		driver.findElement(By.xpath("//span[text()='Product']")).click();
		driver.findElement(By.xpath("//a[@title='View']")).click();
		boolean Actual = driver.findElement(By.id("title")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=4, enabled=false)
	public void EditButton()
	{
		driver.findElement(By.xpath("//span[text()='Products']")).click();
		driver.findElement(By.xpath("//span[text()='Product']")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		driver.findElement(By.id("price")).clear();
		driver.findElement(By.id("price")).sendKeys("290");
		driver.findElement(By.id("image")).sendKeys("C:\\Users\\ahmad\\Downloads\\Translated 06.jpeg");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
	}
	
	@Test(priority=5, enabled=false) 
	public void DeleteButton()
	{
		driver.findElement(By.xpath("//span[text()='Products']")).click();
		driver.findElement(By.xpath("//span[text()='Product']")).click();
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		Set<String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		String MoveTo = it.next();
		driver.switchTo().window(MoveTo);
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
	}
	
	@Test(priority=6, enabled=false)
	public void DownloadPDF()
	{
		driver.findElement(By.xpath("//span[text()='Products']")).click();
		driver.findElement(By.xpath("//span[text()='Product']")).click();
		driver.findElement(By.xpath("//span[text()='Excel']")).click();
	}
	
	@Test(priority=7, enabled=false)
	public void DownloadCSV()
	{
		driver.findElement(By.xpath("//span[text()='Products']")).click();
		driver.findElement(By.xpath("//span[text()='Product']")).click();
		driver.findElement(By.xpath("//span[text()='CSV']")).click();
	}
	

	@Test(priority=8, enabled=false)
	public void DownloadExcel()
	{
		driver.findElement(By.xpath("//span[text()='Products']")).click();
		driver.findElement(By.xpath("//span[text()='Product']")).click();
		driver.findElement(By.xpath("//span[text()='Excel']")).click();
	}
	
	@Test(priority=9)
	public void AddNewProduct()
	{
		driver.findElement(By.xpath("//span[text()='Products']")).click();
		driver.findElement(By.xpath("//span[text()='Product']")).click();
		driver.findElement(By.xpath("//a[text()='Add New']")).click();
		
		WebElement category = driver.findElement(By.name("category_id"));
		WebElement brand = driver.findElement(By.name("brand_id"));
		WebElement material = driver.findElement(By.name("material_id"));
		
		Select selectcategory = new Select(category);
		Select selectbrand = new Select(brand);
		Select selectmaterial = new Select(material);
		
		selectcategory.selectByValue("8");
		selectbrand.selectByValue("7");
		selectmaterial.selectByValue("8");
		
		driver.findElement(By.name("title_en")).sendKeys("TestProduct");
		driver.findElement(By.name("title_ar")).sendKeys("TestProduct");
		driver.findElement(By.name("short_content_en")).sendKeys("TestContect");
		driver.findElement(By.name("short_content_ar")).sendKeys("TestContect");
		driver.findElement(By.name("content_en")).sendKeys("Testdescription");
		driver.findElement(By.name("content_ar")).sendKeys("Testdescription");
		driver.findElement(By.id("price")).sendKeys("210");
		driver.findElement(By.id("image")).sendKeys("C:\\Users\\ahmad\\Downloads\\Translated 06.jpeg");
		driver.findElement(By.id("file")).sendKeys("C:\\Users\\ahmad\\Downloads\\Translated 08.jpeg");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
	}
	
	
	

	

}
