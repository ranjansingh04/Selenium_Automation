package com.devzery.scenes.Pages.SignUp;

import com.devzery.scenes.BaseClass.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SignUpPageObject extends TestBase {
    public SignUpPageObject(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //    ***************PAGE OBJECTS*****************
    final By firstNameInput = By.xpath("//input[@id='first_name']");
    final By lastNameInput = By.xpath("//input[@id='last_name']");
    final By emailInput = By.xpath("//input[@id='email']");
    final By passwordInput = By.xpath("//input[@id='password']");
    final By termsAndConditionsCheckbox = By.xpath("//input[@id='accept_conditions']");
    final By signUpButton = By.xpath("//button[normalize-space()='Sign up']");
    final By invalidEmailValidation = By.xpath("//span[@class='error-text']");
    final By invalidPasswordValidation = By.xpath(""); // No Validation message implemented when password is less than 6 characters
    final By nobodyLikesTrollText = By.xpath("(//div[@class='text__title text-2xl text-center mb-1 font-semibold'])[1]");
}
