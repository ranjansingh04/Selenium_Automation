/** This is Sample Code for a Random Page **/

package com.scenes.qa.TestCases;

import com.scenes.qa.Pages.HomePage;
import com.scenes.qa.Pages.LoginPage;
import com.scenes.qa.Utilities.TestUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.scenes.qa.BaseClass.TestBase;
import com.scenes.qa.Constants.Constants;

public class HomePageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	TestUtility testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest()
	{
		super();
	}

	@BeforeMethod(alwaysRun=true)
	public void setUp()
	{
		initialization();
		Log.info("Application Launched Successfully");
		
		testUtil = new TestUtility();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(property.getProperty("Username"),property.getProperty("Password"));
	}

	@Test(priority=1, enabled=true)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, Constants.HOME_PAGE_TITLE, "Home Page Title is not Matched");
		Log.info("Home Page Title Verified");
	}
	
	@Test(priority=2, enabled=true)
	public void verifyUserNameTest()
	{
		testUtil.switchToFrame("mainpanel");
		Assert.assertTrue(homePage.verifyCorrectUserName());
		Log.info("UserName Verified");
	}
	
	@Test(priority=3, enabled=true)
	public void verifyContactsLinkTest()
	{
		testUtil.switchToFrame("mainpanel");
		contactsPage = homePage.clickOnContactsLink();
		Log.info("Switched into Frame and Clicked on Contacts Link");
	}

}
