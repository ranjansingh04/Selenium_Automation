package com.devzery.scenes.Pages.SignUp;

import com.devzery.scenes.Utilities.JavaScriptUtilities;
import com.devzery.scenes.Utilities.SeleniumUtils;
import com.devzery.scenes.Utilities.StaticWaits;
import com.devzery.scenes.Utilities.TestUtility;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BasicProfileCreationPageActions extends BasicProfileCreationPageObject{
    private final SeleniumUtils seleniumUtils;
	
    //Constructor
	public BasicProfileCreationPageActions(WebDriver driver){
		super(driver);
		this.seleniumUtils = new SeleniumUtils(driver);
    }
	
	public void changeProfilePic(String imgPath) {
		TestUtility.waitForElementToBeVisible(driver, changeProfilePic, 20);
		StaticWaits.staticShortWait();
		seleniumUtils.click(seleniumUtils.findElement(changeProfilePic));
		StaticWaits.staticShortWait();
		TestUtility.uploadfileFromWindows(imgPath);
		StaticWaits.staticShortWait();
		Log.info("Profile pic uploaded successfully:"+imgPath);
	}
	public void enterFirstName(String firstName) {
		driver.findElement(inputFirstName).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
		TestUtility.sendKeys(driver, driver.findElement(inputFirstName), 5, firstName);
		Log.info("Entered First Name:"+firstName);
	}
	public void enterLastName(String lastName) {
		driver.findElement(inputLastName).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
		TestUtility.sendKeys(driver, driver.findElement(inputLastName), 5, lastName);
		Log.info("Entered Last Name:"+lastName);
	}
	public void enterUserName(String userName) {
		driver.findElement(inputUserName).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
		TestUtility.sendKeys(driver, driver.findElement(inputUserName), 5, userName);
		Log.info("Entered User Name:"+userName);
	}
	public void selectGender(String value) {
		JavaScriptUtilities.scrollIntoElementByJavaScript(driver.findElement(genderListBox), driver);
		seleniumUtils.click(seleniumUtils.findElement(genderListBox));
		TestUtility.waitUntilElementEnabled(driver, genderListBoxOptions, 10);
		seleniumUtils.click(seleniumUtils.findElement(selectGenderValue(value)));
		Log.info("Selected Gender as:"+value);
	}
	public void uploadProfileCoverPhoto(String photPath) {
		seleniumUtils.click(seleniumUtils.findElement(profileCoverPhoto));
		StaticWaits.staticShortWait();
		TestUtility.uploadfileFromWindows(photPath);
		StaticWaits.staticShortWait();
		Log.info("Profile cover photo uploaded successfully:"+photPath);
	}
	public void enterBio(String bioContent) {
		TestUtility.sendKeys(driver, driver.findElement(bio), 15, bioContent);
		Log.info("Entered Bio:"+bioContent);
	}
	public void clickContinue() {
		seleniumUtils.click(seleniumUtils.findElement(continueBtn));
		JavaScriptUtilities.waitForLoad(driver);
		Log.info("Continue button is clicked");
	}
    public void clickSkipBtn() {
    	if(seleniumUtils.isElementDisplayed(skip)) {
    		driver.findElement(skip).click();
    		JavaScriptUtilities.waitForLoad(driver);
    		Log.info("Skip button is clicked");
    	}
    }
    public String getFirstName() {
    	TestUtility. waitUntilElementEnabled(driver, inputFirstName, 10);
    	return driver.findElement(inputFirstName).getAttribute("value");
    }
    public void cropImg() {
    	if(TestUtility.checkElementIsEnabledFor(driver, cropBtn, 5)) {
    		seleniumUtils.click(seleniumUtils.findElement(cropBtn));
    		Log.info("Crop image button is clicked");
    	}
    }
}
