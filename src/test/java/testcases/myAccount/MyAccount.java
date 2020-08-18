package testcases.myAccount;

import commonFunctions.AbstractTest;
import commonFunctions.GlobalConstants;
import commonFunctions.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.*;
import testdata.helper.DataHelper;

public class MyAccount extends AbstractTest {
    private WebDriver driver;
    HomeUserPageObject homeUserPage;
    LoginUserPageObject loginUserPage;
    CustomerInfoMyAccountUserPageObject customerInfoMyAccountUserPage;
    AddressMyAccountUserPageObject addressMyAccountUserPage;
    ChangePasswordMyAccountUserPageObject changePasswordMyAccountUserPage;
    ProductDetailUserPageObject productDetailUserPage;
    ProductReviewUserPageObject productReviewUserPage;
    MyProductReviewMyAccountUserPageObject myProductReviewMyAccountUserPage;
    DataHelper data;
    String firstname, lastname, day, month, year, company;
    String add_firstname, add_lastname, add_email, add_company, add_country, add_state, add_city, add_address1, add_address2, add_zipcode, add_phone, add_fax;
    String productTitle, reviewTitle, reviewText, ratingValue;
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
        add_firstname = data.getFirstName();
        add_lastname = data.getLastName();
        add_email = data.getEmail();
        add_company = data.getCompany();
        add_country = "United States";
        add_state = "Texas";
        add_city = data.getCity();
        add_address1 = data.getAddress();
        add_address2 = data.getAddress();
        add_zipcode = data.getZipcode();
        add_phone = data.getPhoneNumber();
        add_fax = data.getFaxNumber();

