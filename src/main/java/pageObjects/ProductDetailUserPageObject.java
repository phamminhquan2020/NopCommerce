package pageObjects;

import commonFunctions.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.ProductDetailUserPageUI;

public class ProductDetailUserPageObject extends AbstractPage {
    private WebDriver driver;

    public ProductDetailUserPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddYourReviewLink() {
        waitElementClickable(driver, ProductDetailUserPageUI.ADD_YOUR_REVIEW_LINK);
        clickToElement(driver, ProductDetailUserPageUI.ADD_YOUR_REVIEW_LINK);
    }
}
