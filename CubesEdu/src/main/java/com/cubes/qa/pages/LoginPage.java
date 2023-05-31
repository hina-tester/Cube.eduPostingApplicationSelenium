
package com.cubes.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cubes.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	
	//page factory
	
	@FindBy(name = "email")
	@CacheLookup
	WebElement email;
	
	@FindBy(name = "password")
	@CacheLookup
	WebElement pw;
	
	@FindBy (xpath = "/html/body/div/div[2]/div/form/div[3]/div[2]/button")
	@CacheLookup
	WebElement loginButton;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	//Actions:
	public DashbordPage login(String em , String pw1){
		
		
		email.sendKeys(em);
		pw.sendKeys(pw1);
		loginButton.click();
		    //	JavascriptExecutor js = (JavascriptExecutor)driver;
		  //  	js.executeScript("arguments[0].click();", loginButton);
		    	
		    	return new DashbordPage();
	}
	

	
}
