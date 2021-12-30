package com.extentreport;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ExtentReportDemowithTestNG 
{
	ExtentSparkReporter htmlReporter;
	ExtentSparkReporter sparkFail;
	ExtentSparkReporter sparkAll;
	ExtentReports extent;
	
		@BeforeSuite
	public void setUp() 
	{
		
		/*
		 * // start reporters 
		 * htmlReporter = new ExtentSparkReporter("extent.html");
		 * 
		 * // create ExtentReports and attach reporter(s) 
		 * extent = new ExtentReports();
		 * extent.attachReporter(htmlReporter);
		 */
			
			// will only contain failures
		 sparkFail = new ExtentSparkReporter("target/SparkFail.html")
			  .filter()
			    .statusFilter()
			    .as(new Status[] { Status.FAIL })
			  .apply();
	        
			
			// will contain all tests
			 sparkAll = new ExtentSparkReporter("spark/SparkAll.html")
			 .viewConfigurer()
			    .viewOrder()            //If you intend to change the view order to a view other than Test as the primary
			    .as(new ViewName[] { 
				   ViewName.DASHBOARD, 
				   ViewName.TEST, 
				   ViewName.CATEGORY,
				   ViewName.AUTHOR, 
				   ViewName.DEVICE, 
				   ViewName.EXCEPTION, 
				   ViewName.LOG 
				})
			  .apply();
			 extent = new ExtentReports();
			 
			extent.attachReporter(sparkFail, sparkAll);
	}
		@Test
		public void Test() 
		{
			 // creates a toggle for the given test, adds all log events under it    
	        ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
	        
	     // log(Status, details)
	        test.log(Status.INFO, "This step shows usage of log(status, details)");

	        // info(details)
	        test.info("This step shows usage of info(details)");
	        
	        // log with snapshot
	        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
	        
	        // test with snapshot
	        test.addScreenCaptureFromPath("screenshot.png");        
	}
		@Test
		public void Test1() 
		{
			 // creates a toggle for the given test, adds all log events under it    
	        ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
	        
	     // log(Status, details)
	        test.log(Status.INFO, "This step shows usage of log(status, details)");

	        // info(details)
	        test.info("This step shows usage of info(details)");
	        
	        // log with snapshot
	        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
	        
	        // test with snapshot
	        test.addScreenCaptureFromPath("screenshot.png");        
	}	
		@AfterSuite
		public void tearDown() 
		{
			 // calling flush writes everything to the log file
	        extent.flush();	
		}
}
