package testcases.login;

import commonFunctions.AbstractTest;
import commonFunctions.GlobalConstants;
import commonFunctions.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.HomeUserPageObject;
import pageObjects.LoginUserPageObject;
import testdata.helper.DataHelper;

public class Login extends AbstractTest {
    private WebDriver driver;
    HomeUserPageObject homeUserPage;
    LoginUserPageObject loginUserPage;
    DataHelper data;
    String newEmail, password, userEmail, userPassword, emptyEmailMessage, loginUnsuccessfulMessage, incorrectCredentialMessage, noAccountMessage, wrongEmailMessage;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browser) {

        data = DataHelper.getData();
        newEmail = data.getEmail();
        password = data.getPassword();
        userEmail = DataHelper.getUserEmail(browser);
        userPassword = GlobalConstants.USER_PASSWORD;

        emptyEmailMessage = "Please enter your email";
        wrongEmailMessage = "Wrong email";
        loginUnsuccessfulMessage = "Login was unsuccessful. Please correct the errors and try again.";
        incorrectCredentialMessage = "The credentials provided are incorrect";
        noAccountMessage = "No customer account found";
        driver = getBrowserDriverFromFactory(browser);
        homeUserPage = PageGeneratorManager.getHomeUserPage(driver);


    }
    @BeforeMethod
    public void beforeMethod() {
        homeUserPage.navigatePageUrl(driver, GlobalConstants.USER_URL);
        homeUserPage.clickToLoginLink(driver);
        loginUserPage = PageGeneratorManager.getLoginUserPage(driver);
    }
    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.manage().deleteAllCookies();
    }

    @Test
    public void login_01_empty_data() {
        loginUserPage.clickToLoginButton();
        verifyEquals(loginUserPage.getEmailErrorMsg(), emptyEmailMessage);
    }
    @Test
    public void login_02_invalid_email() {
        loginUserPage.inputToEmailTextBox("qwert");
        loginUserPage.clickToLoginButton();
        verifyEquals(loginUserPage.getEmailErrorMsg(), wrongEmailMessage);
    }
    @Test
    public void login_03_not_exist_email() {
        loginUserPage.inputToEmailTextBox("qwert@yopmail.com");
        loginUserPage.clickToLoginButton();
        verifyTrue(loginUserPage.getLoginErrorMsg().contains(loginUnsuccessfulMessage) && loginUserPage.getLoginErrorMsg().contains(noAccountMessage));
    }
    @Test
    public void login_04_empty_password() {
        loginUserPage.inputToEmailTextBox(userEmail);
        loginUserPage.clickToLoginButton();
        verifyTrue(loginUserPage.getLoginErrorMsg().contains(loginUnsuccessfulMessage) && loginUserPage.getLoginErrorMsg().contains(incorrectCredentialMessage));
    }
    @Test
    public void login_05_wrong_password() {
        loginUserPage.inputToEmailTextBox(userEmail);
        loginUserPage.inputToPasswordTextBox(password);
        loginUserPage.clickToLoginButton();
        verifyTrue(loginUserPage.getLoginErrorMsg().contains(loginUnsuccessfulMessage) && loginUserPage.getLoginErrorMsg().contains(incorrectCredentialMessage));
    }
    @Test
    public void login_06_login_success() {
        loginUserPage.inputToEmailTextBox(userEmail);
        loginUserPage.inputToPasswordTextBox(userPassword);
        loginUserPage.clickToLoginButton();
        verifyEquals(loginUserPage.getPageUrl(driver), GlobalConstants.USER_URL);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
