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
    HomeUserPageObject homeUserPage;
    RegisterUserPageObject registerUserPage;
    DataHelper data;
    String firstname06, lastname06, day06, month06, year06, email03, companyName03, password03, userEmail, userPassword;
    String firstNameRequiredErrorMessage, lastNameRequiredErrorMessage, emailRequiredErrorMessage, passwordRequiredErrorMessage, wrongEmailErrorMessage, passwordRuleErrorMessage, password6CharacterMessage, confirmPasswordNotMatchMessage;
    private WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browser) {
        data = DataHelper.getData();
        firstname06 = GlobalConstants.FIRST_NAME;
        lastname06 = GlobalConstants.LAST_NAME;
        day06 = "15";
        month06 = "June";
        year06 = "2000";
        userEmail = DataHelper.getUserEmail(browser);
        userPassword = GlobalConstants.USER_PASSWORD;
        email03 = "automationfc.vn@gmail.com";
        companyName03 = data.getCompanyName();
        password03 = data.getPassword();

        firstNameRequiredErrorMessage = "First name is required.";
        lastNameRequiredErrorMessage = "Last name is required.";
        emailRequiredErrorMessage = "Email is required.";
        passwordRequiredErrorMessage = "Password is required.";
        wrongEmailErrorMessage = "Wrong email";
        passwordRuleErrorMessage = "Password must meet the following rules:";
        password6CharacterMessage = "must have at least 6 characters";
        confirmPasswordNotMatchMessage = "The password and confirmation password do not match.";
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
        verifyEquals(registerUserPage.getFirstNameRequiredErrorMsg(), firstNameRequiredErrorMessage);
        verifyEquals(registerUserPage.getLastNameRequiredErrorMsg(), lastNameRequiredErrorMessage);
        verifyEquals(registerUserPage.getEmailErrorMsg(), emailRequiredErrorMessage);
        verifyEquals(registerUserPage.getPasswordErrorMsg(), passwordRequiredErrorMessage);
        verifyEquals(registerUserPage.getConfirmPasswordErrorMsg(), passwordRequiredErrorMessage);
    }


    public void register_02_invalid_email() {

        registerUserPage.inputEmail("qwerty");
        registerUserPage.clickRegisterButton();
        verifyEquals(registerUserPage.getEmailErrorMsg(), wrongEmailErrorMessage);
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
        verifyTrue(registerUserPage.getPasswordErrorMsg().contains(passwordRuleErrorMessage) && registerUserPage.getPasswordErrorMsg().contains(password6CharacterMessage));
    }


    public void register_05_Confirm_Password_Not_Match() {
        registerUserPage.inputPassword(password03);
        registerUserPage.inputConfirmPassword(password03 + "123");
        registerUserPage.clickRegisterButton();
        verifyEquals(registerUserPage.getConfirmPasswordErrorMsg(), confirmPasswordNotMatchMessage);
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
        verifyEquals(registerUserPage.getSuccessMsg(), "Your registration completed");
        registerUserPage.clickContinueButton();
        verifyEquals(registerUserPage.getPageUrl(driver), GlobalConstants.USER_URL);

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
