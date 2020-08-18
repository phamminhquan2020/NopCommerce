package pageObjects;

import commonFunctions.AbstractPage;
import org.openqa.selenium.WebDriver;

public class ProductListUserPageObjectBackup extends AbstractPage {
    WebDriver driver;

    public ProductListUserPageObjectBackup(WebDriver driver) {
        this.driver = driver;
    }
    public WebDriver getDriver() {
        return this.driver;
    }
}
