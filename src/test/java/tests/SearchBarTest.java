package tests;

import io.qameta.allure.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ExactDressPage;
import pages.MainPage;
import staticdata.Dresses;
import utilities.RetryAnalyzer;


@Epic("UI regression tests")
@Feature("Catalogue")
@Story("Searchbar test")
public class SearchBarTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(SearchBarTest.class.getName());

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    @Description("Check if searching of products is possible")
    @Attachment(value = "screenshot", type = "image/png")
    @Severity(SeverityLevel.CRITICAL)
    public void searchBarTest() {
        LOGGER.info("'Search bar' test started");
        LOGGER.debug("Thread id is " + Thread.currentThread().getId() + ", webdriver is " + driverType.toString());
        MainPage mainPage = new MainPage(driver);
        LOGGER.info("Attempting to open main page http://automationpractice.com/index.php");
        mainPage.openMainPage();
        LOGGER.info("Attempting to search exact dress");
        mainPage.searchExactDress();
        ExactDressPage exactDressPage = new ExactDressPage(driver);
        LOGGER.info("Checking if dress was found");
        Assert.assertEquals(exactDressPage.getDressName(), Dresses.FIRST_DRESS, "Error");
    }
}
