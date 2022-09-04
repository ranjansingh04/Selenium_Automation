package com.devzery.scenes.Pages.Forum;

import com.devzery.scenes.BaseClass.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForumPageObject extends TestBase
{
    public ForumPageObject(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //    ***************PAGE OBJECTS*****************
	@FindBy(xpath = "//*[@id='3831']")
	@CacheLookup
	WebElement forumChannel;

	@FindBy(xpath = "(//button[text()='Add a new channel'])[1]")
	WebElement addNewChannel;

	@FindBy(xpath = "//div[@test-id='Forum']")
	WebElement newForumChannelCreation;

	@FindBy(xpath = "//button[text()='Next']")
	WebElement nextButtonNewChannelCreation;

	@FindBy(xpath = "//label[text()='Channel Name']/following::input")
	WebElement channelNameElement;

	/*@FindBy(xpath = "//label[text()='Channel Category']/following::select")
	WebElement channelCategoryElement;*/

	@FindBy(xpath = "//button[text()='Create']")
	WebElement createButtonForumCreation;

	@FindBy(xpath = "//button[text()='Save Settings']")
	WebElement editForumSaveSettings;

	@FindBy(xpath = "//button[text()='Delete Channel']")
	WebElement deleteChannel;

	@FindBy(xpath = "(//button[text()='Delete Channel'])[2]")
	WebElement deleteChannelButton;

	@FindBy(xpath = "(//div[contains(@class,'ml-auto pl-2')]//div)[3]")
	WebElement channelSettingsButton;

    @FindBy(xpath = "//*[@class='card rounded shadow p-4 mb-4 post-wrapper']")
    WebElement forumCard;

	@FindBy(xpath = "//*[name()='svg' and @id='like']")
	WebElement likeButton;

	@FindBy(xpath = "//div[@class='card rounded shadow p-4 mb-4 post-wrapper']/div[3]/div//small")
	WebElement netLikeDislikeCount;

	@FindBy(xpath = "//*[name()='svg' and @id='dislike'][\"+i+\"]")
	WebElement dislikeButton;

	@FindBy(xpath = "//div[@class='card rounded shadow p-4 mb-4 post-wrapper']/div[3]/div[2]//*[name()='svg']")
	WebElement commentButton;

	@FindBy(xpath = "//div[@class='card rounded shadow p-4 mb-4 post-wrapper']/div[3]/div[2]//small")
	WebElement commentCount;

	@FindBy(xpath = "//div[@class='card rounded shadow p-4 mb-4 post-wrapper']/div[3]/div[3]//*[name()='svg'][\"+i+\"]")
	WebElement shareButton;

	/*@FindBy(xpath = "//span[text()='Open options']")
	WebElement threedotsMenuButton;*/

	@FindBy(xpath = "(//button[@type='button'])[2]")
	WebElement forumPostButton;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement forumCreatePostButton;

	@FindBy(xpath = "//div[text()='Add Image']")
	WebElement forumCreatePostAddImage;

    final By AddImage = By.xpath("//div[text()='Add Image']");

	@FindBy(xpath = "//body[@id='tinymce']")
	WebElement forumPostBody;

	@FindBy(xpath = "(//*[@id='forumPostComment']")
	WebElement forumPostCommentBody;

	@FindBy(xpath = "//p[@class='text-base text__body']")
	WebElement forumPostCommentAs;

	@FindBy(xpath = "//*[@id='forumPostCommentButton']")
	WebElement forumPostCommentButton;

    @FindBy(xpath = "(//a[normalize-space()='Pin Post'])[1]")
    WebElement pinBtn;

    /*@FindBy(xpath = "/html/body/div[1]/div[1]/div/div[2]/div/div/main/div/div/div/div[1]/div[1]/span")
    WebElement pinPosttext;*/

    @FindBy(xpath = "(//*[name()='svg'][@class='h-5 w-5 main__icon'])[1]")
    WebElement unPinDot;

    @FindBy(xpath = "(//a[normalize-space()='Un-pin Post'])[1]")
    WebElement getUnPinFirstPost;

    /*@FindBy(xpath = "(//*[name()='svg'][@class='h-5 w-5 main__icon'])[2]")
    WebElement secThreedot;*/

    /*@FindBy(xpath = "(//div[contains(text(),'Test Post')])[1]")
    WebElement secPinPostContent;*/

   /* @FindBy(xpath = "(//*[name()='svg'][@class='h-5 w-5 main__icon'])[3]")
    WebElement thirdThreedot;*/

    /*@FindBy(xpath = "(//div[@class='post-details'])[3]")
    WebElement thirdPinPostContent;*/

    /*@FindBy(xpath = "(//button[normalize-space()='Pin Post'])[1]")
    WebElement pinPostPopup;*/

    /*@FindBy(xpath = "//div[contains(text(),'jbiyvouivicvg kmbk')]")
    WebElement thirdPinPostContent1;*/

    @FindBy(xpath = "(//a[normalize-space()='Bookmark Post'])[1]")
    WebElement firstBookmarkBtn;

   /* @FindBy(xpath = "(//img[@class='inline-block h-8 w-8 rounded-full'])[1]")
    WebElement profileImage;*/

    /*@FindBy(id = "headlessui-menu-item-98")
    WebElement myBookmark;*/

    /*@FindBy(id = "headlessui-menu-item-31")
    WebElement myBookmar2;*/

    /*@FindBy(xpath = "(//div[contains(text(),'Test')])[5]")
    WebElement profileBookmarkText;*/

    @FindBy(xpath = "(//*[name()='svg'][@class='h-5 w-5 main__icon'])[1]")
    WebElement removeBookmarkThreeDot;

    @FindBy(xpath = "(//a[normalize-space()='Remove Bookmark'])[1]")
    WebElement removeBookmarkBtn;
    @FindBy(xpath = "(//div[@class='text-lg text-center font-normal text__body text-gray-800 font-Geomanist-book'])[1]")
    WebElement noBookmarkMessage;

    /*@FindBy(xpath = "(//div[contains(text(),'jbiyvouivicvg kmbk')])[1]")
    WebElement thirdProfileBookmarkText;*/

    /*@FindBy(linkText = "https://automation.avalonmeta.com/profile/bookmarks")
    WebElement bookmarkUrl;*/

    @FindBy(xpath = "(//a[normalize-space()='Edit Post'])[1]")
    WebElement editForumPostBtn;

    @FindBy(xpath = "//body[@id='tinymce']")
    WebElement edittextBox;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/button[1]")
    WebElement editSubmitBtn;

    @FindBy(xpath = "(//div[@class='text-sm text-green-800 font-Geomanist font-semibold tracking-normal'])[1]")
    WebElement editSuccessFulMsg;

    @FindBy(xpath = "(//a[normalize-space()='Report Post'])[1]")
    WebElement reportPostButton;

    @FindBy(xpath ="(//textarea[@placeholder='Add anything you would like us to know'])[1]")
    WebElement reportPostDetails;

    @FindBy(xpath = "(//button[normalize-space()='Cancel'])[1]")
    WebElement reportPostCancelBtn;

    @FindBy(xpath = "(//button[normalize-space()='Send Report'])[1]")
    WebElement reportPostBtn;

    @FindBy(xpath = "(//div[@class='text-sm text-green-800 font-Geomanist font-semibold tracking-normal'])[1]")
    WebElement reportSuccessText;

    @FindBy(xpath = "(//a[normalize-space()='Delete Post'])[1]")
    WebElement deleteButton;

    @FindBy(xpath = "(//button[normalize-space()='Cancel'])[1]")
    WebElement deleteCancelButton;

    @FindBy(xpath = "(//button[normalize-space()='Delete'])[1]")
    WebElement deleteConfirmButton;

    @FindBy(xpath = "(//div[@class='text-sm text-green-800 font-Geomanist font-semibold tracking-normal'])[1]")
    WebElement deleteConfirmText;

    @FindBy(xpath = "(//div[contains(@class,'flex flex-row')])[1]//*[name()='svg']")
    WebElement shareCloseButton;

    @FindBy(xpath = "//p[text()='Starter Forum']")
    WebElement backToForumMainPage;
}
