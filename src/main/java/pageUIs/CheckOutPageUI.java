package pageUIs;

public class CheckOutPageUI {
    public static final String COUNTRY_DROPDOWN = "//select[@id='BillingNewAddress_CountryId']";
    public static final String STATE_DROPDOWN = "//select[@id='BillingNewAddress_StateProvinceId']";
    public static final String CITY_TEXTBOX = "//input[@id='BillingNewAddress_City']";
    public static final String ADDRESS1_TEXTBOX = "//input[@id='BillingNewAddress_Address1']";
    public static final String ZIPCODE_TEXTBOX = "//input[@id='BillingNewAddress_ZipPostalCode']";
    public static final String PHONE_NUMBER_TEXTBOX = "//input[@id='BillingNewAddress_PhoneNumber']";
    public static final String BILLING_CONTINUE_BUTTON = "//div[@id='billing-buttons-container']//input[@value='Continue']";
    public static final String DYNAMIC_SHIPPING_METHOD = "//label[contains(text(),'%s')]";
    public static final String SHIPPING_METHOD_CONTINUE_BUTTON = "//div[@id='shipping-method-buttons-container']//input[@value='Continue']";
    public static final String LOADING_NEXT_STEP_BILLING = "//div[@id='billing-buttons-container']//span[text()='Loading next step...']";
}
