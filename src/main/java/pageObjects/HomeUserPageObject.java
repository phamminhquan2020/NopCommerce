package pageObjects;

import commonFunctions.AbstractPage;
import org.openqa.selenium.WebDriver;

public class HomeUserPageObject extends AbstractPage {
    private WebDriver driver;

    public HomeUserPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
