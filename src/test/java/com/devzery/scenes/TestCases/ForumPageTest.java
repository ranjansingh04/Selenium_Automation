package com.devzery.scenes.TestCases;

import com.devzery.scenes.BaseClass.TestBase;
import com.devzery.scenes.Pages.Forum.ForumPageActions;
import com.devzery.scenes.Pages.Login.LoginPageActions;
import com.devzery.scenes.Utilities.TestUtility;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ForumPageTest extends TestBase
{
    LoginPageActions loginPage;
    ForumPageActions forumPage;
    TestUtility testUtil;

    @BeforeMethod(alwaysRun=true)
    public void setUp()
    {
        driver = initialization();
        Log.info("Application Launched Successfully");
        testUtil = new TestUtility(driver);
        loginPage = new LoginPageActions(driver);
        forumPage = new ForumPageActions(driver);
        loginPage.loginAs(property.getProperty("Email"),property.getProperty("Password"));
    }

    //Pin and Unpin Post

    @Test(description = "Verify pinning and unpinning of forum post", priority=1, enabled=false)
    public void ForumPinPost() throws InterruptedException {
        forumPage.clickOnForumChannel();
        forumPage.pinAndUnpinPost();
    }

    //Bookmark and Remove Bookmark
    @Test(description = "Verify Bookmark and Remove Bookmark post of forum post", priority=2, enabled=true)
    public void firstBookmark() throws InterruptedException {
        forumPage.clickOnForumChannel();
        forumPage.bookmarkAndRemoveBookmarkpost();
    }

    //Report Post
    @Test(description = "Verify Report post of forum post", priority=3, enabled=true)
    public void Report() throws InterruptedException {
        forumPage.clickOnForumChannel();
        forumPage.reportPost();
    }

    //Delete Post
    @Test(description = "Verify Delete post of forum post", priority=4, enabled=false)
    public void DeletePost() throws InterruptedException {
        forumPage.clickOnForumChannel();
        forumPage.deletePost();
    }

    //Edit Forum Post
    @Test(description = "Verify Edit post of forum post", priority=5, enabled=true)
    public void EditForumPost() throws InterruptedException {
        forumPage.clickOnForumChannel();
        forumPage.editPost();
    }

    @Test(description = "Verify Forum Channel Creation", priority=6, enabled=true)
    public void CreateNewForumChannel() {
        forumPage.createNewForumChannel(property.getProperty("ChannelName"));
    }

    @Test(description = "Verify Edit of Forum Channel Created", priority=7, enabled=true)
    public void EditForumChannelName() {
        forumPage.editForumChannel(property.getProperty("ChannelName"));
    }

    @Test(description = "Verify Deletion of Forum Channel Created", priority=8, enabled=true)
    public void DeleteForumChannelName() {
        forumPage.deleteForumChannel(property.getProperty("EditChannelName"));
    }

    @Test(description = "Verify Forum Post Creation - Image with Text Post", priority=9, enabled=true)
    public void ForumPostCreation() throws InterruptedException {
        forumPage.clickOnForumChannel();
        forumPage.forumPostCreation("Forum Description Goes Here");
    }

    @Test(description = "Verify Forum Post Creation - Image without Text Post", priority=10, enabled=true)
    public void ForumPostCreationNegative() throws InterruptedException {
        forumPage.clickOnForumChannel();
        forumPage.forumPostCreationNegative();
    }

    @Test(description = "Verify Forum Post Creation - Text Post without Image", priority=11, enabled=true)
    public void ForumPostCreationTextOnly() throws InterruptedException {
        forumPage.clickOnForumChannel();
        forumPage.forumPostCreationTextOnly("Forum Description Goes Here");
    }
    @Test(description = "Verify Like button functionality", priority=12)
    public void ForumLikePost() throws InterruptedException {
        forumPage.clickOnForumChannel();
        int total = forumPage.getTotalForumpostCount();
        if(total != 0) {
            for(int i = 1; i <= total; i++) {
                int initialCount = forumPage.likeDislikeCount(i);
                forumPage.likePost(i);
                Thread.sleep(2000);
                int countAfterLike = forumPage.likeDislikeCount(i);
                //assertEquals(countAfterLike, initialCount + 1, "Like Count After liking the post has incremented");
            }
        }
        else {
            Log.info("No Forum Posts Found");
        }
    }
    @Test(description = "Verify Dislike button functionality", priority=13, enabled=true)
    public void ForumDislikePost() throws InterruptedException {
        forumPage.clickOnForumChannel();
        int total = forumPage.getTotalForumpostCount();
        if(total != 0) {
            for(int i = 1; i <= total; i++) {
                int initialCount = forumPage.likeDislikeCount(i);
                forumPage.dislikePost(i);
                Thread.sleep(2000);
                int countAfterDislike = forumPage.likeDislikeCount(i);
                //assertEquals(countAfterDislike, initialCount - 1, "Dislike Count After disliking the post has decremented");
            }
        }
        else {
            Log.info("No Forum Posts Found");
        }
    }
    @Test(description = "Verify if user clicks on share button", priority=14, enabled=true)
    public void ForumPostShare() throws InterruptedException {
        forumPage.clickOnForumChannel();
        int total = forumPage.getTotalForumpostCount();
        if(total != 0) {
            for(int i = 1; i <= total; i++) {
                forumPage.sharePost(i);
                Thread.sleep(2000);
            }
        }
        else {
            Log.info("No Forum Posts Found");
        }
    }
    @Test(description = "Verify Comment functionality on any forum post", priority=15, enabled=true)
    public void ForumPostComment() throws InterruptedException {
        forumPage.clickOnForumChannel();
        int total = forumPage.getTotalForumpostCount();
        if(total != 0) {
            for(int i = 1; i <= total; i++) {
                forumPage.commentPost("Comment 1", i);
                Thread.sleep(2000);
            }
        }
        else {
            Log.info("No Forum Posts Found");
        }
    }
    @Test(priority=16, enabled=true)
    public void postImageRemove() throws InterruptedException {
        forumPage.clickOnForumChannel();
        forumPage.postImageValidation("fullscreen", 1);
        //forumPage.postImageValidation("edit", 2);
        //forumPage.postImageValidation("remove", 3);
    }
}
