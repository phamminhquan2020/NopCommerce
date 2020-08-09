package testcases.register;

import commonFunctions.AbstractTest;
import commonFunctions.GlobalConstants;
import commonFunctions.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.HomeUserPageObject;
import pageObjects.RegisterUserPageObject;
import testdata.helper.DataHelper;

public class Register extends AbstractTest {
    WebDriver driver;
    HomeUserPageObject homeUserPage;
    RegisterUserPageObject registerUserPage;
    DataHelper data;
    String firstname, lastname, day, month, year, email, companyName, password;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browser) {
        driver = getBrowserDriverFromFactory(browser);
        homeUserPage = PageGeneratorManager.getHomeUserPage(driver);

        data = DataHelper.getData();
        firstname = GlobalConstants.FIRST_NAME;
        lastname = GlobalConstants.LAST_NAME;
        day = "15";
        month = "June";
        year = "2000";
        email = "automationfc.vn@gmail.com";
        companyName = data.getCompany();
        password = data.getPassword();
    }

    @BeforeMethod
    public void beforeMethod() {
        log.info("Navigate to User Home Page");
        homeUserPage.navigatePageUrl(driver, GlobalConstants.USER_URL);
        homeUserPage.clickToRegisterLink(driver);
        registerUserPage = PageGeneratorManager.getRegisterUserPage(driver);

    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.manage().deleteAllCookies();
    }

    @Test
    public void register_01_empty_data() {

        registerUserPage.clickRegisterButton();
        verifyEquals(registerUserPage.getFirstNameRequiredErrorMsg(), "First name is required.");
        verifyEquals(registerUserPage.getLastNameRequiredErrorMsg(), "Last name is required.");
        verifyEquals(registerUserPage.getEmailErrorMsg(), "Email is required.");
        verifyEquals(registerUserPage.getPasswordErrorMsg(), "Password is required.");
        verifyEquals(registerUserPage.getConfirmPasswordErrorMsg(), "Password is required.");
    }

    @Test
    public void register_02_invalid_email() {

        registerUserPage.inputEmail("qwerty");
        registerUserPage.clickRegisterButton();
        verifyEquals(registerUserPage.getEmailErrorMsg(), "Wrong email");
    }

    @Test
    public void register_03_existing_email() {
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
        registerUserPage.clickRegisterButton();
        verifyTrue(registerUserPage.isEmailAlreadyExistMsgDisplayed());
    }

    @Test
    public void register_04_invalid_password() {
        registerUserPage.inputPassword("123");
        registerUserPage.clickRegisterButton();
        verifyTrue(registerUserPage.getPasswordErrorMsg().contains("Password must meet the following rules:") && registerUserPage.getPasswordErrorMsg().contains("must have at least 6 characters"));
    }

    @Test
    public void register_05_Confirm_Password_Not_Match() {
        registerUserPage.inputPassword(password);
        registerUserPage.inputConfirmPassword(password + "123");
        registerUserPage.clickRegisterButton();
        verifyEquals(registerUserPage.getConfirmPasswordErrorMsg(), "The password and confirmation password do not match.");
    }

    @Test
    public void register_06_register_success() {
        registerUserPage.clickMaleGender();
        registerUserPage.inputFirstName(firstname);
        registerUserPage.inputLastName(lastname);
        registerUserPage.selectDay(day);
        registerUserPage.selectMonth(month);
        registerUserPage.selectYear(year);
        registerUserPage.inputEmail(GlobalConstants.USER_EMAIL);
        registerUserPage.inputCompanyName(companyName);
        registerUserPage.inputPassword(GlobalConstants.USER_PASSWORD);
        registerUserPage.inputConfirmPassword(GlobalConstants.USER_PASSWORD);
        registerUserPage.clickRegisterButton();
        verifyEquals(registerUserPage.getSuccessMsg(), "Your registration completed");
        registerUserPage.clickContinueButton();
        verifyEquals(registerUserPage.getPageUrl(driver), GlobalConstants.USER_URL);

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
