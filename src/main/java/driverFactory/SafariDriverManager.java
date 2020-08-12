package driverFactory;

import org.openqa.selenium.safari.SafariDriver;

public class SafariDriverManager extends BrowserDriverManager {

    @Override
    protected void createDriver() {
/*
        SafariOptions options = new SafariOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        List<String> args = new ArrayList<String>() ;

        args.add("--disable-notifications");
        args.add("--disable-geolocation");
        args.add("--disable-extensions");
        args.add("-lang=vi");



        System.setProperty("webdriver.chrome.args", "--disable-logging");
        System.setProperty("webdriver.chrome.silentOutput", "true");

        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
*/

//        options.addArguments("-headless");
//        options.addArguments("window-size=1920,1080");

        driver = new SafariDriver();
    }

}
