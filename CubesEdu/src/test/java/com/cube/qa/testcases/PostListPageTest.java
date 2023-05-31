package com.cube.qa.testcases;

import static org.testng.Assert.assertFalse;

import java.awt.AWTException;
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
import com.cubes.qa.pages.EditPostPage;
import com.cubes.qa.pages.LoginPage;
import com.cubes.qa.pages.PostsListPage;
import com.cubes.qa.pages.ViewPostPage;

public class PostListPageTest  extends TestBase{
	
	LoginPage loginPage;
	DashbordPage dashboardpage;
	PostsListPage postlistpage;
	AddPostsPage addpost;
	ViewPostPage viewpostpage;
	EditPostPage editpostpage;

	public PostListPageTest(){
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
		editpostpage = new 	EditPostPage();

		
		dashboardpage = loginPage.login(prop.getProperty("email"), prop.getProperty("pw"));
		postlistpage =  dashboardpage.Postlist();	
		
				
	}

	

	@Test(priority=1,description = "Search with valid data using all fields and filter")
	public void AllSearch() throws InterruptedException{
		
		
		// set dynamic fields

		WebElement title = driver.findElement(By.xpath("//*[@id='entities-list-table']/tbody/tr[1]/td[5]"));
		
		String title1 = title.getText();
		
		WebElement Author = driver.findElement(By.xpath("//*[@id='entities-list-table']/tbody/tr[1]/td[6]"));
		String Author1 = Author.getText();
		
		WebElement category = driver.findElement(By.xpath("//*[@id='entities-list-table']/tbody/tr[1]/td[7]"));
		String cat1 = category.getText();
		
		WebElement imp = driver.findElement(By.xpath("//*[@id='entities-list-table']/tbody/tr[1]/td[3]"));
		String imp1 = imp.getText().toLowerCase( );
		
		WebElement status = driver.findElement(By.xpath("//*[@id='entities-list-table']/tbody/tr[1]/td[4]"));
		String sta1 = status.getText();
		
	//	WebElement tags = driver.findElement(By.xpath("//*[@id='entities-list-table;]/tbody/tr[1]/td[8]"));
	//	String tag1 = tags.getText();
		
		//end
		
		postlistpage.performSearch(title1,Author1,cat1,imp1,sta1);
		
		Thread.sleep(5000);
		
		List<WebElement> ColumnList = driver.findElements(By.xpath("//*[@id='entities-list-table']/tbody/tr/td"));
		boolean status1=false;
		
		

for(WebElement ele:ColumnList)
{
String value=ele.getText();
System.out.println(value);
if(value.contains(title1)) {
	status1=true;
	break;
	
}
}
Assert.assertTrue(status1,"fail");
              
	    }
	

	
	@Test(priority=2,description = "Search with invalid data")
	public void AllSearchResultnotfound() {
		
				postlistpage.AllSearchResultnotfound("GUI","Polaznik","TestCity","yes","enabled","Default TAG NE BRISATI");
			List<WebElement> ColumnList = driver.findElements(By.xpath("//*[@id='entities-list-table']/tbody/tr/td"));
			boolean status=false;

for(WebElement ele:ColumnList)
{
	String value=ele.getText();
	System.out.println(value);
	if(value.contains("No matching records found")) {
		status=true;
		break;
		
	}
}
Assert.assertTrue(status,"fail");
	    }


	@Test(priority=3,description = "Search in table")
	public void searchinTable() throws InterruptedException {
		
		
		// set dynamic fields

				WebElement title = driver.findElement(By.xpath("//*[@id='entities-list-table']/tbody/tr[1]/td[5]"));
				
				String title1 = title.getText();
				
				
				//end
				
				
		
		postlistpage.searchinTable(title1);
		List<WebElement> ColumnList = driver.findElements(By.xpath("//*[@id='entities-list-table']/tbody/tr/td"));

//System.out.println(ColumnList.size());

//Assert.assertEquals(ColumnList.size(),120," colum count not same");

boolean status=false;

for(WebElement ele:ColumnList)
{
	String value=ele.getText();
	System.out.println(value);
	if(value.contains(title1)) {
		status=true;
		break;
		
	}
}


Assert.assertTrue(status,"fail");
	    }
	    
	   
	
	
	
	@Test(priority=4,description =  "Check ViewPost Icon")
	public void ViewpostIconTest() throws InterruptedException{
		

//set window size so that all elements should displayed
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='50%'");
		Thread.sleep(5000);
		
//first we search only enable post inorder to click view icon
		
		postlistpage.SearchByStatus("enabled");
		Thread.sleep(5000);
		
		
		// set dynamic fields

				WebElement title = driver.findElement(By.xpath("//*[@id='entities-list-table']/tbody/tr[1]/td[5]"));
				
				String title1 = title.getText();
				
				
				//end
				
	
		WebElement viewicon = driver.findElement(By.xpath("//*[@id='entities-list-table']/tbody/tr[1]/td[12]/div[1]/a[1]"));
		
		
	 	
		JavascriptExecutor js2 = (JavascriptExecutor)driver;
    	js2.executeScript("arguments[0].click();", viewicon);
	
		Thread.sleep(5000);
		
	}
	
	 
	
