package tests;

import io.qameta.allure.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.EveningDressesPage;
import pages.MainPage;
import pages.SignInPage;
import testdata.GetNewLoginModel;
import utilities.RetryAnalyzer;


@Epic("UI regression tests")
@Feature("Cart")
@Story("Add one product to the cart test")
public class AddProductToTheCartTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(AddProductToTheCartTest.class.getName());

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    @Description("Check if adding of a product to the cart is possible")
    @Attachment(value = "screenshot", type = "image/png")
    @Severity(SeverityLevel.CRITICAL)
    public void addProductTest() {
        LOGGER.info("'Add one product to the cart' test started");
        LOGGER.debug("Thread id is " + Thread.currentThread().getId() + ", webdriver is " + driverType.toString());
        MainPage mainPage = new MainPage(driver);
        LOGGER.info("Attempting to open main page http://automationpractice.com/index.php");
        mainPage.openMainPage();
        LOGGER.info("Attempting to sign in");
        mainPage.clickSignInButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.logIn(GetNewLoginModel.getCredentials());
        AccountPage accountPage = new AccountPage(driver);
        LOGGER.info("Return to main page");
        accountPage.clickLogo();
        LOGGER.info("Move to 'Evening dresses' page");
        mainPage.selectEveningDresses();
        EveningDressesPage eveningDressesPage = new EveningDressesPage(driver);
        LOGGER.info("Attempting to add a dress to the cart");
        eveningDressesPage.selectPrintedDress();
        Assert.assertEquals(eveningDressesPage.getConfirmationText(), "\n\t\t\t\t\tProduct successfully added to your shopping cart\n\t\t\t\t");
    }
}
