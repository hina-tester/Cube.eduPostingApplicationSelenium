package com.cubes.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.cubes.qa.base.TestBase;



public class TestUtil extends TestBase{
	
	
	public static long PAGE_LOAD_TIMEOUT  = 20;
	public static long  IMPLICIT_WAIT = 10;
	
		
	 public static void takeScreenshotAtEndOfTest() throws IOException {
		  
		  File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  String currentDir = System.getProperty("user.dir");
		  FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" +  System.currentTimeMillis() + ".png"));
		  
		  }
	 
	 public static String getScreenshot(String name)
		{
			TakesScreenshot ts=(TakesScreenshot) driver;
			
			File src=ts.getScreenshotAs(OutputType.FILE);
			
			String path=System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";
			
			File destination=new File(path);
			
			try 
			{
				FileUtils.copyFile(src, destination);
			} catch (IOException e) 
			{
				System.out.println("Capture Failed "+e.getMessage());
			}
			
			return path;
		}
	 
		
	 public static String takeScreenShot(WebDriver driver, String screenshotName) throws IOException{
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			// after execution, you could see a folder "FailedTestsScreenshots"
			// under src folder
			String destination = System.getProperty("user.dir") + "/screenshots/" + screenshotName + dateName
					+ ".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			
			return destination;
		}
		
	  
	  public static void runTimeInfo(String messageType, String message) throws InterruptedException {
		  JavascriptExecutor js = (JavascriptExecutor) driver;
			js = (JavascriptExecutor) driver;
			// Check for jQuery on the page, add it if need be
			js.executeScript("if (!window.jQuery) {"
					+ "var jquery = document.createElement('script'); jquery.type = 'text/javascript';"
					+ "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
					+ "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
			Thread.sleep(5000);

			// Use jQuery to add jquery-growl to the page
			js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");

			// Use jQuery to add jquery-growl styles to the page
			js.executeScript("$('head').append('<link rel=\"stylesheet\" "
					+ "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
			Thread.sleep(5000);

			// jquery-growl w/ no frills
			js.executeScript("$.growl({ title: 'GET', message: '/' });");
	//'"+color+"'"
			if (messageType.equals("error")) {
				js.executeScript("$.growl.error({ title: 'ERROR', message: '"+message+"' });");
			}else if(messageType.equals("info")){
				js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
			}else if(messageType.equals("warning")){
				js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
			}else
				System.out.println("no error message");
			// jquery-growl w/ colorized output
//			js.executeScript("$.growl.error({ title: 'ERROR', message: 'your error message goes here' });");
//			js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
//			js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
			Thread.sleep(5000);
		}



}