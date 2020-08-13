package pageObjects;

import commonFunctions.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.CompareProductsPageUI;

public class CompareProductsPageObject extends AbstractPage {
    private WebDriver driver;

    public CompareProductsPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getNumberOfProductInComparePage() {
        int number = finds(driver, CompareProductsPageUI.ALL_CELL_OF_FIRST_ROW).size() - 1;
        if (number < 1) {
            return "0";
        } else {
            return Integer.toString(number);
        }

    }

    public String getCellDataByProductNameAndRow(String productName, String rowName) {
        int indexInt = getIndexByName(productName);
        String index = Integer.toString(indexInt);
        return getElementText(driver, CompareProductsPageUI.DYNAMIC_CELL_BY_LABEL_AND_INDEX, rowName, index);
    }

    public int getIndexByName(String productName) {
        return finds(driver, CompareProductsPageUI.INDEX_BY_NAME, productName).size();
    }

    public boolean isRemoveButtonDisplayedByProductName(String productName) {
        int indexInt = getIndexByName(productName);
        String index = Integer.toString(indexInt + 1);
        return isElementDisplayed(driver, CompareProductsPageUI.DYNAMIC_REMOVE_BUTTON_BY_INDEX, index);
    }

    public void clickToClearListButton() {
        waitElementClickable(driver, CompareProductsPageUI.CLEAR_LIST_BUTTON);
        clickToElement(driver, CompareProductsPageUI.CLEAR_LIST_BUTTON);
    }

    public boolean isEmptyMessageDisplayed() {
        return isElementDisplayed(driver, CompareProductsPageUI.EMPTY_MESSAGE);
    }
}
