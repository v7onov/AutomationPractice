package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import staticdata.Emails;
import utilities.GenerateFakeMessage;

public class PasswordRecoveryPage extends BasePage {

    private By EMAIL_INPUT_FIELD = By.id("email");
    private By RETRIEVE_PASSWORD_BUTTON = By.xpath("//button/span[text()='Retrieve Password']");
    private By ALERT_SUCCESS = By.xpath("//p[@class='alert alert-success']");
    private By ALERT_DANGER = By.xpath("//div[@class='alert alert-danger']/p");


    public PasswordRecoveryPage(WebDriver driver) {
        super(driver);
    }

    public void recoverPassword(){
        driver.findElement(EMAIL_INPUT_FIELD).sendKeys(Emails.VALID_EMAIL);
        driver.findElement(RETRIEVE_PASSWORD_BUTTON).click();
    }

    public void recoverPasswordWithInvalidEmail(){
        driver.findElement(EMAIL_INPUT_FIELD).sendKeys(GenerateFakeMessage.getEmail());
        driver.findElement(RETRIEVE_PASSWORD_BUTTON).click();
    }

    public String getAlertSuccessText(){
        return driver.findElement(ALERT_SUCCESS).getText();
    }

    public String getAlertFailedText(){
        return driver.findElement(ALERT_DANGER).getText();
    }


}