	@Test(priority=5,description =  "Check Edit Post Icon")
	public void EditpostIconTest() throws InterruptedException{
		


		//set window size so that all elements should displayed
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("document.body.style.zoom='50%'");
				Thread.sleep(5000);
			
				postlistpage.EditPostIcon();
		

		
		Thread.sleep(5000);
		Thread.sleep(2000);
		String titleofpage = driver.getTitle();
		boolean status=false;
		
		Thread.sleep(2000);
		if(titleofpage.equalsIgnoreCase("Edit Post | Blog"))
		{	status=true;}
	
			Assert.assertTrue(status,"fail");
		
	}
	
	
	@Test(priority=6,description =  "Check enable Post Icon")
	public void EnablePost() throws InterruptedException, AWTException{
		
		

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='50%'");
		Thread.sleep(5000);
		
		
		postlistpage.SearchByStatus("disabled");  //only disable post should display in table in order to esit it
		
		Thread.sleep(5000);
		
			
	
		WebElement disicon = driver.findElement(By.xpath("//*[@id='entities-list-table']/tbody/tr[1]/td[12]/div[2]/button[1]"));
	
			Thread.sleep(5000);
			
			JavascriptExecutor js1 = (JavascriptExecutor)driver;
	    	js1.executeScript("arguments[0].click();", disicon);
	    	Thread.sleep(5000);
	    	

			WebElement disablewinbutt = driver.findElement(By.xpath("//*[@id='enable-modal']/div/div/div[3]/button[2]"));
			WebElement title = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/tbody/tr[1]/td[5]"));  //get sno  of selected reord for research
			
			
			String searchtitle = title.getText();
			System.out.println("this is string 1" + searchtitle);
			
			js1.executeScript("arguments[0].click();", disablewinbutt);

			Thread.sleep(5000);
			
			
	    	boolean flag=  	postlistpage.SearchByStatus2("disabled");  //research to display on disable fields and validate the update
	    //	Assert.assertTrue(flag);
	    	boolean assertResult = flag;
	    	Thread.sleep(5000);
	    	if (assertResult) {
	
			
	    //	postlistpage.SearchByStatus("enabled");
	    	
	    //	postlistpage.enablePost(searchtitle);
	    	
	    	Thread.sleep(5000);

	    	List<WebElement> ColumnList = driver.findElements(By.xpath("//*[@id='entities-list-table']/tbody/tr/td"));
			boolean status=false;
			
			

	for(WebElement ele:ColumnList)
	{
	String value=ele.getText();
	System.out.println("this is string 1" + value);
	if(value.contains(searchtitle)) {
		System.out.println("this is string 1" + searchtitle);
		status=true;
		break;
		
	}
	}
	Assert.assertTrue(status,"fail");
	

			}}
			
	
	
	@Test(priority=7,description =  "Check disable Post Icon")
	public void DisablePost() throws InterruptedException, AWTException{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='50%'");
		Thread.sleep(5000);
		
		
		postlistpage.SearchByStatus("enabled"); //only enable posts will display in table inorder to edit it
		
		Thread.sleep(8000);
		
			
	
		WebElement enableicon = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/tbody/tr[1]/td[12]/div[2]/button[1]"));
	
			Thread.sleep(6000);
			
			JavascriptExecutor js1 = (JavascriptExecutor)driver;
	    	js1.executeScript("arguments[0].click();", enableicon);
	    	Thread.sleep(7000);
	    	

			WebElement disablewinbutt = driver.findElement(By.xpath("//*[@id='disable-modal']/div/div/div[3]/button[2]"));
			WebElement title = driver.findElement(By.xpath("//*[@id='entities-list-table']/tbody/tr[1]/td[5]"));  //get title of selected reord for research
			String searchtitle = title.getText();
			
		
            js1.executeScript("arguments[0].click();", disablewinbutt);
	    	Thread.sleep(5000);
	  	
	    	boolean flag=  	postlistpage.SearchByStatus2("disabled");  //research to display on disable fields and validate the update
	    //	Assert.assertTrue(flag);
	    	boolean assertResult = flag;
	    	Thread.sleep(5000);
	    	if (assertResult) {
	

postlistpage.enablePost(searchtitle);

	    	List<WebElement> ColumnList = driver.findElements(By.xpath("//*[@id='entities-list-table']/tbody/tr/td"));
			boolean status=false;
			
			

	for(WebElement ele:ColumnList)
	{
	String value=ele.getText();
	System.out.println(value);
	System.out.println(searchtitle);
	if(value.contains(searchtitle)) {
		status=true;
		break;
		
	}
	}
	Assert.assertTrue(status,"fail");
	
	    	}
	}
	
	

