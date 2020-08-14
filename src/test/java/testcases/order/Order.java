package testcases.order;

import commonFunctions.AbstractTest;
import commonFunctions.GlobalConstants;
import commonFunctions.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.HomeUserPageObject;
import pageObjects.LoginUserPageObject;
import pageObjects.RegisterUserPageObject;
import testdata.helper.DataHelper;

public class Order extends AbstractTest {
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
        loginUserPage.inputToEmailTextBox(GlobalConstants.USER_EMAIL);
        loginUserPage.inputToPasswordTextBox(GlobalConstants.USER_PASSWORD);
        loginUserPage.clickToLoginButton();
        homeUserPage = PageGeneratorManager.getHomeUserPage(driver);

    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.manage().deleteAllCookies();
    }

    @Test



    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}


