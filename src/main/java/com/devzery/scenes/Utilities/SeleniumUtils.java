package com.devzery.scenes.Utilities;


import com.devzery.scenes.BaseClass.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
public class SeleniumUtils extends TestBase {
    WebDriver driver;
    SoftAssert softAssert;
    public SeleniumUtils(WebDriver driver) {
        this.driver = driver;
    }

    // Click on Element
    public void click(WebElement obj) {
        if (obj != null) {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.elementToBeClickable(obj));
            String elementText=obj.getText();
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView()", obj);
            if (obj.isEnabled()) {
                try {
                    jse.executeScript("arguments[0].click()", obj);
                    Log.info("\n Click on Element: "+ elementText);
                }
                catch (Exception e) {
                    try {
                        click(obj);
                    }
                    catch (Exception ex) {
                        Log.info("\n Element Not Clicked: "+ elementText);
                        Assert.fail("\n Element Not Clicked: "+ elementText);
                    }
                }
            }
        }
    }

    // Set Input/Text Box value
    public void setTextBoxValue(WebElement obj, String value) {
        if (obj != null) {
            obj.clear();
            obj.sendKeys(Keys.HOME);
            obj.sendKeys(value);
            Log.info("\n Input Field: "+obj.getText()+ "\nSet Value: "+ value);
        }
    }

    // Set Dropdown value
    public void setDropDownText(WebElement obj, String value) {
            if (obj != null) {
                Select dropDownObj = new Select(obj);
                dropDownObj.selectByVisibleText(value);
                Log.info("\n Dropdown Field: "+obj + "\nSet Value: "+ value);
            }
            else{
                Log.info("\n Dropdown Field: "+ null + " Unable to Set Value");
            }
        }

    // Find Element on a Web page
    public WebElement findElement(By finder) {
        WebElement obj;
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            obj = wait.until(ExpectedConditions.visibilityOfElementLocated(finder));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", obj);
            jse.executeScript("arguments[0].setAttribute('style', '');", obj);
            return obj;
        } catch (Exception e) {
            softAssert.fail( "Element Not Found "+ e.getMessage());
            return null;
        }
    }

    // Find Elements on a Web page
    public List<WebElement> findElements(By finder) {
        List<WebElement> obj;
        try {
            obj = driver.findElements(finder);
            return obj;
        }
        catch(NoSuchElementException e) {
            Assert.fail("No Elements Found "+e.getMessage());
            return null;
        }
    }

    // Waiting for URL to load
    public boolean WaitForURLLoad(String url) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        return wait.until(ExpectedConditions.urlMatches(url));
    }

    // Implicit Wait in Seconds
    public void WaitInSec(Integer timeInSec) {
        try {
            Thread.sleep(timeInSec * 1000);
        }catch (Exception e){
            Log.info("Wait Timeout || CommonFunc.java | WaitInSec()");
        }
    }

    // Wait for Page to Return Complete State
    public void WaitForPageToLoad() {
        WaitInSec(5);
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(webDriver -> "complete".equals(((JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState")));
        }
        catch (Exception e) {
            Log.info("Page load Timeout || CommonFunc.java");
        }
    }

    // Accept Alert popup
    public void acceptAlert() {
        try {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        }
        catch (Exception e) {
            Log.info("Alert not found");
        }
    }
    public void switchToFrame(By element) {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        Log.info("Switched to the iframe : " + element);
    }
    public boolean isElementDisplayed(By by) {
        boolean flag=false;
        try {
            if(driver.findElement(by).isDisplayed()) {
                flag=true;
            }
            return flag;
        }
        catch(Exception ignored) {
        }
        return false;
    }
    public void keyboardTab(By by) {
        WebElement webElement;
        try {
            webElement = driver.findElement(by);
            webElement.sendKeys(Keys.TAB);
            Log.info("Keyboard TAB pressed");

        }
        catch (NoSuchElementException e) {
            Assert.fail("No such element exception: " + e.getMessage());
        }
        catch (Exception e) {
            Assert.fail("Exception: " + e.getMessage());
        }
    }
    public void doubleClick(By by) {
        try {
            Actions actions = new Actions(driver);
            WebElement ele = driver.findElement(by);
            actions.moveToElement(ele).doubleClick().build().perform();
        }
        catch (Exception ignored) {
        }
    }
}