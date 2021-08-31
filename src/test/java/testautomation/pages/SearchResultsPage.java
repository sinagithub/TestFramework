package testautomation.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testautomation.utils.Helper;

public class SearchResultsPage extends Helper {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public void clickSearchedRestaurant(String val) throws InterruptedException {
        val = "/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div[contains(.,'" + val + "')]/div[2]/div[1]/div[2]/a";
        waitForElementExists(By.xpath(val));
        clickAction(By.xpath(val));
    }














}
