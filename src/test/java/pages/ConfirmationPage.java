package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage  extends BasePage {

    private By CONFIRM_ORDER_BUTTON = By.xpath("//*[@id='cart_navigation']/button");


    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public void confirmOrder(){
        driver.findElement(CONFIRM_ORDER_BUTTON).click();
    }
}
