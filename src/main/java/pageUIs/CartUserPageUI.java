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
    public static final String TERM_OF_SERVICE_CHECKBOX = "//input[@id='termsofservice']";
    public static final String GIFT_WRAPPING_DROPDOWN = "//label[contains(text(), 'Gift wrapping')]/parent::dt/following-sibling::dd/select";
    public static final String CHECK_OUT_BUTTON = "//button[@id='checkout']";
    public static final String ESTIMATE_SHIPPING_BUTTON = "//a[@id='open-estimate-shipping-popup']";
    public static final String COUNTRY_DROPDOWN = "//select[@id='CountryId']";
    public static final String STATE_DROPDOWN = "//select[@id='StateProvinceId']";
    public static final String ZIPCODE_TEXTBOX = "//input[@id='ZipPostalCode']";
    public static final String DYNAMIC_METHOD_DROPDOWN = "//div[contains(text(),'%s')]";
    public static final String APPLY_BUTTON = "//input[@value='Apply']";
    public static final String TOTAL_PRICE_FIELD = "//tr[@class='order-total']//span[@class='value-summary']/strong";


}
