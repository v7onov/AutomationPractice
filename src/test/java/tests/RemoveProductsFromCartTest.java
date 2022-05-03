package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.MainPage;
import pages.SignInPage;
import pages.SummaryPage;
import testdata.GetNewLoginModel;

public class RemoveProductsFromCartTest extends BaseTest {


    @Test
    public void addThreeDressesAndRemoveTwo(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickSignInButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.logIn(GetNewLoginModel.getCredentials());
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickLogo();
        mainPage.addThreeProductsToCart();
        mainPage.openShoppingCart();
        SummaryPage summaryPage = new SummaryPage(driver);
        summaryPage.deleteThirdProduct();
        summaryPage.deleteSecondProduct();
        driverManager.removeTimeout();
        Assert.assertEquals(summaryPage.getNumberOfProductsLeft(), 1, "Something went wrong");
    }
}