        productTitle = "Apple MacBook Pro 13-inch";
        reviewTitle = "This is best Macbook" + randomNumber();
        reviewText = "It's have lots of valuable upgrades from previous version";
        ratingValue = "5";


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
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.manage().deleteAllCookies();
    }

    @Test
    public void myAccount_01_update_customer_info() {
        homeUserPage.clickToMyAccountLink(driver);
        customerInfoMyAccountUserPage = PageGeneratorManager.getCustomerInfoMyAccountUserPage(driver);
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

    @Test
    public void myAccount_02_add_address() {
        homeUserPage.clickToMyAccountLink(driver);
        customerInfoMyAccountUserPage = PageGeneratorManager.getCustomerInfoMyAccountUserPage(driver);
        customerInfoMyAccountUserPage.clickToDynamicMyAccountMenu(driver, "Addresses");
        addressMyAccountUserPage = PageGeneratorManager.getAddressMyAccountUserPage(driver);
        addressMyAccountUserPage.clickToAddButton();
        addressMyAccountUserPage.inputAddFirstName(add_firstname);
        addressMyAccountUserPage.inputAddLastName(add_lastname);
        addressMyAccountUserPage.inputAddEmail(add_email);
        addressMyAccountUserPage.inputAddCompany(add_company);
        addressMyAccountUserPage.selectAddCountry(add_country);
        addressMyAccountUserPage.selectAddState(add_state);
        addressMyAccountUserPage.inputAddCity(add_city);
        addressMyAccountUserPage.inputAddAddress1(add_address1);
        addressMyAccountUserPage.inputAddAddress2(add_address2);
        addressMyAccountUserPage.inputAddZipcode(add_zipcode);
        addressMyAccountUserPage.inputAddPhone(add_phone);
        addressMyAccountUserPage.inputAddFax(add_fax);
        addressMyAccountUserPage.clickSaveButton();
        verifyEquals(addressMyAccountUserPage.getAddTitle(), add_firstname + " " + add_lastname);
        verifyEquals(addressMyAccountUserPage.getAddFullName(), add_firstname + " " + add_lastname);
        verifyEquals(addressMyAccountUserPage.getAddEmail(), "Email: " + add_email);
        verifyEquals(addressMyAccountUserPage.getAddPhone(), "Phone number: " + add_phone);
        verifyEquals(addressMyAccountUserPage.getAddFax(), "Fax number: " + add_fax);
        verifyEquals(addressMyAccountUserPage.getAddCompany(), add_company);
        verifyEquals(addressMyAccountUserPage.getAddAddress1(), add_address1);
        verifyEquals(addressMyAccountUserPage.getAddCityStateZip(), add_city + ", " + add_state + ", " + add_zipcode);
        verifyEquals(addressMyAccountUserPage.getAddCountry(), add_country);
        addressMyAccountUserPage.clickToDeleteButton();
        addressMyAccountUserPage.acceptAlert(driver);
        verifyTrue(addressMyAccountUserPage.isNoAddressMsgDisplayed());


    }


    public void myAccount_03_change_password() {
        homeUserPage.clickToMyAccountLink(driver);
        customerInfoMyAccountUserPage = PageGeneratorManager.getCustomerInfoMyAccountUserPage(driver);
        customerInfoMyAccountUserPage.clickToDynamicMyAccountMenu(driver, "Change password");
        changePasswordMyAccountUserPage = PageGeneratorManager.getChangePasswordMyAccountUserPage(driver);
        changePasswordMyAccountUserPage.inputOldPassword(GlobalConstants.USER_PASSWORD);
        changePasswordMyAccountUserPage.inputNewPassword(GlobalConstants.CHANGED_USER_PASSWORD);
        changePasswordMyAccountUserPage.inputConfirmNewPassword(GlobalConstants.CHANGED_USER_PASSWORD);
        changePasswordMyAccountUserPage.clickChangePasswordButton();
        verifyEquals(changePasswordMyAccountUserPage.getResultMsg(), "Password was changed");
        changePasswordMyAccountUserPage.clickToLogoutLink(driver);
        changePasswordMyAccountUserPage.clickToLoginLink(driver);
        loginUserPage.inputToEmailTextBox(GlobalConstants.USER_EMAIL);
        loginUserPage.inputToPasswordTextBox(GlobalConstants.USER_PASSWORD);
        loginUserPage.clickToLoginButton();
        verifyTrue(loginUserPage.getLoginErrorMsg().contains("Login was unsuccessful. Please correct the errors and try again.") && loginUserPage.getLoginErrorMsg().contains("The credentials provided are incorrect"));
        loginUserPage.inputToPasswordTextBox(GlobalConstants.CHANGED_USER_PASSWORD);
        loginUserPage.clickToLoginButton();
        verifyEquals(loginUserPage.getPageUrl(driver), GlobalConstants.USER_URL);
    }

    @Test
    public void myAccount_04_review_product() {
        homeUserPage.clickToDynamicProductImageByTitle(driver, productTitle);
        productDetailUserPage = PageGeneratorManager.getProductDetailUserPage(driver);
        productDetailUserPage.clickAddYourReviewLink();
        productReviewUserPage = PageGeneratorManager.getProductReviewUserPage(driver);
        productReviewUserPage.inputReviewTitleTextbox(reviewTitle);
        productReviewUserPage.inputReviewTextTextbox(reviewText);
        productReviewUserPage.clickToDynamicRatingOption(ratingValue);
        productReviewUserPage.clickSubmitReviewButton();
        verifyEquals(productReviewUserPage.getResultReviewMsg(), "Product review is successfully added.");
        productReviewUserPage.clickToMyAccountLink(driver);
        customerInfoMyAccountUserPage = PageGeneratorManager.getCustomerInfoMyAccountUserPage(driver);
        customerInfoMyAccountUserPage.clickToDynamicMyAccountMenu(driver, "My product reviews");
        myProductReviewMyAccountUserPage = PageGeneratorManager.getMyProductReviewMyAccountPage(driver);
        verifyTrue(myProductReviewMyAccountUserPage.isReviewTitleDisplayed(reviewTitle));
        verifyEquals(myProductReviewMyAccountUserPage.getReviewTextByTitle(reviewTitle), reviewText);
        verifyTrue(myProductReviewMyAccountUserPage.isReviewRatingDisplayedCorrectly(reviewTitle, ratingValue));
        verifyTrue(myProductReviewMyAccountUserPage.getReviewInfoByTitle(reviewTitle).contains(productTitle));







    }
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
