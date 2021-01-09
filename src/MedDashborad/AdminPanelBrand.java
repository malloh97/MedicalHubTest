package MedDashborad;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import atu.testrecorder.exceptions.ATUTestRecorderException;

public class AdminPanelBrand extends TestBase{
	
	
	@BeforeSuite
	public void StartedTesting()
	{
		Started();
	}
	
	@AfterSuite
	public void FinishedTesing()
	{
		Finished();
	}
	
	
	@BeforeMethod
	public void setup(Method method) throws ATUTestRecorderException
	{
		before(method.getName());
	}
	
	@AfterMethod
	public void teardown(ITestResult result) throws ATUTestRecorderException
	{
		
		recorder.stop();
		if (result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(LogStatus.PASS, "Test Pass");
			test.log(LogStatus.PASS,  "<a href='"+result.getName()+".mov" + "'><span class='lable info'>Download Video</span></a>");
			test.log(LogStatus.PASS, "<a href='"+result.getName()+".png" + "'><span class='lable info'>Download Snapshot</span></a>");
		} 
		else if (result.getStatus() == ITestResult.FAILURE)
		{
			test.log(LogStatus.FAIL, "Test Fail");
			test.log(LogStatus.FAIL,  "<a href='"+result.getName()+".mov" + "'><span class='lable info'>Download Video</span></a>");
			test.log(LogStatus.FAIL, "<a href='"+result.getName()+".png" + "'><span class='lable info'>Download Snapshot</span></a>");
		}
		else 
			test.log(LogStatus.SKIP, "Test Skipped");
		
		driver.quit();
	}
	
	@Test(priority=1)
	public void ShowEntries()
	{
		driver.findElement(By.xpath("//span[text()='Products']")).click();
		driver.findElement(By.xpath("//span[text()='Brands']")).click();
		WebElement show = driver.findElement(By.xpath("//select[contains(@class,'custom-select')]"));
		Select select = new Select(show);
		select.selectByValue("25");
	}
	
	@Test(priority=2) 
	public void SearchTextBox()
	{
		driver.findElement(By.xpath("//span[text()='Products']")).click();
		driver.findElement(By.xpath("//span[text()='Brands']")).click();
		WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
		search.sendKeys("4");
		boolean Actual = driver.findElement(By.xpath("//td[text()=' adidas ']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	
	@Test(priority=3) 
	public void ShowButton()
	{
		driver.findElement(By.xpath("//span[text()='Products']")).click();
		driver.findElement(By.xpath("//span[text()='Brands']")).click();
		driver.findElement(By.xpath("//a[@title='View']")).click();
		boolean Actual = driver.findElement(By.id("title")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=4)
	public void EditButton()
	{
		driver.findElement(By.xpath("//span[text()='Products']")).click();
		driver.findElement(By.xpath("//span[text()='Brands']")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		driver.findElement(By.id("title_en")).clear();
		driver.findElement(By.id("title_en")).sendKeys("Brand#1");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
	}
	
	@Test(priority=5, enabled=false) 
	public void DeleteButton()
	{
		driver.findElement(By.xpath("//span[text()='Products']")).click();
		driver.findElement(By.xpath("//span[text()='Brands']")).click();
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		Set<String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		String MoveTo = it.next();
		driver.switchTo().window(MoveTo);
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
	}
	
	
	@Test(priority=6)
	public void DownloadPDF()
	{
		driver.findElement(By.xpath("//span[text()='Products']")).click();
		driver.findElement(By.xpath("//span[text()='Brands']")).click();
		driver.findElement(By.xpath("//span[text()='Excel']")).click();
	}
	
	@Test(priority=7)
	public void DownloadCSV()
	{
		driver.findElement(By.xpath("//span[text()='Products']")).click();
		driver.findElement(By.xpath("//span[text()='Brands']")).click();
		driver.findElement(By.xpath("//span[text()='CSV']")).click();
	}
	

	@Test(priority=8)
	public void DownloadExcel()
	{
		driver.findElement(By.xpath("//span[text()='Products']")).click();
		driver.findElement(By.xpath("//span[text()='Brands']")).click();
		driver.findElement(By.xpath("//span[text()='Excel']")).click();
	}
	
	@Test(priority=9)
	public void AddBrand()
	{
		driver.findElement(By.xpath("//span[text()='Products']")).click();
		driver.findElement(By.xpath("//span[text()='Brands']")).click();
		driver.findElement(By.xpath("//a[text()='Add New']")).click();
		driver.findElement(By.id("title_en")).sendKeys("Brand#1");
		driver.findElement(By.id("title_ar")).sendKeys("Brand#1");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	}
	
	
	

}
