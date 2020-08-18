package pageObjects;

import commonFunctions.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginUserPageUI;

public class LoginUserPageObject extends AbstractPage {
    WebDriver driver;

    public LoginUserPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public WebDriver getDriver() {
        return this.driver;
    }
    public void clickToLoginButton() {
        waitElementClickable(driver, LoginUserPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginUserPageUI.LOGIN_BUTTON);
    }

    public String getEmailErrorMsg() {
        waitElementVisible(driver, LoginUserPageUI.EMAIL_ERROR_MSG);
        return getElementText(driver, LoginUserPageUI.EMAIL_ERROR_MSG);
    }

    public String getLoginErrorMsg() {
        waitElementVisible(driver, LoginUserPageUI.LOGIN_ERROR_MSG);
        return getElementText(driver, LoginUserPageUI.LOGIN_ERROR_MSG);
    }

    public void inputToEmailTextBox(String email) {
        waitElementVisible(driver, LoginUserPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, LoginUserPageUI.EMAIL_TEXTBOX, email);
    }

    public void inputToPasswordTextBox(String password) {
        waitElementVisible(driver, LoginUserPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginUserPageUI.PASSWORD_TEXTBOX, password);
    }
}
