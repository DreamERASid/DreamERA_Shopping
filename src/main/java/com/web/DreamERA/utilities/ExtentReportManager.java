package com.web.DreamERA.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;

import org.testng.ITestResult;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener
{
	
	public ExtentSparkReporter esparkreporter;
	public ExtentReports extent;
	public ExtentTest etest;
	
	String reportname;
	
	 public void onStart(ITestContext context) 
	 {
		 
		 String timestamp=new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss").format(new Date());
		 reportname="Test-Reprot-"+timestamp+".html";
		
		 esparkreporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/"+reportname);
		 esparkreporter.config().setDocumentTitle("Functional Testing");
		 esparkreporter.config().setReportName("Siddhant's report");
		 esparkreporter.config().setTheme(Theme.STANDARD);
		 
		 
		 extent=new ExtentReports();
		 extent.attachReporter(esparkreporter);
		 extent.setSystemInfo("Tester Name", "Siddhant");
		
	 }
	 
	 public void onTestSuccess(ITestResult result)
	 {
		etest=extent.createTest(result.getName());
		etest.log(Status.PASS,"Test Case pass:- "+result.getName());
		
	  }
	 
	 public void onTestFailure(ITestResult result) {
		 etest=extent.createTest(result.getName());
			etest.log(Status.FAIL,"Test Case Failed:- "+result.getName());
			try
			{
				String imgpath=new evidenceImage().CaptureScreen(result.getName());
				etest.addScreenCaptureFromPath(imgpath);
			}catch(Exception e)
			{
				System.out.println(e);
			}
			
		  }
	 
	 public void onFinish(ITestContext context) {
		  extent.flush();
		  }
	 
	
	  
}
