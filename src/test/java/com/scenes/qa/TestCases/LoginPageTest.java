/** This is Sample Code for a Random Page **/

package com.scenes.qa.TestCases;

import com.scenes.qa.Pages.HomePage;
import com.scenes.qa.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.scenes.qa.BaseClass.TestBase;
import com.scenes.qa.Constants.Constants;

public class LoginPageTest extends TestBase
{	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}

	@BeforeMethod(alwaysRun=true)
	public void setUp()
	{
		initialization();
		Log.info("Application Launched Successfully");
		
		loginPage = new LoginPage();
	}
	
	@Test(priority=1, enabled=true)
	public void loginPageTitleTest()
	{
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "Login Page Title is not Matched");
		Log.info("Login Page Title Verified");
	}
	
	@Test(priority=2, enabled=true)
	public void scenesLogoImageTest()
	{
		boolean flag = loginPage.validateScenesImage();
		Assert.assertTrue(flag);
		Log.info("Scenes Logo Verified");
	}
	
	@Test(priority=3, enabled=true, invocationCount=1) 
	public void loginTest()
	{
		homePage = loginPage.login(property.getProperty("Username"),property.getProperty("Password"));
		Log.info("Successfully Logged into Scenes Application");
	}
}
