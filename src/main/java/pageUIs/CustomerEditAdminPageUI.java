package pageUIs;

public class CustomerEditAdminPageUI  {
    public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
    public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
    public static final String FIRSTNAME_TEXTBOX = "//input[@id='FirstName']";
    public static final String LASTNAME_TEXTBOX = "//input[@id='LastName']";
    public static final String GENDER_MALE_RADIO = "//input[@id='Gender_Male']";
    public static final String GENDER_FEMALE_RADIO = "//input[@id='Gender_Female']";
    public static final String DOB_TEXTBOX = "//input[@id='DateOfBirth']";
    public static final String COMPANY_NAME_TEXTBOX = "//input[@id='Company']";
    public static final String IS_TAX_CHECKBOX = "//input[@id='IsTaxExempt']";
    public static final String NEWSLETTER_DROPDOWN = "//select[@id='SelectedNewsletterSubscriptionStoreIds']";
    public static final String CUSTOMER_ROLES_DROPDOWN = "//select[@id='SelectedCustomerRoleIds']";
    public static final String MANAGER_OF_VENDOR_DROPDOWN = "//select[@id='VendorId']";
    public static final String ACTIVE_CHECKBOX = "//input[@id='Active']";
    public static final String ADMIN_COMMENT = "//textarea[@id='AdminComment']";
    public static final String BACK_TO_CUSTOMER_LIST_LINK = "//a[contains(text(),'back to customer list')]";

    public static final String DYNAMIC_SELECTED_STORE_NAME = "//ul[@id='SelectedNewsletterSubscriptionStoreIds_taglist']/li/span[text()='%s']";
    public static final String DYNAMIC_SELECTED_ROLE_NAME = "//ul[@id='SelectedCustomerRoleIds_taglist']/li/span[text()='%s']";
}
