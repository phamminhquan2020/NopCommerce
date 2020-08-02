package pageObjects;

import commonFunctions.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterUserPageUI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterUserPageObject extends AbstractPage {
    private WebDriver driver;

    public RegisterUserPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMaleGender() {
        waitElementClickable(driver, RegisterUserPageUI.GENDER_MALE_RADIO);
        clickToElement(driver, RegisterUserPageUI.GENDER_MALE_RADIO);

    }

    public void inputFirstName(String firstname) {
        waitElementVisible(driver, RegisterUserPageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, RegisterUserPageUI.FIRST_NAME_TEXTBOX, firstname);

    }

    public void inputLastName(String lastname) {
        waitElementVisible(driver, RegisterUserPageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, RegisterUserPageUI.LAST_NAME_TEXTBOX, lastname);

    }

    public void selectDay(String day) {
        waitElementVisible(driver, RegisterUserPageUI.DAY_DROPDOWN);
        selectOptionInDropdown(driver, RegisterUserPageUI.DAY_DROPDOWN, day);
    }

    public void selectMonth(String month) {
        waitElementVisible(driver, RegisterUserPageUI.MONTH_DROPDOWN);
        selectOptionInDropdown(driver, RegisterUserPageUI.MONTH_DROPDOWN, month);
    }

    public void selectYear(String year) {
        waitElementVisible(driver, RegisterUserPageUI.YEAR_DROPDOWN);
        selectOptionInDropdown(driver, RegisterUserPageUI.YEAR_DROPDOWN, year);
    }

    public void inputEmail(String email) {
        waitElementVisible(driver, RegisterUserPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, RegisterUserPageUI.EMAIL_TEXTBOX, email);
    }

    public void inputCompanyName(String companyName) {
        waitElementVisible(driver, RegisterUserPageUI.COMPANY_TEXTBOX);
        sendkeyToElement(driver, RegisterUserPageUI.COMPANY_TEXTBOX, companyName);
    }

    public void inputPassword(String password) {
        waitElementVisible(driver, RegisterUserPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, RegisterUserPageUI.PASSWORD_TEXTBOX, password);
    }

    public void inputConfirmPassword(String password) {
        waitElementVisible(driver, RegisterUserPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, RegisterUserPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
    }

    public void clickRegisterButton() {
        //scrollToElement(driver, RegisterUserPageUI.REGISTER_BUTTON);
        waitElementClickable(driver, RegisterUserPageUI.REGISTER_BUTTON);
        //sleepInSecond(1);
        clickToElement(driver, RegisterUserPageUI.REGISTER_BUTTON);
    }

    public String getFirstNameRequiredErrorMsg() {
        waitElementVisible(driver, RegisterUserPageUI.FIRST_NAME_REQUIRED_ERROR_MSG);
        return getElementText(driver, RegisterUserPageUI.FIRST_NAME_REQUIRED_ERROR_MSG);
    }

    public String getLastNameRequiredErrorMsg() {
        waitElementVisible(driver, RegisterUserPageUI.LAST_NAME_REQUIRED_ERROR_MSG);
        return getElementText(driver, RegisterUserPageUI.LAST_NAME_REQUIRED_ERROR_MSG);
    }

    public String getEmailErrorMsg() {
        waitElementVisible(driver, RegisterUserPageUI.EMAIL_ERROR_MSG);
        return getElementText(driver, RegisterUserPageUI.EMAIL_ERROR_MSG);
    }

    public String getPasswordRequiredErrorMsg() {
        waitElementVisible(driver, RegisterUserPageUI.PASSWORD_REQUIRED_ERROR_MSG);
        return getElementText(driver, RegisterUserPageUI.PASSWORD_REQUIRED_ERROR_MSG);
    }

    public String getConfirmPasswordRequiredErrorMsg() {
        waitElementVisible(driver, RegisterUserPageUI.CONFIRM_PASSWORD_REQUIRED_ERROR_MSG);
        return getElementText(driver, RegisterUserPageUI.CONFIRM_PASSWORD_REQUIRED_ERROR_MSG);
    }

}

