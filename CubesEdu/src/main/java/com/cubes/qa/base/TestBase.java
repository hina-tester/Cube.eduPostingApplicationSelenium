package com.cubes.qa.base;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;


public class TestBase{
	


	public static WebDriver driver;
	public static Properties prop;
	public static Logger logger;
	
	
	
	public TestBase() {
	

		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\Selenium\\work space\\CubesEdu\\src\\main\\java\\com\\cubes\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
		public static void initialization(){
			
			logger = Logger.getLogger("Cubes Edu");
			PropertyConfigurator.configure("Log4j.properties");
			
			String browserName = prop.getProperty("browser");
			
			if(browserName.equals("chrome")){
				System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chrom\\chromedriver.exe");		
				driver = new ChromeDriver(); 
			}
		
				  else if(browserName.equals("FF")){
						System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\work space\\FreeCRMtest\\geckodriver.exe");	
						driver = new FirefoxDriver(); 
					
			}
			

	        
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		
			 driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 driver.manage().deleteAllCookies();
				
			driver.get(prop.getProperty("url"));
			
		}

		public void onTestStart(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onTestSuccess(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onTestFailure(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
			
		}

		public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub
			
		}

}
	

	
	
