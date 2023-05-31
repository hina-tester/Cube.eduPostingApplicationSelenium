package com.cubes.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cubes.qa.base.TestBase;

public class DashbordPage  extends TestBase {
	
	
	//page factory
	
	@FindBy(xpath = "/html/body/div/aside/div/nav/ul/li[4]/a/i")
	@CacheLookup
	WebElement Posts;
	
	@FindBy(xpath = "/html/body/div/aside/div/nav/ul/li[4]/ul/li[1]/a/i")
	@CacheLookup
	WebElement PostsLists;
	
	@FindBy(xpath = "/html/body/div/aside/div/nav/ul/li[4]/ul/li[2]/a")
	@CacheLookup
	WebElement AddPosts;
	
	public DashbordPage() {
		
		PageFactory.initElements(driver, this);
		
		
	}
	

	
	//Actions:
	public PostsListPage Postlist(){
		
				
		Posts.click();
		PostsLists.click();
		
		return new PostsListPage();
	}
	
	public AddPostsPage AddPost(){
		
		
		Posts.click();
		AddPosts.click();
		
		return new AddPostsPage();
	}
	


}
