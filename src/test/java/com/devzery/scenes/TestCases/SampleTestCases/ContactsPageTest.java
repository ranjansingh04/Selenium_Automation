/** This is Sample Code for a Random Page **/
/*
package com.scenes.qa.TestCases;

import com.scenes.qa.Pages.HomePage;
import com.scenes.qa.Pages.LoginPage;
import com.scenes.qa.Utilities.TestUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.scenes.qa.BaseClass.TestBase;

public class ContactsPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	TestUtility testUtil;
	ContactsPage contactsPage;
	String sheetName = "Contacts"; 
	
	public ContactsPageTest()
	{
		super();
	}

	@BeforeMethod(alwaysRun=true)
	public void setUp()
	{
		initialization();
		testUtil = new TestUtility();
		Log.info("Application Launched Successfully");
		
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(property.getProperty("Username"),property.getProperty("Password"));
	}
	
	@Test(priority=1, enabled=true)
	public void verifyContactsPageLabelTest()
	{
		testUtil.switchToFrame("mainpanel");
		contactsPage = homePage.clickOnContactsLink();
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts Label is Missing in the Page");
		Log.info("Verified Contacts Page Label");
	}
	
	@Test(priority=2, enabled=true)
	public void selectSingleContactsTest()
	{
		testUtil.switchToFrame("mainpanel");
		contactsPage = homePage.clickOnContactsLink();
		contactsPage.selectContactByName("Ram Kumar");
		Log.info("Verified Single Contacts");
	}
	
	@Test(priority=3, enabled=true)
	public void selectMultipleContactsTest()
	{
		testUtil.switchToFrame("mainpanel");
		contactsPage = homePage.clickOnContactsLink();
		contactsPage.selectContactByName("Ram Kumar");
		contactsPage.selectContactByName("Sanjay Kumar");
		Log.info("Verified Multiple Contacts");
	}
	
	@DataProvider
	public Object[][] getCRMContactsTestData()
	{
		Object data [][] = TestUtility.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=4, enabled=true, dataProvider="getScenesTestData")
	public void validateCreateNewContactTest(String Title, String FirstName, String LastName, String Company)
	{
		testUtil.switchToFrame("mainpanel");
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact(Title, FirstName, LastName, Company);
		Log.info("New Contacts Created Successfully");
	}
}
*/