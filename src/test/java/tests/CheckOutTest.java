package tests;

import io.qameta.allure.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import testdata.GetNewLoginModel;
import utilities.RetryAnalyzer;


@Epic("UI regression tests")
@Feature("Cart")
@Story("Make order test")
public class CheckOutTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(CheckOutTest.class.getName());

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    @Description("Check if purchase performing is possible")
    @Attachment(value = "screenshot", type = "image/png")
    @Severity(SeverityLevel.CRITICAL)
    public void buyOneDressTest() {
        LOGGER.info("'Make order' test started");
        LOGGER.debug("Thread id is " + Thread.currentThread().getId() + ", webdriver is " + driverType.toString());
        MainPage mainPage = new MainPage(driver);
        LOGGER.info("Attempting to open main page http://automationpractice.com/index.php");
        mainPage.openMainPage();
        LOGGER.info("Attempting to sign in");
        mainPage.clickSignInButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.logIn(GetNewLoginModel.getCredentials());
        AccountPage accountPage = new AccountPage(driver);
        LOGGER.info("Move to 'Evening dresses' page");
        accountPage.clickLogo();
        mainPage.selectEveningDresses();
        EveningDressesPage eveningDressesPage = new EveningDressesPage(driver);
        LOGGER.info("Attempting to add a dress to the cart");
        eveningDressesPage.selectPrintedDress();
        LOGGER.info("Attempting to proceed to checkout");
        eveningDressesPage.proceedToCheckout();
        SummaryPage summaryPage = new SummaryPage(driver);
        summaryPage.proceedToCheckout();
        LOGGER.info("Attempting to proceed to delivery address page");
        AddressPage addressPage = new AddressPage(driver);
        addressPage.proccedToCheckout();
        LOGGER.info("Attempting to proceed to shipping page");
        ShippingPage shippingPage = new ShippingPage(driver);
        LOGGER.info("Attempting to proceed to payment page");
        shippingPage.proceedToCheckout();
        PaymentPage paymentPage = new PaymentPage(driver);
        LOGGER.info("Attempting to commit a payment");
        paymentPage.payByBankWire();
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        LOGGER.info("Attempting to confirm order");
        confirmationPage.confirmOrder();
        PaymentCompletePage paymentCompletePage = new PaymentCompletePage(driver);
        Assert.assertEquals(paymentCompletePage.getConfirmationMessage(), "Your order on My Store is complete.", "Error");
    }
}
