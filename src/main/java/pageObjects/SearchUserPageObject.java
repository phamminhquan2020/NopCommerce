package pageObjects;

import commonFunctions.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.SearchUserPageUI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SearchUserPageObject extends AbstractPage {
    private WebDriver driver;

    public SearchUserPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToSearchButton() {
        waitElementClickable(driver, SearchUserPageUI.SEARCH_BUTTON);
        clickToElement(driver, SearchUserPageUI.SEARCH_BUTTON);
    }

    public String getWarningMsg() {
        waitElementVisible(driver, SearchUserPageUI.WARNING_MSG);
        return getElementText(driver, SearchUserPageUI.WARNING_MSG);
    }

    public void inputToKeywordField(String keyword) {
        waitElementVisible(driver, SearchUserPageUI.KEYWORD_TEXT_BOX);
        sendkeyToElement(driver, SearchUserPageUI.KEYWORD_TEXT_BOX, keyword);
    }

    public String getNoResultMsg() {
        waitElementVisible(driver, SearchUserPageUI.NO_RESULT_MSG);
        return getElementText(driver, SearchUserPageUI.NO_RESULT_MSG);
    }

    public String getSizeOfSearchResult() {
        List<WebElement> elements = finds(driver, SearchUserPageUI.PRODUCT_TITLES);
        return Integer.toString(elements.size());

    }

    public List<String> getTitlesOfSearchResult() {
        List<WebElement> elements = finds(driver, SearchUserPageUI.PRODUCT_TITLES);
        List<String> titles = new ArrayList<String>();
        for (WebElement element:elements) {
            titles.add(element.getText());
        }
        return titles;
    }

    public void clickToAdvanceSearchCheckbox() {
        waitElementClickable(driver, SearchUserPageUI.ADVANCE_SEARCH_CHECKBOX);
        clickToElement(driver, SearchUserPageUI.ADVANCE_SEARCH_CHECKBOX);
    }

    public void selectCategoryDropdown(String category) {
        waitElementVisible(driver, SearchUserPageUI.CATEGORY_DROPDOWN);
        selectOptionInDropdown(driver, SearchUserPageUI.CATEGORY_DROPDOWN, category);
    }

    public void clickToSearchSubcategoryCheckbox() {
        waitElementClickable(driver, SearchUserPageUI.SUB_CATEGORY_CHECKBOX);
        clickToElement(driver, SearchUserPageUI.SUB_CATEGORY_CHECKBOX);
    }

    public void selectManufacturerDropdown(String manufacturer) {
        waitElementVisible(driver, SearchUserPageUI.MANUFACTURER_DROPDOWN);
        selectOptionInDropdown(driver, SearchUserPageUI.MANUFACTURER_DROPDOWN, manufacturer);
    }

    public void inputToPriceFromTextbox(String priceFrom) {
        waitElementVisible(driver, SearchUserPageUI.PRICE_FROM_TEXTBOX);
        sendkeyToElement(driver, SearchUserPageUI.PRICE_FROM_TEXTBOX, priceFrom);
    }

    public void inputToPriceToTextbox(String priceToTC) {
        waitElementVisible(driver, SearchUserPageUI.PRICE_TO_TEXTBOX);
        sendkeyToElement(driver, SearchUserPageUI.PRICE_TO_TEXTBOX, priceToTC);
    }

    public void selectSortByDropdown(String sortByValue) {
        waitElementVisible(driver, SearchUserPageUI.SORT_BY_DROPDOWN);
        selectOptionInDropdown(driver, SearchUserPageUI.SORT_BY_DROPDOWN, sortByValue);
    }

    public void selectDisplayPerPageDropdown(String numberValue) {
        waitElementVisible(driver, SearchUserPageUI.DISPLAY_PER_PAGE_DROPDOWN);
        selectOptionInDropdown(driver, SearchUserPageUI.DISPLAY_PER_PAGE_DROPDOWN, numberValue);
    }

    public boolean isProductTitleSortedAtoZ() {
        waitAllElementsVisible(driver, SearchUserPageUI.PRODUCT_TITLES);
        return isDataSortedAscending(driver, SearchUserPageUI.PRODUCT_TITLES);
    }

    public boolean isProductTitleSortedZtoA() {
        waitAllElementsVisible(driver, SearchUserPageUI.PRODUCT_TITLES);
        return isDataSortedDecending(driver, SearchUserPageUI.PRODUCT_TITLES);
    }

    public boolean isProductPriceSortedLowToHigh() {
        waitElementVisible(driver, SearchUserPageUI.PRODUCT_PRICES);
        return isPriceSortedAscending(driver, SearchUserPageUI.PRODUCT_PRICES);
    }

    public boolean isProductPriceSortedHighToLow() {
        waitElementVisible(driver, SearchUserPageUI.PRODUCT_PRICES);
        return isPriceSortedDecending(driver, SearchUserPageUI.PRODUCT_PRICES);
    }
}
