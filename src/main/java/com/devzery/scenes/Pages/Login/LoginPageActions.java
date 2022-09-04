package com.devzery.scenes.Pages.Login;

import com.devzery.scenes.Pages.CommunityHomepage.CommunityHomepageActions;
import com.devzery.scenes.Utilities.SeleniumUtils;
import com.devzery.scenes.Utilities.StaticWaits;
import com.devzery.scenes.Utilities.TestUtility;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
public class LoginPageActions extends LoginPageObject {
    SeleniumUtils seleniumUtils;

    public LoginPageActions(WebDriver driver) {
        super(driver);
        seleniumUtils = new SeleniumUtils(driver);
    }
    public void clickSignUpLink(){
        seleniumUtils.click(seleniumUtils.findElement(signUpLink));
    }

    public void clickLoginButton(){
        //seleniumUtils.click(seleniumUtils.findElement(signInButton));
        seleniumUtils.click(signInButton);
        StaticWaits.staticShortWait();
    }

    public void enterMailAddress(String emailAddress){
      /*  TestUtility.waitUntilElementEnabled(driver, emailAddressInput, 15);
        driver.findElement(emailAddressInput).click();
        driver.findElement(emailAddressInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        StaticWaits.staticShortWait();
        TestUtility.sendKeys(driver, driver.findElement(emailAddressInput), 15, emailAddress);*/
        seleniumUtils.setTextBoxValue(emailAddressInput, emailAddress);
        System.out.println("Mail Address:"+emailAddress);
    }
    public void enterPassword(String password){
        seleniumUtils.setTextBoxValue(passwordInput, password);
        System.out.println("Password:"+password);
        // driver.findElement(passwordInput).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        //TestUtility.sendKeys(driver, driver.findElement(passwordInput), 15, password);
    }

    public void logoutFromCommunityPage() {
        seleniumUtils.click(seleniumUtils.findElement(profileImageButton));
      //  TestUtility.waitUntilElementEnabled(driver, logOutButton, 10);
        seleniumUtils.click(seleniumUtils.findElement(logOutButton));
        seleniumUtils.WaitForPageToLoad();
        Log.info("User Logged out from Community portal");
     //   StaticWaits.staticShortWait();
    }

    public CommunityHomepageActions loginAs(String emailAddress, String password) {
        enterMailAddress(emailAddress);
        enterPassword(password);
        clickLoginButton();
        return new CommunityHomepageActions(driver);
    }
}
