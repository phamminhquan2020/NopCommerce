package pageUIs;

public class ProductListAdminPageUI {
    public static final String PRODUCT_NAME_TEXTBOX = "//input[@id='SearchProductName']";
    public static final String SEARCH_BUTTON = "//button[@id='search-products']";
    public static final String ALL_ROW_IN_TABLE = "//table[@id='products-grid']//tbody/tr";
    public static final String CATEGORY_DROPDOWN = "//select[@id='SearchCategoryId']";
    public static final String EMPTY_ROW_MESSAGE = "//table[@id='products-grid']//tbody/tr/td[text()='No data available in table']";
    public static final String SEARCH_SUBCATEGORY_CHECKBOX = "//input[@id='SearchIncludeSubCategories']";
    public static final String MANUFACTURER_DROPDOWN = "//select[@id='SearchManufacturerId']";
    public static final String GO_DIRECTLY_PRODUCT_SKU_TEXTBOX = "//input[@id='GoDirectlyToSku']";
    public static final String GO_DIRECTLY_PRODUCT_SKU_BUTTON = "//button[@id='go-to-product-by-sku']";
    public static final String DYNAMIC_SKU_BY_PRODUCT_NAME = "//td[text()='%s']/following-sibling::td[1]";
    public static final String DYNAMIC_PRICE_BY_PRODUCT_NAME = "//td[text()='%s']/following-sibling::td[2]";
    public static final String DYNAMIC_STOCK_BY_PRODUCT_NAME = "//td[text()='%s']/following-sibling::td[3]";
    public static final String DYNAMIC_PRODUCT_TYPE_BY_PRODUCT_NAME = "//td[text()='%s']/following-sibling::td[4]";
}
