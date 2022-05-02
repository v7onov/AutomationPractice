package tests;

import driverfactory.DriverFactory;
import driverfactory.DriverManager;
import driverfactory.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class BaseTest {

    WebDriver driver;
    DriverManager driverManager;
    DriverType driverType;

    @BeforeSuite
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
        DriverFactory factory = new DriverFactory();
        driverType = null;
        if(browser.equals("chrome")) {
            driverType = DriverType.CHROME;
        }
        if(browser.equals("remote")) {
            driverType = DriverType.REMOTE;
        }
        driverManager = factory.getManager(driverType);
        driverManager.createDriver();
        driver = driverManager.getDriver();
        driverManager.maximize();
        driverManager.setTimeout();
        System.getProperty("configuration");
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driverManager.quitDriver();
    }

    public void setTimeout(){

    }
}
