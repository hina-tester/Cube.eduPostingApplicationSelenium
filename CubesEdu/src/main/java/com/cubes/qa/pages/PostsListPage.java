package com.cubes.qa.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.cubes.qa.base.TestBase;

public class PostsListPage  extends TestBase {
	
	
	//page factory
	
		
		@FindBy(name = "title")
		@CacheLookup
		WebElement title;
		
		@FindBy(xpath = "//*[@role='combobox'][1]//span")
		@CacheLookup
		WebElement Author;
		
		@FindBy(xpath = "(//input[@role='searchbox'])[2]")
		@CacheLookup
		WebElement input;
		
		@FindBy(xpath = "//span[@class='select2-results']//ul//li")
		@CacheLookup
		WebElement pot;
		
		
		@FindBy(xpath = "(//span[@role='combobox'])[2]")
		@CacheLookup
		WebElement Category;
		
		@FindBy(xpath = "/html/body/span/span/span[1]/input")
		@CacheLookup
		WebElement Catinput;
		
		@FindBy(xpath = "//*[@role='listbox']")
		@CacheLookup
		WebElement Catpro;
		
		@FindBy(name = "important")
		@CacheLookup
		WebElement important;
		
			
		@FindBy(name = "status")
		@CacheLookup
		WebElement status;
		
		@FindBy(xpath = "//*[@id=\"entities-filter-form\"]/div/div[6]/span/span[1]/span")
		@CacheLookup
		WebElement Tags;
		
		@FindBy(xpath = "//span//ul[@role='listbox']")
		@CacheLookup
		WebElement Tagsbox;
		
		@FindBy(xpath = "//*[@id=\"entities-list-table\"]/tbody/tr")
		@CacheLookup
		WebElement record;
		
		@FindBy(xpath = "//*[@id=\"entities-list-table\"]")
		@CacheLookup
		WebElement table;
		
		@FindBy(xpath = "/html/body/div/div[1]/section[2]/div/div/div/div[1]/div[1]/div/a")
		@CacheLookup
		WebElement AddPost;
		
		@FindBy(xpath = "//*[@id=\"entities-list-table_filter\"]/label/input")
		@CacheLookup
		WebElement searchbox;
		
		@FindBy(xpath = "//*[@id=\"entities-list-table\"]/tbody/tr/td[5]")
		@CacheLookup
		WebElement searchboxresult;
		
		@FindBy(xpath = "//*[@id=\"entities-list-table\"]/tbody/tr/td")
		@CacheLookup
		WebElement recordnotfound;
		
		@FindBy(xpath = "//*[@id=\"entities-list-table\"]/tbody/tr/td/div[1]/a[1]/i")
		@CacheLookup
		WebElement Viewpost;
		
		@FindBy(xpath = "//*[@id=\"entities-list-table\"]/tbody/tr[1]/td[12]/div[1]/a[2]")
		@CacheLookup
		WebElement EditIcon;
		
		@FindBy(xpath = "//*[@id=\"entities-list-table\"]/tbody/tr[1]/td[12]/div[1]/button")
		@CacheLookup
		WebElement DeleteIcon;
		
		
		@FindBy(xpath = "//*[@id='delete-modal']/div/div/div[2]/strong")
		@CacheLookup
		WebElement Deletetitle;
		
		
		@FindBy(xpath = "//*[@id='delete-modal']/div/div/div[3]/button[2]")
		@CacheLookup
		WebElement Deletewinbutton;
		
		
		@FindBy(xpath = "//*[@id=\"entities-list-table\"]/tbody/tr[1]/td[1]")
		@CacheLookup
		WebElement sno;
		
		public PostsListPage() {
			
			PageFactory.initElements(driver, this);
			
		}
		

		
		//Actions:
		public void performSearch(String Title, String Aut, String Cat, String Imp , String Sta) {
	        
	        
			title.clear();
	        title.sendKeys(Title);

	      
	        Author.click();
	        input.sendKeys(Aut);
	        
	        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        pot.click();
	        
	        
	        Category.click();
	        Catinput.sendKeys(Cat);
	        
	        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			 Catpro.click();

			 Select dropdown = new Select(important);  
			 dropdown.selectByVisibleText(Imp);
			 
			 Select dropdown2 = new Select(status);  
			 dropdown2.selectByVisibleText(Sta);
			 
	        
	 //       Tags.sendKeys(Tag);
	 //       Tagsbox.click();
	        
	        
	       
		}	        
	      
