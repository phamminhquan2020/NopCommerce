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
    public static final String BILLING_INFO = "//div[@class='billing-info']//li";
    public static final String PAYMENT_METHOD_INFO = "//div[@class='payment-method-info']//li";
    public static final String SHIPPING_INFO = "//div[@class='shipping-info']//li";
    public static final String SHIPPING_METHOD_INFO = "//div[@class='shipping-method-info']//li";

    public static final String PRODUCT_NAME_CONFIRM = "//a[@class='product-name']";
    public static final String ORDER_TOTAL_CONFIRM = "//tr[@class='order-total']//span[@class='value-summary']/strong";

    public static final String CARD_TYPE_DROPDOWN = "//select[@id='CreditCardType']";
    public static final String CARD_HOLDER_NAME = "//input[@id='CardholderName']";
    public static final String CARD_NUMBER_TEXBOX = "//input[@id='CardNumber']";
    public static final String EXPIRE_MONTH_DROPDOWN = "//select[@id='ExpireMonth']";
    public static final String EXPIRE_YEAR_DROPDOWN = "//select[@id='ExpireYear']";
    public static final String CODE_TEXTBOX = "//input[@id='CardCode']";
}
