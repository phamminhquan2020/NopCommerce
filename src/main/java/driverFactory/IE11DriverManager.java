package driverFactory;

import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IE11DriverManager extends BrowserDriverManager {

    @Override
    protected void createDriver() {
        WebDriverManager.iedriver().arch32().setup();
        driver = new InternetExplorerDriver();
    }

}
