package testautomation.utils;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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
        waitForElementExists(locator);
        find(locator).click();
    }

    public void clickAction(By locator) {
        new Actions(driver).moveToElement(find(locator)).click().perform();
    }

    public void waitForElementExists(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void sendEscape(){
        new Actions(driver).moveToElement(find(By.cssSelector("body"))).sendKeys(Keys.ESCAPE).perform();
    }


    public void inputText(By locator, boolean clearText, String inputText) {
        if (clearText) {
            find(locator).clear();
        }
        find(locator).sendKeys(inputText);
    }

    public void inputTextAction(By locator, String inputText) throws InterruptedException {
        //Thread.sleep(1000);
        new Actions(driver).moveToElement(find(locator)).sendKeys(inputText).perform();
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

    public boolean isDisplayed(By locator){
        try {
            WebElement element = find(locator);
            return element.isDisplayed()  || element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }
    }







