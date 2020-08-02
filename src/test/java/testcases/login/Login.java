package testcases.login;

import commonFunctions.AbstractTest;
import commonFunctions.GlobalConstants;
import commonFunctions.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.HomeUserPageObject;
import pageObjects.LoginUserPageObject;

public class Login extends AbstractTest {
    WebDriver driver;
    HomeUserPageObject homeUserPage;
    LoginUserPageObject loginUserPage;
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browser) {
        driver = getBrowserDriverFromFactory(browser);
        homeUserPage = PageGeneratorManager.getHomeUserPage(driver);
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

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
