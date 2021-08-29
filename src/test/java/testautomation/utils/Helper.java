package testautomation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.Locator;

import java.sql.DriverManager;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class Helper {
    protected WebDriver driver;
    public static int waitForPresentElement = 5;
    public Helper(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public void clearText(By locator) {
        find(locator).clear();
    }

    public void click(By locator) {
        find(locator).click();
    }

    public void waitForElementExists(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void inputText(By locator, boolean clearText, String inputText) {
        if (clearText) {
            find(locator).clear();
        }
        find(locator).sendKeys(inputText);
    }

    public String getText(By locator) {
        return find(locator).getText();
    }

    public void scrollTo(By locator) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView();", find(locator));

    }


}


