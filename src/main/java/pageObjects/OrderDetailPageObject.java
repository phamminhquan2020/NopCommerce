package pageObjects;

import commonFunctions.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.OrderDetailPageUI;

import java.util.List;

public class OrderDetailPageObject extends AbstractPage {
    private WebDriver driver;

    public OrderDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getOrderID() {
        waitElementVisible(driver, OrderDetailPageUI.ORDER_NUMBER);
        return getElementText(driver, OrderDetailPageUI.ORDER_NUMBER).split("#")[1];
    }

    public String getStatus() {
        waitElementVisible(driver, OrderDetailPageUI.ORDER_STATUS);
        return getElementText(driver, OrderDetailPageUI.ORDER_STATUS).split(": ")[1];
    }

    public Float getTotalPrice() {
        waitElementVisible(driver, OrderDetailPageUI.ORDER_TOTAL);
        return Float.parseFloat(getElementText(driver, OrderDetailPageUI.ORDER_TOTAL).replace("$", ",").replace(",", ""));
    }

    public List<String> getBillingAddressInfo() {
        waitAllElementsVisible(driver, OrderDetailPageUI.BILLING_INFO);
        return getElementsText(driver, OrderDetailPageUI.BILLING_INFO);
    }

    public List<String> getPaymentMethodInfo() {
        waitAllElementsVisible(driver, OrderDetailPageUI.PAYMENT_METHOD_INFO);
        return getElementsText(driver, OrderDetailPageUI.PAYMENT_METHOD_INFO);
    }

    public List<String> getShippingAddressInfo() {
        waitAllElementsVisible(driver, OrderDetailPageUI.SHIPPING_INFO);
        return getElementsText(driver, OrderDetailPageUI.SHIPPING_INFO);
    }

    public List<String> getShippingMethodInfo() {
        waitAllElementsVisible(driver, OrderDetailPageUI.SHIPPING_METHOD_INFO);
        return getElementsText(driver, OrderDetailPageUI.SHIPPING_METHOD_INFO);
    }
}
