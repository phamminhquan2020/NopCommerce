package pageObjects;

import commonFunctions.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.ProductDetailUserPageUI;

import java.util.List;

public class ProductDetailUserPageObject extends AbstractPage {
    private WebDriver driver;

    public ProductDetailUserPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public WebDriver getDriver() {
        return this.driver;
    }

    public void clickAddYourReviewLink() {
        waitElementClickable(driver, ProductDetailUserPageUI.ADD_YOUR_REVIEW_LINK);
        clickToElement(driver, ProductDetailUserPageUI.ADD_YOUR_REVIEW_LINK);
    }

    public void clickToAddToWishListButton() {
       waitElementClickable(driver, ProductDetailUserPageUI.ADD_TO_WISH_LIST_BUTTON);
       clickToElement(driver, ProductDetailUserPageUI.ADD_TO_WISH_LIST_BUTTON);
    }

    public void clickToAddToCompareButton() {
        waitElementClickable(driver, ProductDetailUserPageUI.ADD_TO_COMPARE_BUTTON);
        clickToElement(driver, ProductDetailUserPageUI.ADD_TO_COMPARE_BUTTON);
    }

    public void selectProcessor(String processor) {
        waitElementVisible(driver, ProductDetailUserPageUI.PROCESSOR_DROPDOWN);
        selectOptionInDropdown(driver, ProductDetailUserPageUI.PROCESSOR_DROPDOWN, processor);
    }

    public void selectRam(String ram) {
        waitElementVisible(driver, ProductDetailUserPageUI.RAM_DROPDOWN);
        selectOptionInDropdown(driver, ProductDetailUserPageUI.RAM_DROPDOWN, ram);
    }

    public void selectHDD(String hdd) {
        waitElementClickable(driver, ProductDetailUserPageUI.DYNAMIC_INPUT_OPTION, hdd);
        clickToElement(driver, ProductDetailUserPageUI.DYNAMIC_INPUT_OPTION, hdd);
    }

    public void selectOS(String os) {
        waitElementClickable(driver, ProductDetailUserPageUI.DYNAMIC_INPUT_OPTION, os);
        clickToElement(driver, ProductDetailUserPageUI.DYNAMIC_INPUT_OPTION, os);
    }

    public void selectSoftware(List<String> softwares) {
        for (String software: softwares) {
            waitElementClickable(driver, ProductDetailUserPageUI.DYNAMIC_SOFTWARE_OPTION, software);
            if (!isElementSelected(driver, ProductDetailUserPageUI.DYNAMIC_SOFTWARE_OPTION, software)) {
                clickToElement(driver, ProductDetailUserPageUI.DYNAMIC_SOFTWARE_OPTION, software);
            }

        }
    }

    public void inputQuantity(String qty) {
        waitElementVisible(driver, ProductDetailUserPageUI.QTY_TEXTBOX);
        sendkeyToElement(driver, ProductDetailUserPageUI.QTY_TEXTBOX, qty);
    }

    public void clickAddToCartButton() {
        waitElementClickable(driver, ProductDetailUserPageUI.ADD_TO_CART_BUTTON);
        clickToElement(driver, ProductDetailUserPageUI.ADD_TO_CART_BUTTON);
    }

    public void clickToUpdateButton() {
        waitElementClickable(driver, ProductDetailUserPageUI.UPDATE_BUTTON);
        clickToElement(driver, ProductDetailUserPageUI.UPDATE_BUTTON);
    }
}
