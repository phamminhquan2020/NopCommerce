package driverFactory;

public class DriverFactoryManager {
    private static BrowserDriverManager driverManager;

    public static BrowserDriverManager getDriverManager(String browserName) {
        switch (browserName) {
            case "chrome":
                driverManager = new ChromeDriverManager();
                break;
            case "firefox":
                driverManager = new FirefoxDriverManager();
                break;
            case "ie11":
                driverManager = new IE11DriverManager();
                break;
            case "edge":
                driverManager = new EdgeDriverManager();
            default:
                System.out.println("Browser name " + browserName + " is incorrect. Please check again");
                break;
        }
        return driverManager;
    }

}
