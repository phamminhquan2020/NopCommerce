package commonUIs;

public class AdminAbstractPageUI {
    public static final String DYNAMIC_LEVEL_1_MENU = "//span[text()='%s']/preceding-sibling::span";
    public static final String DYNAMIC_LEVEL_2_MENU = "//span[text()='%s']/parent::a/following-sibling::a/span[text()='%s']";
    public static final String LOG_OUT_BUTTON = "//a[contains(@href,'logout')]";

}
