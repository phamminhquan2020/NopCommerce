package pageUIs;

public class WishListUserPageUI {
public static final String SHARE_LINK_LINK = "//a[@class='share-link']";
    public static final String WISHLIST_TITLE = "//div[@class='page-title']";
    public static final String DYNAMIC_SKU_BY_ROW = "//tbody/tr[%s]//span[@class='sku-number']";
    public static final String DYNAMIC_PRODUCT_NAME_BY_ROW = "//tbody/tr[%s]//a[@class='product-name']";
    public static final String DYNAMIC_PRICE_BY_ROW = "//tbody/tr[%s]//span[@class='product-unit-price']";
    public static final String DYNAMIC_ADD_TO_CART_CHECKBOX_BY_ROW = "//tbody/tr[%s]//input[@name='addtocart']";
    public static final String ADD_TO_CART_BUTTON = "//input[@name='addtocartbutton']";
    public static final String DYNAMIC_REMOVE_CHECKBOX_BY_ROW = "//tbody/tr[%s]//input[@name='removefromcart']";
    public static final String UPDATE_WISHLIST_BUTTON = "//input[@name='updatecart']";
    public static final String EMPTY_WISHLIST_MSG = "//div[@class='no-data' and contains(text(),'The wishlist is empty!')]";
}
