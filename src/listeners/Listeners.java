package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{
	
	@Override  
	public void onTestStart(ITestResult result) {  
	// TODO Auto-generated method stub  
		System.out.println("Lets Test");
	}  
	  
	@Override  
	public void onTestSuccess(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Congrats, testcase is pass");  
	}  
	  
	@Override  
	public void onTestFailure(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Ohhps, testcase is fail!!");  
	}  
	  
	@Override  
	public void onTestSkipped(ITestResult result) {  
	// TODO Auto-generated method stub  
	  
	}  
	  
	@Override  
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
	// TODO Auto-generated method stub  
	  
	}  
	  
	@Override  
	public void onStart(ITestContext context) {  
	System.out.println("Lets Test");  
	}  
	  
	@Override  
	public void onFinish(ITestContext context) {  
	System.out.println("Finished");  
	} 

}