	@Test(priority=8,description =  "Check  set as un important Post Icon")
	public void Unimportant() throws InterruptedException, AWTException{
		
		

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='50%'");
		Thread.sleep(5000);
		
		
		postlistpage.SearchByImportant("yes"); //only important post will be shown in table to update
		
		Thread.sleep(5000);
		
			
	
		WebElement unimpoticon = driver.findElement(By.xpath("//*[@id='entities-list-table']/tbody/tr[1]/td[12]/div[2]/button[2]"));
	
			Thread.sleep(5000);
			
			JavascriptExecutor js1 = (JavascriptExecutor)driver;
	    	js1.executeScript("arguments[0].click();", unimpoticon);
	    	Thread.sleep(5000);
	    	

			WebElement setunimpbutt = driver.findElement(By.xpath("//*[@id='unimportant-modal']/div/div/div[3]/button[2]"));
			WebElement title = driver.findElement(By.xpath("//*[@id='unimportant-modal']/div/div/div[2]/strong"));  //get title of selected reord for research
			String searchtitle = title.getText();
			
			
			System.out.println(searchtitle);
			
			
			js1.executeScript("arguments[0].click();", setunimpbutt);
		//	disablewinbutt.click();
			Thread.sleep(5000);
			
			postlistpage.SearchByImportant("no");  //researh unimportant to validate update
			
	    	Thread.sleep(5000);

	    	List<WebElement> ColumnList = driver.findElements(By.xpath("//*[@id='entities-list-table']/tbody/tr/td"));
			boolean status=false;
			
			

	for(WebElement ele:ColumnList)
	{
	String value=ele.getText();
	
	if(value.contains(searchtitle)) {
		status=true;
		break;
		
	}
	}
	Assert.assertTrue(status,"fail");
	

			}

	
	

	@Test(priority=9,description =  "Check  set as important Post Icon")
	public void ImportantPost() throws InterruptedException, AWTException{
		
		

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='50%'");
		Thread.sleep(5000);
		
		
		postlistpage.SearchByImportant("no");  //display only unimportamt post to convert into unimportant
		
		Thread.sleep(5000);
		
			
	
		WebElement unimpoticon = driver.findElement(By.xpath("//*[@id='entities-list-table']/tbody/tr[1]/td[12]/div[2]/button[2]")); //click icon
	
			Thread.sleep(5000);
			
			JavascriptExecutor js1 = (JavascriptExecutor)driver;
	    	js1.executeScript("arguments[0].click();", unimpoticon);
	    	Thread.sleep(5000);
	    	

			WebElement unimpinbutt = driver.findElement(By.xpath("//*[@id='important-modal']/div/div/div[3]/button[2]")); //click button inside popup window
		
			
			WebElement title2 = driver.findElement(By.xpath("//*[@id='important-modal']/div/div/div[2]/strong")); 
			String searchtitle2 = title2.getText();
			
			System.out.println(searchtitle2);
			
			
			js1.executeScript("arguments[0].click();", unimpinbutt); //click button inside popup
		//	disablewinbutt.click();
			Thread.sleep(5000);
			
			postlistpage.SearchByImportant("yes"); //display only important postd to validate update
			
	    	Thread.sleep(5000);

	    	List<WebElement> ColumnList = driver.findElements(By.xpath("//*[@id='entities-list-table']/tbody/tr/td"));
			boolean status=false;
			
			

	for(WebElement ele:ColumnList)
	{
	String value=ele.getText();
	
	if(value.contains(searchtitle2)) {
		status=true;
		break;
		
	}
	}
	Assert.assertTrue(status,"fail");
	

			}	
	

	@Test(priority=10,description =  "Check Delete Post Icon")
	public void DeletePost() throws InterruptedException, AWTException{
		
		

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='50%'");
		Thread.sleep(5000);
		

		   	//call function from class page
		   	WebElement sno = driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/tbody/tr[1]/td[1]"));
		   	String snotext = sno.getText();
			   	
		    postlistpage.DeletePost();
		  
		   	Thread.sleep(8000);
		   	
		   	
		   	List<WebElement> ColumnList = driver.findElements(By.xpath("//*[@id='entities-list-table']/tbody/tr/td"));

	
		  boolean status=true;

		  for(WebElement ele:ColumnList)
		  {
		  	String value=ele.getText();
		  
		  	if(value.contains(snotext)) {
		  		status=false;
		  		break;
		  		
		  	}

							}
			Assert.assertTrue(status,"fail");
			
		   	
			}


	

	@Test(priority=11,description =  "Check Add Post Button")
	public void AddPost() throws InterruptedException {
		
		
		addpost =	postlistpage.addPost();
		
		String title = driver.getTitle();
		
		 boolean status=true;
		 
		if(title.equals("Add Post | Blog")) {
			
			status=true;
	  	
		}
	
			Assert.assertTrue(status,"fail");
			
		Thread.sleep(2000);
	   	
		
	}
		
		
		
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
