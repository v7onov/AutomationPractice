package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SummaryPage extends BasePage {

    private By CHECKOUT_BUTTON = By.xpath("//*[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']");

    public SummaryPage(WebDriver driver) {
        super(driver);
    }

    public void proceedToCheckout(){
        driver.findElement(CHECKOUT_BUTTON).click();
    }
}
