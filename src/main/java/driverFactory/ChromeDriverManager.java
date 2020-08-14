package driverFactory;

import commonFunctions.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChromeDriverManager extends BrowserDriverManager {

    @Override
    protected void createDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        List<String> args = new ArrayList<String>();
        String path = GlobalConstants.EXTENSION_FOLDER + "/extension_6_1_7_0.crx";
        File file = new File(path);

        options.addExtensions(file);

        args.add("--disable-notifications");
        args.add("--disable-geolocation");
        args.add("--disable-extensions");
        args.add("-lang=vi");
        options.addArguments(args);


        System.setProperty("webdriver.chrome.args", "--disable-logging");
        System.setProperty("webdriver.chrome.silentOutput", "true");

        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("prefs", prefs);
        //options.addArguments("-headless");
        //options.addArguments("window-size=1920,1080");
        System.out.println(System.getProperty("user.name"));
        if (System.getProperty("user.name")=="LeoAzureVirtual$") {
            options.addArguments("-headless");
            options.addArguments("window-size=1920,1080");
            System.out.println("Leo Azure");
        } else {
            System.out.println("run by normal user");
        }
        driver = new ChromeDriver(options);
    }

}
