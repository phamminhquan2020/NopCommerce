package driverFactory;

import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeDriverManager extends BrowserDriverManager {

    @Override
    protected void createDriver() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }

}
