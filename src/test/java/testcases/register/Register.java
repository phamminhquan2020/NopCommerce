package testcases.register;

import commonFunctions.AbstractTest;
import commonFunctions.GlobalConstants;
import commonFunctions.PageGeneratorManager;
import driverFactory.BrowserDriverManager;
import org.openqa.selenium.WebDriver;
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
        month = "June";
        year = "2000";
        email = data.getEmail();
        companyName = data.getCompany();
        password = data.getPassword();
    }

    @BeforeMethod
    public void beforeMethod() {
        homeUserPage.navigatePageUrl(driver, GlobalConstants.USER_URL);
        homeUserPage.clickToRegisterLink(driver);
        registerUserPage = PageGeneratorManager.getRegisterUserPage(driver);

    }

    @Test
    public void Register_01_empty_data() {

        registerUserPage.clickRegisterButton();
        verifyEquals(registerUserPage.getFirstNameRequiredErrorMsg(), "First name is required.");
        verifyEquals(registerUserPage.getLastNameRequiredErrorMsg(), "Last name is required.");
        verifyEquals(registerUserPage.getEmailErrorMsg(), "Email is required.");
        verifyEquals(registerUserPage.getPasswordRequiredErrorMsg(), "Password is required.");
        verifyEquals(registerUserPage.getConfirmPasswordRequiredErrorMsg(), "Password is required.");
    }
    @Test
    public void Register_02_invalid_email() {

        registerUserPage.inputEmail("qwerty");
        registerUserPage.clickRegisterButton();
        verifyEquals(registerUserPage.getEmailErrorMsg(), "Wrong email");
    }


    public void Register_03_empty_data() {
        registerUserPage.clickRegisterButton();


    }


    public void Register_04_empty_data() {
        registerUserPage.clickRegisterButton();


    }


    public void Register_05_empty_data() {
        registerUserPage.clickRegisterButton();


    }


    public void Register_06_empty_data() {
        registerUserPage.clickMaleGender();
        System.out.println("firstname: " + firstname);
        registerUserPage.inputFirstName(firstname);
        System.out.println("firstname: " + lastname);
        registerUserPage.inputLastName(lastname);
        registerUserPage.selectDay(day);
        registerUserPage.selectMonth(month);
        registerUserPage.selectYear(year);
        registerUserPage.inputEmail(email);
        registerUserPage.inputCompanyName(companyName);
        registerUserPage.inputPassword(password);
        registerUserPage.inputConfirmPassword(password);
        registerUserPage.clickRegisterButton();


    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
