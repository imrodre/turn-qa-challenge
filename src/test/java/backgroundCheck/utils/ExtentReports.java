package backgroundCheck.utils;

import java.util.Calendar;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * Allows custom report creation trough Extent Reports library
 * 
 * @author Rodrigo Moran
 */
public class ExtentReports {
	
	static com.aventstack.extentreports.ExtentReports extent;
	
	/**
	 * Do Report configurations like directory, title, etc...
	 * @return Configured ExtentReports instance
	 */
	static public com.aventstack.extentreports.ExtentReports getReport() {
		
		String path = System.getProperty("user.dir") + "/reports/index.html"; //e.g file:///C:/Users/rodrigo.moran1/eclipse-workspace/background-check/reports/index.html
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path); //Configure reporter
		reporter.config().setReportName("Background Check Test Results");
		reporter.config().setDocumentTitle("Background Check_" + Calendar.getInstance());
		
		extent = new com.aventstack.extentreports.ExtentReports(); //Configure actual report
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", System.getProperty("user.name"));
		
		return extent;
	}

}
