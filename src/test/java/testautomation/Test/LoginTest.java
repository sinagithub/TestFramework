package testautomation.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testautomation.pages.LoginPage;
import testautomation.utils.WebDriverUtils;

public class LoginTest {
    WebDriver driver = WebDriverUtils.getDriver("chrome");
    LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);

    public LoginTest() {

    }

    @BeforeMethod
    public void beforeMethod() {

    }

    @Test
    public void successLogin() throws Exception {

        loginPage.navigateTo("https://www.yemeksepeti.com/istanbul");
        loginPage.enterUserId("holyusername",true);
        loginPage.enterPassword("holypassword",true);
        loginPage.clickLoginButton(1);
        //driver = WebDriverUtils.initBrowser("chrome","https://www.yemeksepeti.com/istanbul");

    }
    @AfterTest
    public void quit(){
        WebDriverUtils.quitBrowser();
    }


}
