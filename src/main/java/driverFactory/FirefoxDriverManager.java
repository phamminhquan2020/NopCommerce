package driverFactory;

import commonFunctions.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

public class FirefoxDriverManager extends BrowserDriverManager {

    @Override
    protected void createDriver() {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, System.getProperty("user.dir") + "\\browserLog\\FirefoxLog.txt");
        FirefoxProfile profile = new FirefoxProfile();
        String path = GlobalConstants.EXTENSION_FOLDER + "/ggtraslate.xpi";
        File file = new File(path);
        profile.addExtension(file);
        profile.setPreference("font.language.group", "x-unicode");
        profile.setPreference("intl.accept_languages", "vi-vn, vi, en-us, en");
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        options.addPreference("font.language.group", "x-unicode");
        options.addPreference("intl.accept_languages", "vi-vn, vi, en-us, en");
        //bug hover of firefox (can not hover twice), add below line to workaround
        options.setCapability("moz:useNonSpecCompliantPointerOrigin", true);
        if (System.getProperty("user.name").contains("LeoAzureVirtual")) {
            options.addArguments("-headless");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--width=1920");
            options.addArguments("--height=1080");
        }
        System.out.println("Run by: " + System.getProperty("user.name"));
        driver = new FirefoxDriver(options);

    }

}
