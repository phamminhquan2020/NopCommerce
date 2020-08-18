package pageObjects;

import commonFunctions.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.EditProductAdminPageUI;

public class EditProductAdminPageObject extends AbstractPage {
    private WebDriver driver;

    public EditProductAdminPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName() {
        waitElementVisible(driver, EditProductAdminPageUI.PRODUCT_NAME_TEXTBOX);
        return getElementTextByJS(driver, EditProductAdminPageUI.PRODUCT_NAME_TEXTBOX);
    }

    public boolean isDynamicCategoryDisplayed(String categoryOption) {
        return isElementDisplayed(driver, EditProductAdminPageUI.DYNAMIC_CATEGORY_LABEL, categoryOption);
    }

    public String getSelectedProductType() {
        waitElementVisible(driver, EditProductAdminPageUI.PRODUCT_TYPE_DROPDOWN);
        return getSelectedItemInDropDown(driver, EditProductAdminPageUI.PRODUCT_TYPE_DROPDOWN);
    }

    public String getPrice() {
        scrollToElement(driver, EditProductAdminPageUI.PRICE_TEXTBOX);
        waitElementVisible(driver, EditProductAdminPageUI.PRICE_TEXTBOX);
        return getElementTextByJS(driver, EditProductAdminPageUI.PRICE_TEXTBOX);
    }
}
