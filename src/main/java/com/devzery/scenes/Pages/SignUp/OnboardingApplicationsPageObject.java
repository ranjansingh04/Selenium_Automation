package com.devzery.scenes.Pages.SignUp;

import com.devzery.scenes.BaseClass.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OnboardingApplicationsPageObject extends TestBase {
    public OnboardingApplicationsPageObject(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    final By fieldName = By.xpath("//div[contains(@class,'text__title') and contains(@class,'y-scroll')]");
    final By textField = By.xpath("//div[contains(@class,'text__title') and contains(@class,'y-scroll')]/following-sibling::*//*[contains(@class,'input card') and not(@id='date')]");
    final By numericField = By.xpath("//div[contains(@class,'text__title') and contains(@class,'y-scroll')]/following-sibling::*[contains(@class,'input card')]");
    final By dob = By.id("date");
    final By year = By.cssSelector("[class='numInput cur-year']");
    final By date(String date) {
        return By.xpath("//*[@class='flatpickr-day' and text()='"+date+"']");
    }
    final By month = By.cssSelector("[class='flatpickr-monthDropdown-months']");
    final By uploadFile = By.cssSelector("[for='upload_step']");
    final By removeFile = By.xpath("//button//*[text()='Remove File']");
    final By searchUser = By.id("searchUser");
    final By selectOption(String option) {
        return By.xpath("//div[contains(@class,'cursor-pointer select__option')]/span[text()='"+option+"']");
    }
    final By otherReason = By.cssSelector("[name='reason']");
    final By submitAnswer = By.xpath("//button[@type='submit']");
    final By selectCheckBox = By.xpath("//label[@for='accept_conditions']/preceding-sibling::input");
    final By checkBoxValue = By.xpath("//label[@for='accept_conditions']");
    final By fieldTitle = By.cssSelector("[class*='text__title']");
    final By logoutBtn = By.xpath("//button[@type='button']");
    public final By mailAddress = By.id("email-address");
    final By skip = By.xpath("//button[@type='button' and text()='Skip']");
}
