package extentlisteners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testclasses.BaseTest;
import utility.ScreenshotWithMethod;



public class TestNGListeners extends BaseTest implements ITestListener
{
public static ExtentTest test;
	ExtentReports extent = ExtentReportGen.extentReportGenerator();
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Testcase started : "+ result.getName());
			 test = extent.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String nameOfTestCase = result.getName();
		
		System.out.println(nameOfTestCase+" Test case passed");
		
		test.log(Status.PASS, "Test case is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String nameOfTestCase = result.getName();
		
		System.out.println(nameOfTestCase+" Test case failed");
		
		test.fail(result.getThrowable());
		try {
		String path = ScreenshotWithMethod.captureScreenshot(driver, nameOfTestCase);
				
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			System.out.println("Exception arrived while taking the screenshot");
		}
		
		
		
		
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String nameofTestcase = result.getName(); 
		System.out.println(nameofTestcase+" Test case skipped");
		
		test.log(Status.SKIP, "Testcase got skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test tag started");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test tag finished");
		extent.flush();
	}

	

	

}
