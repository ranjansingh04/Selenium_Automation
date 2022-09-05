package com.devzery.scenes.Pages.CommunitySettings;

import com.devzery.scenes.BaseClass.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnboardingPageObject extends TestBase {

    public OnboardingPageObject(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //    ***************PAGE OBJECTS*****************

    @FindBy(xpath = "//*[@id='settings']/parent::button")
    WebElement settingsButton;

    @FindBy(xpath = "//*[@id = 'Onboarding Settings']")
    WebElement onboardingSettings;

    @FindBy(xpath = "(//button[@role='switch'])[3]")
    WebElement applicationFormSwitch;

    @FindBy(xpath = "//button[text()='Save Settings']")
    WebElement onboardingSaveSettings;

    @FindBy(xpath = "//div[contains(@class,'mt-5 flex')]")
    WebElement addAnotherQuestionButton;

    public WebElement type(String questionType) {
        return driver.findElement(By.xpath("//p[text()='"+questionType+"']"));
    }

    final By gateKeepingToggle = By.xpath("//span[contains(text(),'Gate Keeping')]/parent::button");


}
