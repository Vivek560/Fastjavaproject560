package ITLISTENER;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenersTest implements ITestListener{

	
	public void onTestStart(ITestResult result) {
		
		System.out.println("The test method execution is started="+result.getName());
	
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("The test method execution is successful="+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("The test method execution is failed="+result.getName());
		
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("The test execution is skipped="+result.getName());
	}

	public void onFinish(ITestContext context) {
		System.out.println("This is onFinish method=" +context.getPassedTests());
		System.out.println("This is onFinish method=" +context.getFailedTests());
	}
}
