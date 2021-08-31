package testautomation.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import testautomation.pages.MainPage;
import testautomation.pages.RestaurantPage;
import testautomation.pages.SearchResultsPage;
import testautomation.utils.WebDriverUtils;

public class FavoriteRestaurantStepDefs {
    MainPage mainPage;
    SearchResultsPage searchResultsPage;
    RestaurantPage restaurantPage;

    String restaurantNameForSearch = "Ayvalık Ekspress";


    public FavoriteRestaurantStepDefs() {
        mainPage = new MainPage(WebDriverUtils.getDriver());
        searchResultsPage = new SearchResultsPage(WebDriverUtils.getDriver());
        restaurantPage = new RestaurantPage(WebDriverUtils.getDriver());
    }

    @When("Click My Favorites Tab")
    public void enterCorrectUserIdAndPassword() throws Throwable {
        mainPage.clickMyFavorites();
    }

    @And("Search for non-favorite restaurant and go to restaurants page")
    public void searchForNonFavoriteRestaurant() throws Throwable {
        mainPage.selectDistrict();
        mainPage.enterSearchTextbox(restaurantNameForSearch);
        mainPage.clickSearchButton();
        searchResultsPage.clickSearchedRestaurant(restaurantNameForSearch);
        mainPage.ignoreBanaBiPopUp();
        restaurantPage.assertNavigatedRestaurantPage(restaurantNameForSearch);
        restaurantPage.makeRestaurantNoFavorite();
    }

    @And("Search for TEST restaurant and go to restaurants page")
    public void searchFortestRestaurant() throws Throwable {
        mainPage.selectDistrict();
        mainPage.enterSearchTextbox(restaurantNameForSearch);
        mainPage.clickSearchButton();
        searchResultsPage.clickSearchedRestaurant(restaurantNameForSearch);
        mainPage.ignoreBanaBiPopUp();
        restaurantPage.assertNavigatedRestaurantPage(restaurantNameForSearch);
    }

    @And("Should see favorite button text is {string}")
    public void shouldSeeFavoriteButtonTextIs(String btnText) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(btnText, restaurantPage.getFavoriteButtonText());
    }

    @When("Go to main page and click favorites tab")
    public void goToMainPageAndClickFavoritesTab() {
        mainPage.goToMainPage();
        mainPage.clickMyFavorites();
    }

    @Then("Should see restaurant LISTED in favorites")
    public void shouldSeeRestaurantListedInFavorites() {
        mainPage.assertFavoriteRestaurantAdded(restaurantNameForSearch);
    }

    @And("Click favorite restaurant from favorites tab")
    public void clickFavoriteRestaurantFromFavoritesTab() {
        mainPage.goToFavoriteRestaurant(restaurantNameForSearch);
    }

    @Then("Should see restaurant reachable from Favorites")
    public void shouldSeeRestaurantReachableFromFavorites() {
        restaurantPage.assertNavigatedRestaurantPage(restaurantNameForSearch);
    }

    @Then("Should see restaurant NOT listed in favorites")
    public void shouldSeeRestaurantNOTListedInFavorites() {
        mainPage.assertFavoriteRestaurantNotListed(restaurantNameForSearch);

    }

    @And("Click 'Favorite' button in restaurant page")
    public void clickRemoveFavoriteButtonInRestaurantPage() throws InterruptedException {
        restaurantPage.clickFavoriteButton();
    }

    @Given("Search test restaurant and make it non-favorite")
    public void searchTestRestaurantAndMakeItNonFavorite() throws InterruptedException {
        mainPage.selectDistrict();
        mainPage.enterSearchTextbox(restaurantNameForSearch);
        mainPage.clickSearchButton();
        searchResultsPage.clickSearchedRestaurant(restaurantNameForSearch);
        mainPage.ignoreBanaBiPopUp();
        restaurantPage.assertNavigatedRestaurantPage(restaurantNameForSearch);
        restaurantPage.makeRestaurantNoFavorite();
        mainPage.goToMainPage();
        mainPage.assertFavoriteRestaurantNotListed(restaurantNameForSearch);

    }
}




