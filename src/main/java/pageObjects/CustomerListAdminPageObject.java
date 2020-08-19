package pageObjects;

import commonFunctions.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.CustomerCreateAdminPageUI;
import pageUIs.CustomerListAdminPageUI;

public class CustomerListAdminPageObject extends AbstractPage {
    private WebDriver driver;

    public CustomerListAdminPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public WebDriver getDriver() {
        return this.driver;
    }

    public void clickToAddNewButton() {
        waitElementClickable(driver, CustomerListAdminPageUI.ADD_NEW_BUTTON);
        clickToElement(driver, CustomerListAdminPageUI.ADD_NEW_BUTTON);
    }

    public void clickToSearchButton() {
        waitElementClickable(driver, CustomerListAdminPageUI.SEARCH_BUTTON);
        clickToElement(driver, CustomerListAdminPageUI.SEARCH_BUTTON);
    }

    public void selectCustomerRolesMultiSelectDropdown(String roleNames) {
        waitElementVisible(driver, CustomerCreateAdminPageUI.CUSTOMER_ROLES_DROPDOWN);
        selectItemInCustomDropdown(driver, CustomerCreateAdminPageUI.CUSTOMER_ROLES_DROPDOWN, CustomerCreateAdminPageUI.CUSTOMER_OPTIONS, roleNames);
    }
}
