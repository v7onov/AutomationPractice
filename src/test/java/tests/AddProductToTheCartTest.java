package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.EveningDressesPage;
import pages.MainPage;
import pages.SignInPage;
import testdata.GetNewLoginModel;


@Epic("UI regression tests")
@Feature("Cart")
@Story("Add one product to the cart test")
public class AddProductToTheCartTest extends BaseTest {


    @Test
    @Description("Check if adding of a product to the cart is possible")
    @Attachment(value = "screenshot", type = "image/png")
    @Severity(SeverityLevel.CRITICAL)
    public void addProductTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickSignInButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.logIn(GetNewLoginModel.getCredentials());
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickLogo();
        mainPage.selectEveningDresses();
        EveningDressesPage eveningDressesPage = new EveningDressesPage(driver);
        eveningDressesPage.selectPrintedDress();
        Assert.assertEquals(eveningDressesPage.getConfirmationText(), "\n\t\t\t\t\tProduct successfully added to your shopping cart\n\t\t\t\t");
    }

}
