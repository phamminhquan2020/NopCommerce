package pageUIs;

public class CheckOutPageUI {
    public static final String ADDRESS_DROPDOWN = "//select[@id='billing-address-select']";
    public static final String COUNTRY_DROPDOWN = "//select[@id='BillingNewAddress_CountryId']";
    public static final String STATE_DROPDOWN = "//select[@id='BillingNewAddress_StateProvinceId']";
    public static final String CITY_TEXTBOX = "//input[@id='BillingNewAddress_City']";
    public static final String ADDRESS1_TEXTBOX = "//input[@id='BillingNewAddress_Address1']";
    public static final String ZIPCODE_TEXTBOX = "//input[@id='BillingNewAddress_ZipPostalCode']";
    public static final String PHONE_NUMBER_TEXTBOX = "//input[@id='BillingNewAddress_PhoneNumber']";
    public static final String CONTINUE_BUTTON_BILLING = "//div[@id='billing-buttons-container']//input[@value='Continue']";
    public static final String LOADING_NEXT_STEP_BILLING = "//div[@id='billing-buttons-container']//span[text()='Loading next step...']";

    public static final String DYNAMIC_SHIPPING_METHOD = "//label[contains(text(),'%s')]";
    public static final String CONTINUE_BUTTON_SHIPPING_METHOD = "//div[@id='shipping-method-buttons-container']//input[@value='Continue']";
    public static final String LOADING_NEXT_STEP_SHIPPING_METHOD = "//div[@id='shipping-method-buttons-container']//span[text()='Loading next step...']";

    public static final String DYNAMIC_PAYMENT_METHOD = "//label[contains(text(),'%s')]";
    public static final String CONTINUE_BUTTON_PAYMENT_METHOD = "//div[@id='payment-method-buttons-container']//input[@value='Continue']";
    public static final String LOADING_NEXT_STEP_PAYMENT_METHOD = "//div[@id='payment-method-buttons-container']//span[text()='Loading next step...']";

    public static final String CONTINUE_BUTTON_PAYMENT_INFO = "//div[@id='payment-info-buttons-container']/input[@value='Continue']";
    public static final String LOADING_NEXT_STEP_PAYMENT_INFO = "//div[@id='payment-info-buttons-container']//span[text()='Loading next step...']";

    public static final String CONFIRM_BUTTON = "//input[@value='Confirm']";
    public static final String SUBMITTING_ORDER_TEXT = "//span[@id='confirm-order-please-wait']";
    public static final String THANK_YOU_MESSAGE = "//h1[contains(text(),'Thank you')]";
    public static final String SUCCESS_MESSAGE = "//div[@class='title']/strong[contains(text(), 'Your order has been successfully processed!')]";
    public static final String ORDER_NUMBER = "//div[@class='order-number']/strong";
    public static final String DETAIL_LINK = "//div[@class='details-link']";
    public static final String CONTINUE_BUTTON_SUCCESS = "//input[@value='Continue']";


    public static final String PAYMENT_INFO_TEXT = "//div[@class='info']//td";
}
