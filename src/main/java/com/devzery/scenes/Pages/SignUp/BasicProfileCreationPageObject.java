package com.devzery.scenes.Pages.SignUp;

import com.devzery.scenes.BaseClass.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasicProfileCreationPageObject extends TestBase {
    public BasicProfileCreationPageObject(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    final By inputFirstName = By.id("firstName");
    final By inputLastName = By.id("lastName");
    final By inputUserName = By.id("username");
    final By genderListBox = By.cssSelector("button[id*='listbox-button']");
    final By genderListBoxOptions = By.xpath("//button[contains(@id,'listbox-button')]/following-sibling::*[@role='listbox']//span[string-length(text())>0]");
    final By selectGenderValue(String value) {
        return By.xpath("//button[contains(@id,'listbox-button')]/following-sibling::*[@role='listbox']//span[string-length(text())>0 and text()="+value+"']");
    }
    final By profileCoverPhoto = By.xpath("//*[@id='cover_img']/preceding-sibling::div");
    final By bio = By.id("about");
    final By continueBtn = By.xpath("//button[@type='submit' and text()='Continue']");
    final By changeProfilePic = By.cssSelector("[for='profile_pic']");
    final By skip = By.xpath("//button[@type='button' and text()='Skip']");
    final By cropBtn = By.xpath("//button[text()='Crop']");
}
