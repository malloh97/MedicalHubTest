package MedWebsite;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import atu.testrecorder.exceptions.ATUTestRecorderException;

public class DirectoriesPage extends TestData {
	
	@BeforeMethod
	public void setup(Method method) throws ATUTestRecorderException
	{
		beforetest(method.getName());
	}
	
	@BeforeSuite
	public void Started()
	{
		started();
	}
	
	@AfterSuite
	public void finishd()
	{
		finished();
	}
	
	@AfterMethod
	public void teardown(ITestResult result, Method method) throws ATUTestRecorderException
	{
		if (result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(LogStatus.PASS, "Test Case is Passed");
			test.log(LogStatus.PASS, "<a href='"+result.getName()+".mov" + "'><span class='lable info'>Download Video</span></a>");
			test.log(LogStatus.PASS, "<a href='"+result.getName()+".png" + "'><span class='lable info'>Download Snapshot</span></a>");
		}
		else if (result.getStatus() == ITestResult.FAILURE)
		{
			test.log(LogStatus.FAIL, "Test Case is Fail");
			test.log(LogStatus.PASS, "<a href='"+result.getName()+".mov" + "'><span class='lable info'>Download Video</span></a>");
			test.log(LogStatus.PASS, "<a href='"+result.getName()+".png" + "'><span class='lable info'>Download Snapshot</span></a>");
		}
		else
			test.log(LogStatus.SKIP, "Test Case is Skipped");
		recorder.stop();
		driver.quit();
		
	}
	
	@Test(priority=1)
	public void HospitalChecked()
	{
		Actions action = new Actions(driver);
		WebElement Move = driver.findElement(By.xpath("//a[text()='Directories']"));
		action.moveToElement(Move).build().perform();
		driver.findElement(By.xpath("//a[text()='Hospital']")).click();
		
		WebElement moveto = driver.findElement(By.xpath("//ul[contains(@class,'pagination justify-content-center')]"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", moveto);
		driver.findElement(By.xpath("(//a[@class='page-link'])[6]")).click();
		driver.findElement(By.xpath("(//div[@class='card'])[9]")).click();
		driver.findElement(By.xpath("//a[text()='Doctors']")).click();
		WebElement Doctor = driver.findElement(By.xpath("//a[text()='Doctors']"));
		js.executeScript("arguments[0].scrollIntoView(true);", Doctor);
		
		boolean Actual = driver.findElement(By.xpath("//h5[text()='Dr. Yazan Haliqa']")).isDisplayed();
		Assert.assertTrue(Actual);
		
	}

}
