package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import staticdata.WebTimeouts;

import java.util.concurrent.TimeUnit;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private By SIGN_IN_BUTTON = By.cssSelector("[title='Log in to your customer account']");
    private By LOG_OUT_BUTTON = By.cssSelector("[title='Log me out']");
    private By ACCOUNT_BUTTON = By.cssSelector("[title='View my customer account']");


    public void openMainPage() {
        driver.get("https://automationpractice.com/index.php/");
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
}
