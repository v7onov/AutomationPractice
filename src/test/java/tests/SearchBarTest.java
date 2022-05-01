package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ExactDressPage;
import pages.MainPage;
import staticdata.Dresses;

public class SearchBarTest extends BaseTest {

    @Test
    public void searchBarTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.searchExactDress();
        ExactDressPage exactDressPage = new ExactDressPage(driver);
        Assert.assertEquals(exactDressPage.getDressName(), Dresses.FIRST_DRESS, "Error");
    }

}
