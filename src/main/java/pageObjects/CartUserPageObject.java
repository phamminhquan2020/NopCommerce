package pageObjects;

import commonFunctions.AbstractPage;
import commonUIs.UserAbstractPageUI;
import org.openqa.selenium.WebDriver;
import pageUIs.CartUserPageUI;
import pageUIs.WishListUserPageUI;

public class CartUserPageObject extends AbstractPage {
    private WebDriver driver;

    public CartUserPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public boolean isOnlyOnceProductInCart() {
        return finds(driver, UserAbstractPageUI.CART_ROW).size() == 1;
    }

    public String getSKUByRow(String rowNumber) {
        waitElementVisible(driver, WishListUserPageUI.DYNAMIC_SKU_BY_ROW, rowNumber);
        return getElementText(driver, WishListUserPageUI.DYNAMIC_SKU_BY_ROW, rowNumber);
    }

    public String getProductNameByRow(String rowNumber) {
        waitElementVisible(driver, WishListUserPageUI.DYNAMIC_PRODUCT_NAME_BY_ROW, rowNumber);
        return getElementText(driver, WishListUserPageUI.DYNAMIC_PRODUCT_NAME_BY_ROW, rowNumber);
    }

    public Object getPriceByRow(String rowNumber) {
        waitElementVisible(driver, WishListUserPageUI.DYNAMIC_PRICE_BY_ROW, rowNumber);
        return getElementText(driver, WishListUserPageUI.DYNAMIC_PRICE_BY_ROW, rowNumber);
    }

    public void clickToEditLink() {
        waitElementClickable(driver, CartUserPageUI.EDIT_LINK);
        clickToElement(driver, CartUserPageUI.EDIT_LINK);
    }

    public void clickToRemoveCheckbox() {
        waitElementClickable(driver, CartUserPageUI.REMOVE_CHECK_BOX);
        clickToElement(driver, CartUserPageUI.REMOVE_CHECK_BOX);
    }

    public void clickToUpdateShoppingCartButton() {
        waitElementClickable(driver, CartUserPageUI.UPDATE_SHOPPING_CART_BUTTON);
        clickToElement(driver, CartUserPageUI.UPDATE_SHOPPING_CART_BUTTON);
    }

    public boolean isEmptyCartMessageDisplayed() {
        return isElementDisplayed(driver, CartUserPageUI.EMPTY_CART_MESSAGE);
    }

    public void inputQuantity(String qty) {
        waitElementVisible(driver, CartUserPageUI.QTY_TEXTBOX);
        sendkeyToElement(driver, CartUserPageUI.QTY_TEXTBOX, qty);
    }

    public void selectGiftWrappingDropdown(String giftWrapping) {
        waitElementVisible(driver, CartUserPageUI.GIFT_WRAPPING_DROPDOWN);
        selectOptionInDropdown(driver, CartUserPageUI.GIFT_WRAPPING_DROPDOWN, giftWrapping);
    }

    public void clickToEstimateShippingButton() {
        waitElementVisible(driver, CartUserPageUI.ESTIMATE_SHIPPING_BUTTON);
        clickToElement(driver, CartUserPageUI.ESTIMATE_SHIPPING_BUTTON);

    }

    public void selectCountryInDrropdown(String country) {
        waitElementVisible(driver, CartUserPageUI.COUNTRY_DROPDOWN);
        selectOptionInDropdown(driver, CartUserPageUI.COUNTRY_DROPDOWN, country);
    }

    public void selectStateInDropdown(String state) {
        waitElementVisible(driver, CartUserPageUI.STATE_DROPDOWN);
        selectOptionInDropdown(driver, CartUserPageUI.STATE_DROPDOWN, state);
    }

    public void inputToZipcodeTextbox(String zip) {
        waitElementVisible(driver, CartUserPageUI.ZIPCODE_TEXTBOX);
        sendkeyToElement(driver, CartUserPageUI.ZIPCODE_TEXTBOX, zip);
    }

    public void clickToShippingMethod(String shippingMethod) {
        waitElementVisible(driver, CartUserPageUI.DYNAMIC_METHOD_RADIO, shippingMethod);
        clickToElement(driver, CartUserPageUI.DYNAMIC_METHOD_RADIO, shippingMethod);
    }

    public void clickToApplyButton() {
        waitElementClickable(driver, CartUserPageUI.APPLY_BUTTON);
        clickToElement(driver, CartUserPageUI.APPLY_BUTTON);
    }

    public void clickToCheckOutButton() {
        waitElementClickable(driver, CartUserPageUI.CHECK_OUT_BUTTON);
        clickToElement(driver, CartUserPageUI.CHECK_OUT_BUTTON);
    }

    public void clickToTermOfServiceCheckbox() {
        waitElementClickable(driver, CartUserPageUI.TERM_OF_SERVICE_CHECKBOX);
        clickToElement(driver, CartUserPageUI.TERM_OF_SERVICE_CHECKBOX);
    }

    public Float getTotalValue() {
        waitElementVisible(driver, CartUserPageUI.TOTAL_PRICE_FIELD);
        return Float.parseFloat(getElementText(driver, CartUserPageUI.TOTAL_PRICE_FIELD).replace("$", "").replace(",", ""));

    }
}
