package testautomation.utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverFactory extends WebDriverUtils {

    @Before("@chrome")
    public void startChromeWebdriver() {
        initDriver("chrome");
        maximizeWindow();
    }

    @Before("@firefox")
    public void startFirefoxfWebdriver() {
        initDriver("firefox");
        maximizeWindow();
    }

    @After
    public void killChromeWebDriver() {
        closeDriver();
        quitDriver();
    }
}



