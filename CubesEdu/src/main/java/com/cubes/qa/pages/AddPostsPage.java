package com.cubes.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cubes.qa.base.TestBase;

public class AddPostsPage  extends TestBase {
	
	

	
	//page factory
	
		
		@FindBy(xpath = "//*[@id=\"entity-form\"]/div[1]/div/div/div[1]/select")
		@CacheLookup
		WebElement Cat;
		
		@FindBy(xpath = "//*[@id=\"entity-form\"]/div[1]/div/div/div[2]/input")
		@CacheLookup
		WebElement title;
		
		@FindBy(xpath = "//*[@id=\"entity-form\"]/div[1]/div/div/div[3]/textarea")
		@CacheLookup
		WebElement dec;
		
		@FindBy(xpath = "//label[@for='set-as-important']")
		@CacheLookup
		WebElement yes;
		
		
		@FindBy(xpath = "//input[@id='tag-checkbox-1630']")
		@CacheLookup
		WebElement tag1;
		
		@FindBy(xpath = "//input[@id='tag-checkbox-2009']")
		@CacheLookup
		WebElement tag2;
		
		@FindBy(xpath = "//input[@name='photo']")
		@CacheLookup
		WebElement choosepicbutt;
		
		@FindBy(xpath = "//p[normalize-space()]")
		@CacheLookup
		WebElement contantbox;
		
		@FindBy(xpath = "//button[@type='submit']")
		@CacheLookup
		WebElement savebutt;
		
			
		@FindBy(xpath = "(//a[normalize-space()='Cancel'])[1]")
		@CacheLookup
		WebElement cancelbutt;
		
		@FindBy(xpath = "//span[@id='title-error']")
		@CacheLookup
		WebElement errormsg;
		
		@FindBy(xpath = "//a[normalize-space()='Home']")
		@CacheLookup
		WebElement homelink;
		
		
		@FindBy(xpath = "//a[normalize-space()='Post']")
		@CacheLookup
		WebElement postlink;
		
		@FindBy(xpath = "//div[contains(text(),'The photo must be an image.')]")
		@CacheLookup
		WebElement wrongimgerror;
		
		
		
		
public AddPostsPage() {
			
			PageFactory.initElements(driver, this);
			
		}
		







//Actions:

public PostsListPage AddPost() throws InterruptedException {
	
	
	
	  // Select category from dropdown menu
    Select categoryDropdown = new Select(Cat);
    categoryDropdown.selectByVisibleText("Ivona");
    
    title.sendKeys("new way to generate new way to generate new way to generate new way to generate");
    
    
    dec.sendKeys("An In-Depth Comprehensive Functional Testing Tutorial with Types, Techniques, and Examples, What is Functional Testing?");
  
    // Select radio button for Yes or No
    yes.click();
    
    tag1.click();
   
  //  driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
    
    JavascriptExecutor jse = (JavascriptExecutor)driver;
    jse.executeScript("window.scrollBy(0,250)");
    
    Thread.sleep(2000);
    
    tag2.click();
    
    jse.executeScript("window.scrollBy(0,250)");
    Thread.sleep(2000);


    choosepicbutt.sendKeys("D:\\Selenium\\work space\\CubesEdu\\src\\main\\java\\com\\cubes\\qa\\config\\Word Art 5.png");
    
    
    Thread.sleep(3000);
    
    jse.executeScript("window.scrollBy(0,250)");

 // Write paragraph in editor
    
    driver.switchTo().frame(0);
    WebElement el  =  driver.switchTo().activeElement();
    new Actions(driver).moveToElement(el).perform();
    driver.findElement(By.xpath("/html/body")).sendKeys("Check Since manually entering text in your application goes into the textarea element, you can try to set value using sendKeys to textarea element in selenium.\r\n"
    		+ "When you set some value in textarea element using selenium, the same value will be added to the rich text editor in the web application.\r\n"
    		+ "\r\n"
    		+ "But as per your HTML code the textarea element is styled as display:none due to which your selenium code will throw an Exception when you sendKeys to the element. This can be fixed if the display attribute is changed to inline or block.\r\n"
    		+ "\r\n"
    		+ "Thus, you first need to set style of textarea to display:inline and then set some value to the element using sendKeys.\r\n"
    		+ "\r\n"
    		+ "To change style of textarea element using JavascriptExecutor :\r\n"
    		+ "\r\n"
    		+ "((JavascriptExecutor)driver).executeScri");
    driver.switchTo(). defaultContent();
    Thread.sleep(3000);
    jse.executeScript("window.scrollBy(0,250)");
 //   JavascriptExecutor js1 = (JavascriptExecutor)driver;
//	js1.executeScript("arguments[0].click();", contantbox); 
 //   driver.findElement(By.xpath("/html/body")).sendKeys("Check");
  //  contantbox.sendKeys("Introduction To Functional Testing ");
  //  driver.findElement(By.xpath("//button[@type='submit']")).click();
    
    JavascriptExecutor js1 = (JavascriptExecutor)driver;
	js1.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@type='submit']"))); 
    
