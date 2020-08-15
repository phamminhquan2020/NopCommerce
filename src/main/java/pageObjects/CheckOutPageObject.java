package pageObjects;

import commonFunctions.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.CheckOutPageUI;

public class CheckOutPageObject extends AbstractPage {
    private WebDriver driver;

    public CheckOutPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCountryInDropdown(String country) {
        waitElementVisible(driver, CheckOutPageUI.COUNTRY_DROPDOWN);
        selectOptionInDropdown(driver, CheckOutPageUI.COUNTRY_DROPDOWN, country);
    }

    public void selectStateInDropdown(String state) {
        waitElementVisible(driver, CheckOutPageUI.STATE_DROPDOWN);
        selectOptionInDropdown(driver, CheckOutPageUI.STATE_DROPDOWN, state);
    }

    public void inputToCityTextBox(String city) {
        waitElementVisible(driver, CheckOutPageUI.CITY_TEXTBOX);
        sendkeyToElement(driver, CheckOutPageUI.CITY_TEXTBOX, city);
    }

    public void inputToAddress1TextBox(String address1) {
        waitElementVisible(driver, CheckOutPageUI.ADDRESS1_TEXTBOX);
        sendkeyToElement(driver, CheckOutPageUI.ADDRESS1_TEXTBOX, address1);
    }

    public void inputToZipcodeTextBox(String zipcode) {
        waitElementVisible(driver, CheckOutPageUI.ZIPCODE_TEXTBOX);
        sendkeyToElement(driver, CheckOutPageUI.ZIPCODE_TEXTBOX, zipcode);
    }

    public void inputToPhoneNumberTextBox(String phoneNumber) {
        waitElementVisible(driver, CheckOutPageUI.PHONE_NUMBER_TEXTBOX);
        sendkeyToElement(driver, CheckOutPageUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
    }

    public void clickToCoutinueBillingButton() {
        waitElementClickable(driver, CheckOutPageUI.CONTINUE_BUTTON_BILLING);
        clickToElement(driver, CheckOutPageUI.CONTINUE_BUTTON_BILLING);
    }

    public void waitForLoadingTextBillingDisappeared() {
        waitElementInvisible(driver, CheckOutPageUI.LOADING_NEXT_STEP_BILLING);
    }

    public void clickToShippingMethodRadio(String shippingMethod) {
        waitElementClickable(driver, CheckOutPageUI.DYNAMIC_SHIPPING_METHOD, shippingMethod);
        clickToElement(driver, CheckOutPageUI.DYNAMIC_SHIPPING_METHOD, shippingMethod);
    }

    public void clickToContinueShippingMethodButton() {
        waitElementClickable(driver, CheckOutPageUI.CONTINUE_BUTTON_SHIPPING_METHOD);
        clickToElement(driver, CheckOutPageUI.CONTINUE_BUTTON_SHIPPING_METHOD);
    }

    public void waitForLoadingTextShippingMethodDisappear() {
        waitElementInvisible(driver, CheckOutPageUI.LOADING_NEXT_STEP_SHIPPING_METHOD);
    }

    public void clickToDynamicPaymentMethod(String paymentMethod) {
        waitElementClickable(driver, CheckOutPageUI.DYNAMIC_PAYMENT_METHOD, paymentMethod);
        clickToElement(driver, CheckOutPageUI.DYNAMIC_PAYMENT_METHOD, paymentMethod);
    }

    public void clickToContinuePaymentMethodButton() {
        waitElementClickable(driver, CheckOutPageUI.CONTINUE_BUTTON_PAYMENT_METHOD);
        clickToElement(driver, CheckOutPageUI.CONTINUE_BUTTON_PAYMENT_METHOD);
    }

    public void waitForLoadingTextPaymentMethodDisappeared() {
        waitElementInvisible(driver, CheckOutPageUI.LOADING_NEXT_STEP_PAYMENT_METHOD);
    }

    public void clickToContinueButtonPaymentInfo() {
        waitElementClickable(driver, CheckOutPageUI.CONTINUE_BUTTON_PAYMENT_INFO);
        clickToElement(driver, CheckOutPageUI.CONTINUE_BUTTON_PAYMENT_INFO);
    }

    public void waitForLoadingNextStepPaymentInfoDisappeared() {
        waitElementInvisible(driver, CheckOutPageUI.LOADING_NEXT_STEP_PAYMENT_INFO);
    }

    public void clickToConfirmButton() {
        waitElementClickable(driver, CheckOutPageUI.CONFIRM_BUTTON);
        clickToElement(driver, CheckOutPageUI.CONFIRM_BUTTON);
    }

    public void waitForSubmittingOrderTextDisappeared() {
        waitElementInvisible(driver, CheckOutPageUI.SUBMITTING_ORDER_TEXT);
    }

    public void clickToContinueButtonCartSuccess() {
        waitElementClickable(driver, CheckOutPageUI.CONTINUE_BUTTON_SUCCESS);
        clickToElement(driver, CheckOutPageUI.CONTINUE_BUTTON_SUCCESS);
    }

    public void selectNewAddressIfAny() {
        try {
            if (isElementDisplayed(driver, CheckOutPageUI.ADDRESS_DROPDOWN)) {
                selectOptionInDropdown(driver, CheckOutPageUI.ADDRESS_DROPDOWN, "New Address");
            }
        } catch (Exception e) {
            System.out.println("Cannot select new address");
        }
    }

    public String getOrderID() {
        waitElementVisible(driver, CheckOutPageUI.ORDER_NUMBER);
        return getElementText(driver, CheckOutPageUI.ORDER_NUMBER);
    }
}
