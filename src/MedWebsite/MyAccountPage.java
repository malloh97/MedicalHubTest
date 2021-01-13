package MedWebsite;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class MyAccountPage extends TestData {
	
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
	public void Teardown(ITestResult result, Method method) throws ATUTestRecorderException, IOException
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
	
	@Test(priority=1)
	public void RecentOrdersCheck()
	{
		driver.findElement(By.xpath("//a[text()='sign In/ register']")).click();
		driver.findElement(By.id("username")).sendKeys("malloh");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//span[@class='button_text_container']")).click();
		driver.findElement(By.xpath("//a[text()='Ahmad']")).click();
		driver.findElement(By.xpath("//a[contains(@class,'btn btn-view')]")).click();
		boolean Actual = driver.findElement(By.xpath("//h5[text()='Your Order Confirmed!']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=2)
	public void MyOrdersCheck()
	{
		driver.findElement(By.xpath("//a[text()='sign In/ register']")).click();
		driver.findElement(By.id("username")).sendKeys("malloh");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//span[@class='button_text_container']")).click();
		driver.findElement(By.xpath("//a[text()='Ahmad']")).click();
		driver.findElement(By.xpath("//i[contains(@class,'las la-cart-arrow-down')]")).click();
		driver.findElement(By.xpath("//a[contains(@class,'btn btn-view')]")).click();
		boolean Actual = driver.findElement(By.xpath("//h5[text()='Your Order Confirmed!']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=3)
	public void MyWishlistCheck()
	{
		driver.findElement(By.xpath("//a[text()='sign In/ register']")).click();
		driver.findElement(By.id("username")).sendKeys("malloh");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//span[@class='button_text_container']")).click();
		driver.findElement(By.xpath("//a[text()='Ahmad']")).click();
		driver.findElement(By.xpath("//i[contains(@class,'lar la-heart')]")).click();
		driver.findElement(By.xpath("//a[contains(@class,'btn btn-delete')]")).click();
	}
	
	@Test(priority=4)
	public void MyReviwesCheck()
	{
		driver.findElement(By.xpath("//a[text()='sign In/ register']")).click();
		driver.findElement(By.id("username")).sendKeys("malloh");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//span[@class='button_text_container']")).click();
		driver.findElement(By.xpath("//a[text()='Ahmad']")).click();
		driver.findElement(By.xpath("//i[contains(@class,'las la-comment')]")).click();
		boolean Actual = driver.findElement(By.xpath("//th[text()='Rating']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=5)
	public void MyAddressCheck()
	{
		driver.findElement(By.xpath("//a[text()='sign In/ register']")).click();
		driver.findElement(By.id("username")).sendKeys("malloh");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//span[@class='button_text_container']")).click();
		driver.findElement(By.xpath("//a[text()='Ahmad']")).click();
		driver.findElement(By.xpath("//i[contains(@class,'las la-address-book')]")).click();
		driver.findElement(By.xpath("//button[@type='button']")).click();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("Ahmad Malloh");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys("Amman").build().perform();
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys("Al Zarqa").build().perform();
		WebElement CityFeild = driver.findElement(By.name("city"));
		Select select = new Select(CityFeild);
		select.selectByValue("4");
		driver.findElement(By.xpath("//button[text()='Save Address']")).click();
	}
	
	@Test(priority=6)
	public void MyProfileCheck()
	{
		driver.findElement(By.xpath("//a[text()='sign In/ register']")).click();
		driver.findElement(By.id("username")).sendKeys("malloh");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//span[@class='button_text_container']")).click();
		driver.findElement(By.xpath("//a[text()='Ahmad']")).click();
		driver.findElement(By.xpath("//i[contains(@class,'las la-user-circle')]")).click();
		driver.findElement(By.id("password")).sendKeys("1234567");
		driver.findElement(By.id("confirm-password")).sendKeys("1234567");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@Test(priority=7)
	public void LogOutCheck()
	{
		driver.findElement(By.xpath("//a[text()='sign In/ register']")).click();
		driver.findElement(By.id("username")).sendKeys("malloh");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//span[@class='button_text_container']")).click();
		driver.findElement(By.xpath("//a[text()='Ahmad']")).click();
		driver.findElement(By.xpath("//i[contains(@class,'las la-sign-out-alt')]")).click();
	}
	

}
