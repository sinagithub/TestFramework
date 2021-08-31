package testautomation.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testautomation.utils.Helper;

public class RestaurantPage extends Helper {

    String restaurantNameXpath = "/html/body/div[1]/div/span[2]";
    String favoriteButtonXpath = "/html/body/div[2]/div/div[2]/div/div[2]/div[1]/div/div";

    public RestaurantPage(WebDriver driver){
        super(driver);
    }

    public void assertNavigatedRestaurantPage(String restName){
        String actualString = getText(By.xpath(restaurantNameXpath));
        Assert.assertTrue(actualString.contains(restName));
    }

    public void clickFavoriteButton() throws InterruptedException {
        clickAction(By.xpath(favoriteButtonXpath));

    }

    public String getFavoriteButtonText() {
        return getText(By.xpath(favoriteButtonXpath));
    }

    public void makeRestaurantNoFavorite(){
        if (getText(By.xpath(favoriteButtonXpath)).equals("Favorilerden Çıkar")){
            clickAction(By.xpath(favoriteButtonXpath));
        }


    }
    }

