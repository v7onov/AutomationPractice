package tests;

import io.qameta.allure.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.MainPage;
import pages.SignInPage;
import pages.SummaryPage;
import testdata.GetNewLoginModel;
import utilities.RetryAnalyzer;


@Epic("UI regression tests")
@Feature("Cart")
@Story("Remove products from cart test")
public class RemoveProductsFromCartTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(RemoveProductsFromCartTest.class.getName());

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    @Description("Check if removing of products from the cart is possible")
    @Attachment(value = "screenshot", type = "image/png")
    @Severity(SeverityLevel.NORMAL)
    public void addThreeDressesAndRemoveTwo() {
        LOGGER.info("'Remove products from cart' test started");
        LOGGER.debug("Thread id is " + Thread.currentThread().getId() + ", webdriver is " + driverType.toString());
        MainPage mainPage = new MainPage(driver);
        LOGGER.info("Attempting to open main page http://automationpractice.com/index.php");
        mainPage.openMainPage();
        LOGGER.info("Attempting to sign in");
        mainPage.clickSignInButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.logIn(GetNewLoginModel.getCredentials());
        AccountPage accountPage = new AccountPage(driver);
        LOGGER.info("Moving to main page");
        accountPage.clickLogo();
        LOGGER.info("Attempting to add three products to the cart");
        mainPage.addThreeProductsToCart();
        LOGGER.info("Moving to the cart page");
        mainPage.openShoppingCart();
        SummaryPage summaryPage = new SummaryPage(driver);
        LOGGER.info("Attempting to remove two of three products from the cart");
        summaryPage.deleteThirdProduct();
        summaryPage.deleteSecondProduct();
        driverManager.removeTimeout();
        LOGGER.info("Checking number of products remained");
        Assert.assertEquals(summaryPage.getNumberOfProductsLeft(), 1, "Something went wrong");
    }
}
