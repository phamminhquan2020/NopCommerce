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

    public String getAddTitle() {
        waitElementVisible(driver, AddressMyAccountUserPageUI.TITLE_FIELD);
        return getElementText(driver, AddressMyAccountUserPageUI.TITLE_FIELD);
    }

    public String getAddFullName() {
        waitElementVisible(driver, AddressMyAccountUserPageUI.FULL_NAME_FIELD);
        return getElementText(driver, AddressMyAccountUserPageUI.FULL_NAME_FIELD);
    }

    public String getAddEmail() {
        waitElementVisible(driver, AddressMyAccountUserPageUI.EMAIL_FIELD);
        return getElementText(driver, AddressMyAccountUserPageUI.EMAIL_FIELD);
    }

    public String getAddPhone() {
        waitElementVisible(driver, AddressMyAccountUserPageUI.PHONE_FIELD);
        return getElementText(driver, AddressMyAccountUserPageUI.PHONE_FIELD);
    }

    public String getAddFax() {
        waitElementVisible(driver, AddressMyAccountUserPageUI.FAX_FIELD);
        return getElementText(driver, AddressMyAccountUserPageUI.FAX_FIELD);
    }

    public String getAddCompany() {
        waitElementVisible(driver, AddressMyAccountUserPageUI.COMPANY_FIELD);
        return getElementText(driver, AddressMyAccountUserPageUI.COMPANY_FIELD);
    }

    public String getAddAddress1() {
        waitElementVisible(driver, AddressMyAccountUserPageUI.ADDRESS1_FIELD);
        return getElementText(driver, AddressMyAccountUserPageUI.ADDRESS1_FIELD);
    }

    public String getAddCityStateZip() {
        waitElementVisible(driver, AddressMyAccountUserPageUI.CITY_STATE_ZIP_FIELD);
        return getElementText(driver, AddressMyAccountUserPageUI.CITY_STATE_ZIP_FIELD);
    }

    public String getAddCountry() {
        waitElementVisible(driver, AddressMyAccountUserPageUI.COUNTRY_FIELD);
        return getElementText(driver, AddressMyAccountUserPageUI.COUNTRY_FIELD);
    }

    public void clickToDeleteButton() {
        waitElementClickable(driver, AddressMyAccountUserPageUI.DELETE_BUTTON);
        clickToElement(driver, AddressMyAccountUserPageUI.DELETE_BUTTON);
    }

    public boolean isNoAddressMsgDisplayed() {
       return isElementDisplayed(driver, AddressMyAccountUserPageUI.NO_ADDRESS_FIELD);
    }
}
