package com.devzery.scenes.Pages.Login;

import com.devzery.scenes.BaseClass.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends TestBase {
    public LoginPageObject(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //    ***************PAGE OBJECTS*****************
    @FindBy(xpath = "//input[@id='email-address']")
    @CacheLookup
    WebElement emailAddressInput;

    @FindBy(xpath = "//input[@id='password']")
    @CacheLookup
    WebElement passwordInput;

    @FindBy(xpath = "//button[normalize-space()='Sign in']")
    @CacheLookup
    WebElement signInButton;
    private final By rememberMe = By.xpath("//input[@id='remember-me']");
    private final By forgotPasswordLink = By.xpath("//span[@class='font-semibold text__link']");
    final By profileImageButton = By.xpath("//*[@id='headlessui-menu-button-:r45:']");
    final By logOutButton = By.xpath("//*[text()='Logout']");
    final By signUpLink = By.xpath("//button[normalize-space()='Signup']");
}
