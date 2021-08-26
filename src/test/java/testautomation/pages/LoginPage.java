package testautomation.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import static java.lang.Thread.sleep;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "UserName")
    WebElement userName;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "ys-fastlogin-button")
    WebElement loginButton;

    public void navigateTo(String url){
        driver.get(url);
    }

    public void enterUserId(String user, boolean clearText) {
        userName.click();
        if (clearText) {
            userName.clear();
        }
        userName.sendKeys("user");
    }

    public void enterPassword(String pass, boolean clearText) {
        password.click();
        if (clearText) {
            password.clear();
        }
        password.sendKeys("pass");
        password.sendKeys(pass);

    }

    public void clickLoginButton(long time) throws InterruptedException {
        Thread.sleep(time);
        loginButton.click();
    }

    public void assertLoginIsSuccess(){

    }



}
