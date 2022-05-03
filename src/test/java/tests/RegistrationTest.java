package tests;

import io.qameta.allure.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.MainPage;
import pages.RegistrationPage;
import pages.SignInPage;
import testdata.GetNewRegistrationModel;
import utilities.RetryAnalyzer;


@Epic("UI regression tests")
@Feature("Account")
@Story("Create new account test")
public class RegistrationTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(RegistrationTest.class.getName());

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    @Description("Check if registration of a new user is possible")
    @Attachment(value = "screenshot", type = "image/png")
    @Severity(SeverityLevel.BLOCKER)
    public void createNewAccountTest() {
        LOGGER.info("'Create new account' test started");
        LOGGER.debug("Thread id is " + Thread.currentThread().getId() + ", webdriver is " + driverType.toString());
        MainPage mainPage = new MainPage(driver);
        LOGGER.info("Attempting to open main page http://automationpractice.com/index.php");
        mainPage.openMainPage();
        mainPage.clickSignInButton();
        SignInPage signInPage = new SignInPage(driver);
        LOGGER.info("Attempting to open registration page");
        signInPage.openRegistrationPage();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        LOGGER.info("Filling in all necessary fields and attempting to register an account");
        registrationPage.createNewAccount(GetNewRegistrationModel.getRegistrationModelWithAllFields());
        AccountPage accountPage = new AccountPage(driver);
        Assert.assertEquals(accountPage.getWelcomeText(), "Welcome to your account. Here you can manage all of your personal information and orders.", "Account was not created");
    }
}
