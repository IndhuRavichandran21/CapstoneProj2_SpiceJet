package utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.ProjectSpecificationMethod;

public class Listener extends ProjectSpecificationMethod implements ITestListener{

	ExtentReports extentReports = SpiceJetReport.getReport();
	ExtentTest test; //to categorize the test report
	String screenshotFilePath;
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" is started");
		test = extentReports.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" is passed");
		test.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" is failed");
		
		test.fail(result.getThrowable());
		try {
			screenshotFilePath = takeScreenshot(result.getMethod().getMethodName());//In case of failure take screenshot
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(screenshotFilePath,result.getMethod().getMethodName()); //add the screenshot to the test report
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
	}

}
