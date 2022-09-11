package com.devzery.scenes.Pages.Forum;

import com.devzery.scenes.Utilities.JavaScriptUtilities;
import com.devzery.scenes.Utilities.SeleniumUtils;
import com.devzery.scenes.Utilities.StaticWaits;
import com.devzery.scenes.Utilities.TestUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.regex.Pattern;

import static org.testng.Assert.assertEquals;

public class ForumPageActions extends ForumPageObject {

    private final SeleniumUtils seleniumUtils;

    public ForumPageActions(WebDriver driver) {
        super(driver);
        seleniumUtils = new SeleniumUtils(driver);
    }
	public void clickOnForumChannel()
	{
        try {
            forumChannel.click();
            StaticWaits.staticMediumWait();
        } catch (StaleElementReferenceException e) {
            PageFactory.initElements(driver, ForumPageObject.class);
        }
    }

	public void createNewForumChannel (String channelName)
	{
		addNewChannel.click();
		newForumChannelCreation.click();
		nextButtonNewChannelCreation.click();
		channelNameElement.sendKeys(channelName);
		createButtonForumCreation.click();
        StaticWaits.staticMediumWait();
	}

    public void editForumChannel(String channelName)
    {
        Actions action = new Actions(driver);
        WebElement channelSettingsButton = driver.findElement(By.xpath("//div[text()='"+channelName+"']/following-sibling::div/div"));
        action.moveToElement(channelSettingsButton);
        action.click().build().perform();
        channelNameElement.clear();
        channelNameElement.sendKeys(property.getProperty("EditChannelName"));
        StaticWaits.staticMediumWait();
        editForumSaveSettings.click();
        StaticWaits.staticMediumWait();
    }

    public void deleteForumChannel(String channelName)
    {
        Actions action = new Actions(driver);
        WebElement channelSettingsButton = driver.findElement(By.xpath("//div[text()='"+channelName+"']/following-sibling::div/div"));
        action.moveToElement(channelSettingsButton);
        action.click().build().perform();
        deleteChannel.click();
        deleteChannelButton.click();
    }

    public void forumPostCreation(String forumPostDescription) throws InterruptedException {
        forumPostButton.click();
        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@title='Rich Text Area']"));
        driver.switchTo().frame(iframeElement);
        Thread.sleep(2000);
        forumPostBody.sendKeys(forumPostDescription);
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
 //     uploadImg("UploadFiles\\images\\sampleImg.png");
        String filePath = "UploadFiles\\images\\sampleImg.png";
        seleniumUtils.uploadFileByJavaScript(AddImage,filePath);
        forumCreatePostButton.click();
    }

    public void forumPostCreationTextOnly(String forumPostDescription) throws InterruptedException {
        forumPostButton.click();
        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@title='Rich Text Area']"));
        driver.switchTo().frame(iframeElement);
        Thread.sleep(2000);
        forumPostBody.sendKeys(forumPostDescription);
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        forumCreatePostButton.click();
    }

    public void forumPostCreationNegative() throws InterruptedException {
        forumPostButton.click();
 //     uploadImg("UploadFiles\\images\\sampleImg.png");
        String filePath = "UploadFiles\\images\\sampleImg.png";
        seleniumUtils.uploadFileByJavaScript(AddImage,filePath);
        forumCreatePostButton.click();
    }

	public void likePost(int i)
	{
        WebElement likeButton = driver.findElement(By.xpath("//*[@class='card rounded shadow p-4 mb-4 post-wrapper']["+i+"]//*[name()='svg' and @id='like']"));
        likeButton.click();
        //JavaScriptUtilities.clickElementByJavaScript(likeButton, driver);
	}

	public void dislikePost(int i)
	{
        WebElement dislikeButton = driver.findElement(By.xpath("//*[@class='card rounded shadow p-4 mb-4 post-wrapper']["+i+"]//*[name()='svg' and @id='dislike']"));
        dislikeButton.click();
	}

	public int  likeDislikeCount(int i)
	{
        WebElement netLikeDislikeCount = driver.findElement(By.xpath("//*[@class='card rounded shadow p-4 mb-4 post-wrapper']["+i+"]/div[3]/div//small"));
        String count = netLikeDislikeCount.getText();
        return Integer.parseInt(count);
	}

	public void sharePost(int i)
	{
        WebElement shareButton = driver.findElement(By.xpath("(//*[@class='card rounded shadow p-4 mb-4 post-wrapper']/div[3]/div[3])["+i+"]//*[name()='svg']"));
		shareButton.click();
        shareCloseButton.click();
	}

    public void commentPost(String comment, int i) throws InterruptedException {
        //WebElement commentButton = driver.findElement(By.xpath("(//*[@class='card rounded shadow p-4 mb-4 post-wrapper']/div[3]/div[2])["+i+"]//*[name()='svg']"));
        WebElement commentButton = driver.findElement(By.xpath("(//*[@class='card rounded shadow p-4 mb-4 post-wrapper']/div[3]/div[2])["+i+"]"));
        JavaScriptUtilities.scrollIntoElementByJavaScript(commentButton, driver);
        JavaScriptUtilities.clickElementByJavaScript(commentButton, driver);
        forumPostCommentAs.getText();
        StaticWaits.staticMediumWait();
        forumPostCommentBody.sendKeys(comment);
        StaticWaits.staticMediumWait();
        forumPostCommentButton.click();
        StaticWaits.staticMediumWait();
        backToForumMainPage.click();
        StaticWaits.staticMediumWait();
        getTotalForumpostCount();
    }

	public void commentCount()
	{
		commentCount.getText();
	}

    public WebElement getThreedot(int i)
    {
        String path = "(//*[@class='card rounded shadow p-4 mb-4 post-wrapper'])["+i+"]//button";
        By Threedot = By.xpath(path);
        return driver.findElement(Threedot);
    }

    public WebElement getPinBtn()
    {
        return pinBtn;
    }

