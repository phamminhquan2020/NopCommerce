package pageObjects;

import commonFunctions.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.AddressMyAccountUserPageUI;

public class AddressMyAccountUserPageObject extends AbstractPage {
    private WebDriver driver;

    public AddressMyAccountUserPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public WebDriver getDriver() {
        return this.driver;
    }

    public void clickToAddButton() {
        waitElementClickable(driver, AddressMyAccountUserPageUI.ADD_NEW_BUTTON);
        clickToElement(driver, AddressMyAccountUserPageUI.ADD_NEW_BUTTON);
    }

    public void inputAddFirstName(String add_firstname) {
        waitElementVisible(driver, AddressMyAccountUserPageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, AddressMyAccountUserPageUI.FIRST_NAME_TEXTBOX, add_firstname);
    }

    public void inputAddLastName(String add_lastname) {
        waitElementVisible(driver, AddressMyAccountUserPageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, AddressMyAccountUserPageUI.LAST_NAME_TEXTBOX, add_lastname);
    }

    public void inputAddEmail(String add_email) {
        waitElementVisible(driver, AddressMyAccountUserPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, AddressMyAccountUserPageUI.EMAIL_TEXTBOX, add_email);
    }

    public void inputAddCompany(String add_company) {
        waitElementVisible(driver, AddressMyAccountUserPageUI.COMPANY_TEXTBOX);
        sendkeyToElement(driver, AddressMyAccountUserPageUI.COMPANY_TEXTBOX, add_company);
    }

    public void selectAddCountry(String add_country) {
        waitElementVisible(driver, AddressMyAccountUserPageUI.COUNTRY_DROPDOWN);
        selectOptionInDropdown(driver, AddressMyAccountUserPageUI.COUNTRY_DROPDOWN, add_country);
    }

    public void selectAddState(String add_state) {
        waitElementVisible(driver, AddressMyAccountUserPageUI.STATE_DROPDOWN);
        selectOptionInDropdown(driver, AddressMyAccountUserPageUI.STATE_DROPDOWN, add_state);
    }

    public void inputAddCity(String add_city) {
        waitElementVisible(driver, AddressMyAccountUserPageUI.CITY_TEXTBOX);
        sendkeyToElement(driver, AddressMyAccountUserPageUI.CITY_TEXTBOX, add_city);
    }

    public void inputAddAddress1(String add_address1) {
        waitElementVisible(driver, AddressMyAccountUserPageUI.ADDRESS1_TEXTBOX);
        sendkeyToElement(driver, AddressMyAccountUserPageUI.ADDRESS1_TEXTBOX, add_address1);
    }

    public void inputAddAddress2(String add_address2) {
        waitElementVisible(driver, AddressMyAccountUserPageUI.ADDRESS2_TEXTBOX);
        sendkeyToElement(driver, AddressMyAccountUserPageUI.ADDRESS2_TEXTBOX, add_address2);
    }

    public void inputAddZipcode(String add_zipcode) {
        waitElementVisible(driver, AddressMyAccountUserPageUI.ZIPCODE_TEXTBOX);
        sendkeyToElement(driver, AddressMyAccountUserPageUI.ZIPCODE_TEXTBOX, add_zipcode);
    }

    public void inputAddPhone(String add_phone) {
        waitElementVisible(driver, AddressMyAccountUserPageUI.PHONE_TEXTBOX);
        sendkeyToElement(driver, AddressMyAccountUserPageUI.PHONE_TEXTBOX, add_phone);
    }

    public void inputAddFax(String add_fax) {
        waitElementVisible(driver, AddressMyAccountUserPageUI.FAX_TEXTBOX);
        sendkeyToElement(driver, AddressMyAccountUserPageUI.FAX_TEXTBOX, add_fax);
    }

    public void clickSaveButton() {
        waitElementVisible(driver, AddressMyAccountUserPageUI.SAVE_BUTTON);
        clickToElement(driver, AddressMyAccountUserPageUI.SAVE_BUTTON);
    }

    public boolean isAddressTitleDisplayed(String addTitle) {
        return isElementDisplayed(driver, AddressMyAccountUserPageUI.DYNAMIC_TITLE_FIELD, addTitle);
    }

    public String getAddFullNameByTitle(String addTitle) {
        waitElementVisible(driver, AddressMyAccountUserPageUI.DYNAMIC_FULL_NAME_FIELD_BY_TITLE, addTitle);
        return getElementText(driver, AddressMyAccountUserPageUI.DYNAMIC_FULL_NAME_FIELD_BY_TITLE, addTitle);
    }

    public String getAddEmailByTitle(String addTitle) {
        waitElementVisible(driver, AddressMyAccountUserPageUI.DYNAMIC_EMAIL_FIELD_BY_TITLE, addTitle);
        return getElementText(driver, AddressMyAccountUserPageUI.DYNAMIC_EMAIL_FIELD_BY_TITLE, addTitle);
    }

    public String getAddPhoneByTitle(String addTitle) {
        waitElementVisible(driver, AddressMyAccountUserPageUI.DYNAMIC_PHONE_FIELD_BY_TITLE, addTitle);
        return getElementText(driver, AddressMyAccountUserPageUI.DYNAMIC_PHONE_FIELD_BY_TITLE, addTitle);
    }

    public String getAddFaxByTitle(String addTitle) {
        waitElementVisible(driver, AddressMyAccountUserPageUI.DYNAMIC_FAX_FIELD_BY_TITLE, addTitle);
        return getElementText(driver, AddressMyAccountUserPageUI.DYNAMIC_FAX_FIELD_BY_TITLE, addTitle);
    }

    public String getAddCompanyByTitle(String addTitle) {
        waitElementVisible(driver, AddressMyAccountUserPageUI.DYNAMIC_COMPANY_FIELD_BY_TITLE, addTitle);
        return getElementText(driver, AddressMyAccountUserPageUI.DYNAMIC_COMPANY_FIELD_BY_TITLE, addTitle);
    }

    public String getAddAddress1ByTitle(String addTitle) {
        waitElementVisible(driver, AddressMyAccountUserPageUI.DYNAMIC_ADDRESS1_FIELD_BY_TITLE, addTitle);
        return getElementText(driver, AddressMyAccountUserPageUI.DYNAMIC_ADDRESS1_FIELD_BY_TITLE, addTitle);
    }

    public String getAddCityStateZipByTitle(String addTitle) {
        waitElementVisible(driver, AddressMyAccountUserPageUI.DYNAMIC_CITY_STATE_ZIP_FIELD_BY_TITLE, addTitle);
        return getElementText(driver, AddressMyAccountUserPageUI.DYNAMIC_CITY_STATE_ZIP_FIELD_BY_TITLE, addTitle);
    }

    public String getAddCountryByTitle(String addTitle) {
        waitElementVisible(driver, AddressMyAccountUserPageUI.DYNAMIC_COUNTRY_FIELD_BY_TITLE, addTitle);
        return getElementText(driver, AddressMyAccountUserPageUI.DYNAMIC_COUNTRY_FIELD_BY_TITLE, addTitle);
    }

    public void clickToDeleteButtonByTitle(String addTitle) {
        waitElementClickable(driver, AddressMyAccountUserPageUI.DYNAMIC_DELETE_BUTTON_BY_TITLE, addTitle);
        clickToElement(driver, AddressMyAccountUserPageUI.DYNAMIC_DELETE_BUTTON_BY_TITLE, addTitle);
    }

    public boolean isNoAddressMsgDisplayed() {
       return isElementDisplayed(driver, AddressMyAccountUserPageUI.NO_ADDRESS_FIELD);
    }
}
