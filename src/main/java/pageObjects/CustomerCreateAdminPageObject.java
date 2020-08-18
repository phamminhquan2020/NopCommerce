package pageObjects;

import commonFunctions.AbstractPage;
import org.openqa.selenium.WebDriver;

public class CustomerCreateAdminPageObject extends AbstractPage {
    private WebDriver driver;

    public CustomerCreateAdminPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public WebDriver getDriver() {
        return this.driver;
    }
}
