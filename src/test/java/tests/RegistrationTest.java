package tests;

import models.RegistrationModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.MainPage;
import pages.RegistrationPage;
import pages.SignInPage;
import testdata.GetNewRegistrationModel;

public class RegistrationTest extends BaseTest {

    @Test
    public void createNewAccountTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickSignInButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.openRegistrationPage();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.createNewAccount(GetNewRegistrationModel.getRegistrationModelWithAllFields());
        AccountPage accountPage = new AccountPage(driver);
        Assert.assertEquals(accountPage.getWelcomeText(), "Welcome to your account. Here you can manage all of your personal information and orders.", "Account was not created");
    }
}
