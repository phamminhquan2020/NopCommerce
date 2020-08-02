package pageObjects;

import commonFunctions.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.CustomerInfoMyAccountUserPageUI;

public class CustomerInfoMyAccountUserPageObject extends AbstractPage {
    private WebDriver driver;

    public CustomerInfoMyAccountUserPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToFemaleRadio() {
        waitElementClickable(driver, CustomerInfoMyAccountUserPageUI.FEMALE_RADIO);
        clickToElement(driver, CustomerInfoMyAccountUserPageUI.FEMALE_RADIO);
    }

    public void inputFirstName(String firstname) {
        waitElementVisible(driver, CustomerInfoMyAccountUserPageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, CustomerInfoMyAccountUserPageUI.FIRST_NAME_TEXTBOX, firstname);
    }

    public void inputLastName(String lastname) {
        waitElementVisible(driver, CustomerInfoMyAccountUserPageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, CustomerInfoMyAccountUserPageUI.LAST_NAME_TEXTBOX, lastname);
    }

    public void selectDayDropdown(String day) {
        waitElementVisible(driver, CustomerInfoMyAccountUserPageUI.DAY_DROPDOWN);
        selectOptionInDropdown(driver, CustomerInfoMyAccountUserPageUI.DAY_DROPDOWN, day);
    }

    public void selectMonthDropdown(String month) {
        waitElementVisible(driver, CustomerInfoMyAccountUserPageUI.MONTH_DROPDOWN);
        selectOptionInDropdown(driver, CustomerInfoMyAccountUserPageUI.MONTH_DROPDOWN, month);
    }

    public void selectYearDropdown(String year) {
        waitElementVisible(driver, CustomerInfoMyAccountUserPageUI.YEAR_DROPDOWN);
        selectOptionInDropdown(driver, CustomerInfoMyAccountUserPageUI.YEAR_DROPDOWN, year);
    }

    public void inputCompanyName(String company) {
        waitElementVisible(driver, CustomerInfoMyAccountUserPageUI.COMPANY_TEXTBOX);
        sendkeyToElement(driver, CustomerInfoMyAccountUserPageUI.COMPANY_TEXTBOX, company);
    }

    public void clickSaveButton() {
        waitElementClickable(driver, CustomerInfoMyAccountUserPageUI.SAVE_BUTTON);
        clickToElement(driver, CustomerInfoMyAccountUserPageUI.SAVE_BUTTON);
    }

    public boolean isFemaleChecked() {
        waitElementVisible(driver, CustomerInfoMyAccountUserPageUI.FEMALE_RADIO);
        return isElementSelected(driver, CustomerInfoMyAccountUserPageUI.FEMALE_RADIO);
    }

    public String getFirstName() {
        waitElementVisible(driver, CustomerInfoMyAccountUserPageUI.FIRST_NAME_TEXTBOX);
        return getElementTextByJS(driver, CustomerInfoMyAccountUserPageUI.FIRST_NAME_TEXTBOX);
    }

    public String getLastName() {
        waitElementVisible(driver, CustomerInfoMyAccountUserPageUI.LAST_NAME_TEXTBOX);
        return getElementTextByJS(driver, CustomerInfoMyAccountUserPageUI.LAST_NAME_TEXTBOX);
    }

    public String getDay() {
        waitElementVisible(driver, CustomerInfoMyAccountUserPageUI.DAY_DROPDOWN);
        return getSelectedItemInDropDown(driver, CustomerInfoMyAccountUserPageUI.DAY_DROPDOWN);
    }

    public String getMonth() {
        waitElementVisible(driver, CustomerInfoMyAccountUserPageUI.MONTH_DROPDOWN);
        return getSelectedItemInDropDown(driver, CustomerInfoMyAccountUserPageUI.MONTH_DROPDOWN);
    }

    public String getYear() {
        waitElementVisible(driver, CustomerInfoMyAccountUserPageUI.YEAR_DROPDOWN);
        return getSelectedItemInDropDown(driver, CustomerInfoMyAccountUserPageUI.YEAR_DROPDOWN);
    }

    public String getCompany() {
        waitElementVisible(driver, CustomerInfoMyAccountUserPageUI.COMPANY_TEXTBOX);
        return getElementTextByJS(driver, CustomerInfoMyAccountUserPageUI.COMPANY_TEXTBOX);
    }
}
