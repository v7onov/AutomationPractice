package tests;

import driverfactory.DriverFactory;
import driverfactory.DriverManager;
import driverfactory.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilities.TestListeners;

import java.net.MalformedURLException;

@Listeners(TestListeners.class)
public class BaseTest {

    WebDriver driver;
    DriverManager driverManager;
    DriverType driverType;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
        DriverFactory factory = new DriverFactory();
        driverType = null;
        if (browser.equals("chrome")) {
            driverType = DriverType.CHROME;
        }
        if (browser.equals("remote")) {
            driverType = DriverType.REMOTE;
        }
        if (browser.equals("safari")) {
            driverType = DriverType.SAFARI;
        }
        if (browser.equals("firefox")) {
            driverType = DriverType.FIREFOX;
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

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driverManager.quitDriver();
    }

    public void setTimeout() {
    }
}
