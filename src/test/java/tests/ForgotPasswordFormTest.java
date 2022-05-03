package tests;

import io.qameta.allure.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.PasswordRecoveryPage;
import pages.SignInPage;
import utilities.PropertiesManager;
import utilities.RetryAnalyzer;


@Epic("UI regression tests")
@Feature("Forms")
@Story("Recover password form test")
public class ForgotPasswordFormTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(ForgotPasswordFormTest.class.getName());

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    @Description("Check if password recovery is possible")
    @Attachment(value = "screenshot", type = "image/png")
    @Severity(SeverityLevel.CRITICAL)
    public void recoverPasswordWithValidEmailTest() {
        LOGGER.info("'Recover password form (valid email)' test started");
        LOGGER.debug("Thread id is " + Thread.currentThread().getId());
        MainPage mainPage = new MainPage(driver);
        LOGGER.info("Attempting to open main page http://automationpractice.com/index.php");
        mainPage.openMainPage();
        mainPage.clickSignInButton();
        SignInPage signInPage = new SignInPage(driver);
        LOGGER.info("Attempting to open password recovery page");
        signInPage.openPasswordRecoveryPage();
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);
        LOGGER.info("Attempting to recover password with valid email");
        passwordRecoveryPage.recoverPassword();
        PropertiesManager propertiesManager = new PropertiesManager();
        Assert.assertEquals(passwordRecoveryPage.getAlertSuccessText(), "A confirmation email has been sent to your address: " + propertiesManager.get("EMAIL"));
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    @Description("Check if password recovery is not possible if email is invalid")
    @Attachment(value = "screenshot", type = "image/png")
    @Severity(SeverityLevel.NORMAL)
    public void recoverPasswordWithInvalidEmailTest() {
        LOGGER.info("'Recover password form (invalid email)' test started");
        LOGGER.debug("Thread id is " + Thread.currentThread().getId() + ", webdriver is " + driverType.toString());
        MainPage mainPage = new MainPage(driver);
        LOGGER.info("Attempting to open main page http://automationpractice.com/index.php");
        mainPage.openMainPage();
        mainPage.clickSignInButton();
        SignInPage signInPage = new SignInPage(driver);
        LOGGER.info("Attempting to open password recovery page");
        signInPage.openPasswordRecoveryPage();
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);
        LOGGER.info("Attempting to recover password with invalid email");
        passwordRecoveryPage.recoverPasswordWithInvalidEmail();
        Assert.assertEquals(passwordRecoveryPage.getAlertFailedText(), "There is 1 error");
    }
}
