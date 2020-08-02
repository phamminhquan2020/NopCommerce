package commonFunctions;

import org.openqa.selenium.WebDriver;
import pageObjects.HomeUserPageObject;
import pageObjects.RegisterUserPageObject;

public class PageGeneratorManager {


    public static HomeUserPageObject getHomeUserPage(WebDriver driver) {
        sleepInSecond(1);
        return new HomeUserPageObject(driver);
    }

    public static RegisterUserPageObject getRegisterUserPage(WebDriver driver) {
        sleepInSecond(1);
        return new RegisterUserPageObject(driver);
    }
}
