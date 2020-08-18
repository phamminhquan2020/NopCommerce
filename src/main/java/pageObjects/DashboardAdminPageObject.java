package pageObjects;

import commonFunctions.AbstractPage;
import org.openqa.selenium.WebDriver;

public class DashboardAdminPageObject extends AbstractPage {
    private WebDriver driver;

    public DashboardAdminPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public WebDriver getDriver() {
        return this.driver;
    }
}
