package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaryPage extends BasePage {

    private By CHECKOUT_BUTTON = By.xpath("//*[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']");
    private By DELETE_SECOND_PRODUCT_BUTTON = By.xpath("(//*[@class='cart_quantity_delete'])[2]");
    private By DELETE_THIRD_PRODUCT_BUTTON = By.xpath("(//*[@class='cart_quantity_delete'])[3]");
    private By CART_DESCRIPTION = By.xpath("//*[@class='cart_description']");

    public SummaryPage(WebDriver driver) {
        super(driver);
    }

    public void proceedToCheckout(){
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public void deleteThirdProduct(){
        driver.findElement(DELETE_THIRD_PRODUCT_BUTTON).click();
    }

    public void deleteSecondProduct(){
        driver.findElement(DELETE_SECOND_PRODUCT_BUTTON).click();
    }

    public int getNumberOfProductsLeft(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(DELETE_SECOND_PRODUCT_BUTTON));
        return (driver.findElements(CART_DESCRIPTION).size());
    }
}
