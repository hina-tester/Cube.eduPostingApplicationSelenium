package com.cube.qa.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.cubes.qa.base.TestBase;
import com.cubes.qa.pages.AddPostsPage;
import com.cubes.qa.pages.DashbordPage;
import com.cubes.qa.pages.LoginPage;
import com.cubes.qa.pages.PostsListPage;
import com.cubes.qa.pages.ViewPostPage;

public class AddPostPageTest extends TestBase {
	
		
	LoginPage loginPage;
	DashbordPage dashboardpage;
	PostsListPage postlistpage;
	AddPostsPage addpost;
	ViewPostPage viewpostpage;
	

	public AddPostPageTest(){
		super();
	}
	
	

	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
		dashboardpage = new DashbordPage();
		postlistpage = new PostsListPage();
		addpost = new AddPostsPage();
		viewpostpage = new ViewPostPage();
		

		
		dashboardpage = loginPage.login(prop.getProperty("email"), prop.getProperty("pw"));
		addpost =  dashboardpage.AddPost();	
		
				
	}
	


	@Test(priority=1,description = "Add post with valid data")
	public void AddPost() throws InterruptedException{
		
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("document.body.style.zoom='50%'");
		
		Thread.sleep(2000);
		
		
		postlistpage=	addpost.AddPost();
		
		Thread.sleep(5000);
		
		postlistpage.searchinTable("new way to generate new way to generate new way to generate new way to generate");
		List<WebElement> ColumnList = driver.findElements(By.xpath("//*[@id='entities-list-table']/tbody/tr/td"));
	    
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("window.scrollBy(0,250)");
		 jse.executeScript("window.scrollBy(0,250)");
		 jse.executeScript("window.scrollBy(0,250)");


		Thread.sleep(5000);
boolean status=false;

for(WebElement ele:ColumnList)
{
	String value=ele.getText();
	//System.out.println("Complete Functional Testing Guide With Its Types And Example");
	if(value.contains("new way to generate")) {
		status=true;
		break;
		
	}
}


Assert.assertTrue(status,"fail");
	    }
		


	@Test(priority=2,description = "Add post with empty data")
	public void AddWothEmptyData() throws InterruptedException{
		
		
		
		boolean flag=	addpost.Addwithemptydata();
		
		Assert.assertTrue(flag);
		
	}
	


	@Test(priority=2,description = "Check Cancel button")
	public void Cancel() throws InterruptedException{
		
		
		
		postlistpage =	addpost.Cancel();
		
		String title = driver.getTitle();
		
		Assert.assertEquals(title,"Posts | Blog");
		
	}
	
	@Test(priority=3,description = "Check Home Link form Breadcrumb")
	public void Homelink() throws InterruptedException{
		
		
		
		dashboardpage =	addpost.checkhomelink();
		
		String title = driver.getTitle();
		
		Assert.assertEquals(title,"Admin Page | Blog");
		
	}
	
	
	@Test(priority=4,description = "Check Post Link form Breadcrumb")
	public void Postlink() throws InterruptedException{
		
		
		
		postlistpage =	addpost.checkpostlink();
		
		String title = driver.getTitle();
		
		Assert.assertEquals(title,"Posts | Blog");
		
	}
	
	

	@Test(priority=4,description = "Validate Image type")
	public void CheckImageType() throws InterruptedException{
		
		
		
	addpost.ValidateImageType();
		
	 Thread.sleep(5000);
	 
		
	}
	
	

	
	@Test(priority=5,description = "Validate Invalid Image upload")
	public void InvalidIMage() throws InterruptedException{
		
		
		
		boolean flag=	addpost.ValidateImageType();
		
		Assert.assertTrue(flag);
		
	}
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
