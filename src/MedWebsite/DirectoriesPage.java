package MedWebsite;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
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
		//driver.findElement(By.xpath("//span[text()=' English ']")).click();
		driver.findElement(By.linkText("Directories")).click();
		driver.findElement(By.xpath("//h5[text()='Hospital']")).click();
		driver.findElement(By.xpath("//a[text()='2']")).click();
	}

}
