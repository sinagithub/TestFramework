package testautomation.pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testautomation.utils.Helper;

public class MainPage extends Helper {

   String myFavoritesXpath = "/html/body/div[2]/div/div[2]/div[1]/div[2]/div/div[1]/ul/li[2]/a";
    String searchTextBoxXpath = "/html/body/header/div/div/div/div[4]";
    String searchButtonXpath = "/html/body/header/div/div/div/div[5]/button";
    String banaBiPopUpCloseButtonXpath = "/html/body/div[4]/div[2]/a[1]";
    String favoriteRestInListXpath1 = "/html/body/div[2]/div/div[2]/div[1]/div[2]/div/div[2]/div[2]/div[contains(.,'";
    String favoriteRestInListXpath2 = "')]/a";
    String toMainPageLogoClassName = "logo2";


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public void clickMyFavorites() {
        waitForElementExists(By.xpath(myFavoritesXpath));
        click(By.xpath(myFavoritesXpath));
    }

    public void enterSearchTextbox(String text) throws InterruptedException {
        waitForElementExists(By.xpath(searchTextBoxXpath));
        inputTextAction(By.xpath(searchTextBoxXpath), text);
    }

    public void clickSearchButton() {
        click(By.xpath(searchButtonXpath));
    }

    public void selectDistrict() {
        click(By.xpath("/html/body/header/div/div/div/div[2]/span/span[1]/span/span[1]"));
        click(By.xpath("/html/body/header/div/div/div/div[2]/div/span/span/span[2]/ul/li[1]/ul/li[1]"));

    }

    public void ignoreBanaBiPopUp() throws InterruptedException {
        waitForElementExists(By.xpath(banaBiPopUpCloseButtonXpath));
        clickAction(By.xpath(banaBiPopUpCloseButtonXpath));
    }
    public void goToMainPage(){
        click(By.className(toMainPageLogoClassName));
    }



    public void goToFavoriteRestaurant(String restName){
        click(By.xpath(favoriteRestInListXpath1
                +restName +favoriteRestInListXpath2));

    }

    public void assertFavoriteRestaurantAdded(String restName){
        String actualString = find(By.xpath(favoriteRestInListXpath1
                +restName +favoriteRestInListXpath2)).getText();
        Assert.assertTrue(actualString.contains(restName));
    }

    public void assertFavoriteRestaurantNotListed(String restName){

        Assert.assertFalse(isDisplayed(By.xpath(favoriteRestInListXpath1 + favoriteRestInListXpath2)));




    }




}
