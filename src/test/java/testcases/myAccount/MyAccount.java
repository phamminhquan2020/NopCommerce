package testcases.myAccount;

import commonFunctions.AbstractTest;
import commonFunctions.GlobalConstants;
import commonFunctions.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.HomeUserPageObject;
import pageObjects.LoginUserPageObject;
import pageObjects.CustomerInfoMyAccountUserPageObject;
import testdata.helper.DataHelper;

public class MyAccount extends AbstractTest {
    WebDriver driver;
    HomeUserPageObject homeUserPage;
    LoginUserPageObject loginUserPage;
    CustomerInfoMyAccountUserPageObject customerInfoMyAccountUserPage;
    DataHelper data;
    String firstname, lastname, day, month, year, company;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browser) {
        data = DataHelper.getData();
        firstname = "Automation";
        lastname = "FC";
        day = "1";
        month = "January";
        year = "1999";
        company = "Automation FC";
        driver = getBrowserDriverFromFactory(browser);
        homeUserPage = PageGeneratorManager.getHomeUserPage(driver);
        homeUserPage.navigatePageUrl(driver, GlobalConstants.USER_URL);
        homeUserPage.clickToLoginLink(driver);
        loginUserPage = PageGeneratorManager.getLoginUserPage(driver);
        loginUserPage.inputToEmailTextBox(GlobalConstants.USER_EMAIL);
        loginUserPage.inputToPasswordTextBox(GlobalConstants.USER_PASSWORD);
        loginUserPage.clickToLoginButton();
        homeUserPage.clickToMyAccountLink(driver);
        customerInfoMyAccountUserPage = PageGeneratorManager.getMyAccountUserPage(driver);
    }
    @BeforeMethod
    public void beforeMethod() {

    }

    @Test
    public void myAccount_01_update_customer_info() {
        customerInfoMyAccountUserPage.clickToFemaleRadio();
        customerInfoMyAccountUserPage.inputFirstName(firstname);
        customerInfoMyAccountUserPage.inputLastName(lastname);
        customerInfoMyAccountUserPage.selectDayDropdown(day);
        customerInfoMyAccountUserPage.selectMonthDropdown(month);
        customerInfoMyAccountUserPage.selectYearDropdown(year);
        customerInfoMyAccountUserPage.inputCompanyName(company);
        customerInfoMyAccountUserPage.clickSaveButton();
        verifyTrue(customerInfoMyAccountUserPage.isFemaleChecked());
        verifyEquals(customerInfoMyAccountUserPage.getFirstName(), firstname);
        verifyEquals(customerInfoMyAccountUserPage.getLastName(), lastname);
        verifyEquals(customerInfoMyAccountUserPage.getDay(), day);
        verifyEquals(customerInfoMyAccountUserPage.getMonth(), month);
        verifyEquals(customerInfoMyAccountUserPage.getYear(), year);
        verifyEquals(customerInfoMyAccountUserPage.getCompany(), company);


    }
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
