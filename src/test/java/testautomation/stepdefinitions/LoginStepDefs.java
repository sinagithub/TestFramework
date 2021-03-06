package testautomation.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testautomation.pages.LoginPage;
import testautomation.utils.WebDriverUtils;

public class LoginStepDefs {
    LoginPage loginPage;

    String validUser = "sina.test.yemeksepeti@gmail.com";
    String validPassword = "Test1123..";
    String invalidUser = "invalid@invalid.com";
    String invalidPassword = "invalid123";


    public LoginStepDefs() {

        loginPage = new LoginPage(WebDriverUtils.getDriver());
    }

    @Given("Navigate to login page")
    public void navigateToLoginPage() throws Throwable {
        loginPage.navigateToLoginPage();

    }

    @When("Enter valid UserId and Password and click Login")
    public void enterCorrectUserIdAndPassword() throws Throwable {
        loginPage.inputTextToUserTextBox(validUser, true);
        loginPage.inputTextToPasswordTextBox(validPassword,true);
        loginPage.clickLoginButton();
    }

    @Then("Should see login successful")
    public void shouldSeeLoginSuccessful() throws Throwable {
        loginPage.clickYemekSipraisiOnModal();
        loginPage.assertLoginIsSuccess();

    }

    @When("Enter invalid User and valid Password and click Login")
    public void enterInvalidUserAndValidPassword() throws InterruptedException {
        loginPage.inputTextToUserTextBox(invalidUser, true);
        loginPage.inputTextToPasswordTextBox(validPassword,true);
        loginPage.clickLoginButton();
    }

    @When("Logged in Successfully")
    public void loggedInSuccessfully() throws Throwable {
        loginPage.navigateToLoginPage();
        loginPage.navigateToLoginPage();
        loginPage.inputTextToUserTextBox(validUser, true);
        loginPage.inputTextToPasswordTextBox(validPassword,true);
        loginPage.clickLoginButton();
        loginPage.clickYemekSipraisiOnModal();
        loginPage.assertLoginIsSuccess();
    }

    @When("Enter valid User and invalid Password and click Login")
    public void enterValidUserAndInvalidPassword() throws InterruptedException {
        loginPage.inputTextToUserTextBox(validUser, true);
        loginPage.inputTextToPasswordTextBox(invalidPassword,true);
        loginPage.clickLoginButton();
    }

    @Then("Should see login Failed")
    public void shouldSeeLoginFailed() throws Throwable {
        loginPage.assertLoginFailed();
    }

    @When("Click Log out button")
    public void clickLogOutButton() throws Throwable {
        loginPage.dropUserInfoList();
        loginPage.clickLogOutButton();

    }
    @Then("Should see browser not allowed to forward and session closed")
    public void shouldSeeBrowserNotAllowedToForwardAndSessionClosed() throws Throwable {
        loginPage.assertUserLoggedOut();
        loginPage.navigateForward();
        loginPage.assertUserLoggedOut();
    }


}




