package com.devzery.scenes.Pages.CommunitySettings;

import com.devzery.scenes.Utilities.JavaScriptUtilities;
import com.devzery.scenes.Utilities.SeleniumUtils;
import com.devzery.scenes.Utilities.StaticWaits;
import com.devzery.scenes.Utilities.TestUtility;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NewApplicationsPageActions extends NewApplicationsPageObject {

    SeleniumUtils seleniumUtils;
    public NewApplicationsPageActions(WebDriver driver) {
        super(driver);
        seleniumUtils = new SeleniumUtils(driver);
    }

    public void clickNewApplications() {
        TestUtility.waitUntilElementEnabled(driver, newApplications, 20);
        JavaScriptUtilities.scrollIntoElementByJavaScript(driver.findElement(newApplications), driver);
        seleniumUtils.click(seleniumUtils.findElement(newApplications));
        Log.info("Clicked: New Application");
    }

    public void clickViewBtn(String id) {
        if(TestUtility.checkElementIsEnabledFor(driver,viewBtn(id),10)) {
            seleniumUtils.click(seleniumUtils.findElement(viewBtn(id)));
            Log.info("Clicked: View button");
        }else {
            Log.info("User Application is already approved or locator changed-->"+ viewBtn(id));
            Assert.fail("New Application request is not present for id:"+id);
        }
    }
    public void clickAcceptBtn() {
        TestUtility.waitUntilElementEnabled(driver, acceptBtn, 20);
        seleniumUtils.click(seleniumUtils.findElement(acceptBtn));
        Log.info("Clicked: Accept button");
    }
    public void clickDeclineBtn() {
        TestUtility.waitUntilElementEnabled(driver, declineBtn, 20);
        seleniumUtils.click(seleniumUtils.findElement(declineBtn));
        Log.info("Clicked: Decline button");
    }
    public void updateNewApplicationStatus(String status) {
        if(status.toLowerCase().contains("accept")) {
            clickAcceptBtn();
        }else {
            clickDeclineBtn();
        }
        StaticWaits.staticShortWait();
    }
}
