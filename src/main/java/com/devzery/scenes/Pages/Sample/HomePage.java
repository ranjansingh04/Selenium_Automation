/** This is Sample Code for a Random Page **/
/*
package com.scenes.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scenes.qa.BaseClass.TestBase;

public class HomePage extends TestBase
{
	@FindBy(xpath = "//td[contains(text(),'User: Ranjan')]")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement settingsLink;

	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newChannelLink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCorrectUserName()
	{
		return userNameLabel.isDisplayed();
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public ContactsPage clickOnSettings()
	{
		settingsLink.click();
		return new SettingsPage();
	}

	public void clickOnNewChannel()
	{
		Actions action = new Actions(driver);
		action.moveToElement(settingsLink).build().perform();
		newChannelLink.click();
	}
}
*/