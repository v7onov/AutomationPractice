package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AccountPage extends BasePage {


    private By WELCOME_TEXT = By.xpath("//p[@class='info-account']");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getWelcomeText(){
        return driver.findElement(WELCOME_TEXT).getText();
    }
}
