package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.MainPage;
import pages.SignInPage;
import testdata.GetNewLoginModel;

public class LogoutTest extends BaseTest {

    @Test
    public void logOutFromAccountPageTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickSignInButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.logIn(GetNewLoginModel.getCredentials());
        AccountPage accountPage = new AccountPage(driver);
        accountPage.performLogout();
        Assert.assertEquals(signInPage.checkHeaderText(), "AUTHENTICATION", "Error");

    }

    @Test
    public void logOutFromMainPageTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickSignInButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.logIn(GetNewLoginModel.getCredentials());
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickLogo();
        mainPage.performLogout();
        Assert.assertTrue(mainPage.isAccountButtonNotShown());
    }


}
