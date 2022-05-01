package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import staticdata.Dresses;
import staticdata.WebTimeouts;
import staticdata.WebUrls;

import java.util.concurrent.TimeUnit;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private By SIGN_IN_BUTTON = By.cssSelector("[title='Log in to your customer account']");
    private By LOG_OUT_BUTTON = By.cssSelector("[title='Log me out']");
    private By ACCOUNT_BUTTON = By.cssSelector("[title='View my customer account']");
    private By DRESSES_BUTTON = By.xpath("(//*[@title='Dresses'])[2]");
    private By EVENING_DRESSES_BUTTON = By.xpath("(//*[text()='Evening Dresses'])[2]");
    private By DRESS_OPTION = By.xpath("//*[@class='ac_results']/ul/li/*[contains(text(), '"+ Dresses.FIRST_DRESS + "')]");
    private By SEARCH_BAR = By.id("search_query_top");
    private By FEEDBACK_BUTTON = By.id("contact-link");



    public void openMainPage() {
        driver.get(WebUrls.MAIN_PAGE);
    }

    public void clickSignInButton() {
        driver.findElement(SIGN_IN_BUTTON).click();
    }

    public void performLogout() {
        driver.findElement(LOG_OUT_BUTTON).click();
    }

    public boolean isAccountButtonNotShown() {
        boolean notExist;
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            notExist = driver.findElements(ACCOUNT_BUTTON).size() < 1;
        } finally {
            driver.manage().timeouts().implicitlyWait(WebTimeouts.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        }
        return notExist;
    }

    public void selectEveningDresses(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(DRESSES_BUTTON));
        action.perform();
        driver.findElement(EVENING_DRESSES_BUTTON).click();
    }

    public void searchExactDress(){
        driver.findElement(SEARCH_BAR).sendKeys(Dresses.FIRST_DRESS);
        driver.findElement(DRESS_OPTION).click();
    }

    public void clickFeedbackButton(){
        driver.findElement(FEEDBACK_BUTTON).click();
    }
}
