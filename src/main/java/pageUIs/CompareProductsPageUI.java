package pageUIs;

public class CompareProductsPageUI {
    public static final String ALL_CELL_OF_FIRST_ROW = "//table[@class='compare-products-table']//tr[1]/td";
    public static final String DYNAMIC_CELL_BY_LABEL_AND_INDEX = "//label[text()='%s']/parent::td/following-sibling::td[%s]";
    public static final String INDEX_BY_NAME = "//a[text()='%s']/parent::td/preceding-sibling::td" ;
    public static final String DYNAMIC_REMOVE_BUTTON_BY_INDEX = "//tr[@class='remove-product']/td[%s]";
    public static final String CLEAR_LIST_BUTTON = "//a[@class='clear-list']";
    public static final String EMPTY_MESSAGE = "//div[@class='no-data' and text()='You have no items to compare.']";
}
