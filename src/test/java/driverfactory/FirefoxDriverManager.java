package driverfactory;

import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.PropertiesManager;

public class FirefoxDriverManager extends DriverManager {


    @Override
    public void createDriver(){
        PropertiesManager propertiesManager = new PropertiesManager();
        System.setProperty("webdriver.gecko.driver", propertiesManager.get("PATH_TO_FIREFOX_DRIVER"));
        driver = new FirefoxDriver();
    }
}
