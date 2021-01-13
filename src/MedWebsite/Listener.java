package MedWebsite;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener{
	
	public void onStart(ITestContext context) {	
		System.out.println("Test is Starting");
	}

	public void onFinish(ITestContext context) {
		System.out.println("Congrats, Testing Finished ");
	}
	
		public void onTestStart(ITestResult result) {
			System.out.println("New Test Started  " +result.getName());
		}
		
		public void onTestSuccess(ITestResult result) {
			System.out.println("onTestSuccess Method  " +result.getName());
		}

		public void onTestFailure(ITestResult result) {
			System.out.println("Opps, TestCase Fail  " +result.getName());
		}

		public void onTestSkipped(ITestResult result) {
			System.out.println("onTestSkipped Method  " +result.getName());
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			System.out.println("onTestFailedButWithinSuccessPercentage" +result.getName());
		}
}
	

