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
	
	@BeforeSuite(groups={"fixed"})
	public void Started()
	{
		started();
	}
	
	@AfterSuite(groups={"fixed"})
	public void Finished()
	{
		finished();
	}
	
	@BeforeMethod(groups={"fixed"})
	public void Setup(Method method) throws ATUTestRecorderException
	{
		beforetest(method.getName());
    }
	

	@AfterMethod(groups={"fixed"})
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
	
	@Test(priority=1)
	public void LanguageButtonCheck()
	{
		driver.findElement(By.id("navbarDropdown")).click();
		boolean Actual = driver.findElement(By.xpath("//a[contains(@class,'nav-link')]")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	
	@Test(priority=2)
	public void PhoneNumberCheck()
	{
		driver.findElement(By.xpath("//span[text()='+962 797561465']")).click();
	}
	
	@Test(priority=3)
	public void ContuctCheck()
	{
		driver.findElement(By.xpath("//a[text()='Contact Us']")).click();
		driver.findElement(By.xpath("//input[@placeholder='First Name *']")).sendKeys("Ahmad");
		driver.findElement(By.xpath("//input[@placeholder='Last Name *']")).sendKeys("Test");
		driver.findElement(By.xpath("//textarea[@placeholder='Message *']")).sendKeys("Hi MedicalHub");
		driver.findElement(By.xpath("//span[@class='button_text_container']")).click();
	}
	
	@Test(priority=4)
	public void FacebookCheck()
	{
		driver.findElement(By.xpath("//i[contains(@class,'fa fa-facebook-f')]")).click();
	}
	

	@Test(priority=5)
	public void LinkedInCheck()
	{
		driver.findElement(By.xpath("//i[contains(@class,'fa fa-linkedin-in')]")).click();
	}
	

	@Test(priority=6)
	public void TwitterCheck()
	{
		driver.findElement(By.xpath("//i[contains(@class,'fa fa-twitter')]")).click();
	}
	

	@Test(priority=7)
	public void InstagrameCheck()
	{
		driver.findElement(By.xpath("//i[contains(@class,'fa fa-instagram')]")).click();
	}
	
	@Test(priority=8)
	public void SnapchatCheck()
	{
		driver.findElement(By.xpath("//i[contains(@class,'fa fa-snapchat-ghost')]")).click();
	}
	
	@Test(priority=9)
	public void AboutUsCheck()
	{
		WebElement about = driver.findElement(By.xpath("(//a[@class='nav-link'])[6]"));
		Actions action = new Actions(driver);
		action.moveToElement(about).build().perform();
		boolean Actual = driver.findElement(By.xpath("//a[text()='Our Company']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=10)
	public void DirectoriesCheck()
	{
		WebElement about = driver.findElement(By.xpath("(//a[@class='nav-link'])[7]"));
		Actions action = new Actions(driver);
		action.moveToElement(about).build().perform();
	}
	
	@Test(priority=11)
	public void ServicesCheck()
	{
		WebElement about = driver.findElement(By.xpath("(//a[@class='nav-link'])[8]"));
		Actions action = new Actions(driver);
		action.moveToElement(about).build().perform();
		boolean Actual = driver.findElement(By.xpath("//a[text()='Ecommerce']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=12)
	public void BlogsNewsCheck()
	{
		WebElement about = driver.findElement(By.xpath("(//a[@class='nav-link'])[9]"));
		Actions action = new Actions(driver);
		action.moveToElement(about).build().perform();
	}
	

	@Test(priority=13)
	public void MedicalTourisumCheck()
	{
		WebElement about = driver.findElement(By.xpath("(//a[@class='nav-link'])[10]"));
		Actions action = new Actions(driver);
		action.moveToElement(about).build().perform();
	}
	
	@Test(priority=14)
	public void MyCartCheck()
	{
		driver.findElement(By.xpath("//a[contains(@class,'nav-link shop-now-btn')]")).click();
		driver.findElement(By.xpath("//h3[text()='Diabetic Care']")).click();
		driver.findElement(By.xpath("(//i[contains(@class,'fa fa-shopping-cart')])[2]")).click();
		driver.findElement(By.xpath("(//i[contains(@class,'fa fa-shopping-cart')])[3]")).click();
		WebElement scrolldown = driver.findElement(By.xpath("//h3[text()='Diabetic Care']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", scrolldown);
		
		driver.findElement(By.id("cart")).click();
		boolean Actual = driver.findElement(By.xpath("//a[text()='Your cart']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=15)
	public void SearchCheck()
	{
		driver.findElement(By.id("search-popup")).click();
		driver.findElement(By.id("searchbox")).sendKeys("Brand");
		driver.findElement(By.id("searchsubmit")).click();
	}
	

	@Test(priority=16)
	public void ShopNowCheck()
	{
    	driver.findElement(By.xpath("//span[@class='button_text_container']")).click();
    	boolean Actual = driver.findElement(By.xpath("//h1[text()='Start-ups and solutions']")).isDisplayed();
    	Assert.assertTrue(Actual);
	}
	
	@Test(priority=17, groups= {"fixed"})
	public void HosptialCheck()
	{
    	driver.findElement(By.xpath("(//span[@class='button_text_container'])[2]")).click();
    	String Actual = driver.getCurrentUrl();
    	String Expected = "https://medical-hub.com/en/hospital/login";
    	Assert.assertEquals(Actual, Expected);
	}
	
	@Test(priority=18, groups= {"fixed"})
	public void VendorCheck()
	{
    	driver.findElement(By.xpath("(//span[@class='button_text_container'])[3]")).click();
    	String Actual = driver.getCurrentUrl();
    	String Expecetd = "https://medical-hub.com/en/merchant/login";
    	Assert.assertEquals(Actual, Expecetd);
	}
	
	@Test(priority=19)
	public void ConsultancyCheck()
	{
    	driver.findElement(By.xpath("(//span[@class='button_text_container'])[4]")).click();
    	boolean Actual = driver.findElement(By.xpath("//h2[text()='Consultancy']")).isDisplayed();
    	Assert.assertTrue(Actual);
	}
	
	@Test(priority=20)
	public void OurMissionCheck()
	{
		Actions action = new Actions(driver);
		WebElement ourmission = driver.findElement(By.xpath("//h3[text()='Our Mission']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", ourmission);
    	action.moveToElement(ourmission).build().perform();
	}
	

	@Test(priority=21)
	public void OurVisionCheck()
	{
		Actions action = new Actions(driver);
		WebElement ourmission = driver.findElement(By.xpath("//h3[text()='Our Vision']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", ourmission);
    	action.moveToElement(ourmission).build().perform();
	}
	
	@Test(priority=22)
	public void OurValueCheck()
	{
		Actions action = new Actions(driver);
		WebElement ourmission = driver.findElement(By.xpath("//h3[text()='Our Value']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", ourmission);
    	action.moveToElement(ourmission).build().perform();
	}
	
	@Test(priority=23, groups= {"fixed"})
	public void LatestNews()
	{
		WebElement scrolldown = driver.findElement(By.xpath("//span[text()='News']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", scrolldown);
    	driver.findElement(By.xpath("(//span[@class='button_text_container'])[5]")).click();
	}
	
	@Test(priority=24)
	public void SubscribNow()
	{
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("ahmadmalloh97@gmail.com");
		driver.findElement(By.xpath("//i[contains(@class,'fa fa-long-arrow-right')]")).click();
	}
	
	@Test(priority=25)
	public void ConnectWithUsTwitter() 
	{
		WebElement scrolldown = driver.findElement(By.xpath("//h2[text()='Payment Method']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", scrolldown);
		driver.findElement(By.xpath("//div[contains(@class,'social twitter')]")).click();
	}
	
	@Test(priority=26)
	public void ConnectWithUsFacebook() 
	{
		WebElement scrolldown = driver.findElement(By.xpath("//h2[text()='Payment Method']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", scrolldown);
		driver.findElement(By.xpath("//div[contains(@class,'social facebook')]")).click();
	}

	@Test(priority=27)
	public void ConnectWithUsGoogle() 
	{
		WebElement scrolldown = driver.findElement(By.xpath("//h2[text()='Payment Method']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", scrolldown);
		driver.findElement(By.xpath("//div[contains(@class,'social google')]")).click();
	}
	
	@Test(priority=28)
	public void ConnectWithUsLinkedIn() 
	{
		WebElement scrolldown = driver.findElement(By.xpath("//h2[text()='Payment Method']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", scrolldown);
		driver.findElement(By.xpath("//div[contains(@class,'social linkedin')]")).click();
	}

	@Test(priority=30)
	public void HelpPageInformation()
	{
		WebElement scrolldown = driver.findElement(By.xpath("//h2[text()='Payment Method']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", scrolldown);
		driver.findElement(By.xpath("//a[text()='Information']")).click();
		boolean Actual = driver.findElement(By.xpath("//li[text()='Information']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=31)
	public void HelpPagePrivacyPolicy()
	{
		WebElement scrolldown = driver.findElement(By.xpath("//h2[text()='Payment Method']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", scrolldown);
		driver.findElement(By.xpath("//a[text()='Privacy Policy']")).click();
		boolean Actual = driver.findElement(By.xpath("//h1[text()='Privacy Policy']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=32)
	public void HelpPageShippingDetails()
	{
		WebElement scrolldown = driver.findElement(By.xpath("//h2[text()='Payment Method']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", scrolldown);
		driver.findElement(By.xpath("//a[text()='Shipping Details']")).click();
		boolean Actual = driver.findElement(By.xpath("//li[text()='Shipping Details']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=33)
	public void HelpPageAboutUs()
	{
		WebElement scrolldown = driver.findElement(By.xpath("//h2[text()='Payment Method']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", scrolldown);
		driver.findElement(By.xpath("(//a[text()='About Us'])[3]")).click();
		boolean Actual = driver.findElement(By.xpath("//li[text()='About Us']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=34)
	public void HelpPageCareers()
	{
		WebElement scrolldown = driver.findElement(By.xpath("//h2[text()='Payment Method']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", scrolldown);
		driver.findElement(By.xpath("//a[text()='Careers']")).click();
		boolean Actual = driver.findElement(By.xpath("//li[text()='Careers']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=35)
	public void HelpPageRefundsReturns()
	{
		WebElement scrolldown = driver.findElement(By.xpath("//h2[text()='Payment Method']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", scrolldown);
		driver.findElement(By.xpath("//a[text()='Refunds & Returns']")).click();
		boolean Actual = driver.findElement(By.xpath("//li[text()='Refunds & Returns']")).isDisplayed();
		Assert.assertTrue(Actual);
	}
	
	@Test(priority=36)
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
		boolean Actual = driver.findElement(By.xpath("//h3[text()='Shop by Category']")).isDisplayed();
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
