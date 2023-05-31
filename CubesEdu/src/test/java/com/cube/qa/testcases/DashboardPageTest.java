package com.cube.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cubes.qa.base.TestBase;
import com.cubes.qa.pages.AddPostsPage;
import com.cubes.qa.pages.DashbordPage;
import com.cubes.qa.pages.LoginPage;
import com.cubes.qa.pages.PostsListPage;

public class DashboardPageTest extends TestBase {
	
	LoginPage loginPage;
	DashbordPage dashboardpage;
	PostsListPage postlistpage;
	AddPostsPage addpost;
	
	

	public DashboardPageTest(){
		super();
	}
	

	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
		dashboardpage = new DashbordPage();
		postlistpage = new PostsListPage();
		addpost = new AddPostsPage();
		
		dashboardpage = loginPage.login(prop.getProperty("email"), prop.getProperty("pw"));
				
	}

	@Test(priority=1)
	public void PostList(){
		
		postlistpage = dashboardpage.Postlist();	
			
	}
	
	@Test(priority=2)
	public void AddPost(){
		
		addpost = dashboardpage.AddPost();	
			
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
