package MedHubProject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import TestData.TestBase;

public class HomePage extends TestBase {
	public HomePage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	WebDriver driver;
	@Parameters({"URL"})
	@BeforeMethod
	public void setup()
	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--incognito");
	    System.setProperty("webdriver.chrome.driver","C:\\Users\\ahmad\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		driver = new ChromeDriver(option);
		driver.get("https://gb.qiotic.info/");
		driver.manage().window().maximize();
        driver.findElement(By.id("cky-btn-accept")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
		WebElement list = driver.findElement(By.xpath("//ul[@class='header-dropdown']"));
		list.findElements(By.tagName("a")).get(1).click();
		driver.findElement(By.id("email")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
        
    }
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	

	@Test(priority=4, groups= {"Home"})
	public void SearchCheck()
	{
		driver.findElement(By.xpath("(//img[@class='img-fluid'])[2]")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Work");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
	}
	
	@Test(priority=5, groups= {"Home"})
	public void CartCheck()
	{
	    driver.findElement(By.xpath("(//img[@class='img-fluid'])[3]")).click();	
	    driver.findElement(By.xpath("//a[@class='view-cart']")).click();
	    boolean Actual = driver.findElement(By.xpath("//li[@class='breadcrumb-item active']")).isDisplayed();
	    Assert.assertTrue(Actual);
	}

	
	
	
	
	
	
	
	
	
	
}
