package MedWebsite;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import atu.testrecorder.exceptions.ATUTestRecorderException;

public class ShopNowPage extends TestData{
	
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
	
	@Test(priority=1, enabled=false) 
	public void ShopNowCheck()
	{
		driver.findElement(By.xpath("//a[text()='sign In/ register']")).click();
		driver.findElement(By.id("username")).sendKeys("malloh");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//span[@class='button_text_container']")).click();
		driver.findElement(By.xpath("//a[contains(@class,'nav-link shop-now-btn')]")).click();
		driver.findElement(By.xpath("(//a[@class='medical-button'])[3]")).click();
		WebElement Count = driver.findElement(By.name("quantity"));
		WebElement name = driver.findElement(By.xpath("//span[text()='1000.00 JOD']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", name);
    	js.executeScript("arguments[0].style.border='3px solid red'", Count);
		
		for (int i=0; i<3 ; i++)
		{
			driver.findElement(By.className("qtyplus")).click();
		}
		driver.findElement(By.xpath("//a[text()='Buy Now']")).click();
	}
	
	@Test(priority=2, enabled=false)
	public void AddReviewCheck()
	{
		driver.findElement(By.xpath("//a[text()='sign In/ register']")).click();
		driver.findElement(By.id("username")).sendKeys("malloh");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//span[@class='button_text_container']")).click();
		driver.findElement(By.xpath("//a[contains(@class,'nav-link shop-now-btn')]")).click();
		driver.findElement(By.xpath("(//a[@class='medical-button'])[3]")).click();
		driver.findElement(By.xpath("//a[text()=' Reviews']")).click();
		driver.findElement(By.className("form-control")).sendKeys("Test");
		driver.findElement(By.xpath("(//input[type='text'])")).sendKeys("Ahmad");
		driver.findElement(By.xpath("(//input[type='text'])[2]")).sendKeys("test");
		driver.findElement(By.xpath("//button[text()='Submit Review']")).click();
	}
	
	@Test(priority=3, enabled=false)
	public void ShopByCategory()
	{
		SoftAssert soft = new SoftAssert();
	    driver.findElement(By.xpath("//a[contains(@class,'nav-link shop-now-btn')]")).click();
		driver.findElement(By.xpath("//h3[text()='Diabetic Care']")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		boolean Actual = driver.findElement(By.xpath("//div[text()='Onetouch']")).isDisplayed();
		soft.assertTrue(Actual);
		
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[4]")).click();
		boolean Result = driver.findElement(By.xpath("//div[text()='Contour 01']")).isDisplayed();
		soft.assertTrue(Result);
		soft.assertAll();
	}
	
	@Test(priority=4, enabled=false)
	public void ShopByBrand()
	{
		driver.findElement(By.xpath("//a[contains(@class,'nav-link shop-now-btn')]")).click();
		driver.findElement(By.xpath("//h3[text()='Diabetic Care']")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		
		WebElement Brand = driver.findElement(By.xpath("//h3[text()='Shop by Brand']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", Brand);
    	
		driver.findElement(By.xpath("(//input[@type='checkbox'])[17]")).click();
		WebElement pic = driver.findElement(By.xpath("//h3[text()='Shop by Category']"));
		Actions action = new Actions(driver);
		action.moveToElement(pic).build().perform();
		boolean actual = driver.findElement(By.xpath("//div[text()='Ego 01']")).isDisplayed();
		Assert.assertTrue(actual);
	}
	
	@Test(priority=5, enabled=false)
	public void ShopByMaterial()
	{
		driver.findElement(By.xpath("//a[contains(@class,'nav-link shop-now-btn')]")).click();
		driver.findElement(By.xpath("//h3[text()='Diabetic Care']")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		
		WebElement Material = driver.findElement(By.xpath("//h3[text()='Shop by Material']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", Material);
    	driver.findElement(By.xpath("(//input[@type='checkbox'])[25]")).click();
    	
    	WebElement pic = driver.findElement(By.xpath("//h3[text()='Shop by Category']"));
		Actions action = new Actions(driver);
		action.moveToElement(pic).build().perform();
		
		boolean Actual = driver.findElement(By.xpath("//div[text()='Ensureplus']")).isDisplayed();
		Assert.assertTrue(Actual);
    }
	
	@Test
	public void PriceFilter()
	{
		driver.findElement(By.xpath("//a[contains(@class,'nav-link shop-now-btn')]")).click();
		driver.findElement(By.xpath("//h3[text()='Diabetic Care']")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();

		WebElement price = driver.findElement(By.xpath("//h3[text()='Price']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", price);
		
		WebElement pricefilter = driver.findElement(By.xpath("//div[@class='price-field']"));
		
		
		Actions move = new Actions(driver);
		Action action = (Action) move.dragAndDropBy(pricefilter, 100, 500).build();
		action.perform();
		
		
	}

}
