package MedWebsite;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class RegisterandLogIn extends TestData {

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
	public void Teardown(ITestResult result, Method method ) throws ATUTestRecorderException, IOException
	{
		if (result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(LogStatus.PASS, "TestCase is Pass");
			test.log(LogStatus.PASS, "<a href='"+result.getName()+".mov" + "'><span class='lable info'>Download Video</span></a>");
			test.log(LogStatus.PASS, "<a href='"+result.getName()+".png" + "'><span class='lable info'>Download Snapshot</span></a>");
		}
		else if (result.getStatus() == ITestResult.FAILURE)
		{
			test.log(LogStatus.FAIL, "TestCase is Fail");
			test.log(LogStatus.PASS, "<a href='"+result.getName()+".mov" + "'><span class='lable info'>Download Video</span></a>");
			test.log(LogStatus.PASS, "<a href='"+result.getName()+".png" + "'><span class='lable info'>Download Snapshot</span></a>");
		}
		else
			test.log(LogStatus.SKIP, "TestCase is Skipped");
		recorder.stop();
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE );
		FileUtils.copyFile(srcfile, new File("D:\\Users\\ahmad\\eclipse-workspace\\Qiotic_Projects\\MedTestReport"+method.getName()+".png"));
		driver.quit();
	}
	
	@Test(priority=1, enabled=false)
	public void RegisterCheck()
	{
		Actions action = new Actions(driver);
		driver.findElement(By.xpath("//a[text()='sign In/ register']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		driver.findElement(By.name("name")).sendKeys("Ahmad Malloh");
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys("malloh");
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys("ahmadmalloh97@gmail.com");
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys("123456");
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys("123456");
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.TAB).build().perform();
		driver.findElement(By.xpath("(//span[@class='button_text_container'])[2]")).click();
	}
	
	@Test(priority=2, enabled=false)
	public void LogInCheck()
	{
		driver.findElement(By.xpath("//a[text()='sign In/ register']")).click();
		driver.findElement(By.id("username")).sendKeys("malloh");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//span[@class='button_text_container']")).click();
	}
	
	@Test(priority=3, enabled=false)
	public void PolicyCheck()
	{
		driver.findElement(By.xpath("//a[text()='sign In/ register']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		driver.findElement(By.linkText("privacy policy.")).click();
		boolean Actual = driver.findElement(By.xpath("//li[@class='breadcrumb-item active']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=4, dataProvider= "MyData", enabled=false)
	public void loginDifferentCases(String username, String password)
	{
		driver.findElement(By.xpath("//a[text()='sign In/ register']")).click();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//span[@class='button_text_container']")).click();
	}
	
	
	@DataProvider
	public Object[][] MyData()
	{
		Object[][] data = new Object[4][2];
		data[0][0]="malloh";
		data[0][1]="123456";
		data[1][0]="malloh";
		data[1][1]="123456789";
		data[2][0]="ahmad";
		data[2][1]="123456";
		data[3][0]="ahmad";
		data[3][1]="123";
		
		return data;
	}
	
	@Test(priority=5, enabled=false)
	public void ForgetpassCheck()
	{
		driver.findElement(By.xpath("//a[text()='sign In/ register']")).click();
		driver.findElement(By.linkText("Forgot Password")).click();
		driver.findElement(By.name("email")).sendKeys("ahmadmalloh97@gmail.com");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	

}
