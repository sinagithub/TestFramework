package testautomation.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebDriverUtils {
    public static WebDriver driver = null;
    public static RemoteWebDriver remoteWebDriver = null;


    public WebDriverUtils() {
    }

    public static WebDriver getDriver(String browserName){
        String projectPath = System.getProperty("user.dir");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "/src/test/resources/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public static WebDriver initBrowser(String browserName,String appUrl) {
        getDriver(browserName);
        driver.manage().window().maximize();
        driver.get(appUrl);
        return driver;
    }

    public static void quitBrowser() {
        driver.close();
    }

        public void getRemoteDriver() throws MalformedURLException {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setBrowserName("chrome");
            cap.setPlatform(Platform.WINDOWS);
            ChromeOptions op = new ChromeOptions();
            op.setHeadless(true);
            op.merge(cap);
            String huburl = "http://localhost:4444/wd/hub";
            driver = new RemoteWebDriver(new URL(huburl), op);

            //Selenium grid kullanımı için.
            //jar ın bulundugu klasörde çalışacak local chrome versiyonuna uygun chromedriver bulunmalı.
            //Ayrı terminallerden hub oluşturulması ve node registiration
            //java -jar selenium-server-standalone-3.141.59.jar -role hub
            //java -jar selenium-server-standalone-3.141.59.jar -role node -hub "http://localhost:4444/grid/register/"

        }


    }

