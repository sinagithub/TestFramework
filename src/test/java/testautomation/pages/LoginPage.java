package testautomation.pages;



import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testautomation.utils.Helper;

public class LoginPage extends Helper {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Elements
    String userNameTextboxId = "UserName";
    String passwordTextBoxId = "password";
    String loginButtonId = "ys-fastlogin-button";
    String userNameMainPageId = "ysUserName"; //Login sonrası kullanıcı adı üzerinden assertion
    String modalYemekSiparisiXpath = "/html/body/div[13]/div/div/div/div[2]/div/a[2]/div[1]/div";
    String invalidLoginMessageXpath = "/html/body/div[9]/div[2]/div[1]/span/strong";
    String logoutButtonClass  = "btnUserLogout";


    String invalidLoginFailedPopupButtonXpath = "/html/body/div[9]/div[2]/div[2]/button";
    String failedLoginPopupMessage = "Hatalı giriş. Lütfen kullanıcı adı ve şifrenizi kontrol edip tekrar deneyiniz.";
    String loginBoxTitle = "Kullanıcı Adı / E-Posta";
    String loginBoxTitleClass = "control-label";
    //TestData
    String expectedUserNameAfterLogin = "sina can sürücü";




    public void navigateToLoginPage(){
        driver.get("https://www.yemeksepeti.com/istanbul");
    }

    public void inputTextToUserTextBox(String text, boolean clearText) {
        inputText(By.id(userNameTextboxId),clearText,text);
    }

    public void inputTextToPasswordTextBox(String text, boolean clearText) {
        inputText(By.id(passwordTextBoxId),clearText,text);
        }

    public void clickLoginButton() throws InterruptedException {
        click(By.id(loginButtonId));
    }
    public void assertLoginIsSuccess()throws Throwable{
        Assert.assertEquals(expectedUserNameAfterLogin,getText(By.id(userNameMainPageId)));
    }

    public void clickYemekSipraisiOnModal()throws Throwable{
        waitForElementExists(By.xpath(modalYemekSiparisiXpath));
        click(By.xpath(modalYemekSiparisiXpath));
    }

    public void assertLoginFailed() throws Throwable{
        waitForElementExists(By.xpath(invalidLoginMessageXpath));
        Assert.assertEquals(failedLoginPopupMessage,getText(By.xpath(invalidLoginMessageXpath)));
        waitForElementExists(By.xpath(invalidLoginFailedPopupButtonXpath));
        click(By.xpath(invalidLoginFailedPopupButtonXpath));
        Assert.assertEquals(loginBoxTitle,getText(By.className(loginBoxTitleClass)));

    }

    public void clickLogOutButton()throws Throwable{
        waitForElementExists(By.className(logoutButtonClass));
        click(By.className(logoutButtonClass));
    }

    public void dropUserInfoList()throws Throwable{
        click(By.id(userNameMainPageId));
    }

    public void assertUserLoggedOut()throws Throwable{
        waitForElementExists(By.className(loginBoxTitleClass));
        Assert.assertEquals(loginBoxTitle,getText(By.className(loginBoxTitleClass)));
    }




}
