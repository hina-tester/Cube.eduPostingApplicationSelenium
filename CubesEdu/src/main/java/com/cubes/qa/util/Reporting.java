package com.cubes.qa.util;

//Listener class used to generate Extent reports

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
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.relevantcodes.extentreports.HTMLReporter;


public class Reporting extends TestListenerAdapter
{
	public HTMLReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	TestUtil util;
	
		
	public void onStart(ITestContext testContext)
	{
		util= new TestUtil();
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html";
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/"+repName);
		
	htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","Hina");
		
		htmlReporter.config().setDocumentTitle("Cubes.Edu Test Project"); // Tile of report
		htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
	//	htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);//location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
		logger.log(Status.PASS, "TEST CASE FAILED IS :"+tr.getMethod().getDescription()); 
	}
	
	public void onTestFailure(ITestResult tr)
	{
	
		 System.out.println("TEST CASE FAILED IS" +tr.getName() + " failed");
		 
	
		logger=extent.createTest(tr.getName()); // create new entry in th report
		
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
				
		//new added line
		//to add error/exception in extent report
		logger.log(Status.FAIL, "TEST CASE FAILED IS :"+tr.getMethod().getDescription()); 
		logger.log(Status.FAIL, "TEST CASE FAILED IS :"+tr.getThrowable()); 
        String screenshotPath= TestUtil.getScreenshot( "TEST CASE FAILED IS: "+tr.getName());
        
		
//		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		
		File f = new File(screenshotPath); 
		
		if(f.exists())
		{
		try {
			logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
			} 
		catch (IOException e) 
				{
				e.printStackTrace();
				}
		
		}}
	
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
		logger.log(Status.SKIP, "TEST CASE FAILED IS :"+tr.getMethod().getDescription()); 
		logger.log(Status.SKIP, "TEST CASE FAILED IS :"+tr.getThrowable()); 
		
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
}