		public void AllSearchResultnotfound(String Title, String Aut, String Cat, String Imp , String Sta , String Tag) {
	        
	        
			title.clear();
	        title.sendKeys(Title);

	      
	        Author.click();
	        input.sendKeys(Aut);
	        
	        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        pot.click();
	        
	        
	        Category.click();
	        Catinput.sendKeys(Cat);
	        
	        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			 Catpro.click();

			 Select dropdown = new Select(important);  
			 dropdown.selectByVisibleText(Imp);
			 
			 Select dropdown2 = new Select(status);  
			 dropdown2.selectByVisibleText(Sta);
			 
	        
	        Tags.sendKeys(Tag);
	        Tagsbox.click();
	        
		}
			  


		public void searchinTable(String text) throws InterruptedException {
	        
			searchbox.sendKeys(text);
			Thread.sleep(2000);
	
	


}	
		


		public AddPostsPage addPost() throws InterruptedException {


			AddPost.click();
			
			return new AddPostsPage();
			
	


}	
		
	
		
public ViewPostPage ViewPost(String text) throws InterruptedException{
	        
			searchbox.sendKeys(text);
			Thread.sleep(5000);

			    driver.findElement(By.xpath("//*[@id=\"entities-list-table\"]/tbody/tr/td[12]/div[1]/a[1]/i")).click();
			Viewpost.click();
			Thread.sleep(2000);
			return new ViewPostPage();
	
	


}	


public EditPostPage EditPostIcon() throws InterruptedException{
	        
	Thread.sleep(3000);
	
	JavascriptExecutor js2 = (JavascriptExecutor)driver;
    	js2.executeScript("arguments[0].click();", EditIcon);
//	EditIcon.click();
	
			Thread.sleep(5000);

			return new EditPostPage();


}	

public void DisablePost(String text) throws InterruptedException{
    
	searchbox.sendKeys(text);



}	


public void enablePost(String text) throws InterruptedException{
    
	searchbox.sendKeys(text);



}	

public void SearchByStatus(String text) {
    
   	 Select dropdown2 = new Select(status);  
	 dropdown2.selectByVisibleText(text);
	    
	 
	 
	 
}	   


public boolean SearchByStatus2(String text) {
    
   	 Select dropdown2 = new Select(status);  
	 dropdown2.selectByVisibleText(text);
	    
	 return !recordnotfound.isDisplayed();
	 
	 
}	   
  

public void SearchByImportant(String text) {
    

	 Select dropdown = new Select(important);  
	 dropdown.selectByVisibleText(text);
	 
}	        



public void DeletePost() throws InterruptedException {
    
	Thread.sleep(5000);
	
//	DeleteIcon.click();
	
	WebElement deleteicon = driver.findElement(By.xpath("//*[@id='entities-list-table']/tbody/tr[1]/td[12]/div[1]/button"));
	
	JavascriptExecutor js1 = (JavascriptExecutor)driver;
	js1.executeScript("arguments[0].click();", DeleteIcon);
		
	   	Thread.sleep(5000);
	   	
	   	
	   	
	   	String deletetitle = sno.getText();
	   	
	   	JavascriptExecutor js2 = (JavascriptExecutor)driver;
    	js2.executeScript("arguments[0].click();", Deletewinbutton);
	  
	   	Thread.sleep(5000);
	   	
	    System.out.println(deletetitle);
	   	searchbox.sendKeys(deletetitle);
	   	
	   	Thread.sleep(5000);
	 
	  
}	        
  




public static void scrollHorizontally(int scrollValue) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    String script = "window.scrollBy(" + scrollValue + ", 0)";
    js.executeScript(script);
}
		
}
	        
	