package pageObjects;

import commonFunctions.AbstractPage;
import commonUIs.UserAbstractPageUI;
import org.openqa.selenium.WebDriver;
import pageUIs.WishListUserPageUI;

public class WishListUserPageObject extends AbstractPage {
    private WebDriver driver;

    public WishListUserPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOnlyOnceProductInWishList() {
        return finds(driver, UserAbstractPageUI.CART_ROW).size() == 1;
    }

    public boolean isProductInfoDisplayedCorrectly(String sku, String product, String price) {
        boolean isCorrectSKU = getDataByColumnNameAndRow(driver, "SKU", "1").equals(sku);
        boolean isCorrectProduct = getDataByColumnNameAndRow(driver, "Product(s)", "1").equals(product);
        boolean isCorrectPrice = getDataByColumnNameAndRow(driver, "Price", "1").equals(price);

        return isCorrectSKU && isCorrectProduct && isCorrectPrice;
    }

    public void clickToShareLink() {
        waitElementClickable(driver, WishListUserPageUI.SHARE_LINK_LINK);
        clickToElement(driver, WishListUserPageUI.SHARE_LINK_LINK);
    }

    public String getWishListTitle() {
        waitElementVisible(driver, WishListUserPageUI.WISHLIST_TITLE);
        return getElementText(driver, WishListUserPageUI.WISHLIST_TITLE);
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
