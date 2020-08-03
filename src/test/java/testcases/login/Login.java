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
    WebDriver driver;
    HomeUserPageObject homeUserPage;
    LoginUserPageObject loginUserPage;
    DataHelper data;
    String newEmail, password;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browser) {
        driver = getBrowserDriverFromFactory(browser);
        homeUserPage = PageGeneratorManager.getHomeUserPage(driver);
        data = DataHelper.getData();
        newEmail = data.getEmail();
        password = data.getPassword();

}
    @BeforeMethod
    public void beforeMethod() {
        homeUserPage.navigatePageUrl(driver, GlobalConstants.USER_URL);
        homeUserPage.clickToLoginLink(driver);
        loginUserPage = PageGeneratorManager.getLoginUserPage(driver);
    }

    @Test
    public void login_01_empty_data() {
        loginUserPage.clickToLoginButton();
        verifyEquals(loginUserPage.getEmailErrorMsg(), "Please enter your email");
    }
    @Test
    public void login_02_invalid_email() {
        loginUserPage.inputToEmailTextBox("qwert");
        loginUserPage.clickToLoginButton();
        verifyEquals(loginUserPage.getEmailErrorMsg(), "Wrong email");
    }
    @Test
    public void login_03_not_exist_email() {
        loginUserPage.inputToEmailTextBox("qwert@yopmail.com");
        loginUserPage.clickToLoginButton();
        verifyTrue(loginUserPage.getLoginErrorMsg().contains("Login was unsuccessful. Please correct the errors and try again.") && loginUserPage.getLoginErrorMsg().contains("No customer account found"));
    }
    @Test
    public void login_04_empty_password() {
        loginUserPage.inputToEmailTextBox(GlobalConstants.USER_EMAIL);
        loginUserPage.clickToLoginButton();
        verifyTrue(loginUserPage.getLoginErrorMsg().contains("Login was unsuccessful. Please correct the errors and try again.") && loginUserPage.getLoginErrorMsg().contains("The credentials provided are incorrect"));
    }
    @Test
    public void login_05_wrong_password() {
        loginUserPage.inputToEmailTextBox(GlobalConstants.USER_EMAIL);
        loginUserPage.inputToPasswordTextBox(password);
        loginUserPage.clickToLoginButton();
        verifyTrue(loginUserPage.getLoginErrorMsg().contains("Login was unsuccessful. Please correct the errors and try again.") && loginUserPage.getLoginErrorMsg().contains("The credentials provided are incorrect"));
    }
    @Test
    public void login_06_login_success() {
        loginUserPage.inputToEmailTextBox(GlobalConstants.USER_EMAIL);
        loginUserPage.inputToPasswordTextBox(GlobalConstants.USER_PASSWORD);
        loginUserPage.clickToLoginButton();
        verifyEquals(loginUserPage.getPageUrl(driver), GlobalConstants.USER_URL);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
