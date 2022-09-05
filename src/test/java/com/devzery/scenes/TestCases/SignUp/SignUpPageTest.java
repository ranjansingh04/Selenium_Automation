package com.devzery.scenes.TestCases.SignUp;

import com.devzery.scenes.Pages.SignUp.SignUpPageActions;
import com.devzery.scenes.Utilities.SeleniumUtils;
import com.devzery.scenes.Utilities.TestUtility;
import com.devzery.scenes.Pages.Login.LoginPageActions;
import com.devzery.scenes.Utilities.RandomUtilities;
import com.devzery.scenes.Utilities.Verification;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.devzery.scenes.BaseClass.TestBase;


public class SignUpPageTest extends TestBase {
    LoginPageActions loginPage;
    SignUpPageActions signUpPage;
    TestUtility testUtil;
    WebDriver driver;
    RandomUtilities randomUtilities;
    Verification verification;
    SeleniumUtils seleniumUtils;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {

        // Driver and Classes initialization

        driver = initialization();
        Log.info("Application Launched Successfully");
        randomUtilities = new RandomUtilities();
        testUtil = new TestUtility(driver);
        loginPage = new LoginPageActions(driver);
        signUpPage = new SignUpPageActions(driver);
        verification = new Verification(driver);
        seleniumUtils = new SeleniumUtils(driver);
    }

    @Test(description = "Test SignUp with Blank Fields" ,priority=1)
    public void TestSignUpWithEmptyFields()
    {
        //Execution
        signUpPage.signUp(null,null,null,null,false);

        //Verification
        signUpPage.VerifyEmptyFieldValidation("Firstname");
    }

    @Test(description = "Test SignUp with Empty First Name" ,priority=2)
    public void TestSignUpWithEmptyFirstName()
    {
        //Execution
        signUpPage.signUp(null,randomUtilities.randomString(),randomUtilities.random16digitString()+"@gmail.com",
                randomUtilities.randomAlphaNumeric(),true);

        //Verification
        signUpPage.VerifyEmptyFieldValidation("FirstName");
    }

    @Test(description = "Test SignUp with Empty Last Name" ,priority=3)
    public void TestSignUpWithEmptyLastName()
    {
        //Execution
        signUpPage.signUp(randomUtilities.randomString(),null,randomUtilities.random16digitString()+"@gmail.com",
                randomUtilities.randomAlphaNumeric(),true);

        //Verification
        signUpPage.VerifyEmptyFieldValidation("LastName");
    }

    @Test(description = "Test SignUp with Empty Email" ,priority=4)
    public void TestSignUpWithEmptyEmail()
    {
        //Execution
        signUpPage.signUp(randomUtilities.randomString(),randomUtilities.randomString(),null,
                randomUtilities.randomAlphaNumeric(),true);

        //Verification
        signUpPage.VerifyEmptyFieldValidation("Email");
    }

    @Test(description = "Test SignUp with Invalid Email" ,priority=5)
    public void TestSignUpWithInvalidEmail()
    {
        //Execution
        signUpPage.signUp(randomUtilities.randomString(),randomUtilities.randomString(),randomUtilities.randomAlphaNumeric(),
                randomUtilities.randomAlphaNumeric(),true);

        //Verification
        signUpPage.VerifyInvalidEmailValidation();
    }

    @Test(description = "Test SignUp with Empty Password" ,priority=6)
    public void TestSignUpWithEmptyPassword()
    {
        //Execution
        signUpPage.signUp(randomUtilities.randomString(),randomUtilities.randomString(),randomUtilities.random16digitString()+"@gmail.com",
                null, true);

        //Verification
        signUpPage.VerifyEmptyFieldValidation("Password");
    }

    @Test(description = "Test SignUp with Invalid Password" ,priority=7)
    public void TestSignUpWithInvalidPassword()
    {
        //Execution
        signUpPage.signUp(randomUtilities.randomString(),randomUtilities.randomString(),randomUtilities.random16digitString()+"@gmail.com",
                randomUtilities.randomStringCustomLength(4), true);

        //Verification
        signUpPage.VerifyInvalidPasswordValidation();
    }

    @Test(description = "Test SignUp without Checking Terms And Conditions" ,priority=8)
    public void TestSignUpWithoutCheckingTermsAndConditions()
    {
        //Execution
        signUpPage.signUp(randomUtilities.randomString(),randomUtilities.randomString(),randomUtilities.random16digitString()+"@gmail.com",
                randomUtilities.randomAlphaNumeric(), false);

        //Verification
        signUpPage.VerifyEmptyFieldValidation("TermsAndConditions");
    }

    @Test(description = "Test Successful SignUp" ,priority=9)
    public void TestSuccessfulSignUp()
    {
        //Execution
        signUpPage.signUp(randomUtilities.randomString(),randomUtilities.randomString(),randomUtilities.random16digitString()+"@gmail.com",
                randomUtilities.randomAlphaNumeric(), true);

        //Verification
        signUpPage.VerifySuccessfullSignUp();
    }
}
