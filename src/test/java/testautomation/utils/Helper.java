package testautomation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


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

    public void navigateForward() {
        driver.navigate().forward();
    }

    public void navigateBack() {
        driver.navigate().back();
    }


}


