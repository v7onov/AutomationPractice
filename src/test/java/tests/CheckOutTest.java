package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import testdata.GetNewLoginModel;

public class CheckOutTest extends BaseTest {

    @Test
    public void buyOneDressTest(){
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
        eveningDressesPage.proceedToCheckout();
        SummaryPage summaryPage = new SummaryPage(driver);
        summaryPage.proceedToCheckout();
        AddressPage addressPage = new AddressPage(driver);
        addressPage.proccedToCheckout();
        ShippingPage shippingPage = new ShippingPage(driver);
        shippingPage.proceedToCheckout();
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.payByBankWire();
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        confirmationPage.confirmOrder();
        PaymentCompletePage paymentCompletePage = new PaymentCompletePage(driver);
        Assert.assertEquals(paymentCompletePage.getConfirmationMessage(), "Your order on My Store is complete.", "Error");
    }


}
