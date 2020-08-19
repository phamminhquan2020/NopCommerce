package commonUIs;

public class AdminAbstractPageUI {
    public static final String DYNAMIC_MENU_BY_NAME = "//ul[contains(@class, 'sidebar-menu')]/li/a/span[contains(text(), '%s')]";
    public static final String DYNAMIC_SUB_MENU_BY_NAME = "//span[text()='%s']/parent::a/following-sibling::ul/li/a/span[text()='%s']";
    public static final String LOADING_ICON_AJAX = "//div[@id='ajaxBusy']";
    public static final String ALERT_NOTIFICATION = "//div[contains(@class, 'alert')]";
    public static final String DYNAMIC_DELETE_ICON = "//span[text()='%s']/following-sibling::span";
    public static final String DYNAMIC_PAGINATION_PAGE_NUMBER = "//ul[@class='pagination']/li/a[text()= '%s']";
    public static final String PAGINATION_PREVIOUS_PAGE = "//li[@id='customers-grid_previous']";
    public static final String PAGINATION_NEXT_PAGE = "//li[@id='customers-grid_next']";

}
