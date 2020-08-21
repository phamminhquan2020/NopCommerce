package driverFactory;

public class DriverFactoryManager {
    private static BrowserDriverManager driverManager;

    public enum BrowserName {CHROME, FIREFOX, IE11, EDGE, SAFARI}

    public static BrowserDriverManager getDriverManager(String browserName) {
        BrowserName browser = BrowserName.valueOf(browserName.toUpperCase());
        switch (browser) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            case IE11:
                driverManager = new IE11DriverManager();
                break;
            case EDGE:
                driverManager = new EdgeDriverManager();
                break;
            case SAFARI:
                driverManager = new SafariDriverManager();
                break;
            default:
                System.out.println("Browser name " + browserName + " is incorrect. Please check again");
                break;
        }
        return driverManager;
    }

}
