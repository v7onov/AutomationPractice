package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class EveningDressesPage extends BasePage {


    private By PRINTED_DRESS = By.xpath("//*[@title='Printed Dress' and @class='product-name']");
    private By ADD_DRESS_TO_CART_BUTTON = By.xpath("//*[@data-id-product='4']/span");
    private By CONFIRMATION_HEADER = By.xpath("(//h2)[1]");


    public EveningDressesPage(WebDriver driver) {
        super(driver);
    }


    public void selectPrintedDress() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(PRINTED_DRESS));
        action.perform();
        driver.findElement(ADD_DRESS_TO_CART_BUTTON).click();
    }

    public String getConfirmationText() {
        return driver.findElement(CONFIRMATION_HEADER).getAttribute("innerText");
    }

}
