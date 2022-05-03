package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.MainPage;
import pages.SignInPage;
import testdata.GetNewLoginModel;

public class LoginTest extends BaseTest {


    @Test
    public void logInTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickSignInButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.logIn(GetNewLoginModel.getCredentials());
        AccountPage accountPage = new AccountPage(driver);
        Assert.assertEquals(accountPage.getWelcomeText(), "Welcome to your account. Here you can manage all of your personal information and orders.", "ERROR");
    }


}
