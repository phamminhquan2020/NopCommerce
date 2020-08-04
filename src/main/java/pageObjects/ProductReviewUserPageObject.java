package pageObjects;

import commonFunctions.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.ProductReviewUserPageUI;

public class ProductReviewUserPageObject extends AbstractPage {
    private WebDriver driver;

    public ProductReviewUserPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputReviewTitleTextbox(String reviewTitle) {
        waitElementVisible(driver, ProductReviewUserPageUI.REVIEW_TITLE_TEXTBOX);
        sendkeyToElement(driver, ProductReviewUserPageUI.REVIEW_TITLE_TEXTBOX, reviewTitle);
    }

    public void inputReviewTextTextbox(String reviewText) {
        waitElementVisible(driver, ProductReviewUserPageUI.REVIEW_TEXT_TEXTBOX);
        sendkeyToElement(driver, ProductReviewUserPageUI.REVIEW_TEXT_TEXTBOX, reviewText);
    }

    public void clickToDynamicRatingOption(String ratingValue) {
        waitElementClickable(driver, ProductReviewUserPageUI.DYNAMIC_RATING_VALUE, ratingValue);
        clickToElement(driver, ProductReviewUserPageUI.DYNAMIC_RATING_VALUE, ratingValue);
    }

    public void clickSubmitReviewButton() {
        waitElementClickable(driver, ProductReviewUserPageUI.SUBMIT_REVIEW_BUTTON);
        clickToElement(driver, ProductReviewUserPageUI.SUBMIT_REVIEW_BUTTON);
    }

    public String getResultReviewMsg() {
        waitElementVisible(driver, ProductReviewUserPageUI.RESULT_MSG);
        return getElementText(driver, ProductReviewUserPageUI.RESULT_MSG);
    }
}
