package tests;

import io.qameta.allure.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CataloguePage;
import pages.MainPage;
import utilities.RetryAnalyzer;


@Epic("UI regression tests")
@Feature("Catalogue")
@Story("Product filter test")
public class FilterTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(FilterTest.class.getName());

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    @Description("Check if filtering of products is possible")
    @Attachment(value = "screenshot", type = "image/png")
    @Severity(SeverityLevel.NORMAL)
    public void checkFilterTest() {
        LOGGER.info("'Product filter' test started");
        LOGGER.debug("Thread id is " + Thread.currentThread().getId() + ", webdriver is " + driverType.toString());
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickCatalogueButton();
        CataloguePage cataloguePage = new CataloguePage(driver);
        driverManager.removeTimeout();
        Assert.assertTrue(cataloguePage.isFilterWork());
    }
}
