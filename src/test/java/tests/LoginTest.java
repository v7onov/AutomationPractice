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
@Story("Log in test")
public class LoginTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(LoginTest.class.getName());

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    @Description("Check if logging in is possible")
    @Attachment(value = "screenshot", type = "image/png")
    @Severity(SeverityLevel.BLOCKER)
    public void logInTest() {
        LOGGER.info("'Log in' test started");
        LOGGER.debug("Thread id is " + Thread.currentThread().getId() + ", webdriver is " + driverType.toString());
        MainPage mainPage = new MainPage(driver);
        LOGGER.info("Attempting to open main page http://automationpractice.com/index.php");
        mainPage.openMainPage();
        LOGGER.info("Attempting to sign in");
        mainPage.clickSignInButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.logIn(GetNewLoginModel.getCredentials());
        AccountPage accountPage = new AccountPage(driver);
        Assert.assertEquals(accountPage.getWelcomeText(), "Welcome to your account. Here you can manage all of your personal information and orders.", "ERROR");
    }
}
