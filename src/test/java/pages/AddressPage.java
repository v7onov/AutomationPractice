package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.GenerateFakeMessage;

public class AddressPage extends BasePage {

    private By COMMENT_FIELD = By.name("message");
    private By PROCEED_TO_CHECKOUT_BUTTON = By.name("processAddress");

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    public void proccedToCheckout(){
        driver.findElement(COMMENT_FIELD).sendKeys(GenerateFakeMessage.getComment());
        driver.findElement(PROCEED_TO_CHECKOUT_BUTTON).click();
    }
}
