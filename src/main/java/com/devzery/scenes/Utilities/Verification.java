package com.devzery.scenes.Utilities;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Verification {
    WebDriver driver;
    SoftAssert softAssert;
    SeleniumUtils seleniumUtils;
    public Verification(WebDriver driver) {
        this.driver = driver;
        this.seleniumUtils = new SeleniumUtils(driver);
        this.softAssert = new SoftAssert();
    }

    //***********************************************************
    //*************TITLE FUNCTIONS************************
    //***********************************************************
    public void Title(String data) {
        System.out.println(driver.getTitle());
        softAssert.assertEquals(driver.getTitle(),data);
        if (driver.getTitle().equals(data)){
            Assert.assertTrue(true);
        }
        else{
            Assert.fail();
        }
    }
    public void verifyObjText(WebElement obj,String name,String data) {
        if (obj != null) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView()", obj);
            String trim = data.replace(" \n", "\n").replace("&amp;", "&").trim();
            softAssert.assertEquals(obj.getText().replace(" \n","\n").trim(), trim);
            if (obj.getText().replace(" \n","\n").trim().compareTo(trim) == 0) {
                Assert.assertTrue(true);
            } else {
                Assert.fail();
            }
        }
        else
            System.out.println("WebElement Provided for Verification is NULL");
    }

    public void verifyObjValue(WebElement obj, String name , String data) {
        if (obj != null) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView()", obj);
            String FieldValue = obj.getAttribute("value");
            if (FieldValue.contains(data)){
                Assert.assertTrue(true);
            } else {
                Assert.fail();
            }
        }
    }

    //***********************************************************
    //*************OBJECT EXISTANCE FUNCTIONS************************
    //***********************************************************
    public void verifyExists(By identifier,boolean test) {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        List<WebElement> ShowHelp = seleniumUtils.findElements(identifier);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        if (ShowHelp.size()>0 && ShowHelp.get(0).isDisplayed()){
            if (test) {
         Assert.assertTrue(true);
            }
            else {
                Assert.fail();
            }
            softAssert.assertEquals(true, ShowHelp.get(0).isDisplayed());
        }
        else{
            Assert.assertFalse(test);
            softAssert.assertEquals(false, (ShowHelp.size()>0 && ShowHelp.get(0).isDisplayed()));
        }
    }
    public Boolean verifyExists(By identifier){
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        List<WebElement> ShowHelp = seleniumUtils.findElements(identifier);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return !ShowHelp.isEmpty();
    }
}
