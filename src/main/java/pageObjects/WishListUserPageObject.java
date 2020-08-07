package pageObjects;

import commonFunctions.AbstractPage;
import commonUIs.UserAbstractPageUI;
import org.openqa.selenium.WebDriver;

public class WishListUserPageObject extends AbstractPage {
    private WebDriver driver;

    public WishListUserPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOnlyOnceProductInWishList() {
        return finds(driver, UserAbstractPageUI.CART_ROW).size() == 1;
    }

    public boolean isProductInfoDisplayedCorrectly(String sku, String product, String price) {
        getDataByColumnNameAndRow(driver, "SKU", "1");
        getDataByColumnNameAndRow(driver, "Product(s)", "1");
        getDataByColumnNameAndRow(driver, "Price", "1");

        return false;
    }

    public void clickToShareLink() {
        //todo
    }

    public Object getWishListTitle() {
        //todo
    }
}
