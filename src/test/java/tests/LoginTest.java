package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.MainPage;
import pages.SignInPage;

public class LoginTest extends BaseTest {


    @Test
    public void LoginTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickSignInButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.inputLogin();
        signInPage.passwordInput();
        signInPage.clickSignInButton();
        AccountPage accountPage = new AccountPage(driver);
        Assert.assertEquals(accountPage.getWelcomeText(), "Welcome to your account. Here you can manage all of your personal information and orders.", "ERROR");
    }


}
