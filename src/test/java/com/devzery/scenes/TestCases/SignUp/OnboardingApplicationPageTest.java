package com.devzery.scenes.TestCases.SignUp;

import com.devzery.scenes.Pages.CommunitySettings.PeopleManagementAPICalls;
import com.devzery.scenes.Pages.SignUp.BasicProfileCreationPageActions;
import com.devzery.scenes.Pages.SignUp.OnboardingApplicationPageActions;
import com.devzery.scenes.BaseClass.TestBase;
import com.devzery.scenes.Pages.Login.LoginPageActions;
import com.devzery.scenes.Pages.CommunitySettings.OnboardingPageActions;
import com.devzery.scenes.Pages.CommunitySettings.NewApplicationsPageActions;
import com.devzery.scenes.Utilities.JavaScriptUtilities;
import com.devzery.scenes.Utilities.StaticWaits;
import com.devzery.scenes.Utilities.Verification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OnboardingApplicationPageTest extends TestBase
{
	LoginPageActions loginPage;
	Verification verification;
	OnboardingApplicationPageActions applicationPage;
	BasicProfileCreationPageActions basicProfileCreationPage;
	OnboardingPageActions onboardingPage;
	NewApplicationsPageActions newApplicationPage;

	public OnboardingApplicationPageTest()
	{
		super();
	}

	@BeforeMethod(alwaysRun=true)
	public void setUp()
	{
		driver = initialization();
		Log.info("Application Launched Successfully");

		loginPage = new LoginPageActions(driver);

		applicationPage = new OnboardingApplicationPageActions(driver);
		verification = new Verification(driver);
		basicProfileCreationPage = new BasicProfileCreationPageActions(driver);
		onboardingPage = new OnboardingPageActions(driver);
		newApplicationPage = new NewApplicationsPageActions(driver);
	}
	@Test(description = "Verify Application Form is ON and Questions are set, GateKeeping is ON", priority=1)
	public void onboardingApplicationFormQuestionsSetup() {
		//Onboarding Settings by Owner
		String ownerId = property.getProperty("Email");    //Get Owner Email Address
		String ownerPwd = property.getProperty("Password"); //Get Owner Password
		loginPage.enterMailAddress(ownerId);
		loginPage.enterPassword(ownerPwd);
		loginPage.clickLoginButton();
		Log.info("Owner gets Login Successfully");
		onboardingPage.clickOnSettings();
		onboardingPage.clickOnOnboardingSettings();
		onboardingPage.gateKeepingToggle("ON");
		onboardingPage.clickOnApplicationFormSwitch("ON");
		onboardingPage.addAnotherQuestion("Text Input", "What is your name ?");
		onboardingPage.clickOnOnboardingSaveSettings();
		loginPage.logoutFromCommunityPage();
	}

	@Test(description = "Verify Onboarding of User When Application Form is ON and Questions are set and GateKeeping is ON", priority=2)
	public void onboardingApplicationFormUserOnboarding() {
		// Submit Onboarding Application request by Member
		PeopleManagementAPICalls.removeRoleFromUserUsingUserID(property.getProperty("Username"));
		StaticWaits.staticMediumWait();
		String userId = property.getProperty("UserEmail");  //Get New User Email Address
		String userPwd = property.getProperty("UserPassword"); //Get Owner Password
		loginPage.enterMailAddress(userId);
		loginPage.enterPassword(userPwd);
		loginPage.clickLoginButton();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		basicProfileCreationPage.enterUserName(property.getProperty("Username"));
		basicProfileCreationPage.clickContinue();
		applicationPage.fillApplicationFormAndClickSubmit();
	}

	@Test(description = "Verify Accepting Onboarding Application By Owner", priority=3)
	public void onboardingApplicationFormOwnerAccepting() {
		// Accept Application request by Owner
		String ownerId = property.getProperty("Email");    //Get Owner Email Address
		String userId = property.getProperty("UserEmail");  //Get New User Email Address
		loginPage.enterMailAddress(ownerId);
		loginPage.enterPassword(property.getProperty("Password"));
		loginPage.clickLoginButton();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		onboardingPage.clickOnSettings();
		newApplicationPage.clickNewApplications();
		newApplicationPage.clickViewBtn(userId);
		newApplicationPage.updateNewApplicationStatus("accept");
		loginPage.logoutFromCommunityPage();
	}

	@Test(description = "Verify New User Logging to Community after Successful Onboarding", priority=4)
	public void onboardingUserCommunity() {
		// Verify the User is added to community
		String userId = property.getProperty("UserEmail");  //Get New User Email Address
		loginPage.enterMailAddress(userId);
		loginPage.enterPassword(property.getProperty("UserPassword"));
		loginPage.clickLoginButton();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		JavaScriptUtilities.waitForLoad(driver);
		verification.Title("AUTOMATION COMMUNITY");
	}
}
