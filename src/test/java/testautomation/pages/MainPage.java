package testautomation.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testautomation.utils.Helper;

public class MainPage extends Helper {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    String myFavoritesXpath = "/html/body/div[3]/div/div[2]/div[1]/div[2]/div/div[1]/ul/li[2]/a";
    String searchTextBoxXpath = "/html/body/header/div/div/div/div[4]/input";
    String searchButtonXpath = "/html/body/header/div/div/div/div[4]/button";


    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public void clickMyFavorites(){
        click(By.xpath(myFavoritesXpath));
    }
    public void enterSearchTextbox(String text, boolean clearText){
        inputText(By.xpath(searchTextBoxXpath),clearText,text);
    }
    public void clickSearchButton(){
        click(By.xpath(searchButtonXpath));
    }














}
