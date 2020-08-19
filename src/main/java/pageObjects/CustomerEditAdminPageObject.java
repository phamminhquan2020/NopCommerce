package pageObjects;

import commonFunctions.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.CustomerEditAdminPageUI;

public class CustomerEditAdminPageObject extends AbstractPage {
    private WebDriver driver;

    public CustomerEditAdminPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public String getEmail() {
        waitElementVisible(driver, CustomerEditAdminPageUI.EMAIL_TEXTBOX);
        return getElementTextByJS(driver, CustomerEditAdminPageUI.EMAIL_TEXTBOX);
    }

    public String getFirstName() {
        waitElementVisible(driver, CustomerEditAdminPageUI.FIRSTNAME_TEXTBOX);
        return getElementTextByJS(driver, CustomerEditAdminPageUI.FIRSTNAME_TEXTBOX);
    }

    public String getLastName() {
        waitElementVisible(driver, CustomerEditAdminPageUI.LASTNAME_TEXTBOX);
        return getElementTextByJS(driver, CustomerEditAdminPageUI.LASTNAME_TEXTBOX);
    }

    public String getDayOfBirth() {
        waitElementVisible(driver, CustomerEditAdminPageUI.DOB_TEXTBOX);
        return getElementTextByJS(driver, CustomerEditAdminPageUI.DOB_TEXTBOX);
    }

    public String getCompanyName() {
        waitElementVisible(driver, CustomerEditAdminPageUI.COMPANY_NAME_TEXTBOX);
        return getElementTextByJS(driver, CustomerEditAdminPageUI.COMPANY_NAME_TEXTBOX);
    }

    public boolean isTaxExemptChecked() {
        return isElementSelected(driver, CustomerEditAdminPageUI.IS_TAX_CHECKBOX);
    }

    public String getSelectedVendor() {
        waitElementVisible(driver, CustomerEditAdminPageUI.MANAGER_OF_VENDOR_DROPDOWN);
        return getSelectedItemInDropDown(driver, CustomerEditAdminPageUI.MANAGER_OF_VENDOR_DROPDOWN);
    }

    public boolean isActiveChecked() {
        return isElementSelected(driver, CustomerEditAdminPageUI.ACTIVE_CHECKBOX);
    }

    public String getAminComment() {
        waitElementVisible(driver, CustomerEditAdminPageUI.ADMIN_COMMENT);
        return getElementTextByJS(driver, CustomerEditAdminPageUI.ADMIN_COMMENT);
    }

    public void clickToBackToCustomerListButton() {
        waitElementClickable(driver, CustomerEditAdminPageUI.BACK_TO_CUSTOMER_LIST_LINK);
        clickToElement(driver, CustomerEditAdminPageUI.BACK_TO_CUSTOMER_LIST_LINK);
    }

    public boolean isMaleGenderSelected() {
        return isElementSelected(driver, CustomerEditAdminPageUI.GENDER_MALE_RADIO);
    }


    public boolean isStoreNameSelected(String storeNames) {
        return isElementDisplayed(driver, CustomerEditAdminPageUI.DYNAMIC_SELECTED_STORE_NAME, storeNames);
    }

    public boolean isRoleNameSelected(String roleNames) {
        return isElementDisplayed(driver, CustomerEditAdminPageUI.DYNAMIC_SELECTED_ROLE_NAME, roleNames);
    }
}
