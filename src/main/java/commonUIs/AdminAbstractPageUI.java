package commonUIs;

public class AdminAbstractPageUI {
    public static final String DYNAMIC_MENU_BY_NAME = "//ul[contains(@class, 'sidebar-menu')]/li/a/span[contains(text(), '%s')]";
    public static final String DYNAMIC_SUB_MENU_BY_NAME = "//span[text()='%s']/parent::a/following-sibling::ul/li/a/span[text()='%s']";
    public static final String LOADING_ICON_AJAX = "//div[@id='ajaxBusy']";
}
