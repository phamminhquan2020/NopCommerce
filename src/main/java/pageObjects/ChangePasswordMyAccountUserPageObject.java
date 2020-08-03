package pageObjects;

import commonFunctions.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.ChangePasswordMyAccountUserPageUI;

public class ChangePasswordMyAccountUserPageObject extends AbstractPage {
    private WebDriver driver;

    public ChangePasswordMyAccountUserPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputOldPassword(String userPassword) {
        waitElementVisible(driver, ChangePasswordMyAccountUserPageUI.OLD_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, ChangePasswordMyAccountUserPageUI.OLD_PASSWORD_TEXTBOX, userPassword);
    }

    public void inputNewPassword(String changedUserPassword) {
        waitElementVisible(driver, ChangePasswordMyAccountUserPageUI.NEW_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, ChangePasswordMyAccountUserPageUI.NEW_PASSWORD_TEXTBOX, changedUserPassword);
    }

    public void inputConfirmNewPassword(String changedUserPassword) {
        waitElementVisible(driver, ChangePasswordMyAccountUserPageUI.CONFIRM_NEW_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, ChangePasswordMyAccountUserPageUI.CONFIRM_NEW_PASSWORD_TEXTBOX, changedUserPassword);
    }

    public void clickChangePasswordButton() {
        waitElementClickable(driver, ChangePasswordMyAccountUserPageUI.CHANGE_PASSWORD_BUTTON);
        clickToElement(driver, ChangePasswordMyAccountUserPageUI.CHANGE_PASSWORD_BUTTON);
    }

    public String getResultMsg() {
        waitElementVisible(driver, ChangePasswordMyAccountUserPageUI.RESULT_MSG);
        return getElementText(driver, ChangePasswordMyAccountUserPageUI.RESULT_MSG);

    }
}
