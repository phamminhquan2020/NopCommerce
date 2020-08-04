package pageUIs;

public class SearchUserPageUI {
    public static final String DYNAMIC_MENU_BY_NAME = "//div[contains(@class,'block-category-navigation')]//ul[@class='list']/li/a[contains(text(),'%s')]";
    public static final String DYNAMIC_SUB_MENU_BY_NAME = "//div[contains(@class,'block-category-navigation')]//ul[@class='list']/li/a[contains(text(),'%s')]/following-sibling::ul/li/a[contains(text(), '%s')]";
    public static final String SEARCH_BUTTON = "//div[@class='search-input']//input[@value='Search']";
    public static final String WARNING_MSG = "//div[@class='warning']";
    public static final String NO_RESULT_MSG = "//div[@class='no-result']";
    public static final String KEYWORD_TEXT_BOX = "//input[@id='q']";
    public static final String PRODUCT_TITLES = "//div[@class='item-box']//h2[@class='product-title']/a";
    public static final String ADVANCE_SEARCH_CHECKBOX = "//input[@id='adv']";
    public static final String PRICE_FROM_TEXTBOX = "//input[@id='pf']";
    public static final String PRICE_TO_TEXTBOX = "//input[@id='pt']";
    public static final String CATEGORY_DROPDOWN = "//select[@id='cid']";
    public static final String SUB_CATEGORY_CHECKBOX = "//input[@id='isc']";
    public static final String MANUFACTURER_DROPDOWN = "//select[@id='mid']";
}
