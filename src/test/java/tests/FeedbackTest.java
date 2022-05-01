package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FeedbackPage;
import pages.MainPage;

public class FeedbackTest extends BaseTest {

    @Test
    public void feedbackMessageTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickFeedbackButton();
        FeedbackPage feedbackPage = new FeedbackPage(driver);
        feedbackPage.sendMessage();
        Assert.assertEquals(feedbackPage.getAlertText(), "Your message has been successfully sent to our team.", "Error");
    }
}
