package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IE11DriverManager extends BrowserDriverManager {

    @Override
    protected void createDriver() {
        WebDriverManager.iedriver().arch32().setup();
        driver = new InternetExplorerDriver();
    }

}
