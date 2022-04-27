package com.telemed.ExtentReportListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
// import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager extends TestListenerAdapter{
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	public static ExtentReports getReports() {
		if(extent == null){
			extent = new ExtentReports();
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
			String repName="Test-Report-"+timeStamp+".html";
			
			htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/test-output/"+repName);//specify location of the report
			try {
				htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent.xml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			extent=new ExtentReports();
			
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Build","23");
			extent.setSystemInfo("Host name","Telemed App");
			extent.setSystemInfo("Environemnt","QA");
			extent.setSystemInfo("User","Sreedhar");
			extent.setSystemInfo("Platform Name","Android");
			extent.setSystemInfo("Platform Version","11.0");

			
			htmlReporter.config().setDocumentTitle("Caduceus"); // Title of report
			htmlReporter.config().setReportName("Telemed Automation Report"); // name of the report
			//htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
			htmlReporter.config().setTheme(Theme.STANDARD);
			
		}
		return extent;
	}
	
	
	public void onTestSuccess(ITestResult tr)
	{
		// logger=extent.createTest(tr.getName()); // create new entry in the report
		// logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
	}
	
	public void onTestFailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
		
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		
		File f = new File(screenshotPath); 
		
		if(f.exists())
		{
		logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
		}
		
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
}