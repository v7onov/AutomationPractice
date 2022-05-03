package tests;

import io.qameta.allure.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FeedbackPage;
import pages.MainPage;
import utilities.RetryAnalyzer;


@Epic("UI regression tests")
@Feature("Forms")
@Story("Feedback form test")
public class FeedbackTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(FeedbackTest.class.getName());

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    @Description("Check if sending of a feedback message is possible")
    @Attachment(value = "screenshot", type = "image/png")
    @Severity(SeverityLevel.NORMAL)
    public void feedbackMessageTest() {
        LOGGER.info("'Feedback form' test started");
        LOGGER.debug("Thread id is " + Thread.currentThread().getId() + ", webdriver is " + driverType.toString());
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickFeedbackButton();
        FeedbackPage feedbackPage = new FeedbackPage(driver);
        feedbackPage.sendMessage();
        Assert.assertEquals(feedbackPage.getAlertText(), "Your message has been successfully sent to our team.", "Error");
    }
}
