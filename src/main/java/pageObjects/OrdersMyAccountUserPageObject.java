package pageObjects;

import commonFunctions.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.OrderMyAccountUserPageUI;

public class OrdersMyAccountUserPageObject extends AbstractPage {
    private WebDriver driver;

    public OrdersMyAccountUserPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public WebDriver getDriver() {
        return this.driver;
    }

    public void clickToDynamicDetailButtonByOrderID(String orderID) {
        waitElementClickable(driver, OrderMyAccountUserPageUI.DYNAMIC_DETAIL_BUTTON_BY_ORDER_ID, orderID);
        clickToElement(driver, OrderMyAccountUserPageUI.DYNAMIC_DETAIL_BUTTON_BY_ORDER_ID, orderID);
    }
}
