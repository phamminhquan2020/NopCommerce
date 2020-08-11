package pageObjects;

import commonFunctions.AbstractPage;
import commonUIs.UserAbstractPageUI;
import org.openqa.selenium.WebDriver;
import pageUIs.WishListUserPageUI;

public class CartUserPageObject extends AbstractPage {
    private WebDriver driver;

    public CartUserPageObject(WebDriver driver) {
        this.driver = driver;
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

}
