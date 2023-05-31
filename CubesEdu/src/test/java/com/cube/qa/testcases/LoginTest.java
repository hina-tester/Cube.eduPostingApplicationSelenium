package com.cube.qa.testcases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.cubes.qa.base.TestBase;
import com.cubes.qa.pages.DashbordPage;
import com.cubes.qa.pages.LoginPage;

public class LoginTest extends TestBase{

	LoginPage loginPage;
	DashbordPage dashboardpage;
	

	public LoginTest(){
		super();
	}
	

	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
		dashboardpage = new DashbordPage();
		
		
		
	}
	
	
	@Test(priority=1)
	public void loginTest(){
		dashboardpage = loginPage.login(prop.getProperty("email"), prop.getProperty("pw"));
	}
	


	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}