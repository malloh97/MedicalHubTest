package MedDashborad;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import atu.testrecorder.exceptions.ATUTestRecorderException;


public class AdminPanelCoupon extends TestBase {
	
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
		before(method.getName());
	}
	
	@AfterMethod
	public void teardown(ITestResult result, Method method) throws ATUTestRecorderException, IOException
	{
		recorder.stop();
		if (result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(LogStatus.PASS, "<a href='"+result.getName()+".mov" + "'><span class='lable info'>Download Video</span></a>");
			test.log(LogStatus.PASS, "<a href='"+result.getName()+".png" + "'><span class='lable info'>Download Snapshot</span></a>");
		}
		else if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(LogStatus.FAIL,"<a href='"+result.getName()+".mov" + "'><span class='lable info'>Download Video</span></a>");
			test.log(LogStatus.FAIL,"<a href='"+result.getName()+".png" + "'><span class='lable info'>Download Snapshot</span></a>");
		}
		else 
			test.log(LogStatus.SKIP,"Test Skipped");
		
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE );
		FileUtils.copyFile(srcfile, new File("D:\\Users\\ahmad\\eclipse-workspace\\Qiotic_Projects\\TestReport\\"+method.getName()+".png"));

		
		driver.quit();
	}
	

	@Test(priority=1)
	public void ShowEntiersCoupon()
	{
		WebElement Slider = driver.findElement(By.xpath("//span[text()='Slider']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", Slider);
		driver.findElement(By.xpath("//span[text()='Coupon']")).click();
		WebElement show = driver.findElement(By.xpath("//select[contains(@class,'custom-select')]"));
		Select select = new Select(show);
		select.selectByValue("25");
	}
	

	@Test(priority=2) 
	public void SearchTextBoxCoupon()
	{
		WebElement Slider = driver.findElement(By.xpath("//span[text()='Slider']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", Slider);
		driver.findElement(By.xpath("//span[text()='Coupon']")).click();
		WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
		search.sendKeys("4");
	}
	
	@Test(priority=3) 
	public void ShowButtonCoupon()
	{
		WebElement Slider = driver.findElement(By.xpath("//span[text()='Slider']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", Slider);
		driver.findElement(By.xpath("//span[text()='Coupon']")).click();
		driver.findElement(By.xpath("(//i[contains(@class,'ik')])[23]")).click();
	}
	

	@Test(priority=4)
	public void DownloadPDFCoupon()
	{
		WebElement Slider = driver.findElement(By.xpath("//span[text()='Slider']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", Slider);
		driver.findElement(By.xpath("//span[text()='Coupon']")).click();
		driver.findElement(By.xpath("//span[text()='Excel']")).click();
	}
	
	@Test(priority=5)
	public void DownloadCSVCoupon()
	{
		WebElement Slider = driver.findElement(By.xpath("//span[text()='Slider']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", Slider);
		driver.findElement(By.xpath("//span[text()='Coupon']")).click();
		driver.findElement(By.xpath("//span[text()='CSV']")).click();
	}
	
    @Test(priority=6)
	public void DownloadExcelCoupon()
	{
    	WebElement Slider = driver.findElement(By.xpath("//span[text()='Slider']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", Slider);
		driver.findElement(By.xpath("//span[text()='Coupon']")).click();
		driver.findElement(By.xpath("//span[text()='Excel']")).click();
	}
    
    @Test(priority=7)
	public void AddCoupon()
	{
    	WebElement Slider = driver.findElement(By.xpath("//span[text()='Slider']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", Slider);
    	driver.findElement(By.xpath("//span[text()='Coupon']")).click();
    	driver.findElement(By.xpath("//a[text()='Add New']")).click();
		driver.findElement(By.id("code")).sendKeys("test123");
		driver.findElement(By.id("percentage")).sendKeys("25%");
		driver.findElement(By.id("expire_count")).sendKeys("5");
		WebElement From = driver.findElement(By.id("start_at"));
		WebElement To = driver.findElement(By.id("end_at"));
		js.executeScript("arguments[0].setAttribute('value','"+"2021-01-05"+"');", From);
		js.executeScript("arguments[0].setAttribute('value','"+"2021-01-10"+"');", To);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
	}


	@Test(priority=8) 
	public void DeleteButtonCoupon()
	{
		WebElement Slider = driver.findElement(By.xpath("//span[text()='Slider']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", Slider);
		driver.findElement(By.xpath("//span[text()='Coupon']")).click();
		driver.findElement(By.xpath("(//i[contains(@class,'ik')])[24]")).click();
		Set<String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		String MoveTo = it.next();
		driver.switchTo().window(MoveTo);
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
	}
	
	




	
	
	


}
