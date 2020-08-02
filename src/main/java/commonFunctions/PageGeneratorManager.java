package commonFunctions;

import org.openqa.selenium.WebDriver;
import pageObjects.HomeUserPageObject;
import pageObjects.LoginUserPageObject;
import pageObjects.RegisterUserPageObject;


public class PageGeneratorManager extends AbstractTest {


    public static HomeUserPageObject getHomeUserPage(WebDriver driver) {
        sleepInSecond(1);
        return new HomeUserPageObject(driver);
    }

    public static RegisterUserPageObject getRegisterUserPage(WebDriver driver) {
        sleepInSecond(1);
        return new RegisterUserPageObject(driver);
    }

    public static LoginUserPageObject getLoginUserPage(WebDriver driver) {
        sleepInSecond(1);
        return new LoginUserPageObject(driver);
    }
}
