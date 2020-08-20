package driverFactory;

import commonFunctions.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.*;

public class ChromeDriverManager extends BrowserDriverManager {

    @Override
    protected void createDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        List<String> args = new ArrayList<String>();
        String path = GlobalConstants.EXTENSION_FOLDER + "/chroPath.crx";
        File file = new File(path);

        options.addExtensions(file);

        args.add("--disable-notifications");
        args.add("--disable-geolocation");
        //args.add("--disable-extensions");
        args.add("-lang=vi");
        args.add("--no-sandbox");
        options.addArguments(args);


        System.setProperty("webdriver.chrome.args", "--disable-logging");
        System.setProperty("webdriver.chrome.silentOutput", "true");

        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("prefs", prefs);
        if (System.getProperty("user.name").contains("LeoAzureVirtual")) {
            options.addArguments("-headless");
        }
        System.out.println("Run by: " + System.getProperty("user.name"));
        driver = new ChromeDriver(options);
    }

}
