package gproject.prac;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentreporterNg
{
	static ExtentReports extent;
	
public static ExtentReports getReportObject()
{
	String path = System.getProperty("user.dir")+"\\reports\\"+"index.html";
	ExtentSparkReporter reporter=new ExtentSparkReporter(path);
	reporter.config().setReportName("WebApp TEST");
	reporter.config().setDocumentTitle("TEST Result");
	
	extent=new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("tester","Nisha G");
	return extent;

}
}
