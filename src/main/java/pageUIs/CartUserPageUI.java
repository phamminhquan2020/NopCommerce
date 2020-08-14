package pageUIs;

public class CartUserPageUI {

    public static final String DYNAMIC_SKU_BY_ROW = "//tbody/tr[%s]//span[@class='sku-number']";
    public static final String DYNAMIC_PRODUCT_NAME_BY_ROW = "//tbody/tr[%s]//a[@class='product-name']";
    public static final String DYNAMIC_PRICE_BY_ROW = "//tbody/tr[%s]//span[@class='product-unit-price']";
    public static final String EDIT_LINK = "//a[contains(text(),'Edit')]";
    public static final String REMOVE_CHECK_BOX = "//input[@name='removefromcart']";
    public static final String UPDATE_SHOPPING_CART_BUTTON = "//input[@name='updatecart']";
    public static final String EMPTY_CART_MESSAGE = "//div[@class='no-data' and contains(text(),'Your Shopping Cart is empty!')]";
    public static final String QTY_TEXTBOX = "//input[@class='qty-input']";
}
