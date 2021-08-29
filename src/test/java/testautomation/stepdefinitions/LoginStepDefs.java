package testautomation.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testautomation.pages.LoginPage;
import testautomation.utils.WebDriverUtils;
import io.cucumber.java.en.Given;

import java.util.Set;

public class LoginStepDefs {
    LoginPage loginPage;

    String validUser = "sinacan93@gmail.com";
    String validPassword = "Asdam1123..";
    String invalidUser = "invalid@invalid.com";
    String invalidPassword = "invalid123";


    public LoginStepDefs() {

        loginPage = new LoginPage(WebDriverUtils.getDriver());
    }

    @Given("Navigate to login page")
    public void navigateToLoginPage() throws Throwable {
        loginPage.navigateToLoginPage();

    }

    @When("Enter valid UserId and Password")
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

    @When("Enter invalid User and valid Password")
    public void enterInvalidUserAndValidPassword() throws InterruptedException {
        loginPage.inputTextToUserTextBox(invalidUser, true);
        loginPage.inputTextToPasswordTextBox(validPassword,true);
        loginPage.clickLoginButton();
    }

    @When("Enter valid User and invalid Password")
    public void enterValidUserAndInvalidPassword() throws InterruptedException {
        loginPage.inputTextToUserTextBox(validUser, true);
        loginPage.inputTextToPasswordTextBox(invalidPassword,true);
        loginPage.clickLoginButton();
    }

    @Then("Should see login Failed")
    public void shouldSeeLoginFailed() throws Throwable {
        loginPage.assertLoginFailed();
    }
}




