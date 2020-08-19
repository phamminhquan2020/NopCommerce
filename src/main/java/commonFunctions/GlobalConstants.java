package commonFunctions;

public class GlobalConstants {

    public static final long LONG_TIME_OUT = 30;
    public static final long SHORT_TIME_OUT = 10;
    public static final long PAGE_STABLE_TIMEOUT = 2;

    public static final String UPLOAD_FOLDER = System.getProperty("user.dir") + "/upLoadFiles";
    public static final String EXTENSION_FOLDER = System.getProperty("user.dir") + "/browserExtensions";

    public static final String USER_URL = "https://demo.nopcommerce.com/";
    public static final String USER_EMAIL_CHROME = "leo2020chrome@gmail.com";
    public static final String USER_EMAIL_FIREFOX = "leo2020firefox@gmail.com";
    public static final String USER_PASSWORD = "12345678";
    public static final String CHANGED_USER_PASSWORD = "123456789";
    public static final String FIRST_NAME = "Automation";
    public static final String LAST_NAME = "FC";

    public static final String ADMIN_URL = "https://admin-demo.nopcommerce.com/login?ReturnUrl=/admin/";
    public static final String ADMIN_EMAIL = "admin@yourstore.com";
    public static final String ADMIN_PASSWORD = "admin";

    public static String getUserEmail(String browser) {
        String userEmail;
        switch (browser) {
            case "chrome":
                userEmail = USER_EMAIL_CHROME;
                break;
            case "firefox":
                userEmail = USER_EMAIL_FIREFOX;
                break;
            default:
                userEmail = USER_EMAIL_CHROME;
                break;
        }
        return userEmail;
    }
}
