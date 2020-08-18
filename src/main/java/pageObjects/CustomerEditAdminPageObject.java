package pageObjects;

import commonFunctions.AbstractPage;
import org.openqa.selenium.WebDriver;

public class CustomerEditAdminPageObject extends AbstractPage {
    private WebDriver driver;

    public CustomerEditAdminPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public WebDriver getDriver() {
        return this.driver;
    }

}
