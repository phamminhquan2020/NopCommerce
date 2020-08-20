package pageObjects;

import commonFunctions.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.CustomerCreateAdminPageUI;

public class CustomerCreateAdminPageObject extends AbstractPage {
    private WebDriver driver;

    public CustomerCreateAdminPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void inputToEmailTextbox(String email) {
        waitElementVisible(driver, CustomerCreateAdminPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, CustomerCreateAdminPageUI.EMAIL_TEXTBOX, email);
    }

    public void inputToPasswordTextbox(String password) {
        waitElementVisible(driver, CustomerCreateAdminPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, CustomerCreateAdminPageUI.PASSWORD_TEXTBOX, password);
    }

    public void inputToFirstNameTextbox(String firstName) {
        waitElementVisible(driver, CustomerCreateAdminPageUI.FIRSTNAME_TEXTBOX);
        sendkeyToElement(driver, CustomerCreateAdminPageUI.FIRSTNAME_TEXTBOX, firstName);
    }

    public void inputToLastNameTextbox(String lastName) {
        waitElementVisible(driver, CustomerCreateAdminPageUI.LASTNAME_TEXTBOX);
        sendkeyToElement(driver, CustomerCreateAdminPageUI.LASTNAME_TEXTBOX, lastName);
    }

    public void clickToMaleRadio() {
        waitElementClickable(driver, CustomerCreateAdminPageUI.GENDER_MALE_RADIO);
        clickToElement(driver, CustomerCreateAdminPageUI.GENDER_MALE_RADIO);
    }

    public void inputToDayOfBirthTextbox(String dob) {
        waitElementVisible(driver, CustomerCreateAdminPageUI.DOB_TEXTBOX);
        sendkeyToElement(driver, CustomerCreateAdminPageUI.DOB_TEXTBOX, dob);
    }

    public void inputToCompanyNameTextbox(String companyName) {
        waitElementVisible(driver, CustomerCreateAdminPageUI.COMPANY_NAME_TEXTBOX);
        sendkeyToElement(driver, CustomerCreateAdminPageUI.COMPANY_NAME_TEXTBOX, companyName);
    }

    public void checkToIsTaxExemptCheckbox() {
        waitElementClickable(driver, CustomerCreateAdminPageUI.IS_TAX_CHECKBOX);
        checkToCheckBox(driver, CustomerCreateAdminPageUI.IS_TAX_CHECKBOX);
    }

    public void selectManagerOfVendorDropdown(String vendorName) {
        waitElementVisible(driver, CustomerCreateAdminPageUI.MANAGER_OF_VENDOR_DROPDOWN);
        selectOptionInDropdown(driver, CustomerCreateAdminPageUI.MANAGER_OF_VENDOR_DROPDOWN, vendorName);
    }

    public void checkToActiveCheckbox() {
        waitElementClickable(driver, CustomerCreateAdminPageUI.ACTIVE_CHECKBOX);
        checkToCheckBox(driver, CustomerCreateAdminPageUI.ACTIVE_CHECKBOX);
    }

    public void inputToAdminComment(String adminComment) {
        waitElementVisible(driver, CustomerCreateAdminPageUI.ADMIN_COMMENT);
        sendkeyToElement(driver, CustomerCreateAdminPageUI.ADMIN_COMMENT, adminComment);
    }

    public void clickToSaveAndContinueEditButton() {
        waitElementClickable(driver, CustomerCreateAdminPageUI.SAVE_AND_CONTINUE_BUTTON);
        clickToElement(driver, CustomerCreateAdminPageUI.SAVE_AND_CONTINUE_BUTTON);
    }

    public void selectNewsletterMultiSelectDropdown(String storeNames) {
        waitElementVisible(driver, CustomerCreateAdminPageUI.NEWSLETTER_DROPDOWN);
        selectItemInCustomDropdown(driver, CustomerCreateAdminPageUI.NEWSLETTER_DROPDOWN, CustomerCreateAdminPageUI.NEWSLETTER_OPTIONS, storeNames);
    }

    public void selectCustomerRolesMultiSelectDropdown(String roleNames) {
        waitElementVisible(driver, CustomerCreateAdminPageUI.CUSTOMER_ROLES_DROPDOWN);
        selectItemInCustomDropdown(driver, CustomerCreateAdminPageUI.CUSTOMER_ROLES_DROPDOWN, CustomerCreateAdminPageUI.CUSTOMER_OPTIONS, roleNames);
    }
}
