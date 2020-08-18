package testcases.admin;

import commonFunctions.AbstractTest;
import commonFunctions.GlobalConstants;
import commonFunctions.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.LoginAdminPageObject;

public class Admin extends AbstractTest {
    WebDriver driver;
    LoginAdminPageObject loginAdminPageObject;
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browser) {
        driver = getBrowserDriverFromFactory(browser);
    }
    @BeforeMethod
    public void beforeMethod() {
        loginAdminPageObject = PageGeneratorManager.getLoginAdminPage(driver);
        loginAdminPageObject.navigatePageUrl(driver, GlobalConstants.ADMIN_URL);
        loginAdminPageObject.inputToEmailTextbox(GlobalConstants.ADMIN_EMAIL);
        loginAdminPageObject.inputToPasswordTextbox(GlobalConstants.ADMIN_PASSWORD);
        loginAdminPageObject.clickToLoginButton();
    }
    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.manage().deleteAllCookies();
    }

    @Test
    public void admin_01_search_with_product_name() {

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
