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
    private WebDriver driver;
    HomeUserPageObject homeUserPage;
    RegisterUserPageObject registerUserPage;
    DataHelper data;
    String firstname06, lastname06, day06, month06, year06, email03, companyName03, password03, userEmail, userPassword;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browser) {
        data = DataHelper.getData();
        firstname06 = GlobalConstants.FIRST_NAME;
        lastname06 = GlobalConstants.LAST_NAME;
        day06 = "15";
        month06 = "June";
        year06 = "2000";
        userEmail = data.getUserEmail(browser);
        userPassword = GlobalConstants.USER_PASSWORD;
        email03 = "automationfc.vn@gmail.com";
        companyName03 = data.getCompanyName();
        password03 = data.getPassword();

        driver = getBrowserDriverFromFactory(browser);
        homeUserPage = PageGeneratorManager.getHomeUserPage(driver);
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


    public void register_01_empty_data() {

        registerUserPage.clickRegisterButton();
        verifyEquals(registerUserPage.getFirstNameRequiredErrorMsg(), "First name is required.");
        verifyEquals(registerUserPage.getLastNameRequiredErrorMsg(), "Last name is required.");
        verifyEquals(registerUserPage.getEmailErrorMsg(), "Email is required.");
        verifyEquals(registerUserPage.getPasswordErrorMsg(), "Password is required.");
        verifyEquals(registerUserPage.getConfirmPasswordErrorMsg(), "Password is required.");
    }


    public void register_02_invalid_email() {

        registerUserPage.inputEmail("qwerty");
        registerUserPage.clickRegisterButton();
        verifyEquals(registerUserPage.getEmailErrorMsg(), "Wrong email");
    }


    public void register_03_existing_email() {
        registerUserPage.clickMaleGender();
        registerUserPage.inputFirstName(firstname06);
        registerUserPage.inputLastName(lastname06);
        registerUserPage.selectDay(day06);
        registerUserPage.selectMonth(month06);
        registerUserPage.selectYear(year06);
        registerUserPage.inputEmail(email03);
        registerUserPage.inputCompanyName(companyName03);
        registerUserPage.inputPassword(password03);
        registerUserPage.inputConfirmPassword(password03);
        registerUserPage.clickRegisterButton();
        verifyTrue(registerUserPage.isEmailAlreadyExistMsgDisplayed());
    }


    public void register_04_invalid_password() {
        registerUserPage.inputPassword("123");
        registerUserPage.clickRegisterButton();
        verifyTrue(registerUserPage.getPasswordErrorMsg().contains("Password must meet the following rules:") && registerUserPage.getPasswordErrorMsg().contains("must have at least 6 characters"));
    }


    public void register_05_Confirm_Password_Not_Match() {
        registerUserPage.inputPassword(password03);
        registerUserPage.inputConfirmPassword(password03 + "123");
        registerUserPage.clickRegisterButton();
        verifyEquals(registerUserPage.getConfirmPasswordErrorMsg(), "The password and confirmation password do not match.");
    }

    @Test
    public void register_06_register_success() {
        registerUserPage.clickMaleGender();
        registerUserPage.inputFirstName(firstname06);
        registerUserPage.inputLastName(lastname06);
        registerUserPage.selectDay(day06);
        registerUserPage.selectMonth(month06);
        registerUserPage.selectYear(year06);
        registerUserPage.inputEmail(userEmail);
        registerUserPage.inputCompanyName(companyName03);
        registerUserPage.inputPassword(userPassword);
        registerUserPage.inputConfirmPassword(userPassword);
        registerUserPage.clickRegisterButton();
        verifyTrue(false);
/*        verifyEquals(registerUserPage.getSuccessMsg(), "Your registration completed");
        registerUserPage.clickContinueButton();
        verifyEquals(registerUserPage.getPageUrl(driver), GlobalConstants.USER_URL);*/

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
