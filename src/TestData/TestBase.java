package TestData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class TestBase {
	
	static public Properties prop; 
	static public ATUTestRecorder recorder;
	static public WebDriver driver;
	
	
	
	public TestBase() throws IOException
	{
		prop = new Properties();
		FileInputStream file = new FileInputStream("D:\\Users\\ahmad\\eclipse-workspace\\Qiotic_Projects\\src\\config\\data.properties"); 
		prop.load(file);
	}

	
	
}
