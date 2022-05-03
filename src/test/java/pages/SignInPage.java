package pages;

import com.github.javafaker.Faker;
import models.LoginModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.GenerateFakeMessage;
import utilities.PropertiesManager;

public class SignInPage extends BasePage {

    private By SIGN_IN_EMAIL_INPUT_FIELD = By.id("email");
    private By PASSWORD_INPUT_FIELD = By.id("passwd");
    private By REGISTRATION_EMAIL_INPUT_FIELD = By.id("email_create");
    private By CREATE_ACCOUNT_BUTTON = By.id("SubmitCreate");
    private By SIGN_IN_BUTTON = By.id("SubmitLogin");
    private By FORGOT_PASSWORD_BUTTON = By.cssSelector("[title='Recover your forgotten password']");
    private By HEADER = By.xpath("//div[@id='center_column']/h1");
    private By ACCOUNT_BUTTON = By.cssSelector("[title='View my customer account']");


    public SignInPage(WebDriver driver) {
        super(driver);
    }


    public void logIn(LoginModel loginModel) {

        driver.findElement(SIGN_IN_EMAIL_INPUT_FIELD).sendKeys(loginModel.getLogin());
        driver.findElement(PASSWORD_INPUT_FIELD).sendKeys(loginModel.getPassword());
        driver.findElement(SIGN_IN_BUTTON).click();
    }

    public void openRegistrationPage() {
        driver.findElement(REGISTRATION_EMAIL_INPUT_FIELD).sendKeys(GenerateFakeMessage.getEmail());
        driver.findElement(CREATE_ACCOUNT_BUTTON).click();
    }

    public void openPasswordRecoveryPage() {
        driver.findElement(FORGOT_PASSWORD_BUTTON).click();
    }

    public String checkHeaderText() {
        return driver.findElement(HEADER).getText();
    }

    public boolean isAccountButtonShown() {
        return driver.findElement(ACCOUNT_BUTTON).isDisplayed();
    }


}
