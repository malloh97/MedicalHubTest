package MedWebsite;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

public class CheckOutPage extends TestData {
	
	@BeforeSuite
	public void Started()
	{
		started();
	}
	
	@AfterSuite
	public void Finished()
	{
		finished();
	}
	
	@BeforeMethod
	public void Setup(Method method) throws ATUTestRecorderException
	{
		beforetest(method.getName());
    }
	
	@AfterMethod
	public void Teardown(ITestResult result, Method method) throws IOException, ATUTestRecorderException 
	{
		if (result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(LogStatus.PASS, "TestCase is Passed");
			test.log(LogStatus.PASS, "<a href='"+result.getName()+".mov" + "'><span class='lable info'>Download Video</span></a>");
			test.log(LogStatus.PASS, "<a href='"+result.getName()+".png" + "'><span class='lable info'>Download Snapshot</span></a>");
		}
		else if (result.getStatus() == ITestResult.FAILURE)
		{
			test.log(LogStatus.FATAL, "TestCase is Fail");
			test.log(LogStatus.PASS, "<a href='"+result.getName()+".mov" + "'><span class='lable info'>Download Video</span></a>");
			test.log(LogStatus.PASS, "<a href='"+result.getName()+".png" + "'><span class='lable info'>Download Snapshot</span></a>");
		}
		else {
			test.log(LogStatus.SKIP, "TestCase is Skipped");
		}
		recorder.stop();
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE );
		FileUtils.copyFile(srcfile, new File("D:\\Users\\ahmad\\eclipse-workspace\\Qiotic_Projects\\AllSnapshots"+method.getName()+".png"));
		driver.quit(); 
	
	}
	
	@Test(enabled=false)
	public void CopounCheck()
	{
		driver.findElement(By.xpath("//a[text()='sign In/ register']")).click();
		driver.findElement(By.id("username")).sendKeys("malloh");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//span[@class='button_text_container']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'cart-icon d-none d-md-inline-block')]")).click();
		driver.findElement(By.xpath("//a[text()='Checkout']")).click();
		driver.findElement(By.id("coupon")).sendKeys("AHA");
		driver.findElement(By.xpath("//button[text()='Redeem']")).click();
		
		
		String SupTotal = driver.findElement(By.id("totalAmount")).getAttribute("value");
		Double SupTotalamount = Double.parseDouble(SupTotal);
		System.out.println(CopounDiscount(SupTotalamount));
	}
	
	@Test(enabled=false) 
	public void CheckOutCheck()
	{
		driver.findElement(By.xpath("//a[text()='sign In/ register']")).click();
		driver.findElement(By.id("username")).sendKeys("malloh");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//span[@class='button_text_container']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'cart-icon d-none d-md-inline-block')]")).click();
		driver.findElement(By.xpath("//a[text()='Checkout']")).click();
		driver.findElement(By.id("firstName")).sendKeys("Ahmad");
		driver.findElement(By.id("lastName")).sendKeys("Malloh");
		driver.findElement(By.id("username")).sendKeys("malloh");
		driver.findElement(By.id("address")).sendKeys("Amman - Khalda");
		
		WebElement countries = driver.findElement(By.id("country"));
		WebElement state = driver.findElement(By.id("state"));
		
		Select country = new Select(countries);
		country.selectByVisibleText("United States");
		
		Select city = new Select(state);
		city.selectByVisibleText("California");
		
		driver.findElement(By.id("zip")).sendKeys("142078");
		driver.findElement(By.id("cc-name")).sendKeys("Ahmad");
		driver.findElement(By.id("cc-number")).sendKeys("401000033330026");
		driver.findElement(By.id("cc-expiration")).sendKeys("05/32");
		driver.findElement(By.id("cc-cvv")).sendKeys("123");
		driver.findElement(By.className("button_text_container")).click();
		
		boolean Actual = driver.findElement(By.xpath("//h5[text()='Your Order Confirmed!']")).isDisplayed();
		Assert.assertTrue(Actual);
		
	}
	
	@Test 
	public void ChattCheck()
	{
		
		driver.findElement(By.id("maximizeChat")).click();
		
	}
	
	

}
