package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class MyListener implements ITestListener{

	ExtentReports e;
	ExtentTest t;
	ScreenShotUtility s;
	public void onTestStart(ITestResult result) {
		System.out.println("Test Case Started");
		t.log(LogStatus.INFO, result.getMethod().getMethodName()+"has started");
	}
	
public void onTestSuccess(ITestResult result) {
	System.out.println("Test Case Passed");
	try {
	t.log(LogStatus.PASS, "Screenshot" +t.addScreenCapture(s.takeScreenshot()));
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	}

public void onTestFailure(ITestResult result) {
	System.out.println("Test Case Failed");	
	t.log(LogStatus.FAIL, result.getMethod().getMethodName()+"has failed");
}

public void onSkipped(ITestResult result) {
	System.out.println("Test Case Skipped");
	t.log(LogStatus.SKIP, result.getMethod().getMethodName()+"has skipped");
}

public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	//System.out.println("Test Case ");	
}

public void onStart(ITestContext context) {
	s = new ScreenShotUtility();
	System.out.println("TestNG started");	
	e = new ExtentReports("TestReport\\MyReport.html");
	t = e.startTest("LoginTest has started");
	e.addSystemInfo("Browser", "Chrome");
	e.addSystemInfo("Build", "Smoke Testing");
}


public void onFinish(ITestContext context) {
	System.out.println("TestNG Finished ");	
	e.endTest(t);
	e.flush();
}


}
