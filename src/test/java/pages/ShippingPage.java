package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage extends BasePage {


    private By TERMS_CHECKBOX = By.id("cgv");
    private By PROCEED_TO_CHECKOUT_BUTTON = By.name("processCarrier");


    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    public void proceedToCheckout(){
        driver.findElement(TERMS_CHECKBOX).click();
        driver.findElement(PROCEED_TO_CHECKOUT_BUTTON).click();
    }
}
