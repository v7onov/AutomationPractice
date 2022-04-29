package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private By SIGN_IN_BUTTON = By.cssSelector("[title='Log in to your customer account']");


    public void openMainPage(){
        driver.get("https://automationpractice.com/index.php/");
    }

    public void clickSignInButton(){
        driver.findElement(SIGN_IN_BUTTON).click();
    }


}
