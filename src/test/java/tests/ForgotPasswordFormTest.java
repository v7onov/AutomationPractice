package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.PasswordRecoveryPage;
import pages.SignInPage;
import utilities.PropertiesManager;

public class ForgotPasswordFormTest extends BaseTest {

    @Test
    public void recoverPasswordWithValidEmailTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickSignInButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.openPasswordRecoveryPage();
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);
        passwordRecoveryPage.recoverPassword();
        PropertiesManager propertiesManager = new PropertiesManager();
        Assert.assertEquals(passwordRecoveryPage.getAlertSuccessText(), "A confirmation email has been sent to your address: " + propertiesManager.get("EMAIL"));
    }

    @Test
    public void recoverPasswordWithInvalidEmailTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickSignInButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.openPasswordRecoveryPage();
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);
        passwordRecoveryPage.recoverPasswordWithInvalidEmail();
        Assert.assertEquals(passwordRecoveryPage.getAlertFailedText(), "There is 1 error");

    }
}
