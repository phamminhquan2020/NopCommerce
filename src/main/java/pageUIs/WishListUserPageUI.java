package pageUIs;

public class WishListUserPageUI {
public static final String SHARE_LINK_LINK = "//a[@class='share-link']";
    public static final String WISHLIST_TITLE = "//div[@class='page-title']";
    public static final String DYNAMIC_SKU_BY_ROW = "//tbody/tr[%s]//span[@class='sku-number']";
    public static final String DYNAMIC_PRODUCT_NAME_BY_ROW = "//tbody/tr[%s]//a[@class='product-name']";
    public static final String DYNAMIC_PRICE_BY_ROW = "//tbody/tr[%s]//span[@class='product-unit-price']";
    public static final String DYNAMIC_ADD_TO_CART_CHECKBOX_BY_ROW = "//tbody/tr[1]//input[@name='addtocart']";
    public static final String ADD_TO_CART_BUTTON = "//input[@name='addtocartbutton']";
}
