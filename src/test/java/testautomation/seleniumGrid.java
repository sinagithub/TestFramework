package testautomation;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class seleniumGrid {
WebDriver driver;

public seleniumGrid(){

}
    public WebDriver webdriver() throws MalformedURLException {
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setBrowserName("chrome");
        cap.setPlatform(Platform.WINDOWS);
        ChromeOptions op = new ChromeOptions();
        op.setHeadless(true);
        op.merge(cap);
        String huburl ="http://localhost:4444/wd/hub";
        driver=new RemoteWebDriver(new URL(huburl), op);
    return driver;
    }


}

