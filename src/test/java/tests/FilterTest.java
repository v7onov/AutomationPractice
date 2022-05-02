package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CataloguePage;
import pages.MainPage;

public class FilterTest extends BaseTest {

    @Test
    public void checkFilterTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickCatalogueButton();
        CataloguePage cataloguePage = new CataloguePage(driver);
        driverManager.removeTimeout();
        Assert.assertTrue(cataloguePage.isFilterWork());
    }
}
