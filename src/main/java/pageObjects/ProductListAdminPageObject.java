package pageObjects;

import commonFunctions.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.ProductListAdminPageUI;

import java.util.List;

public class ProductListAdminPageObject extends AbstractPage {
    private WebDriver driver;

    public ProductListAdminPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToProductNameTextbox(String productName01) {
        waitElementVisible(driver, ProductListAdminPageUI.PRODUCT_NAME_TEXTBOX);
        sendkeyToElement(driver, ProductListAdminPageUI.PRODUCT_NAME_TEXTBOX, productName01);
    }

    public void clickToSearchButton() {
        waitElementClickable(driver, ProductListAdminPageUI.SEARCH_BUTTON);
        clickToElement(driver, ProductListAdminPageUI.SEARCH_BUTTON);
    }

    public int getNumberOfItemInList() {
        List<WebElement> elements = finds(driver, ProductListAdminPageUI.ALL_ROW_IN_TABLE);
        return elements.size();
    }

    public boolean isEmptyRowMessageDisplayed() {
        return isElementDisplayed(driver, ProductListAdminPageUI.EMPTY_ROW_MESSAGE);
    }

    public String getSKUByProductName(String productName) {
        waitElementVisible(driver, ProductListAdminPageUI.DYNAMIC_SKU_BY_PRODUCT_NAME, productName);
        return getElementText(driver, ProductListAdminPageUI.DYNAMIC_SKU_BY_PRODUCT_NAME, productName);
    }

    public float getPriceByProductName(String productName) {
        waitElementVisible(driver, ProductListAdminPageUI.DYNAMIC_PRICE_BY_PRODUCT_NAME, productName);
        return Float.parseFloat(getElementText(driver, ProductListAdminPageUI.DYNAMIC_PRICE_BY_PRODUCT_NAME, productName));
    }

    public int getStockByProductName(String productName) {
        waitElementVisible(driver, ProductListAdminPageUI.DYNAMIC_STOCK_BY_PRODUCT_NAME, productName);
        return Integer.parseInt(getElementText(driver, ProductListAdminPageUI.DYNAMIC_STOCK_BY_PRODUCT_NAME, productName));
    }

    public String getProductTypeByProductName(String productName) {
        waitElementVisible(driver, ProductListAdminPageUI.DYNAMIC_PRODUCT_TYPE_BY_PRODUCT_NAME, productName);
        return getElementText(driver, ProductListAdminPageUI.DYNAMIC_PRODUCT_TYPE_BY_PRODUCT_NAME, productName);

    }

    public void selectCategoryDropdown(String categoryOption) {
        waitElementVisible(driver, ProductListAdminPageUI.CATEGORY_DROPDOWN);
        selectOptionInDropdown(driver, ProductListAdminPageUI.CATEGORY_DROPDOWN, categoryOption);
    }

    public void clickToSearchSubcatogoryCheckbox() {
        waitElementClickable(driver, ProductListAdminPageUI.SEARCH_SUBCATEGORY_CHECKBOX);
        checkToCheckBox(driver, ProductListAdminPageUI.SEARCH_SUBCATEGORY_CHECKBOX);
    }

    public void selectManufacturerDropdown(String manufacturer) {
        waitElementVisible(driver, ProductListAdminPageUI.MANUFACTURER_DROPDOWN);
        selectOptionInDropdown(driver, ProductListAdminPageUI.MANUFACTURER_DROPDOWN, manufacturer);
    }

    public void inputToGoDirectlyProductSKUTextbox(String sku) {
        waitElementVisible(driver, ProductListAdminPageUI.GO_DIRECTLY_PRODUCT_SKU_TEXTBOX);
        sendkeyToElement(driver, ProductListAdminPageUI.GO_DIRECTLY_PRODUCT_SKU_TEXTBOX, sku);
    }

    public void clickToGoDirectlyProductSKUButton() {
        waitElementClickable(driver, ProductListAdminPageUI.GO_DIRECTLY_PRODUCT_SKU_BUTTON);
        clickToElement(driver, ProductListAdminPageUI.GO_DIRECTLY_PRODUCT_SKU_BUTTON);
    }
}
