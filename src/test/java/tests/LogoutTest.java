package tests;

import io.qameta.allure.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.MainPage;
import pages.SignInPage;
import testdata.GetNewLoginModel;
import utilities.RetryAnalyzer;


@Epic("UI regression tests")
@Feature("Account")
@Story("Log out test")
public class LogoutTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(LogoutTest.class.getName());

    @Test
    @Description("Check if logging out from account page is possible")
    @Attachment(value = "screenshot", type = "image/png")
    @Severity(SeverityLevel.CRITICAL)
    public void logOutFromAccountPageTest() {
        LOGGER.info("'Log out from account's page' test started");
        LOGGER.debug("Thread id is " + Thread.currentThread().getId() + ", webdriver is " + driverType.toString());
        MainPage mainPage = new MainPage(driver);
        LOGGER.info("Attempting to open main page http://automationpractice.com/index.php");
        mainPage.openMainPage();
        LOGGER.info("Attempting to sign in");
        mainPage.clickSignInButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.logIn(GetNewLoginModel.getCredentials());
        AccountPage accountPage = new AccountPage(driver);
        LOGGER.info("Attempting to log out");
        accountPage.performLogout();
        Assert.assertEquals(signInPage.checkHeaderText(), "AUTHENTICATION", "Error");
    }

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    @Description("Check if logging out from account page is possible")
    @Attachment(value = "screenshot", type = "image/png")
    @Severity(SeverityLevel.CRITICAL)
    public void logOutFromMainPageTest() {
        LOGGER.info("'Log out from main page' test started");
        LOGGER.debug("Thread id is " + Thread.currentThread().getId() + ", webdriver is " + driverType.toString());
        MainPage mainPage = new MainPage(driver);
        LOGGER.info("Attempting to open main page http://automationpractice.com/index.php");
        mainPage.openMainPage();
        LOGGER.info("Attempting to sign in");
        mainPage.clickSignInButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.logIn(GetNewLoginModel.getCredentials());
        AccountPage accountPage = new AccountPage(driver);
        LOGGER.info("Moving to main page");
        accountPage.clickLogo();
        LOGGER.info("Attempting to log out");
        mainPage.performLogout();
        Assert.assertTrue(mainPage.isAccountButtonNotShown());
    }
}
