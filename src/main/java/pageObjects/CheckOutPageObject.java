package pageObjects;

import commonFunctions.AbstractPage;
import org.openqa.selenium.WebDriver;

public class CheckOutPageObject extends AbstractPage {
    private WebDriver driver;

    public CheckOutPageObject(WebDriver driver) {
        this.driver = driver;
    }

}
