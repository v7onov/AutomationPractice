package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class ExactDressPage extends BasePage {


    private By DRESS_NAME = By.xpath("//*[@itemprop='name']");


    public ExactDressPage(WebDriver driver) {
        super(driver);
    }


    public String getDressName(){
        return driver.findElement(DRESS_NAME).getText();
    }

}
