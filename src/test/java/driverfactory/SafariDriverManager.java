package driverfactory;

import org.openqa.selenium.safari.SafariDriver;
import utilities.PropertiesManager;

public class SafariDriverManager extends DriverManager {


    @Override
    public void createDriver(){
        PropertiesManager propertiesManager = new PropertiesManager();
        System.setProperty("webdriver.safari.driver", propertiesManager.get("PATH_TO_SAFARI_DRIVER"));
        driver = new SafariDriver();
    }
}
