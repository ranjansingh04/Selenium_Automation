/** This is Sample Code for a Random Page **/

package com.scenes.qa.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scenes.qa.BaseClass.TestBase;

public class LoginPage extends TestBase 
{
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-small' and @type='submit']") 
	WebElement loginButton;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpButton;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateScenesImage()
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String uname, String pword)
	{
		username.sendKeys(uname);
		password.sendKeys(pword);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginButton);
				
		return new HomePage();
	}
}

