package gproject.prac;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;




public class Listeners extends Baseclass implements ITestListener
{ExtentTest test;
ExtentReports extent=ExtentreporterNg.getReportObject();
ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();//for parallel execution 

	@Override
	public void onTestStart(ITestResult result) {
	
	//	ITestListener.super.onTestStart(result);
		test =extent.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onTestSuccess(result);
		extentTest.get().log(Status.PASS,"Test Pass");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		WebDriver driver=null;
		
		// TODO Auto-generated method stub;
	//	ITestListener.super.onTestFailure(result);
		extentTest.get().fail(result.getThrowable());//gives log of failure
		String testMethodName= result.getMethod().getMethodName();
		try {
	driver=	(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());//to get driver instance to send in screenshot method call
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver),result.getMethod().getMethodName()); 

			
			getScreenShotPath(testMethodName,driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onFinish(context);
		extent.flush();
	}
	
}
