package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentCompletePage extends BasePage {

    private By CONFIRMATION_MESSAGE = By.xpath("//*[@id='center_column']/div/p");

    public PaymentCompletePage(WebDriver driver) {
        super(driver);
    }

    public String getConfirmationMessage(){
        return driver.findElement(CONFIRMATION_MESSAGE).getText();
    }
}
