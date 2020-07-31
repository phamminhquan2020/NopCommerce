package driverFactory;

import java.io.File;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import commonFunctions.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

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
        FirefoxOptions option = new FirefoxOptions();
        option.setProfile(profile);
        option.addPreference("font.language.group", "x-unicode");
        option.addPreference("intl.accept_languages", "vi-vn, vi, en-us, en");
        driver = new FirefoxDriver(option);

    }

}
