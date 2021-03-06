package pageObjects;

import commonFunctions.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterUserPageUI;

public class RegisterUserPageObject extends AbstractPage {
    private WebDriver driver;

    public RegisterUserPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public WebDriver getDriver() {
        return this.driver;
    }

    public void clickMaleGender() {
        //waitElementClickable(driver, RegisterUserPageUI.GENDER_MALE_RADIO);
        clickToElement(driver, RegisterUserPageUI.GENDER_MALE_RADIO);

    }

    public void inputFirstName(String firstname) {
        //waitElementVisible(driver, RegisterUserPageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, RegisterUserPageUI.FIRST_NAME_TEXTBOX, firstname);

    }

    public void inputLastName(String lastname) {
        //waitElementVisible(driver, RegisterUserPageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, RegisterUserPageUI.LAST_NAME_TEXTBOX, lastname);

    }

    public void selectDay(String day) {
       // waitElementVisible(driver, RegisterUserPageUI.DAY_DROPDOWN);
        selectOptionInDropdown(driver, RegisterUserPageUI.DAY_DROPDOWN, day);
    }

    public void selectMonth(String month) {
       // waitElementVisible(driver, RegisterUserPageUI.MONTH_DROPDOWN);
        selectOptionInDropdown(driver, RegisterUserPageUI.MONTH_DROPDOWN, month);
    }

    public void selectYear(String year) {
       // waitElementVisible(driver, RegisterUserPageUI.YEAR_DROPDOWN);
        selectOptionInDropdown(driver, RegisterUserPageUI.YEAR_DROPDOWN, year);
    }

    public void inputEmail(String email) {
        //waitElementVisible(driver, RegisterUserPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, RegisterUserPageUI.EMAIL_TEXTBOX, email);
    }

    public void inputCompanyName(String companyName) {
        //waitElementVisible(driver, RegisterUserPageUI.COMPANY_TEXTBOX);
        sendkeyToElement(driver, RegisterUserPageUI.COMPANY_TEXTBOX, companyName);
    }

    public void inputPassword(String password) {
        //waitElementVisible(driver, RegisterUserPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, RegisterUserPageUI.PASSWORD_TEXTBOX, password);
    }

    public void inputConfirmPassword(String password) {
        //waitElementVisible(driver, RegisterUserPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, RegisterUserPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
    }

    public void clickRegisterButton() {
        //waitElementClickable(driver, RegisterUserPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterUserPageUI.REGISTER_BUTTON);
    }

    public String getFirstNameRequiredErrorMsg() {
        //waitElementVisible(driver, RegisterUserPageUI.FIRST_NAME_REQUIRED_ERROR_MSG);
        return getElementText(driver, RegisterUserPageUI.FIRST_NAME_REQUIRED_ERROR_MSG);
    }

    public String getLastNameRequiredErrorMsg() {
        //waitElementVisible(driver, RegisterUserPageUI.LAST_NAME_REQUIRED_ERROR_MSG);
        return getElementText(driver, RegisterUserPageUI.LAST_NAME_REQUIRED_ERROR_MSG);
    }

    public String getEmailErrorMsg() {
        //waitElementVisible(driver, RegisterUserPageUI.EMAIL_ERROR_MSG);
        return getElementText(driver, RegisterUserPageUI.EMAIL_ERROR_MSG);
    }

    public String getPasswordErrorMsg() {
       // waitElementVisible(driver, RegisterUserPageUI.PASSWORD_REQUIRED_ERROR_MSG);
        return getElementText(driver, RegisterUserPageUI.PASSWORD_REQUIRED_ERROR_MSG);
    }

    public String getConfirmPasswordErrorMsg() {
        waitElementVisible(driver, RegisterUserPageUI.CONFIRM_PASSWORD_REQUIRED_ERROR_MSG);
        return getElementText(driver, RegisterUserPageUI.CONFIRM_PASSWORD_REQUIRED_ERROR_MSG);
    }

    public String getSuccessMsg() {
        waitElementVisible(driver, RegisterUserPageUI.SUCCESS_MSG);
       return getElementText(driver, RegisterUserPageUI.SUCCESS_MSG);
    }

    public void clickContinueButton() {
        waitElementClickable(driver, RegisterUserPageUI.CONTINUE_BUTTON);
        clickToElement(driver, RegisterUserPageUI.CONTINUE_BUTTON);
    }

    public boolean isEmailAlreadyExistMsgDisplayed() {
        return isElementDisplayed(driver, RegisterUserPageUI.EMAIL_ALREADY_EXIST_MSG);
    }
}

