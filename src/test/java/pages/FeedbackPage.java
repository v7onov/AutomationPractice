package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.GenerateFakeMessage;

public class FeedbackPage extends BasePage {

    private By SUBJECT_HEADING_OPTION = By.id("id_contact");
    private By EMAIL_FIELD = By.id("email");
    private By ORDER_REFERENCE_FIELD = By.id("id_order");
    private By MESSAGE_FIELD = By.id("message");
    private By SUBMIT_BUTTON = By.id("submitMessage");
    private By MESSAGE_SENT_ALERT = By.cssSelector("[class='alert alert-success']");

    public FeedbackPage(WebDriver driver) {
        super(driver);
    }

    public void sendMessage(){
        Select select = new Select(driver.findElement(SUBJECT_HEADING_OPTION));
        select.selectByVisibleText("Customer service");
        driver.findElement(EMAIL_FIELD).sendKeys(GenerateFakeMessage.getEmail());
        driver.findElement(ORDER_REFERENCE_FIELD).sendKeys(GenerateFakeMessage.getZipCode());
        driver.findElement(MESSAGE_FIELD).sendKeys(GenerateFakeMessage.getComment());
        driver.findElement(SUBMIT_BUTTON).click();
    }

    public String getAlertText(){
        return driver.findElement(MESSAGE_SENT_ALERT).getText();
    }


}
