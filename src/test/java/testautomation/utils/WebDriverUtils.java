package testautomation.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverUtils {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();  //

    public void initDriver(String browserName) {
        String path = System.getProperty("user.dir");
        String chromeDriverPath = "/src/test/resources/drivers/chromedriver.exe";
        String geckoDriverPath = "/src/test/resources/drivers/geckodriver.exe";
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", path + chromeDriverPath);
            driver.set(new ChromeDriver());
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", path + geckoDriverPath);
            driver.set(new FirefoxDriver());

        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public void closeDriver() {
        driver.get().close();
    }

    public void quitDriver() {
        driver.get().quit();
    }
    public void maximizeWindow() {
        driver.get().manage().window().maximize();
    }


}




