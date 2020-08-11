package commonUIs;

public class UserAbstractPageUI {
    public static final String REGISTER_LINK = "//a[@class='ico-register']";
    public static final String LOGIN_LINK = "//a[@class='ico-login']";
    public static final String LOGOUT_LINK = "//a[@class='ico-logout']";
    public static final String MY_ACCOUNT_LINK = "//a[@class='ico-account']";
    public static final String WISH_LIST_LINK = "//span[@class='wishlist-label']";
    public static final String DYNAMIC_MY_ACCOUNT_MENU = "//div[contains(@class,'block-account-navigation')]//li/a[contains(text(),'%s')]";
    public static final String DYNAMIC_PRODUCT_IMAGE_BY_TITLE = "//a[contains(text(),'%s')]/parent::h2/parent::div/preceding-sibling::div";
    public static final String SEARCH_LINK = "//div[@class='footer']//a[contains(text(),'Search')]";
    public static final String DYNAMIC_MENU_BY_NAME = "//div[@class='header-menu']/ul[contains(@class, 'notmobile')]/li/a[contains(text(), '%s')]";
    public static final String DYNAMIC_SUB_MENU_BY_NAME = "//div[@class='header-menu']/ul[contains(@class, 'notmobile')]/li/a[contains(text(), '%s')]/following-sibling::ul//a[contains(text(), '%s')]";
    public static final String LOADING_ICON = "//div[@class='ajax-loading-block-window']";
    public static final String NOTIFICATION_MSG = "//div[@id='bar-notification']//p";
    public static final String CLOSE_ICON = "//div[@id='bar-notification']//span[@class='close']";
    public static final String CART_ROW = "//table[@class='cart']/tbody/tr";
    public static final String DYNAMIC_DATA_CELL = "//tbody//tr[%s]/td[%s]/span";
}
