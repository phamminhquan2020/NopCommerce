package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends BrowserDriverManager {

    @Override
    protected void createDriver() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }

}
