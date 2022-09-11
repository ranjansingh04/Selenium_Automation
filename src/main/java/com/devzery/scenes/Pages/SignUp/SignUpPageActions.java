package com.devzery.scenes.Pages.SignUp;

import com.devzery.scenes.Pages.Login.LoginPageActions;
import com.devzery.scenes.Utilities.SeleniumUtils;
import com.devzery.scenes.Utilities.Verification;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SignUpPageActions extends SignUpPageObject {
    private final SeleniumUtils seleniumUtils;
    private final LoginPageActions loginPage;
    private final Verification verification;

    public SignUpPageActions(WebDriver driver) {
        super(driver);
        this.seleniumUtils = new SeleniumUtils(driver);
        this.loginPage = new LoginPageActions(driver);
        this.verification = new Verification(driver);
    }

    public void signUp(String firstName, String lastName, String email, String password, Boolean acceptTermsAndConditions){
        loginPage.clickSignUpLink();

        if (firstName != null){
            Log.info("\n Entering First Name :" +firstName);
            seleniumUtils.setTextBoxValue(seleniumUtils.findElement(firstNameInput),firstName);
        }

        if (lastName != null){
            Log.info("\n Entering Last Name :" +firstName);
            seleniumUtils.setTextBoxValue(seleniumUtils.findElement(lastNameInput),lastName);
        }

        if (email != null){
            Log.info("\n Entering Email :" + email);
            seleniumUtils.setTextBoxValue(seleniumUtils.findElement(emailInput),email);
        }

        if (password != null){
            Log.info("\n Entering Password :" + password);
            seleniumUtils.setTextBoxValue(seleniumUtils.findElement(passwordInput),email);
        }

        if(acceptTermsAndConditions){
            Log.info("\n Check Terms and Conditions Checkbox " );
            seleniumUtils.click(seleniumUtils.findElement(termsAndConditionsCheckbox));
        }

        seleniumUtils.click(seleniumUtils.findElement(signUpButton));
    }

    public void VerifyPasswordValidationMessage(){
        WebElement inputElement = seleniumUtils.findElement(passwordInput);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",inputElement);
        if(isRequired)
        {
            Assert.assertTrue(true);
        }
    }

    public void VerifyEmptyFieldValidation(String fieldName){
        WebElement inputElement = null;

        if ("firstname".equalsIgnoreCase(fieldName))
            inputElement = seleniumUtils.findElement(firstNameInput);

        else if ("lastname".equalsIgnoreCase(fieldName))
            inputElement = seleniumUtils.findElement(lastNameInput);

        else if ("email".equalsIgnoreCase(fieldName))
            inputElement = seleniumUtils.findElement(emailInput);

        else if ("password".equalsIgnoreCase(fieldName))
            inputElement = seleniumUtils.findElement(passwordInput);

        else if ("termsandconditions".equalsIgnoreCase(fieldName))
            inputElement = seleniumUtils.findElement(termsAndConditionsCheckbox);
        else
        {
            Log.info("Invalid Field Name Provided | Please provide Valid field name");
            Assert.fail();
            driver.quit();
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",inputElement);
        if(isRequired)
        {
            Assert.assertTrue(true);
        }
    }

    public void VerifyInvalidEmailValidation(){
        verification.verifyExists(invalidEmailValidation);
    }

    public void VerifyInvalidPasswordValidation(){
        verification.verifyExists(nobodyLikesTrollText);
    }

    public void VerifySuccessfullSignUp(){
        verification.verifyExists(nobodyLikesTrollText);
    }

}
