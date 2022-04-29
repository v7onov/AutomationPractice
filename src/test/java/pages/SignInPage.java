package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage {

    private By SIGN_IN_EMAIL_INPUT_FIELD = By.id("email");
    private By PASSWORD_INPUT_FIELD = By.id("passwd");
    private By REGISTRATION_EMAIL_INPUT_FIELD = By.id("email_create");
    private By CREATE_ACCOUNT_BUTTON = By.id("SubmitCreate");
    private By SIGN_IN_BUTTON = By.id("SubmitLogin");




    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void inputLogin(){
        driver.findElement(SIGN_IN_EMAIL_INPUT_FIELD).sendKeys("testqa2022@mailinator.com");
    }

    public void passwordInput(){
        driver.findElement(PASSWORD_INPUT_FIELD).sendKeys("over9000");
    }

    public void clickSignInButton(){
        driver.findElement(SIGN_IN_BUTTON).click();
    }

}
