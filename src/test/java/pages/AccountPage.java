package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AccountPage extends BasePage {


    private By WELCOME_TEXT = By.xpath("//p[@class='info-account']");
    private By LOG_OUT_BUTTON = By.cssSelector("[title='Log me out']");
    private By LOGO = By.cssSelector("[title='My Store']");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getWelcomeText(){
        return driver.findElement(WELCOME_TEXT).getText();
    }

    public void performLogout(){
        driver.findElement(LOG_OUT_BUTTON).click();
    }

    public void clickLogo(){
        driver.findElement(LOGO).click();
    }


}
