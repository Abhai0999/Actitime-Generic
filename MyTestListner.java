package com.actitime.generic;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;
public class MyTestListner implements ITestListener
{
	public static int excecutionCount,passCount,failCount,SkipCount=0;
	public long startTime,endTime=0;
	public void onTestStart(ITestResult result) 
	{
		excecutionCount++;
		Reporter.log(result.getName()+" Script Execution Starts "+new Date(),true);
	}
	
	public void onTestSuccess(ITestResult result) 
	{
		passCount++;
	Reporter.log(result.getName()+" Script Execution Passed ",true);
	}
	public void onTestFailure(ITestResult result) 
	{
		failCount++;
	Reporter.log(result.getName()+" Script Execution Failed "+new Date(),true);
	}	public void onTestSkipped(ITestResult result) 
	{
		SkipCount++;
		Reporter.log(result.getName()+" Script is Skipped ",true);
		TakesScreenshot ts=(TakesScreenshot)BaseLib.driver;
		File srcfile=ts.getScreenshotAs(OutputType.FILE);
		File destfile=new File("./ScreenShots/"+result.getName()+".png");
		try 
		{
			Files.copy(srcfile, destfile);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		Reporter.log(" ScreenShot Has been Captutred ",true);
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
		
	}
	public void onStart(ITestContext context) 
	{
		startTime=System.currentTimeMillis();
	 	Reporter.log(" Script Execution Stsrts "+new Date(),true);	
	}
	public void onFinish(ITestContext context) 
	{
		Reporter.log("Suite Execution Ends "+ new Date(),true);
		endTime=System.currentTimeMillis();
		double TotalTime = (endTime-startTime)/1000;
		Reporter.log("Total Batch Execution Time: "+TotalTime+" Seconds");
		Reporter.log("Total Script Executed "+excecutionCount,true);
		Reporter.log("Total Script Passed "+passCount,true);
		Reporter.log("Total Script Failed "+failCount,true);
		Reporter.log("Total Script Failed "+SkipCount,true);
}}
