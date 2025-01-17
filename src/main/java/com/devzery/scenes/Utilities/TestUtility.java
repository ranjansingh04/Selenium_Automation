package com.devzery.scenes.Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.devzery.scenes.BaseClass.TestBase;
import com.devzery.scenes.Constants.Constants;

public class TestUtility extends TestBase {
	public static Workbook book;
	public static Sheet sheet;
	private static WebDriver driver;
	public static Actions actions;
	public static Select select;
	public static Alert alert;
	public TestUtility(WebDriver driver) {
		TestUtility.driver =  driver;
	}

	//DataProvider Utility is used for getting Data from Excel ==>> Should be used with @DataProvider.
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(Constants.TEST_DATA_SHEET_PATH);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			assert file != null;
			book = WorkbookFactory.create(file);
		}
		catch(IOException e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i = 0; i < sheet.getLastRowNum(); i++) {
			for(int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}

	//To Switch into a Frame using Name.
	public void switchToFrame(String frameName) {
		try {
			driver.switchTo().frame(frameName);
			System.out.println("Navigated to Frame with Name ::: " +frameName);
		}
		catch (NoSuchFrameException e) {
			System.out.println("Unable to Locate Frame with Name ::: " +frameName + Arrays.toString(e.getStackTrace()));
		}
		catch (Exception e) {
			System.out.println("Unable to Navigate to Frame with Name ::: " +frameName + Arrays.toString(e.getStackTrace()));
		}
	}

	//To Switch into a Frame using Index.
	public void switchToFrame(int frame) {
		try {
			driver.switchTo().frame(frame);
			System.out.println("Navigated to Frame with Index ::: " +frame);
		}
		catch(NoSuchFrameException e) {
			System.out.println("Unable to Locate Frame with Index ::: " +frame + Arrays.toString(e.getStackTrace()));
		}
		catch(Exception e) {
			System.out.println("Unable to Navigate to Frame with Index ::: " +frame + Arrays.toString(e.getStackTrace()));
		}
	}

	//To Take Screenshot at End Of Test.
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/" + System.currentTimeMillis() + ".png"));
	}

	//Explicit Wait to Click on WebElement.
	public static void clickOn(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	//Explicit Wait to Send Data to WebElement.
	public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}

	//Explicit Wait for Element To Be Visible.
	public static void waitForElementToBeVisible(WebDriver driver, By locator, int timeout) {
		new WebDriverWait(driver, timeout).
				until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public static void waitUntilElementEnabled(WebDriver driver,By by, long timeOutInSeconds) {
		(new WebDriverWait(driver, timeOutInSeconds))
				.until(ExpectedConditions.elementToBeClickable(by));
	}
	public static void waitUntilElementDisabled(WebDriver driver,By by, long timeOutInSeconds) {
		(new WebDriverWait(driver, timeOutInSeconds))
				.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(by)));
	}
	public static Boolean checkElementIsEnabledFor(WebDriver driver,By by, int timeOutInSeconds) {
		try {
			waitUntilElementEnabled(driver,by, timeOutInSeconds);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	//To Handle Multiple Windows or Switch Between Multiple Windows.
	public void switchWindow(WebDriver driver, String firstWindow, String secondWindow) {
		Set<String> windowHandles = driver.getWindowHandles();
		for(String windows : windowHandles) {
			if(!windows.equals(firstWindow) && !windows.equals(secondWindow)) {
				driver.switchTo().window(windows);
			}
		}
	}

	//To Check Element is Displayed or No.
	public static void isElementDisplayed(WebElement element) {
		boolean elementDisplayed = element.isDisplayed();
		if(elementDisplayed) {
			System.out.println("Element is Displayed");
		}
		else {
			System.out.println("Element is not Displayed");
		}
	}

	//To Check Element is Enabled or No.
	public static void isElementEnabled(WebElement element) {
		boolean elementEnabled = element.isEnabled();
		if(elementEnabled) {
			System.out.println("Element is Enabled");
		}
		else {
			System.out.println("Element is not Enabled");
		}
	}

	//To Select a value from Drop Down by using SelectByVisibleText Method.
	public static void selectValueFromDropDownByText(WebElement element, String value) {
		select = new Select(element);
		select.selectByVisibleText(value);
	}

	//To Select a value from Drop Down by using SelectByIndex Method.
	public static void selectValueFromDropDownByIndex(WebElement element, int value) {
		select = new Select(element);
		select.selectByIndex(value);
	}

	//To Select a value from Drop Down by using SelectByValue Method.
	public static void selectValueFromDropDownByValue(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);
	}

	//To Print all Values and Select a Required Value from Drop Down.
	public static void selectDropDownValue(String xpathValue, String value) {
		List<WebElement> monthList = driver.findElements(By.xpath(xpathValue));
		System.out.println(monthList.size());

		for (WebElement webElement : monthList) {
			System.out.println(webElement.getText());
			if (webElement.getText().equals(value)) {
				webElement.click();
				break;
			}
		}
	}

	//To Validate Drop Down Values.
	public static List<String> dropDownValuesValidation(WebElement element) {
		Select select = new Select(element);
		List<WebElement> dropDownValues = select.getOptions();

		List<String> toolsDropDownValues = new ArrayList<>();

		for(WebElement listOfDropDownValues : dropDownValues) {
			toolsDropDownValues.add(listOfDropDownValues.getText());
		}
		return toolsDropDownValues;
	}

	//To Select Radio Button.
	public void selectRadioButton(List<WebElement> element, String value) {
		for(WebElement elements : element) {
			if(elements.getText().equalsIgnoreCase(value)) {
				elements.click();
				break;
			}
		}
	}

	//To Accept Alert Pop-Up.
	public static void acceptAlertPopup() {
		try {
			alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			Thread.sleep(2000);
			alert.accept();
			System.out.println("Alert Accepted Successfully");
		}
		catch(Exception e) {
			System.out.println("Something Went Wrong ==>> Please Check ::: " +e.getMessage());
		}
	}

	//To Dismiss Alert Pop-Up.
	public static void dismissAlertPopup() {
		try {
			alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			Thread.sleep(2000);
			alert.dismiss();
			System.out.println("Alert Dismissed Successfully");
		}
		catch(Exception e) {
			System.out.println("Something Went Wrong ==>> Please Check ::: " + e.getMessage());
		}
	}

	//To Match Value with List of Elements and Click on it.
	public void clickOnMatchingValue(List<WebElement> listOfElements, String valueToBeMatched) {
		for(WebElement element : listOfElements) {
			if(element.getText().equalsIgnoreCase(valueToBeMatched)) {
				element.click();
				return;
			}
		}
	}

	//To Click on Element using Actions Class.
	public void clickOnElementUsingActions(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
	}

	//To Mouse Hover and Click or Select an Element using Actions Class.
	public static void moveToElement(WebDriver driver, WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	//To Perform Drag and Drop action using Actions Class - 1.
	public static void dragAndDrop_1(WebDriver driver, WebElement sourceElement, WebElement destinationElement) {
		actions = new Actions(driver);
		actions.dragAndDrop(sourceElement, destinationElement).pause(Duration.ofSeconds(2)).release().build().perform();
	}

	//To Perform Drag and Drop action using Actions Class - 2.
	public static void dragAndDrop_2(WebDriver driver, WebElement sourceElement, WebElement destinationElement) {
		actions = new Actions(driver);
		actions.clickAndHold(sourceElement).pause(Duration.ofSeconds(2)).moveToElement(destinationElement).pause(Duration.ofSeconds(2)).release().build().perform();
	}

	//To Perform Right Click action using Actions Class.
	public static void rightClick(WebDriver driver, WebElement element) {
		actions = new Actions(driver);
		actions.contextClick(element).build().perform();
	}

	//To perform Double Click action using Actions Class.
	public static void doubleClick(WebDriver driver, WebElement element) {
		actions = new Actions(driver);
		actions.doubleClick(element).build().perform();
	}

	//Extent Report - 1.
	public static String getSystemDate() {
		DateFormat dateFormat = new SimpleDateFormat("_ddMMyyyy_HHmmss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	//Extent Report - 2.
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	//Set Date For Log4J.
	public static void setDateForLog4j() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("_ddMMyyyy_HHmmss");
		System.setProperty("current_date", dateFormat.format(new Date()));
		PropertyConfigurator.configure("./src/main/resources/log4j.properties");
	}
	public static void uploadfileFromWindows(String filePath) {
		String file = filePath;
		if (!filePath.contains(System.getProperty("user.dir")) && filePath.contains("\\"))
			file = System.getProperty("user.dir") + File.separator + filePath;
		StringSelection stringSelection = new StringSelection(file.trim());
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		System.out.println(file);
		Robot robot;
		try {
			robot = new Robot();
			System.out.println("aaa");
			robot.setAutoDelay(3000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.setAutoDelay(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.setAutoDelay(1000);
			robot.keyRelease(KeyEvent.VK_ENTER);
			StaticWaits.staticMediumWait();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
}