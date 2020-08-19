package pageUIs;

public class AddressMyAccountUserPageUI {
    public static final String ADD_NEW_BUTTON = "//input[@value='Add new']";
    public static final String FIRST_NAME_TEXTBOX = "//input[@id='Address_FirstName']";
    public static final String LAST_NAME_TEXTBOX = "//input[@id='Address_LastName']";
    public static final String EMAIL_TEXTBOX = "//input[@id='Address_Email']";
    public static final String COMPANY_TEXTBOX = "//input[@id='Address_Company']";
    public static final String COUNTRY_DROPDOWN = "//select[@id='Address_CountryId']";
    public static final String STATE_DROPDOWN = "//select[@id='Address_StateProvinceId']";
    public static final String CITY_TEXTBOX = "//input[@id='Address_City']";
    public static final String ADDRESS1_TEXTBOX = "//input[@id='Address_Address1']";
    public static final String ADDRESS2_TEXTBOX = "//input[@id='Address_Address2']";
    public static final String ZIPCODE_TEXTBOX = "//input[@id='Address_ZipPostalCode']";
    public static final String PHONE_TEXTBOX = "//input[@id='Address_PhoneNumber']";
    public static final String FAX_TEXTBOX = "//input[@id='Address_FaxNumber']";
    public static final String SAVE_BUTTON = "//input[@value='Save']";

    public static final String DYNAMIC_TITLE_FIELD = "//div[@class='address-list']//div[@class='title']/strong[text()='%s']";
    public static final String DYNAMIC_FULL_NAME_FIELD_BY_TITLE = "//strong[text()='%s']/parent::div/following-sibling::ul/li[@class='name']";
    public static final String DYNAMIC_EMAIL_FIELD_BY_TITLE = "//strong[text()='%s']/parent::div/following-sibling::ul/li[@class='email']";
    public static final String DYNAMIC_PHONE_FIELD_BY_TITLE = "//strong[text()='%s']/parent::div/following-sibling::ul/li[@class='phone']";
    public static final String DYNAMIC_FAX_FIELD_BY_TITLE = "//strong[text()='%s']/parent::div/following-sibling::ul/li[@class='fax']";
    public static final String DYNAMIC_COMPANY_FIELD_BY_TITLE = "//strong[text()='%s']/parent::div/following-sibling::ul/li[@class='company']";
    public static final String DYNAMIC_ADDRESS1_FIELD_BY_TITLE = "//strong[text()='%s']/parent::div/following-sibling::ul/li[@class='address1']";
    public static final String DYNAMIC_CITY_STATE_ZIP_FIELD_BY_TITLE = "//strong[text()='%s']/parent::div/following-sibling::ul/li[@class='city-state-zip']";
    public static final String DYNAMIC_COUNTRY_FIELD_BY_TITLE = "//strong[text()='%s']/parent::div/following-sibling::ul/li[@class='country']";
    public static final String DYNAMIC_DELETE_BUTTON_BY_TITLE = "//strong[text()='%s']/parent::div/following-sibling::div/input[@value='Delete']";
    public static final String NO_ADDRESS_FIELD = "//div[text()='No addresses']";

}
