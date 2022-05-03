package pages;

import models.RegistrationModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class RegistrationPage extends BasePage {


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    private By MALE_GENDER = By.id("id_gender1");
    private By FEMALE_GENDER = By.id("id_gender2");
    private By CUSTOMER_FIRST_NAME = By.id("customer_firstname");
    private By CUSTOMER_LAST_NAME = By.id("customer_lastname");
    private By EMAIL = By.id("email");
    private By PASSWORD = By.id("passwd");
    private By BIRTH_DAY = By.id("days");
    private By BIRTH_MONTH = By.id("months");
    private By BIRTH_YEAR = By.id("years");
    private By FIRST_NAME = By.id("firstname");
    private By LAST_NAME = By.id("lastname");
    private By COMPANY_NAME = By.id("company");
    private By ADDRESS = By.id("address1");
    private By CITY = By.id("city");
    private By STATE = By.id("id_state");
    private By ZIP_CODE = By.id("postcode");
    private By COUNTRY = By.id("id_country");
    private By PHONE_NUMBER = By.id("phone_mobile");
    private By ADDRESS_ALIAS = By.id("alias");
    private By REGISTER_BUTTON = By.id("submitAccount");


    public void createNewAccount(RegistrationModel registrationModel) {
        driver.findElement(MALE_GENDER).click();
        driver.findElement(CUSTOMER_FIRST_NAME).sendKeys(registrationModel.getFirstName());
        driver.findElement(CUSTOMER_LAST_NAME).sendKeys(registrationModel.getLastName());
        driver.findElement(PASSWORD).sendKeys(registrationModel.getPassword());

        Select selectDay = new Select(driver.findElement(BIRTH_DAY));
        selectDay.selectByIndex(5);

        Select selectMonth = new Select(driver.findElement(BIRTH_MONTH));
        selectMonth.selectByIndex(8);

        Select selectYear = new Select(driver.findElement(BIRTH_YEAR));
        selectYear.selectByValue("1990");

        driver.findElement(FIRST_NAME).sendKeys(registrationModel.getFirstName());
        driver.findElement(LAST_NAME).sendKeys(registrationModel.getLastName());
        driver.findElement(COMPANY_NAME).sendKeys(registrationModel.getCompanyName());
        driver.findElement(ADDRESS).sendKeys(registrationModel.getAddress());
        driver.findElement(CITY).sendKeys(registrationModel.getCity());


        Select selectState = new Select(driver.findElement(STATE));
        selectState.selectByIndex(7);

        driver.findElement(ZIP_CODE).sendKeys(registrationModel.getZipCode());

        Select selectCountry = new Select(driver.findElement(STATE));
        selectCountry.selectByIndex(9);

        driver.findElement(PHONE_NUMBER).sendKeys(registrationModel.getPhoneNumber());


        driver.findElement(REGISTER_BUTTON).click();


    }
}
