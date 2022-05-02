package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CataloguePage extends BasePage {

    private By PRODUCT_ITEM = By.xpath("//*[@class='product_list grid row']//*[@class='product-name']");
    private By DRESSES_CHECKBOX = By.id("layered_category_8");
    private By S_SIZE_SCHECKBOX = By.id("layered_id_attribute_group_1");
    private By ORANGE_COLOR_CHECKBOX = By.id("layered_id_attribute_group_13");
    private By COTTON_CHECKBOX = By.id("layered_id_feature_5");
    private By LOADING_GIF = By.xpath("//*[@class='product_list grid row']/p");



    public CataloguePage(WebDriver driver) {
        super(driver);
    }

    public boolean isFilterWork(){
        int overallProductQuantity = driver.findElements(PRODUCT_ITEM).size();
        driver.findElement(DRESSES_CHECKBOX).click();
        driver.findElement(S_SIZE_SCHECKBOX).click();
        driver.findElement(ORANGE_COLOR_CHECKBOX).click();
        driver.findElement(COTTON_CHECKBOX).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(LOADING_GIF));
        return (driver.findElements(PRODUCT_ITEM).size() < overallProductQuantity);
    }


}
