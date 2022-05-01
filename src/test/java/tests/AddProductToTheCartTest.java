package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.EveningDressesPage;
import pages.MainPage;
import pages.SignInPage;

public class AddProductToTheCartTest extends BaseTest {

    @Test
    public void addProductTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickSignInButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.inputLogin();
        signInPage.passwordInput();
        signInPage.clickSignInButton();
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickLogo();
        mainPage.selectEveningDresses();
        EveningDressesPage eveningDressesPage = new EveningDressesPage(driver);
        eveningDressesPage.selectPrintedDress();
        Assert.assertEquals(eveningDressesPage.getConfirmationText(), "\n\t\t\t\t\tProduct successfully added to your shopping cart\n\t\t\t\t");
    }

}
