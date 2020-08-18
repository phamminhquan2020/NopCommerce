package pageObjects;

import commonFunctions.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginAdminPageUI;

public class LoginAdminPageObject extends AbstractPage {
    private WebDriver driver;

    public LoginAdminPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public WebDriver getDriver() {
        return this.driver;
    }

    public void inputToEmailTextbox(String adminEmail) {
        waitElementVisible(driver, LoginAdminPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, LoginAdminPageUI.EMAIL_TEXTBOX, adminEmail);
    }

    public void inputToPasswordTextbox(String adminPassword) {
        waitElementVisible(driver, LoginAdminPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginAdminPageUI.PASSWORD_TEXTBOX, adminPassword);
    }

    public void clickToLoginButton() {
        waitElementClickable(driver, LoginAdminPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginAdminPageUI.LOGIN_BUTTON);
    }
}
