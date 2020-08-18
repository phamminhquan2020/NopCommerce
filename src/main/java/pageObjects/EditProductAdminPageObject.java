package pageObjects;

import commonFunctions.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.EditProductAdminPageUI;

public class EditProductAdminPageObject extends AbstractPage {
    private WebDriver driver;

    public EditProductAdminPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public WebDriver getDriver() {
        return this.driver;
    }

    public String getProductName() {
        String panelName = "Product info";
        if (!isPanelOpened(panelName)) {
            waitElementClickable(driver, EditProductAdminPageUI.IS_PANEL_OPENED, panelName);
            clickToElement(driver, EditProductAdminPageUI.IS_PANEL_OPENED, panelName);
        }
        waitElementVisible(driver, EditProductAdminPageUI.PRODUCT_NAME_TEXTBOX);
        return getElementTextByJS(driver, EditProductAdminPageUI.PRODUCT_NAME_TEXTBOX);
    }

    public boolean isDynamicCategoryDisplayed(String categoryOption) {
        String panelName = "Product info";
        if (!isPanelOpened(panelName)) {
            waitElementClickable(driver, EditProductAdminPageUI.IS_PANEL_OPENED, panelName);
            clickToElement(driver, EditProductAdminPageUI.IS_PANEL_OPENED, panelName);
        }
        return isElementDisplayed(driver, EditProductAdminPageUI.DYNAMIC_CATEGORY_LABEL, categoryOption);
    }

    public String getSelectedProductType() {
        String panelName = "Product info";
        if (!isPanelOpened(panelName)) {
            waitElementClickable(driver, EditProductAdminPageUI.IS_PANEL_OPENED, panelName);
            clickToElement(driver, EditProductAdminPageUI.IS_PANEL_OPENED, panelName);
        }
        waitElementVisible(driver, EditProductAdminPageUI.PRODUCT_TYPE_DROPDOWN);
        return getSelectedItemInDropDown(driver, EditProductAdminPageUI.PRODUCT_TYPE_DROPDOWN);
    }

    public float getPrice() {
        String panelName = "Price";
        if (!isPanelOpened(panelName)) {
            waitElementClickable(driver, EditProductAdminPageUI.IS_PANEL_OPENED, panelName);
            clickToElement(driver, EditProductAdminPageUI.IS_PANEL_OPENED, panelName);
        }
        scrollToElement(driver, EditProductAdminPageUI.PRICE_TEXTBOX);
        return Float.parseFloat(getElementTextByJS(driver, EditProductAdminPageUI.PRICE_TEXTBOX));
    }

    public boolean isPanelOpened(String panelName) {
        return getElementAttributeValue(driver, EditProductAdminPageUI.IS_PANEL_OPENED, "class", panelName).contains("opened");
    }
}
