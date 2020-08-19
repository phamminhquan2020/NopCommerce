package driverFactory;

import commonFunctions.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

public class FirefoxDriverManager extends BrowserDriverManager {
Dimension dimension;
    @Override
    protected void createDriver() {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, System.getProperty("user.dir") + "\\browserLog\\FirefoxLog.txt");
        FirefoxProfile profile = new FirefoxProfile();
        FirefoxOptions options = new FirefoxOptions();
        String path = GlobalConstants.EXTENSION_FOLDER + "/ggtraslate.xpi";
        File file = new File(path);
        profile.addExtension(file);
        profile.setPreference("font.language.group", "x-unicode");
        profile.setPreference("intl.accept_languages", "vi-vn, vi, en-us, en");
        options.setProfile(profile);
        options.addPreference("font.language.group", "x-unicode");
        options.addPreference("intl.accept_languages", "vi-vn, vi, en-us, en");
        //bug hover of firefox (can not hover twice), add below line to workaround
        options.setCapability("moz:useNonSpecCompliantPointerOrigin", true);

        System.out.println("Run by: " + System.getProperty("user.name"));
        if (System.getProperty("user.name").contains("LeoAzureVirtual")) {
            options.setHeadless(true);
            options.addArguments("--width=1920");
            options.addArguments("--height=1080");
//            options.addArguments("--window-size").addArguments("1920,1080");
        }
        driver = new FirefoxDriver(options);

    }

}
