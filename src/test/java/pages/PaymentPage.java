package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {

    private By PAY_BY_BANK_WIRE_BUTTON = By.cssSelector("[title='Pay by bank wire']");


    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void payByBankWire(){
        driver.findElement(PAY_BY_BANK_WIRE_BUTTON).click();
    }
}
