package com.utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.reuseability.HelperClass;
import com.reuseability.Parentclass;



public class BaseClass
{
	public WebDriver driver;
	public ExcelClass ex;
	public ConfigClass co;
	public ExtentReports report;
	public ExtentTest log;
	
	
	@BeforeSuite
	public void start() throws IOException
	{
		ex = new ExcelClass();
		co=new ConfigClass();
		ExtentSparkReporter extent = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/"+HelperClass.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		
		
	}
	@BeforeClass
	public WebDriver setup()
	{
		return driver=Parentclass.Application(driver,co.getBrowser(),co.getURL());
	}
	
	@AfterClass
	public void close()
	{
		Parentclass.quitBrowser(driver);
	}
	
	@AfterMethod
	public void ssMethod(ITestResult result) throws Exception
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			//HelperClass.screenShot(driver);
			log.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(HelperClass.screenShot(driver)).build());
			log.fail("Oops! The testcase failed");
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			log.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(HelperClass.screenShot(driver)).build());
			log.pass("Hurray! TestCase is passed");
		}
		report.flush();
	}
	
}
