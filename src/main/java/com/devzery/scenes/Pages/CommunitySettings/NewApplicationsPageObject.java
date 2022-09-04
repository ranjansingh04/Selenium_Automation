package com.devzery.scenes.Pages.CommunitySettings;

import com.devzery.scenes.BaseClass.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class NewApplicationsPageObject extends TestBase {

    public NewApplicationsPageObject(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    final By newApplications = By.cssSelector("a[id='New Applications']");
    final By viewBtn(String mailId) {
        return By.xpath("//*[contains(text(),'"+mailId+"')]/parent::*//following-sibling::*//span[contains(text(),'View')]/parent::button");
    }
    public final By acceptBtn = By.xpath("//*[contains(@class,'slide-active')]//button[text()='Accept']");
    public final By declineBtn = By.xpath("//*[contains(@class,'slide-active')]//button[text()='Decline']");


}
