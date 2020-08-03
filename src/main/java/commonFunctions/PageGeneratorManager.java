package commonFunctions;

import org.openqa.selenium.WebDriver;
import pageObjects.*;


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

    public static CustomerInfoMyAccountUserPageObject getMyAccountUserPage(WebDriver driver) {
        sleepInSecond(1);
        return new CustomerInfoMyAccountUserPageObject(driver);
    }

    public static AddressMyAccountUserPageObject getAddressMyAccountUserPage(WebDriver driver) {
        sleepInSecond(1);
        return new AddressMyAccountUserPageObject(driver);
    }
}