/*    public WebElement getPinPosttext()
    {
        return pinPosttext;
    }*/

    /*public WebElement getPinPostContent(int i)
    {
        String path = "(//div[@class='post-details'])["+i+"]";
        By PinPostContent = By.xpath(path);
        return driver.findElement(PinPostContent);
    }*/

    public WebElement getGetUnPinFirstPost()
    {
        return getUnPinFirstPost;
    }

    public WebElement getunpindot()
    {
        return unPinDot;
    }

    /*public WebElement getSecThreedot()
    {
        return secThreedot;
    }*/

    /*public WebElement getSecPinPostContent()
    {
        return secPinPostContent;
    }*/

    /*public WebElement getPinPostPopup()
    {
        return pinPostPopup;
    }*/

    /*public WebElement getThirdThreedot()
    {
        return thirdThreedot;
    }*/

    /*public WebElement getThirdPinPostContent()
    {
        return thirdPinPostContent;
    }*/

    /*public WebElement getThirdPinPostContent1()
    {
        return thirdPinPostContent1;
    }*/

    public WebElement getFirstBookmarkBtn()
    {
        return firstBookmarkBtn;
    }

    /*public WebElement getProfileimage()
    {
        return profileImage;
    }*/

    /*public WebElement getMyBookmark()
    {
        return myBookmark;
    }*/

    /*public WebElement getProfileBookmarkText()
    {
        return profileBookmarkText;
    }*/

    public WebElement getRemoveBookmarkThreeDot()
    {
        return removeBookmarkThreeDot;
    }

    public WebElement getremoveBookmarkBtn()
    {
        return removeBookmarkBtn;
    }

    public WebElement getNoBookmarkMessage()
    {
        return noBookmarkMessage;
    }

    /*public WebElement getMyBookmar2()
    {
        return myBookmar2;
    }*/

    /*public WebElement getThirdProfileBookmarkText()
    {
        return thirdProfileBookmarkText;
    }*/

    public WebElement getbookmarkUrl()
    {
        driver.get("https://automation.avalonmeta.com/profile/bookmarks");
        return null;
    }

    public WebElement getEditForumPostBtn()
    {
        return editForumPostBtn;
    }

    public WebElement getEdittextBox()
    {
        edittextBox.click();
        edittextBox.sendKeys(" Hello");
        return null;
    }

    public WebElement getEditSubmitBtn()
    {
        return editSubmitBtn;
    }

    public WebElement getEditSuccessFulMsg()
    {
        return editSuccessFulMsg;
    }

    public WebElement getReportPostButton()
    {
        return reportPostButton;
    }

    public WebElement getReportPostDetails()
    {
        reportPostDetails.sendKeys("Test");
        return null;

    }

    public WebElement getReportPostCancelBtn()
    {
        return reportPostCancelBtn;
    }

    public WebElement getReportPostBtn()
    {
        return reportPostBtn;
    }

    public WebElement getReportSuccessText()
    {
        return reportSuccessText;
    }

    public WebElement getDeleteButton()
    {
        return deleteButton;
    }

    public WebElement getDeleteCancelButton()
    {
        return deleteCancelButton;
    }

    public WebElement getDeleteConfirmButton()
    {
        return deleteConfirmButton;
    }

    public WebElement getDeleteConfirmText()
    {
        return deleteConfirmText;
    }

    public int getTotalForumpostCount() throws InterruptedException {
        List<WebElement> webEleList = driver.findElements(By.xpath("(//div[@class='card rounded shadow p-4 mb-4 post-wrapper'])"));
        //(//div[contains(@class,'card rounded')])
        int initialTotalForumCount = webEleList.size();
        WebElement lastForumcard = driver.findElement(By.xpath("(//div[@class='card rounded shadow p-4 mb-4 post-wrapper'])["+initialTotalForumCount+"]"));
        JavaScriptUtilities.scrollIntoElementByJavaScript(lastForumcard, driver);
        Thread.sleep(10000);
        List<WebElement> webEleListAfterScroll = driver.findElements(By.xpath("(//div[@class='card rounded shadow p-4 mb-4 post-wrapper'])"));
        int TotalForumCount = webEleListAfterScroll.size();
        WebElement firstForumcard = driver.findElement(By.xpath("(//div[@class='card rounded shadow p-4 mb-4 post-wrapper'])[1]"));
        JavaScriptUtilities.scrollIntoElementByJavaScript(firstForumcard, driver);
        Thread.sleep(10000);

        Log.info("Total Forum Post Count is" +TotalForumCount);
        Thread.sleep(TotalForumCount);
        return 4;
    }

    public void pinAndUnpinPost() throws InterruptedException {
        int total = getTotalForumpostCount();

        if(total != 0) {
            for(int i = 1; i<=total; i++) {
                //getThreedot(i).click();
                JavaScriptUtilities.scrollIntoElementByJavaScript(getThreedot(i),driver);
                JavaScriptUtilities.clickElementByJavaScript(getThreedot(i),driver);
                Thread.sleep(4000);

                //getPinBtn().click();
                JavaScriptUtilities.scrollIntoElementByJavaScript(getPinBtn(),driver);
                JavaScriptUtilities.clickElementByJavaScript(getPinBtn(),driver);
                Thread.sleep(4000);

                //getunpindot().click();
                JavaScriptUtilities.scrollIntoElementByJavaScript(getThreedot(1),driver);
                JavaScriptUtilities.clickElementByJavaScript(getThreedot(1),driver);
                Thread.sleep(4000);

                //getGetUnPinFirstPost().click();
                JavaScriptUtilities.scrollIntoElementByJavaScript(getGetUnPinFirstPost(),driver);
                JavaScriptUtilities.clickElementByJavaScript(getGetUnPinFirstPost(),driver);
                Thread.sleep(4000);

                //getThreedot(i).click();
                JavaScriptUtilities.scrollIntoElementByJavaScript(getThreedot(i),driver);
                JavaScriptUtilities.clickElementByJavaScript(getThreedot(i),driver);
                Thread.sleep(4000);

                String PinText = "Pin Post";
                String PinText1 = getPinBtn().getText();

                assertEquals(PinText1, PinText,"Successfully UnPin Posted");
                driver.navigate().refresh();
                Thread.sleep(4000);
            }
        }
        else
        {
            System.out.println("No Forum Found");
        }
    }

    public void bookmarkAndRemoveBookmarkpost() throws InterruptedException {
        int total = getTotalForumpostCount();

        if(total != 0) {
            for(int i = 1; i<=total; i++) {
                //getThreedot(i).click();
                JavaScriptUtilities.scrollIntoElementByJavaScript(getThreedot(i),driver);
                JavaScriptUtilities.clickElementByJavaScript(getThreedot(i),driver);
                Thread.sleep(4000);

                //getFirstBookmarkBtn().click();
                JavaScriptUtilities.scrollIntoElementByJavaScript(getFirstBookmarkBtn(),driver);
                JavaScriptUtilities.clickElementByJavaScript(getFirstBookmarkBtn(),driver);
                Thread.sleep(4000);

                getbookmarkUrl();

                //getRemoveBookmarkThreeDot().click();
                JavaScriptUtilities.scrollIntoElementByJavaScript(getThreedot(1),driver);
                JavaScriptUtilities.clickElementByJavaScript(getThreedot(1),driver);
                Thread.sleep(4000);

                //getremoveBookmarkBtn().click();
                JavaScriptUtilities.scrollIntoElementByJavaScript(getremoveBookmarkBtn(),driver);
                JavaScriptUtilities.clickElementByJavaScript(getremoveBookmarkBtn(),driver);
                Thread.sleep(4000);

                String NodataMsg = "You haven't bookmarked anything yet.";
                String NoBookmarkMessage = getNoBookmarkMessage().getText();

                assertEquals(NoBookmarkMessage, NodataMsg,"Successfully Bookmark removed");
                Thread.sleep(5000);

                clickOnForumChannel();
                getTotalForumpostCount();
            }
        }
        else
        {
            System.out.println("No Forum Found");
        }
    }

    public void reportPost() throws InterruptedException {
        int total = getTotalForumpostCount();
        if(total != 0) {
            for(int i = 1; i<=total; i++) {
                //getThreedot(i).click();
                JavaScriptUtilities.scrollIntoElementByJavaScript(getThreedot(i),driver);
                JavaScriptUtilities.clickElementByJavaScript(getThreedot(i),driver);
                Thread.sleep(2000);

                //getReportPostButton().click();
                JavaScriptUtilities.scrollIntoElementByJavaScript(getReportPostButton(),driver);
                JavaScriptUtilities.clickElementByJavaScript(getReportPostButton(),driver);
                Thread.sleep(2000);

                getReportPostDetails();
                Thread.sleep(2000);

                //getReportPostCancelBtn().click();
                JavaScriptUtilities.scrollIntoElementByJavaScript(getReportPostCancelBtn(),driver);
                JavaScriptUtilities.clickElementByJavaScript(getReportPostCancelBtn(),driver);
                Thread.sleep(2000);

                //getThreedot(i).click();
                JavaScriptUtilities.scrollIntoElementByJavaScript(getThreedot(i),driver);
                JavaScriptUtilities.clickElementByJavaScript(getThreedot(i),driver);
                Thread.sleep(2000);

                //getReportPostButton().click();
                JavaScriptUtilities.scrollIntoElementByJavaScript(getReportPostButton(),driver);
                JavaScriptUtilities.clickElementByJavaScript(getReportPostButton(),driver);
                Thread.sleep(2000);

                getReportPostDetails();
                Thread.sleep(2000);

                //getReportPostBtn().click();
                JavaScriptUtilities.scrollIntoElementByJavaScript(getReportPostBtn(),driver);
                JavaScriptUtilities.clickElementByJavaScript(getReportPostBtn(),driver);
                Thread.sleep(2000);

                String Report= "Your report has been submitted for review.";
                String SuccessText = getReportSuccessText().getText();
                assertEquals(SuccessText, Report,"Successfully Bookmark removed");
                Thread.sleep(5000);

            }
        }
        else
        {
            System.out.println("No Forum Found");
        }
    }

    public void deletePost() throws InterruptedException {
        int total = getTotalForumpostCount();
        if(total != 0) {
            for(int i = 1; i<=total; i++) {
                //getThreedot(i).click();
                JavaScriptUtilities.scrollIntoElementByJavaScript(getThreedot(i),driver);
                JavaScriptUtilities.clickElementByJavaScript(getThreedot(i),driver);
                Thread.sleep(2000);

                //getDeleteButton().click();
                JavaScriptUtilities.scrollIntoElementByJavaScript(getDeleteButton(),driver);
                JavaScriptUtilities.clickElementByJavaScript(getDeleteButton(),driver);
                Thread.sleep(2000);

                //getDeleteCancelButton().click();
                JavaScriptUtilities.scrollIntoElementByJavaScript(getDeleteCancelButton(),driver);
                JavaScriptUtilities.clickElementByJavaScript(getDeleteCancelButton(),driver);
                Thread.sleep(2000);

                //getThreedot(i).click();
                JavaScriptUtilities.scrollIntoElementByJavaScript(getThreedot(i),driver);
                JavaScriptUtilities.clickElementByJavaScript(getThreedot(i),driver);
                Thread.sleep(2000);

                //getDeleteButton().click();
                JavaScriptUtilities.scrollIntoElementByJavaScript(getDeleteButton(),driver);
                JavaScriptUtilities.clickElementByJavaScript(getDeleteButton(),driver);
                Thread.sleep(2000);

                //getDeleteConfirmButton().click();
                JavaScriptUtilities.scrollIntoElementByJavaScript(getDeleteConfirmButton(),driver);
                JavaScriptUtilities.clickElementByJavaScript(getDeleteConfirmButton(),driver);
                Thread.sleep(2000);

                String DeleteText = "Post deleted!";
                String ConfirmDeleteText = getDeleteConfirmText().getText();

                assertEquals(ConfirmDeleteText, DeleteText,"Successfully Deleted");
                Thread.sleep(3000);
                driver.navigate().refresh();
            }
        }
        else
        {
            System.out.println("No Forum Found");
            //driver.close();
        }
    }

    public void editPost() throws InterruptedException {
        int total = getTotalForumpostCount();

        if(total != 0) {
            for (int i = 1; i <= total; i++) {
                //getThreedot(i).click();
                JavaScriptUtilities.scrollIntoElementByJavaScript(getThreedot(i),driver);
                JavaScriptUtilities.clickElementByJavaScript(getThreedot(i),driver);
                Thread.sleep(2000);

                //getEditForumPostBtn().click();
                JavaScriptUtilities.scrollIntoElementByJavaScript(getEditForumPostBtn(),driver);
                JavaScriptUtilities.clickElementByJavaScript(getEditForumPostBtn(),driver);
                Thread.sleep(5000);

                WebElement iframeElement = driver.findElement(By.xpath("//iframe[@title='Rich Text Area']"));
                driver.switchTo().frame(iframeElement);
                Thread.sleep(2000);

                getEdittextBox();
                Thread.sleep(2000);

                driver.switchTo().defaultContent();
                Thread.sleep(2000);

                getEditSubmitBtn().click();
                Thread.sleep(2000);

                String edittest = "Post updated successfully";
                String editedtest = getEditSuccessFulMsg().getText();
                assertEquals(editedtest, edittest, "Successfully Edited");
                driver.navigate().refresh();
            }
        }
        else
        {
            System.out.println("No Forum Found");
        }
    }

    public void uploadImg(String filePath) {
        TestUtility.waitUntilElementEnabled(driver, AddImage, 10);
        TestUtility.waitForElementToBeVisible(driver, AddImage, 10);
        StaticWaits.staticShortWait();
        seleniumUtils.doubleClick(AddImage);
        StaticWaits.staticShortWait();
        TestUtility.uploadfileFromWindows(filePath);
        StaticWaits.staticShortWait();
        filePath=filePath.split(Pattern.quote("\\"))[1].trim();
        TestUtility.uploadfileFromWindows(filePath);
        Log.info("File uploaded successfully: "+filePath);
    }

    public void postImageValidation(String action, int i) throws InterruptedException {
        forumPostButton.click();
//      uploadImg("UploadFiles\\images\\sampleImg.png");
        String filePath = "UploadFiles\\images\\sampleImg.png";
        seleniumUtils.uploadFileByJavaScript(AddImage,filePath);
        StaticWaits.staticMediumWait();
        WebElement imageAction = driver.findElement(By.xpath("(//*[@class='w-56 h-56']//div)[3]//*[name()='svg']["+i+"]"));
        if(action.equals("remove"))
        {
            imageAction.click();
            StaticWaits.staticMediumWait();
        }

        if(action.equals("fullscreen"))
        {
            imageAction.click();
            StaticWaits.staticMediumWait();
            driver.findElement(By.xpath("//button[@title='Close lightbox']")).click();
            StaticWaits.staticMediumWait();
        }

        if(action.equals("edit"))
        {
            imageAction.click();
            StaticWaits.staticMediumWait();
            for (int k = 1; k <= 4; k++) {
                WebElement rectangle = driver.findElement(By.xpath("//*[@class='mr-4'])["+k+"]//*[name()='svg']"));
                Rectangle rect = rectangle.getRect();
                System.out.println(rect.getWidth());
                System.out.println(rect.getHeight());
                StaticWaits.staticMediumWait();
            }
        }
    }
}
