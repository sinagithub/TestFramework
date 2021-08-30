package testautomation.utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;


public class DriverFactory extends WebDriverUtils {

    @Before("@chrome")
    public void startChromeWebdriver() {
        initDriver("chrome");
        maximizeWindow();
    }

    @Before(value = "@firefox")
    public void startFirefoxfWebdriver() {
        initDriver("firefox");
        maximizeWindow();
    }

    @After(order = 1)
    public void takeScreenShot(Scenario scenario) {
        String path = System.getProperty("user.dir");
        if (scenario.isFailed()) {
            File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

            try {
                FileUtils.copyFile(scrFile, new
                        File(path + "/target/" + (scenario.getName()).replace(" ", "") + ".jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @After(order = 0)
    public void killWebDriver() {
        quitDriver();
    }

}



