package pageUIs;

public class CustomerListAdminPageUI {
    public static final String ADD_NEW_BUTTON = "//div[@class='pull-right']/a";
    public static final String SEARCH_BUTTON = "//button[@id='search-customers']";
    public static final String EMAIL_TEXTBOX = "//input[@id='SearchEmail']";
    public static final String ALL_ROWS_IN_LIST = "//table[@id='customers-grid']//tbody/tr";
    public static final String EMPTY_DATA_MESSAGE = "//td[@class='dataTables_empty' and text()='No data available in table']";
    public static final String FIRST_NAME_TEXTBOX = "//input[@id='SearchFirstName']";
    public static final String LAST_NAME_TEXTBOX = "//input[@id='SearchLastName']";
    public static final String COMPANY_NAME_TEXTBOX = "//input[@id='SearchCompany']";
    public static final String MONTH_DROPDOWN = "//select[@id='SearchMonthOfBirth']";
    public static final String DAY_DROPDOWN = "//select[@id='SearchDayOfBirth']";
}
