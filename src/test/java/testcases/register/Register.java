package testcases.register;

import commonFunctions.AbstractTest;
import commonFunctions.GlobalConstants;
import commonFunctions.PageGeneratorManager;
import driverFactory.BrowserDriverManager;
import driverFactory.DriverFactoryManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.HomeUserPageObject;
import pageObjects.RegisterUserPageObject;
import testdata.helper.DataHelper;

public class Register extends AbstractTest {
    WebDriver driver;
    BrowserDriverManager driverManager;
    HomeUserPageObject homeUserPage;
    RegisterUserPageObject registerUserPage;
    DataHelper data;
    String firstname, lastname, day, month, year, email, companyName, password;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browser) {
//        driverManager = DriverFactoryManager.getDriverManager(browser);
//        driver = driverManager.getDriver();
        driver = getBrowserDriver(browser);
        homeUserPage = PageGeneratorManager.getHomeUserPage(driver);

        data = DataHelper.getData();
        firstname = data.getFirstName();
        lastname = data.getLastName();
        day = "15";
        month = "7";
        year = "2000";
        email = data.getEmail();
        companyName = data.getCompany();
        password = data.getPassword();
    }

    @BeforeMethod
    public void beforeMethod() {
        homeUserPage.navigatePageUrl(driver, GlobalConstants.USER_URL);
    }

    @Test
    public void Register_01_empty_data() {
        homeUserPage.clickToRegisterLink(driver);
        Assert.assertTrue(false);
/*        registerUserPage = PageGeneratorManager.getRegisterUserPage(driver);
        registerUserPage.clickMaleGender();
        registerUserPage.inputFirstName(firstname);
        registerUserPage.inputLastName(lastname);
        registerUserPage.selectDay(day);
        registerUserPage.selectMonth(month);
        registerUserPage.selectYear(year);
        registerUserPage.inputEmail(email);
        registerUserPage.inputCompanyName(companyName);
        registerUserPage.inputPassword(password);
        registerUserPage.inputConfirmPassword(password);
        registerUserPage.clickRegisterButton();*/

    }

    @AfterClass
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