 //   savebutt.click(); //click save button
    Thread.sleep(8000);
    
    return new PostsListPage();
}




public boolean Addwithemptydata() throws InterruptedException {
	
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
    jse.executeScript("window.scrollBy(0,250)");
    jse.executeScript("window.scrollBy(0,250)");
    jse.executeScript("window.scrollBy(0,250)");
    jse.executeScript("window.scrollBy(0,250)");
    
    JavascriptExecutor js1 = (JavascriptExecutor)driver;
 	js1.executeScript("arguments[0].click();", savebutt); 
 	  Thread.sleep(5000);
 	 return errormsg.isDisplayed();
 	
     
  //   savebutt.click(); //click save button
}



public PostsListPage Cancel() throws InterruptedException {
	
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
    jse.executeScript("window.scrollBy(0,250)");
    jse.executeScript("window.scrollBy(0,250)");
    jse.executeScript("window.scrollBy(0,250)");
    jse.executeScript("window.scrollBy(0,250)");
    
    JavascriptExecutor js1 = (JavascriptExecutor)driver;
 	js1.executeScript("arguments[0].click();", cancelbutt); 
 	  Thread.sleep(5000);
 	 return new PostsListPage();
 	
     
  //   savebutt.click(); //click save button
}






public DashbordPage checkhomelink() throws InterruptedException {
	
	homelink.click();
 	 return new DashbordPage();
 	
     
 
}



public PostsListPage checkpostlink() throws InterruptedException {
	
	postlink.click();
 	 return new PostsListPage();
 	
     
  //   savebutt.click(); //click save button
}




public boolean ValidateImageType() throws InterruptedException {
/*	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
    jse.executeScript("window.scrollBy(0,250)");
    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    
    
*/
	
	  // Select category from dropdown menu
  Select categoryDropdown = new Select(Cat);
  categoryDropdown.selectByVisibleText("Ivona");
  
  title.sendKeys("new way to generate new way to generate new way to generate new way to generate");
  
  
  dec.sendKeys("An In-Depth Comprehensive Functional Testing Tutorial with Types, Techniques, and Examples, What is Functional Testing?");

  // Select radio button for Yes or No
  yes.click();
  
  tag1.click();
 
//  driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
  
  JavascriptExecutor jse = (JavascriptExecutor)driver;
  jse.executeScript("window.scrollBy(0,250)");
  
  Thread.sleep(2000);
  
  tag2.click();
  
  jse.executeScript("window.scrollBy(0,250)");
  Thread.sleep(2000);


  choosepicbutt.sendKeys("D:\\Selenium\\work space\\CubesEdu\\src\\main\\java\\com\\cubes\\qa\\config\\Sample.pdf");
  
  
  Thread.sleep(3000);
  
  jse.executeScript("window.scrollBy(0,250)");

// Write paragraph in editor
  
  driver.switchTo().frame(0);
  WebElement el  =  driver.switchTo().activeElement();
  new Actions(driver).moveToElement(el).perform();
  driver.findElement(By.xpath("/html/body")).sendKeys("Check Since manually entering text in your application goes into the textarea element, you can try to set value using sendKeys to textarea element in selenium.\r\n"
  		+ "When you set some value in textarea element using selenium, the same value will be added to the rich text editor in the web application.\r\n"
  		+ "\r\n"
  		+ "But as per your HTML code the textarea element is styled as display:none due to which your selenium code will throw an Exception when you sendKeys to the element. This can be fixed if the display attribute is changed to inline or block.\r\n"
  		+ "\r\n"
  		+ "Thus, you first need to set style of textarea to display:inline and then set some value to the element using sendKeys.\r\n"
  		+ "\r\n"
  		+ "To change style of textarea element using JavascriptExecutor :\r\n"
  		+ "\r\n"
  		+ "((JavascriptExecutor)driver).executeScri");
  driver.switchTo(). defaultContent();
  Thread.sleep(3000);
  jse.executeScript("window.scrollBy(0,250)");
  
  JavascriptExecutor js1 = (JavascriptExecutor)driver;
	js1.executeScript("arguments[0].click();", savebutt); 
  
//   savebutt.click(); //click save button
  Thread.sleep(8000);
    
  
  return wrongimgerror.isDisplayed();
}

}
