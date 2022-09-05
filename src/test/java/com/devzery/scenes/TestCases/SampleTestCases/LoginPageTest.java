/** This is Sample Code for a Random Page **/

package com.devzery.scenes.TestCases.SampleTestCases;

import com.devzery.scenes.BaseClass.TestBase;
import com.devzery.scenes.Pages.CommunityHomepage.CommunityHomepageActions;
import com.devzery.scenes.Pages.CommunitySettings.OnboardingAPICalls;
import com.devzery.scenes.Pages.Login.LoginPageActions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase
{
	LoginPageActions loginPage;
    CommunityHomepageActions homePage;
	
	/*public LoginPageTest()
	{
		super();
	}*/

	@BeforeMethod(alwaysRun=true)
	public void setUp()
	{
		initialization();
		Log.info("Application Launched Successfully");
		loginPage = new LoginPageActions(driver);
	}
	
	/*@Test(priority=1, enabled=false)
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
	}*/
	
	@Test(priority=3, enabled=false, invocationCount=1)
	public void loginTest()
	{
		homePage = loginPage.loginAs(property.getProperty("Email"),property.getProperty("Password"));
		Log.info("Successfully Logged into Scenes Application");
	}

	@Test(priority=3, enabled=true, invocationCount=1)
	public void apiTest()
	{
		OnboardingAPICalls.getApplicationFormQuestionsResponse();
	}
}
