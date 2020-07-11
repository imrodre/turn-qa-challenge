package backgroundCheck.utils;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

/**
 * A listener class to develop custom logic for: onTestStart onFinish
 * onTestSuccess onTestFailure
 * 
 * @author Rodrigo Moran
 */
public class TestListener implements ITestListener {

	ExtentReports report = backgroundCheck.utils.ExtentReports.getReport();
	ExtentTest test;
	long testExecutionTimeStamp;

	/**
	 * Invoked each time before a test will be invoked.
	 * 
	 * @param result the partially filled <code>ITestResult</code>
	 * 
	 */
	@Override
	public void onTestStart(ITestResult result) {
		testExecutionTimeStamp = Calendar.getInstance().getTimeInMillis();
		test = report.createTest(result.getMethod().getMethodName() + "_" + testExecutionTimeStamp); //Create a test report for each test execution
	}

	/**
	 * Invoked after all the test methods belonging to the classes inside the
	 * &lt;test&gt; tag have run and all their Configuration methods have been
	 * called.
	 */
	@Override
	public void onFinish(ITestContext context) {
		report.flush(); //Flushes the stream, write them immediately to their intended destination report
	}

	/**
	 * Invoked each time a test succeeds.
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed"); //Report log test passed message
	}

	/**
	 * Invoked each time a test fails.
	 */
	@Override
	public void onTestFailure(ITestResult result) {

		test.log(Status.FAIL, "Test Failed");  //Report log test failed message
		test.fail(result.getThrowable());  //Report log test stacktrace

		//Take test screenshot at the moment of failure
		WebDriver driver = (WebDriver) result.getTestContext().getAttribute("WebDriver");
		File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String directoryName = System.getProperty("user.home") + "/FAILED_TESTS_SCREENSHOTS";
		File directory = new File(directoryName);
		String fileName = String.format(result.getMethod().getMethodName() + "_" + testExecutionTimeStamp);

		if (!directory.exists())
			directory.mkdir();

		File DestFile = new File(directoryName + "/" + fileName);

		try {
			FileHandler.copy(SrcFile, DestFile); //Create file at local machine
			test.addScreenCaptureFromPath(directoryName + "/" + fileName); //Attach screenshot to report
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}