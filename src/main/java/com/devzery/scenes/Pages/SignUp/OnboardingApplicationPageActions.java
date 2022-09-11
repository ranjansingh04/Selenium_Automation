package com.devzery.scenes.Pages.SignUp;

import com.devzery.scenes.Utilities.RandomUtilities;
import com.devzery.scenes.Utilities.SeleniumUtils;
import com.devzery.scenes.Utilities.StaticWaits;
import com.devzery.scenes.Utilities.TestUtility;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.regex.Pattern;

public class OnboardingApplicationPageActions extends OnboardingApplicationsPageObject {

    private final SeleniumUtils seleniumUtils;
    private final RandomUtilities randomUtilities;

    //Constructor
	public OnboardingApplicationPageActions(WebDriver driver){
		super(driver);
		this.seleniumUtils = new SeleniumUtils(driver);
		this.randomUtilities = new RandomUtilities();
    }
	
	 //Action Methods
    public void enterValueToTextField(String value) {
    	String nameOfField = driver.findElement(fieldName).getText();
    	driver.findElement(textField).sendKeys(value);
    	Log.info("Field:"+nameOfField+" --> Entered Value:"+value);
    	seleniumUtils.keyboardTab(textField);
    }
    public void clickSubmitAnswerBtn() {
    	TestUtility. waitUntilElementEnabled(driver, submitAnswer, 15);
    	seleniumUtils.click(seleniumUtils.findElement(submitAnswer));
    	Log.info("Submit Answer is Clicked");
    	StaticWaits.staticShortWait();
    }
    public void selectFirstCheckBoxValue() {
    	String nameOfField = driver.findElement(fieldName).getText();
    	String value = driver.findElement(checkBoxValue).getText();
    	seleniumUtils.click(seleniumUtils.findElement(selectCheckBox));
    	Log.info("Field:"+nameOfField+" --> Selected checkbox Value:"+value);
    }
    public boolean applicationSubmittedMsg() {
    	String title = driver.findElement(fieldTitle).getText();
		return title.toLowerCase().contains("application received");
    }
    public void clickLogoutBtn() {
    	seleniumUtils.click(seleniumUtils.findElement(logoutBtn));
    	Log.info("Logout Button is clicked");
    	TestUtility.waitUntilElementEnabled(driver, mailAddress, 15);
    }
    public void skipBtn() {
    	if(seleniumUtils.isElementDisplayed(skip)) {
    		driver.findElement(skip).click();
    	}
    }
    public void fillApplicationFormAndClickSubmit() {
    	skipBtn();
    	String txtValue = randomUtilities.randomStringCustomLength(6);
    	String numValue = randomUtilities.randomNumber().substring(0,1);
    	int formSize=0;
    	while(!applicationSubmittedMsg() && formSize<50) {
        	if(seleniumUtils.isElementDisplayed(textField)) {
        		enterValueToTextField(txtValue);
        		clickSubmitAnswerBtn();
        	}else if(seleniumUtils.isElementDisplayed(selectCheckBox)) {
        		selectFirstCheckBoxValue();
        		clickSubmitAnswerBtn();
        	}else if(seleniumUtils.isElementDisplayed(numericField)) {
        		enterNumericData(numValue);
        		clickSubmitAnswerBtn();
        	}else if(seleniumUtils.isElementDisplayed(dob)) {
        		selectDateFromCalender("11-10-1990");
        		clickSubmitAnswerBtn();
        	}else if(seleniumUtils.isElementDisplayed(imageFieldName)) {
        		String filePath = "UploadFiles\\images\\sampleImg.png";
				seleniumUtils.uploadFileByJavaScript(uploadFile, filePath);
        		clickSubmitAnswerBtn();
        	}else if(seleniumUtils.isElementDisplayed(fileFieldName)) {
				String filePath = "UploadFiles\\Documents\\SampleDoc.pdf";
				seleniumUtils.uploadFileByJavaScript(uploadFile, filePath);
				clickSubmitAnswerBtn();
			}else if(seleniumUtils.isElementDisplayed(searchUser)) {
        		selectValueFromDropDown("Option 1");
        		clickSubmitAnswerBtn();
        	}else {
        		Assert.fail("New Field is displayed or Expected field is not displayed");
        	}
        	formSize++;
    	}
    	if(applicationSubmittedMsg()) {
    		String status ="submitted successfully";
    		if(formSize==0) {
    			status ="Already submitted";
    		}
    		Log.info("Onboarding Application Form is "+status);
    		clickLogoutBtn();
    	}
    }
    public void enterNumericData(String value) {
    	String nameOfField = driver.findElement(fieldName).getText();
    	driver.findElement(numericField).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
		TestUtility.sendKeys(driver, driver.findElement(numericField), 15, value);
		Log.info("Field:"+nameOfField+" --> Entered Value:"+value);
    }
    public void selectDateFromCalender(String date) {
    	//Provide date in format dd-mm-yyyy or dd-month-yyyy (i.e 12-11-1990 or 1-January-1990)
    	String [] dmy = date.split("-");
    	TestUtility.waitForElementToBeVisible(driver, dob, 10);
    	StaticWaits.waitFor(3000);
    	seleniumUtils.click(seleniumUtils.findElement(dob));
    	
    	//Select year
    	TestUtility.waitForElementToBeVisible(driver, year, 15);
    	StaticWaits.waitFor(1000);
    	driver.findElement(year).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
    	TestUtility.sendKeys(driver, driver.findElement(year), 15, dmy[2].trim());
    	
    	//Select month
    	int monthNum;
    	Select monthName = new Select(driver.findElement(month));
    	try {
    		monthNum=Integer.parseInt(dmy[1].trim())-1;
    		monthName.selectByIndex(monthNum);
    	}catch(Exception e) {
    		monthName.selectByValue(dmy[1].trim());
    	}
    	StaticWaits.waitFor(1000);
    	
    	//Select Date date
    	seleniumUtils.click(seleniumUtils.findElement(date(dmy[0].trim())));
    	StaticWaits.waitFor(2000);
    	Log.info("Date selected from calender:"+date);
    }
	public void uploadImgOrDocument(String filePath) {
		TestUtility.waitUntilElementEnabled(driver, uploadFile, 10);
		TestUtility.waitForElementToBeVisible(driver, uploadFile, 10);
		StaticWaits.staticShortWait();
		seleniumUtils.doubleClick(uploadFile);
		StaticWaits.staticShortWait();
		TestUtility.uploadfileFromWindows(filePath);
		StaticWaits.staticShortWait();
		if(TestUtility.checkElementIsEnabledFor(driver, removeFile, 10)) {
			Log.info("File uploaded successfully");
		}else {
			filePath=filePath.split(Pattern.quote("\\"))[2].trim();
			TestUtility.uploadfileFromWindows(filePath);
		}
		TestUtility.waitUntilElementEnabled(driver, removeFile, 10);
		Log.info("File uploaded successfully: "+filePath);
	}
	public void selectValueFromDropDown(String option) {
		TestUtility.waitUntilElementEnabled(driver, searchUser, 10);
		seleniumUtils.click(seleniumUtils.findElement(selectOption(option)));
		if(option.toLowerCase().contains("others")) {
			TestUtility.sendKeys(driver, driver.findElement(otherReason), 15, "Test other reason");
		}
		Log.info("Selected value from dropdown: "+option);
	}
}
