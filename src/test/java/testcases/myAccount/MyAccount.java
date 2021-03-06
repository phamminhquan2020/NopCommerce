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
    String userEmail, userPassword;
    String firstname, lastname, day, month, year, company;
    String add_firstname, add_lastname, add_email, add_company, add_country, add_state, add_city, add_address1, add_address2, add_zipcode, add_phone, add_fax, addTitle;
    String productTitle, reviewTitle, reviewText, ratingValue, loginUnsuccessfulMessage, incorrectCredentialMessage, changePasswordSuccessMessage, successReviewMessage;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browser) {
        data = DataHelper.getData();
        userEmail = DataHelper.getUserEmail(browser);
        userPassword = GlobalConstants.USER_PASSWORD;
        firstname = "Automation";
        lastname = "FC";
        day = "1";
        month = "January";
        year = "1999";
        company = "Automation FC";
        add_firstname = data.getFirstName();
        add_lastname = data.getLastName();
        add_email = data.getEmail();
        add_company = data.getCompanyName();
        add_country = "United States";
        add_state = "Texas";
        add_city = data.getCity();
        add_address1 = data.getAddress();
        add_address2 = data.getAddress();
        add_zipcode = data.getZipcode();
        add_phone = data.getPhoneNumber();
        add_fax = data.getFaxNumber();
        addTitle = add_firstname + " " + add_lastname;

        productTitle = "Apple MacBook Pro 13-inch";
        reviewTitle = "This is best Macbook" + randomNumber();
        reviewText = "It's have lots of valuable upgrades from previous version";
        ratingValue = "5";

        loginUnsuccessfulMessage = "Login was unsuccessful. Please correct the errors and try again.";
        incorrectCredentialMessage = "The credentials provided are incorrect";
        changePasswordSuccessMessage = "Password was changed";
        successReviewMessage = "Product review is successfully added.";
        driver = getBrowserDriverFromFactory(browser);
        homeUserPage = PageGeneratorManager.getHomeUserPage(driver);


    }

    @BeforeMethod
    public void beforeMethod() {
        homeUserPage.navigatePageUrl(driver, GlobalConstants.USER_URL);
        homeUserPage.clickToLoginLink(driver);
        loginUserPage = PageGeneratorManager.getLoginUserPage(driver);
        loginUserPage.inputToEmailTextBox(userEmail);
        loginUserPage.inputToPasswordTextBox(userPassword);
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
        verifyTrue(addressMyAccountUserPage.isAddressTitleDisplayed(addTitle));
        verifyEquals(addressMyAccountUserPage.getAddFullNameByTitle(addTitle), add_firstname + " " + add_lastname);
        verifyEquals(addressMyAccountUserPage.getAddEmailByTitle(addTitle), "Email: " + add_email);
        verifyEquals(addressMyAccountUserPage.getAddPhoneByTitle(addTitle), "Phone number: " + add_phone);
        verifyEquals(addressMyAccountUserPage.getAddFaxByTitle(addTitle), "Fax number: " + add_fax);
        verifyEquals(addressMyAccountUserPage.getAddCompanyByTitle(addTitle), add_company);
        verifyEquals(addressMyAccountUserPage.getAddAddress1ByTitle(addTitle), add_address1);
        verifyEquals(addressMyAccountUserPage.getAddCityStateZipByTitle(addTitle), add_city + ", " + add_state + ", " + add_zipcode);
        verifyEquals(addressMyAccountUserPage.getAddCountryByTitle(addTitle), add_country);
        addressMyAccountUserPage.clickToDeleteButtonByTitle(addTitle);
        addressMyAccountUserPage.acceptAlert(driver);
        verifyTrue(addressMyAccountUserPage.isNoAddressMsgDisplayed());


    }


    public void myAccount_03_change_password() {
        homeUserPage.clickToMyAccountLink(driver);
        customerInfoMyAccountUserPage = PageGeneratorManager.getCustomerInfoMyAccountUserPage(driver);
        customerInfoMyAccountUserPage.clickToDynamicMyAccountMenu(driver, "Change password");
        changePasswordMyAccountUserPage = PageGeneratorManager.getChangePasswordMyAccountUserPage(driver);
        changePasswordMyAccountUserPage.inputOldPassword(userPassword);
        changePasswordMyAccountUserPage.inputNewPassword(GlobalConstants.CHANGED_USER_PASSWORD);
        changePasswordMyAccountUserPage.inputConfirmNewPassword(GlobalConstants.CHANGED_USER_PASSWORD);
        changePasswordMyAccountUserPage.clickChangePasswordButton();
        verifyEquals(changePasswordMyAccountUserPage.getResultMsg(), changePasswordSuccessMessage);
        changePasswordMyAccountUserPage.clickToLogoutLink(driver);
        changePasswordMyAccountUserPage.clickToLoginLink(driver);
        loginUserPage.inputToEmailTextBox(userEmail);
        loginUserPage.inputToPasswordTextBox(userPassword);
        loginUserPage.clickToLoginButton();
        verifyTrue(loginUserPage.getLoginErrorMsg().contains(loginUnsuccessfulMessage) && loginUserPage.getLoginErrorMsg().contains(incorrectCredentialMessage));
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
        verifyEquals(productReviewUserPage.getResultReviewMsg(), successReviewMessage);
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
