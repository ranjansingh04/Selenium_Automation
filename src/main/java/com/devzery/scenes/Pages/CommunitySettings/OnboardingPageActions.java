package com.devzery.scenes.Pages.CommunitySettings;

import com.devzery.scenes.Utilities.SeleniumUtils;
import com.devzery.scenes.Utilities.StaticWaits;
import com.devzery.scenes.Utilities.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class OnboardingPageActions extends OnboardingPageObject {
    SeleniumUtils seleniumUtils;
    public OnboardingPageActions(WebDriver driver) {
        super(driver);
        seleniumUtils = new SeleniumUtils(driver);
    }

    public void clickOnSettings()
    {
        settingsButton.click();
        //seleniumUtils.click(settingsButton);
        Log.info("Clicked: Settings");
    }

    public void clickOnOnboardingSettings()
    {
        seleniumUtils.click(onboardingSettings);
        Log.info("Clicked: OnBoarding Settings");
    }

    public void clickOnApplicationFormSwitch(String state)
    {
        String switchState = applicationFormSwitch.getAttribute("aria-checked");
        System.out.println("Value of type attribute: "+switchState);
        if(state.equals("ON")) {
            if (switchState.equals("true"))
                Log.info("Application Form is ON");
            else
                applicationFormSwitch.click();
        } else if (state.equals("OFF")) {
            if (switchState.equals("false"))
                Log.info("Application Form is OFF");
            else
                applicationFormSwitch.click();
        }
        else {
            Log.info("Incorrect State! Please, provide correct state");
        }
        StaticWaits.staticShortWait();
    }

    public void gateKeepingToggle(String toggle) {
        TestUtility.waitUntilElementEnabled(driver, gateKeepingToggle, 20);
        String status = driver.findElement(gateKeepingToggle).getCssValue("aria-checked").toString();
        if(toggle.contains("enable")) {
            if(status.contains("true")) {
                Log.info("Already Gate Keeping toggle is enabled");
            }else {
                seleniumUtils.click(seleniumUtils.findElement(gateKeepingToggle));
                Log.info("Gate Keeping toggle is enabled");
                StaticWaits.staticShortWait();
            }
        }else {
            if(status.contains("true")) {
                seleniumUtils.click(seleniumUtils.findElement(gateKeepingToggle));
                Log.info("Gate Keeping toggle is disabled");
                StaticWaits.staticShortWait();
            }else {
                Log.info("Already Gate Keeping toggle is enabled");
            }
        }
        StaticWaits.staticShortWait();
    }

    public void clickOnOnboardingSaveSettings() {
        onboardingSaveSettings.click();
        StaticWaits.staticMediumWait();
        seleniumUtils.acceptAlert();
        StaticWaits.staticMediumWait();
    }

    public void addAnotherQuestion(String questionType, String question) {
        addAnotherQuestionButton.click();
        StaticWaits.staticShortWait();
        type(questionType).click();
        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@title='Rich Text Area']"));
        driver.switchTo().frame(iframeElement);
        StaticWaits.staticShortWait();
        driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys(question);
        StaticWaits.staticShortWait();
        driver.switchTo().defaultContent();
        StaticWaits.staticShortWait();
        driver.findElement(By.xpath("//button[text()='Add Question']")).click();
        StaticWaits.staticMediumWait();
    }

    public void discardQuestionButton() {
        driver.findElement(By.xpath("//button[text()='Discard']")).click();
    }

    public void closeQuestionButton() {
        driver.findElement(By.xpath("//button[contains(@class,'text__title rounded-md')]")).click();
    }
}
