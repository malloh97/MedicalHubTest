package MedWebsite;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

public class HomePage extends TestData {
	
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
		FileUtils.copyFile(srcfile, new File("D:\\Users\\ahmad\\eclipse-workspace\\Qiotic_Projects\\AllSnapshots"+method.getName()+".png"));
		driver.quit();
	}
	
	@Test(priority=1, enabled=false)
	public void LanguageButtonCheck()
	{
		driver.findElement(By.id("navbarDropdown")).click();
		boolean Actual = driver.findElement(By.xpath("//a[contains(@class,'nav-link')]")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	
	@Test(priority=2, enabled=false)
	public void PhoneNumberCheck()
	{
		driver.findElement(By.xpath("//span[text()='+962 797561465']")).click();
	}
	
	@Test(priority=3, enabled=false)
	public void ContuctCheck()
	{
		driver.findElement(By.xpath("//a[text()='Contact Us']")).click();
		driver.findElement(By.xpath("//input[@placeholder='First Name *']")).sendKeys("Ahmad");
		driver.findElement(By.xpath("//input[@placeholder='Last Name *']")).sendKeys("Test");
		driver.findElement(By.xpath("//textarea[@placeholder='Message *']")).sendKeys("Hi MedicalHub");
		driver.findElement(By.xpath("//span[@class='button_text_container']")).click();
	}
	
	@Test(priority=4, enabled=false)
	public void FacebookCheck()
	{
		driver.findElement(By.xpath("//i[contains(@class,'fa fa-facebook-f')]")).click();
	}
	

	@Test(priority=5, enabled=false)
	public void LinkedInCheck()
	{
		driver.findElement(By.xpath("//i[contains(@class,'fa fa-linkedin-in')]")).click();
	}
	

	@Test(priority=6, enabled=false)
	public void TwitterCheck()
	{
		driver.findElement(By.xpath("//i[contains(@class,'fa fa-twitter')]")).click();
	}
	

	@Test(priority=7, enabled=false)
	public void InstagrameCheck()
	{
		driver.findElement(By.xpath("//i[contains(@class,'fa fa-instagram')]")).click();
	}
	
	@Test(priority=8, enabled=false)
	public void SnapchatCheck()
	{
		driver.findElement(By.xpath("//i[contains(@class,'fa fa-snapchat-ghost')]")).click();
	}
	
	@Test(priority=9, enabled=false)
	public void AboutUsCheck()
	{
		WebElement about = driver.findElement(By.xpath("(//a[@class='nav-link'])[6]"));
		Actions action = new Actions(driver);
		action.moveToElement(about).build().perform();
		boolean Actual = driver.findElement(By.xpath("//a[text()='Our Company']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=10, enabled=false)
	public void DirectoriesCheck()
	{
		WebElement about = driver.findElement(By.xpath("(//a[@class='nav-link'])[7]"));
		Actions action = new Actions(driver);
		action.moveToElement(about).build().perform();
	}
	
	@Test(priority=11, enabled=false)
	public void ServicesCheck()
	{
		WebElement about = driver.findElement(By.xpath("(//a[@class='nav-link'])[8]"));
		Actions action = new Actions(driver);
		action.moveToElement(about).build().perform();
		boolean Actual = driver.findElement(By.xpath("//a[text()='Ecommerce']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=12, enabled=false)
	public void BlogsNewsCheck()
	{
		WebElement about = driver.findElement(By.xpath("(//a[@class='nav-link'])[9]"));
		Actions action = new Actions(driver);
		action.moveToElement(about).build().perform();
	}
	

	@Test(priority=13, enabled=false)
	public void MedicalTourisumCheck()
	{
		WebElement about = driver.findElement(By.xpath("(//a[@class='nav-link'])[10]"));
		Actions action = new Actions(driver);
		action.moveToElement(about).build().perform();
	}
	
	@Test(priority=14, enabled=false)
	public void MyCartCheck()
	{
		driver.findElement(By.id("cart")).click();
		boolean Actual = driver.findElement(By.xpath("//a[text()='Your cart']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=15, enabled=false)
	public void SearchCheck()
	{
		driver.findElement(By.id("search-popup")).click();
		driver.findElement(By.id("searchbox")).sendKeys("Brand");
		driver.findElement(By.id("searchsubmit")).click();
	}
	

	@Test(priority=16, enabled=false)
	public void ShopNowCheck()
	{
    	driver.findElement(By.xpath("//span[@class='button_text_container']")).click();
    	boolean Actual = driver.findElement(By.xpath("//span[text()='Category']")).isDisplayed();
    	Assert.assertTrue(Actual);
	}
	
	@Test(priority=17, enabled=false)
	public void HosptialCheck()
	{
    	driver.findElement(By.xpath("(//span[@class='button_text_container'])[2]")).click();
    	boolean Actual = driver.findElement(By.xpath("//h2[text()='Hospital']")).isDisplayed();
    	Assert.assertTrue(Actual);
	}
	
	@Test(priority=18, enabled=false)
	public void VendorCheck()
	{
    	driver.findElement(By.xpath("(//span[@class='button_text_container'])[3]")).click();
    	boolean Actual = driver.findElement(By.xpath("//h2[text()='Vendor']")).isDisplayed();
    	Assert.assertTrue(Actual);
	}
	
	@Test(priority=19, enabled=false)
	public void ConsultancyCheck()
	{
    	driver.findElement(By.xpath("(//span[@class='button_text_container'])[4]")).click();
    	boolean Actual = driver.findElement(By.xpath("//h2[text()='Consultancy']")).isDisplayed();
    	Assert.assertTrue(Actual);
	}
	
	@Test(priority=20, enabled=false)
	public void OurMissionCheck()
	{
		Actions action = new Actions(driver);
		WebElement ourmission = driver.findElement(By.xpath("//h3[text()='Our Mission']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", ourmission);
    	action.moveToElement(ourmission).build().perform();
	}
	

	@Test(priority=21, enabled=false)
	public void OurVisionCheck()
	{
		Actions action = new Actions(driver);
		WebElement ourmission = driver.findElement(By.xpath("//h3[text()='Our Vision']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", ourmission);
    	action.moveToElement(ourmission).build().perform();
	}
	
	@Test(priority=22, enabled=false)
	public void OurValueCheck()
	{
		Actions action = new Actions(driver);
		WebElement ourmission = driver.findElement(By.xpath("//h3[text()='Our Value']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", ourmission);
    	action.moveToElement(ourmission).build().perform();
	}
	
	@Test(priority=23, enabled=false)
	public void OurPartnersCheck()
	{
        WebElement pic = driver.findElement(By.xpath("//img[@src='https://medical.qiotic.info/website/images/partners/Logo-Hospital.png']"));
    	Actions action = new Actions(driver);
    	action.moveToElement(pic).click().build().perform();
	}
	
	@Test(priority=24, enabled=false)
	public void SubscribNow()
	{
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("ahmadmalloh97@gmail.com");
		driver.findElement(By.xpath("//i[contains(@class,'fa fa-long-arrow-right')]")).click();
	}
	
	@Test(priority=25, enabled=false)
	public void ConnectWithUsTwitter() 
	{
		WebElement scrolldown = driver.findElement(By.xpath("//h2[text()='Payment Method']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", scrolldown);
		driver.findElement(By.xpath("//img[@src='https://medical.qiotic.info/website/images/footer/social/twitter.svg']")).click();
	}
	
	@Test(priority=26, enabled=false)
	public void ConnectWithUsFacebook() 
	{
		WebElement scrolldown = driver.findElement(By.xpath("//h2[text()='Payment Method']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", scrolldown);
		driver.findElement(By.xpath("//img[@src='https://medical.qiotic.info/website/images/footer/social/facebook.svg']")).click();
	}

	@Test(priority=27, enabled=false)
	public void ConnectWithUsGoogle() 
	{
		WebElement scrolldown = driver.findElement(By.xpath("//h2[text()='Payment Method']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", scrolldown);
		driver.findElement(By.xpath("//img[@src='https://medical.qiotic.info/website/images/footer/social/google-plus.svg']")).click();
	}
	
	@Test(priority=28, enabled=false)
	public void ConnectWithUsLinkedIn() 
	{
		WebElement scrolldown = driver.findElement(By.xpath("//h2[text()='Payment Method']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", scrolldown);
		driver.findElement(By.xpath("//img[@src='https://medical.qiotic.info/website/images/footer/social/linkedin.svg']")).click();
	}
	
	@Test(priority=29, enabled=false)
	public void HelpPageCheck()
	{
		WebElement scrolldown = driver.findElement(By.xpath("//h2[text()='Payment Method']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", scrolldown);
		driver.findElement(By.xpath("//a[text()='Help']")).click();
		boolean Actual = driver.findElement(By.xpath("//li[text()='Help']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=30, enabled=false)
	public void HelpPageInformation()
	{
		WebElement scrolldown = driver.findElement(By.xpath("//h2[text()='Payment Method']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", scrolldown);
		driver.findElement(By.xpath("//a[text()='Information']")).click();
		boolean Actual = driver.findElement(By.xpath("//li[text()='Information']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=31, enabled=false)
	public void HelpPagePrivacyPolicy()
	{
		WebElement scrolldown = driver.findElement(By.xpath("//h2[text()='Payment Method']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", scrolldown);
		driver.findElement(By.xpath("//a[text()='Privacy Policy']")).click();
		boolean Actual = driver.findElement(By.xpath("//li[text()='Privacy Ploicy']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=32, enabled=false)
	public void HelpPageShippingDetails()
	{
		WebElement scrolldown = driver.findElement(By.xpath("//h2[text()='Payment Method']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", scrolldown);
		driver.findElement(By.xpath("//a[text()='Shipping Details']")).click();
		boolean Actual = driver.findElement(By.xpath("//li[text()='Shipping Details']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=33, enabled=false)
	public void HelpPageAboutUs()
	{
		WebElement scrolldown = driver.findElement(By.xpath("//h2[text()='Payment Method']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", scrolldown);
		driver.findElement(By.xpath("(//a[text()='About Us'])[3]")).click();
		boolean Actual = driver.findElement(By.xpath("//li[text()='About Us']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=34, enabled=false)
	public void HelpPageCareers()
	{
		WebElement scrolldown = driver.findElement(By.xpath("//h2[text()='Payment Method']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", scrolldown);
		driver.findElement(By.xpath("//a[text()='Careers']")).click();
		boolean Actual = driver.findElement(By.xpath("//li[text()='Careers']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=35, enabled=false)
	public void HelpPageRefundsReturns()
	{
		WebElement scrolldown = driver.findElement(By.xpath("//h2[text()='Payment Method']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", scrolldown);
		driver.findElement(By.xpath("//a[text()='Refunds & Returns']")).click();
		boolean Actual = driver.findElement(By.xpath("//li[text()='Refunds & Returns']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=36, enabled=false)
	public void HelpPageDeliveries()
	{
		WebElement scrolldown = driver.findElement(By.xpath("//h2[text()='Payment Method']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", scrolldown);
		driver.findElement(By.xpath("//a[text()='Deliveries']")).click();
		boolean Actual = driver.findElement(By.xpath("//li[text()='Deliveries']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=37)
	public void HelpPageAdvancedSearch()
	{
		WebElement scrolldown = driver.findElement(By.xpath("//h2[text()='Payment Method']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", scrolldown);
		driver.findElement(By.xpath("//a[text()='Advanced Search']")).click();
		boolean Actual = driver.findElement(By.xpath("//li[text()='Advanced Search']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=38)
	public void HelpPageHelpFaqs()
	{
		WebElement scrolldown = driver.findElement(By.xpath("//h2[text()='Payment Method']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", scrolldown);
		driver.findElement(By.xpath("//a[text()='Help & Faqs']")).click();
		boolean Actual = driver.findElement(By.xpath("//li[text()='Help']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=39)
	public void HelpPageStoreLocation()
	{
		WebElement scrolldown = driver.findElement(By.xpath("//h2[text()='Payment Method']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", scrolldown);
		driver.findElement(By.xpath("//a[text()='Store Location']")).click();
		boolean Actual = driver.findElement(By.xpath("//li[text()='Store Location']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=40)
	public void HelpPageOrdersReturns()
	{
		WebElement scrolldown = driver.findElement(By.xpath("//h2[text()='Payment Method']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", scrolldown);
		driver.findElement(By.xpath("//a[text()='Orders & Returns']")).click();
		boolean Actual = driver.findElement(By.xpath("//li[text()='Orders & Returns']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	

	
	


}
